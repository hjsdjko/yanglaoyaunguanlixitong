
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
 * 护工更换申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hugong")
public class HugongController {
    private static final Logger logger = LoggerFactory.getLogger(HugongController.class);

    private static final String TABLE_NAME = "hugong";

    @Autowired
    private HugongService hugongService;


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
        PageUtils page = hugongService.queryPage(params);

        //字典表数据转换
        List<HugongView> list =(List<HugongView>)page.getList();
        for(HugongView c:list){
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
        HugongEntity hugong = hugongService.selectById(id);
        if(hugong !=null){
            //entity转view
            HugongView view = new HugongView();
            BeanUtils.copyProperties( hugong , view );//把实体数据重构到view中
            //级联表 家属
            //级联表
            JiashuEntity jiashu = jiashuService.selectById(hugong.getJiashuId());
            if(jiashu != null){
            BeanUtils.copyProperties( jiashu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiashuId(jiashu.getId());
            }
            //级联表 老人
            //级联表
            LaorenEntity laoren = laorenService.selectById(hugong.getLaorenId());
            if(laoren != null){
            BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLaorenId(laoren.getId());
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
    public R save(@RequestBody HugongEntity hugong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hugong:{}",this.getClass().getName(),hugong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("家属".equals(role))
            hugong.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HugongEntity> queryWrapper = new EntityWrapper<HugongEntity>()
            .eq("jiashu_id", hugong.getJiashuId())
            .eq("laoren_id", hugong.getLaorenId())
            .in("hugong_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HugongEntity hugongEntity = hugongService.selectOne(queryWrapper);
//        if(hugongEntity==null){
            hugong.setInsertTime(new Date());
            hugong.setHugongYesnoTypes(1);
            hugong.setCreateTime(new Date());
            hugongService.insert(hugong);
            return R.ok();
//        }else {
//            if(hugongEntity.getHugongYesnoTypes()==1)
//                return R.error(511,"有相同的待审核的数据");
//            else if(hugongEntity.getHugongYesnoTypes()==2)
//                return R.error(511,"有相同的审核通过的数据");
//            else
//                return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HugongEntity hugong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,hugong:{}",this.getClass().getName(),hugong.toString());
        HugongEntity oldHugongEntity = hugongService.selectById(hugong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("家属".equals(role))
//            hugong.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(hugong.getHugongText()) || "null".equals(hugong.getHugongText())){
                hugong.setHugongText(null);
        }
        if("".equals(hugong.getHugongYesnoText()) || "null".equals(hugong.getHugongYesnoText())){
                hugong.setHugongYesnoText(null);
        }

            hugongService.updateById(hugong);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody HugongEntity hugongEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,hugongEntity:{}",this.getClass().getName(),hugongEntity.toString());

        HugongEntity oldHugong = hugongService.selectById(hugongEntity.getId());//查询原先数据

//        if(hugongEntity.getHugongYesnoTypes() == 2){//通过
//            hugongEntity.setHugongTypes();
//        }else if(hugongEntity.getHugongYesnoTypes() == 3){//拒绝
//            hugongEntity.setHugongTypes();
//        }
        hugongEntity.setHugongShenheTime(new Date());//审核时间
        hugongService.updateById(hugongEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HugongEntity> oldHugongList =hugongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        hugongService.deleteBatchIds(Arrays.asList(ids));

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
            List<HugongEntity> hugongList = new ArrayList<>();//上传的东西
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
                            HugongEntity hugongEntity = new HugongEntity();
//                            hugongEntity.setHugongUuidNumber(data.get(0));                    //报名编号 要改的
//                            hugongEntity.setJiashuId(Integer.valueOf(data.get(0)));   //家属 要改的
//                            hugongEntity.setLaorenId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            hugongEntity.setHugongText(data.get(0));                    //报名理由 要改的
//                            hugongEntity.setInsertTime(date);//时间
//                            hugongEntity.setHugongYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            hugongEntity.setHugongYesnoText(data.get(0));                    //审核回复 要改的
//                            hugongEntity.setHugongShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            hugongEntity.setCreateTime(date);//时间
                            hugongList.add(hugongEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("hugongUuidNumber")){
                                    List<String> hugongUuidNumber = seachFields.get("hugongUuidNumber");
                                    hugongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> hugongUuidNumber = new ArrayList<>();
                                    hugongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("hugongUuidNumber",hugongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<HugongEntity> hugongEntities_hugongUuidNumber = hugongService.selectList(new EntityWrapper<HugongEntity>().in("hugong_uuid_number", seachFields.get("hugongUuidNumber")));
                        if(hugongEntities_hugongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HugongEntity s:hugongEntities_hugongUuidNumber){
                                repeatFields.add(s.getHugongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        hugongService.insertBatch(hugongList);
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
        PageUtils page = hugongService.queryPage(params);

        //字典表数据转换
        List<HugongView> list =(List<HugongView>)page.getList();
        for(HugongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HugongEntity hugong = hugongService.selectById(id);
            if(hugong !=null){


                //entity转view
                HugongView view = new HugongView();
                BeanUtils.copyProperties( hugong , view );//把实体数据重构到view中

                //级联表
                    JiashuEntity jiashu = jiashuService.selectById(hugong.getJiashuId());
                if(jiashu != null){
                    BeanUtils.copyProperties( jiashu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiashuId(jiashu.getId());
                }
                //级联表
                    LaorenEntity laoren = laorenService.selectById(hugong.getLaorenId());
                if(laoren != null){
                    BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaorenId(laoren.getId());
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
    public R add(@RequestBody HugongEntity hugong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,hugong:{}",this.getClass().getName(),hugong.toString());
        Wrapper<HugongEntity> queryWrapper = new EntityWrapper<HugongEntity>()
            .eq("hugong_uuid_number", hugong.getHugongUuidNumber())
            .eq("jiashu_id", hugong.getJiashuId())
            .eq("laoren_id", hugong.getLaorenId())
            .eq("hugong_text", hugong.getHugongText())
            .in("hugong_yesno_types", new Integer[]{1,2})
            .eq("hugong_yesno_text", hugong.getHugongYesnoText())
//            .notIn("hugong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HugongEntity hugongEntity = hugongService.selectOne(queryWrapper);
        if(hugongEntity==null){
            hugong.setInsertTime(new Date());
            hugong.setHugongYesnoTypes(1);
            hugong.setCreateTime(new Date());
        hugongService.insert(hugong);

            return R.ok();
        }else {
            if(hugongEntity.getHugongYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(hugongEntity.getHugongYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

