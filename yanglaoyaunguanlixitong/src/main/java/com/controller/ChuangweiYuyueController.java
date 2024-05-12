
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 床位调动申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuangweiYuyue")
public class ChuangweiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ChuangweiYuyueController.class);

    private static final String TABLE_NAME = "chuangweiYuyue";

    @Autowired
    private ChuangweiYuyueService chuangweiYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChuangweiService chuangweiService;//床位
    @Autowired
    private ChuyaunService chuyaunService;//出院申请
    @Autowired
    private DiaodongService diaodongService;//调动申请
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FangjianService fangjianService;//房间
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private HugongService hugongService;//护工更换申请
    @Autowired
    private JiashuService jiashuService;//家属
    @Autowired
    private JiluService jiluService;//健康信息
    @Autowired
    private LaorenService laorenService;//老人
    @Autowired
    private LaorenqingjiaService laorenqingjiaService;//老人请假申请
    @Autowired
    private LizhiService lizhiService;//离职申请
    @Autowired
    private QingjiaService qingjiaService;//请假申请
    @Autowired
    private YonghuService yonghuService;//护工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("护工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("家属".equals(role))
            params.put("jiashuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = chuangweiYuyueService.queryPage(params);

        //字典表数据转换
        List<ChuangweiYuyueView> list =(List<ChuangweiYuyueView>)page.getList();
        for(ChuangweiYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuangweiYuyueEntity chuangweiYuyue = chuangweiYuyueService.selectById(id);
        if(chuangweiYuyue !=null){
            //entity转view
            ChuangweiYuyueView view = new ChuangweiYuyueView();
            BeanUtils.copyProperties( chuangweiYuyue , view );//把实体数据重构到view中
            //级联表 护工
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chuangweiYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 老人
            //级联表
            LaorenEntity laoren = laorenService.selectById(chuangweiYuyue.getLaorenId());
            if(laoren != null){
            BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLaorenId(laoren.getId());
            }
            //级联表 床位
            //级联表
            ChuangweiEntity chuangwei = chuangweiService.selectById(chuangweiYuyue.getChuangweiId());
            if(chuangwei != null){
            BeanUtils.copyProperties( chuangwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChuangweiId(chuangwei.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangweiYuyueEntity chuangweiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuangweiYuyue:{}",this.getClass().getName(),chuangweiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("护工".equals(role))
            chuangweiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChuangweiYuyueEntity> queryWrapper = new EntityWrapper<ChuangweiYuyueEntity>()
            .eq("yonghu_id", chuangweiYuyue.getYonghuId())
            .eq("laoren_id", chuangweiYuyue.getLaorenId())
            .eq("chuangwei_id", chuangweiYuyue.getChuangweiId())
            .in("chuangwei_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiYuyueEntity chuangweiYuyueEntity = chuangweiYuyueService.selectOne(queryWrapper);
//        if(chuangweiYuyueEntity==null){
            chuangweiYuyue.setInsertTime(new Date());
            chuangweiYuyue.setChuangweiYuyueYesnoTypes(1);
            chuangweiYuyue.setCreateTime(new Date());
            chuangweiYuyueService.insert(chuangweiYuyue);
            return R.ok();
//        }else {
//            if(chuangweiYuyueEntity.getChuangweiYuyueYesnoTypes()==1)
//                return R.error(511,"有相同的待审核的数据");
//            else if(chuangweiYuyueEntity.getChuangweiYuyueYesnoTypes()==2)
//                return R.error(511,"有相同的审核通过的数据");
//            else
//                return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuangweiYuyueEntity chuangweiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chuangweiYuyue:{}",this.getClass().getName(),chuangweiYuyue.toString());
        ChuangweiYuyueEntity oldChuangweiYuyueEntity = chuangweiYuyueService.selectById(chuangweiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("护工".equals(role))
//            chuangweiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(chuangweiYuyue.getChuangweiYuyueText()) || "null".equals(chuangweiYuyue.getChuangweiYuyueText())){
                chuangweiYuyue.setChuangweiYuyueText(null);
        }
        if("".equals(chuangweiYuyue.getChuangweiYuyueYesnoText()) || "null".equals(chuangweiYuyue.getChuangweiYuyueYesnoText())){
                chuangweiYuyue.setChuangweiYuyueYesnoText(null);
        }

            chuangweiYuyueService.updateById(chuangweiYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ChuangweiYuyueEntity chuangweiYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,chuangweiYuyueEntity:{}",this.getClass().getName(),chuangweiYuyueEntity.toString());

        ChuangweiYuyueEntity oldChuangweiYuyue = chuangweiYuyueService.selectById(chuangweiYuyueEntity.getId());//查询原先数据

//        if(chuangweiYuyueEntity.getChuangweiYuyueYesnoTypes() == 2){//通过
//            chuangweiYuyueEntity.setChuangweiYuyueTypes();
//        }else if(chuangweiYuyueEntity.getChuangweiYuyueYesnoTypes() == 3){//拒绝
//            chuangweiYuyueEntity.setChuangweiYuyueTypes();
//        }
        chuangweiYuyueEntity.setChuangweiYuyueShenheTime(new Date());//审核时间
        chuangweiYuyueService.updateById(chuangweiYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChuangweiYuyueEntity> oldChuangweiYuyueList =chuangweiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chuangweiYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ChuangweiYuyueEntity> chuangweiYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChuangweiYuyueEntity chuangweiYuyueEntity = new ChuangweiYuyueEntity();
//                            chuangweiYuyueEntity.setChuangweiYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            chuangweiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chuangweiYuyueEntity.setLaorenId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            chuangweiYuyueEntity.setChuangweiId(Integer.valueOf(data.get(0)));   //床位 要改的
//                            chuangweiYuyueEntity.setChuangweiYuyueText(data.get(0));                    //报名理由 要改的
//                            chuangweiYuyueEntity.setInsertTime(date);//时间
//                            chuangweiYuyueEntity.setChuangweiYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            chuangweiYuyueEntity.setChuangweiYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            chuangweiYuyueEntity.setChuangweiYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            chuangweiYuyueEntity.setCreateTime(date);//时间
                            chuangweiYuyueList.add(chuangweiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("chuangweiYuyueUuidNumber")){
                                    List<String> chuangweiYuyueUuidNumber = seachFields.get("chuangweiYuyueUuidNumber");
                                    chuangweiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chuangweiYuyueUuidNumber = new ArrayList<>();
                                    chuangweiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chuangweiYuyueUuidNumber",chuangweiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<ChuangweiYuyueEntity> chuangweiYuyueEntities_chuangweiYuyueUuidNumber = chuangweiYuyueService.selectList(new EntityWrapper<ChuangweiYuyueEntity>().in("chuangwei_yuyue_uuid_number", seachFields.get("chuangweiYuyueUuidNumber")));
                        if(chuangweiYuyueEntities_chuangweiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuangweiYuyueEntity s:chuangweiYuyueEntities_chuangweiYuyueUuidNumber){
                                repeatFields.add(s.getChuangweiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chuangweiYuyueService.insertBatch(chuangweiYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chuangweiYuyueService.queryPage(params);

        //字典表数据转换
        List<ChuangweiYuyueView> list =(List<ChuangweiYuyueView>)page.getList();
        for(ChuangweiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuangweiYuyueEntity chuangweiYuyue = chuangweiYuyueService.selectById(id);
            if(chuangweiYuyue !=null){


                //entity转view
                ChuangweiYuyueView view = new ChuangweiYuyueView();
                BeanUtils.copyProperties( chuangweiYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chuangweiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    LaorenEntity laoren = laorenService.selectById(chuangweiYuyue.getLaorenId());
                if(laoren != null){
                    BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaorenId(laoren.getId());
                }
                //级联表
                    ChuangweiEntity chuangwei = chuangweiService.selectById(chuangweiYuyue.getChuangweiId());
                if(chuangwei != null){
                    BeanUtils.copyProperties( chuangwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChuangweiId(chuangwei.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangweiYuyueEntity chuangweiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuangweiYuyue:{}",this.getClass().getName(),chuangweiYuyue.toString());
        Wrapper<ChuangweiYuyueEntity> queryWrapper = new EntityWrapper<ChuangweiYuyueEntity>()
            .eq("chuangwei_yuyue_uuid_number", chuangweiYuyue.getChuangweiYuyueUuidNumber())
            .eq("yonghu_id", chuangweiYuyue.getYonghuId())
            .eq("laoren_id", chuangweiYuyue.getLaorenId())
            .eq("chuangwei_id", chuangweiYuyue.getChuangweiId())
            .eq("chuangwei_yuyue_text", chuangweiYuyue.getChuangweiYuyueText())
            .in("chuangwei_yuyue_yesno_types", new Integer[]{1,2})
            .eq("chuangwei_yuyue_yesno_text", chuangweiYuyue.getChuangweiYuyueYesnoText())
//            .notIn("chuangwei_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiYuyueEntity chuangweiYuyueEntity = chuangweiYuyueService.selectOne(queryWrapper);
        if(chuangweiYuyueEntity==null){
            chuangweiYuyue.setInsertTime(new Date());
            chuangweiYuyue.setChuangweiYuyueYesnoTypes(1);
            chuangweiYuyue.setCreateTime(new Date());
        chuangweiYuyueService.insert(chuangweiYuyue);

            return R.ok();
        }else {
            if(chuangweiYuyueEntity.getChuangweiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(chuangweiYuyueEntity.getChuangweiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

