
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
 * 老人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoren")
public class LaorenController {
    private static final Logger logger = LoggerFactory.getLogger(LaorenController.class);

    private static final String TABLE_NAME = "laoren";

    @Autowired
    private LaorenService laorenService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChuangweiService chuangweiService;//床位
    @Autowired
    private ChuangweiYuyueService chuangweiYuyueService;//床位调动申请
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
        PageUtils page = laorenService.queryPage(params);

        //字典表数据转换
        List<LaorenView> list =(List<LaorenView>)page.getList();
        for(LaorenView c:list){
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
        LaorenEntity laoren = laorenService.selectById(id);
        if(laoren !=null){
            //entity转view
            LaorenView view = new LaorenView();
            BeanUtils.copyProperties( laoren , view );//把实体数据重构到view中
            //级联表 护工
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(laoren.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 床位
            //级联表
            ChuangweiEntity chuangwei = chuangweiService.selectById(laoren.getChuangweiId());
            if(chuangwei != null){
            BeanUtils.copyProperties( chuangwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChuangweiId(chuangwei.getId());
            }
            //级联表 家属
            //级联表
            JiashuEntity jiashu = jiashuService.selectById(laoren.getJiashuId());
            if(jiashu != null){
            BeanUtils.copyProperties( jiashu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiashuId(jiashu.getId());
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
    public R save(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("护工".equals(role))
            laoren.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("家属".equals(role))
            laoren.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .eq("yonghu_id", laoren.getYonghuId())
            .eq("chuangwei_id", laoren.getChuangweiId())
            .eq("jiashu_id", laoren.getJiashuId())
            .eq("kanhuren_name", laoren.getKanhurenName())
            .eq("kanhuren_phone", laoren.getKanhurenPhone())
            .eq("laoren_name", laoren.getLaorenName())
            .eq("laoren_phone", laoren.getLaorenPhone())
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            .eq("sex_types", laoren.getSexTypes())
            .eq("age", laoren.getAge())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if(laorenEntity==null){
            laoren.setInsertTime(new Date());
            laoren.setCreateTime(new Date());
            laorenService.insert(laoren);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaorenEntity laoren, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());
        LaorenEntity oldLaorenEntity = laorenService.selectById(laoren.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("护工".equals(role))
//            laoren.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("家属".equals(role))
//            laoren.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(laoren.getLaorenPhoto()) || "null".equals(laoren.getLaorenPhoto())){
                laoren.setLaorenPhoto(null);
        }
        if("".equals(laoren.getLaorenContent()) || "null".equals(laoren.getLaorenContent())){
                laoren.setLaorenContent(null);
        }

            laorenService.updateById(laoren);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LaorenEntity> oldLaorenList =laorenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        laorenService.deleteBatchIds(Arrays.asList(ids));

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
            List<LaorenEntity> laorenList = new ArrayList<>();//上传的东西
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
                            LaorenEntity laorenEntity = new LaorenEntity();
//                            laorenEntity.setYonghuId(Integer.valueOf(data.get(0)));   //护工 要改的
//                            laorenEntity.setChuangweiId(Integer.valueOf(data.get(0)));   //床位 要改的
//                            laorenEntity.setJiashuId(Integer.valueOf(data.get(0)));   //家属 要改的
//                            laorenEntity.setKanhurenName(data.get(0));                    //看护人姓名 要改的
//                            laorenEntity.setKanhurenPhone(data.get(0));                    //看护人联系方式 要改的
//                            laorenEntity.setLaorenName(data.get(0));                    //老人姓名 要改的
//                            laorenEntity.setLaorenPhone(data.get(0));                    //老人手机号 要改的
//                            laorenEntity.setLaorenIdNumber(data.get(0));                    //老人身份证号 要改的
//                            laorenEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            laorenEntity.setAge(Integer.valueOf(data.get(0)));   //年龄 要改的
//                            laorenEntity.setLaorenPhoto("");//详情和图片
//                            laorenEntity.setLaorenContent("");//详情和图片
//                            laorenEntity.setInsertTime(date);//时间
//                            laorenEntity.setCreateTime(date);//时间
                            laorenList.add(laorenEntity);


                            //把要查询是否重复的字段放入map中
                                //老人手机号
                                if(seachFields.containsKey("laorenPhone")){
                                    List<String> laorenPhone = seachFields.get("laorenPhone");
                                    laorenPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> laorenPhone = new ArrayList<>();
                                    laorenPhone.add(data.get(0));//要改的
                                    seachFields.put("laorenPhone",laorenPhone);
                                }
                                //老人身份证号
                                if(seachFields.containsKey("laorenIdNumber")){
                                    List<String> laorenIdNumber = seachFields.get("laorenIdNumber");
                                    laorenIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laorenIdNumber = new ArrayList<>();
                                    laorenIdNumber.add(data.get(0));//要改的
                                    seachFields.put("laorenIdNumber",laorenIdNumber);
                                }
                        }

                        //查询是否重复
                         //老人手机号
                        List<LaorenEntity> laorenEntities_laorenPhone = laorenService.selectList(new EntityWrapper<LaorenEntity>().in("laoren_phone", seachFields.get("laorenPhone")));
                        if(laorenEntities_laorenPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaorenEntity s:laorenEntities_laorenPhone){
                                repeatFields.add(s.getLaorenPhone());
                            }
                            return R.error(511,"数据库的该表中的 [老人手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //老人身份证号
                        List<LaorenEntity> laorenEntities_laorenIdNumber = laorenService.selectList(new EntityWrapper<LaorenEntity>().in("laoren_id_number", seachFields.get("laorenIdNumber")));
                        if(laorenEntities_laorenIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaorenEntity s:laorenEntities_laorenIdNumber){
                                repeatFields.add(s.getLaorenIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [老人身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        laorenService.insertBatch(laorenList);
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
        PageUtils page = laorenService.queryPage(params);

        //字典表数据转换
        List<LaorenView> list =(List<LaorenView>)page.getList();
        for(LaorenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LaorenEntity laoren = laorenService.selectById(id);
            if(laoren !=null){


                //entity转view
                LaorenView view = new LaorenView();
                BeanUtils.copyProperties( laoren , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(laoren.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ChuangweiEntity chuangwei = chuangweiService.selectById(laoren.getChuangweiId());
                if(chuangwei != null){
                    BeanUtils.copyProperties( chuangwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChuangweiId(chuangwei.getId());
                }
                //级联表
                    JiashuEntity jiashu = jiashuService.selectById(laoren.getJiashuId());
                if(jiashu != null){
                    BeanUtils.copyProperties( jiashu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiashuId(jiashu.getId());
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
    public R add(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .eq("yonghu_id", laoren.getYonghuId())
            .eq("chuangwei_id", laoren.getChuangweiId())
            .eq("jiashu_id", laoren.getJiashuId())
            .eq("kanhuren_name", laoren.getKanhurenName())
            .eq("kanhuren_phone", laoren.getKanhurenPhone())
            .eq("laoren_name", laoren.getLaorenName())
            .eq("laoren_phone", laoren.getLaorenPhone())
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            .eq("sex_types", laoren.getSexTypes())
            .eq("age", laoren.getAge())
//            .notIn("laoren_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if(laorenEntity==null){
            laoren.setInsertTime(new Date());
            laoren.setCreateTime(new Date());
        laorenService.insert(laoren);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

