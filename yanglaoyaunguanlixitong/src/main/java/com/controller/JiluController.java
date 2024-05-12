
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
 * 健康信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jilu")
public class JiluController {
    private static final Logger logger = LoggerFactory.getLogger(JiluController.class);

    private static final String TABLE_NAME = "jilu";

    @Autowired
    private JiluService jiluService;


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
        params.put("jiluDeleteStart",1);params.put("jiluDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiluService.queryPage(params);

        //字典表数据转换
        List<JiluView> list =(List<JiluView>)page.getList();
        for(JiluView c:list){
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
        JiluEntity jilu = jiluService.selectById(id);
        if(jilu !=null){
            //entity转view
            JiluView view = new JiluView();
            BeanUtils.copyProperties( jilu , view );//把实体数据重构到view中
            //级联表 护工
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jilu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 老人
            //级联表
            LaorenEntity laoren = laorenService.selectById(jilu.getLaorenId());
            if(laoren != null){
            BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody JiluEntity jilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jilu:{}",this.getClass().getName(),jilu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("护工".equals(role))
            jilu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiluEntity> queryWrapper = new EntityWrapper<JiluEntity>()
            .eq("yonghu_id", jilu.getYonghuId())
            .eq("laoren_id", jilu.getLaorenId())
            .eq("jilu_name", jilu.getJiluName())
            .eq("jilu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiluEntity jiluEntity = jiluService.selectOne(queryWrapper);
        if(jiluEntity==null){
            jilu.setJiluDelete(1);
            jilu.setInsertTime(new Date());
            jilu.setCreateTime(new Date());
            jiluService.insert(jilu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiluEntity jilu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jilu:{}",this.getClass().getName(),jilu.toString());
        JiluEntity oldJiluEntity = jiluService.selectById(jilu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("护工".equals(role))
//            jilu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jilu.getJiluPhoto()) || "null".equals(jilu.getJiluPhoto())){
                jilu.setJiluPhoto(null);
        }
        if("".equals(jilu.getJiluContent()) || "null".equals(jilu.getJiluContent())){
                jilu.setJiluContent(null);
        }

            jiluService.updateById(jilu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiluEntity> oldJiluList =jiluService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiluEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiluEntity jiluEntity = new JiluEntity();
            jiluEntity.setId(id);
            jiluEntity.setJiluDelete(2);
            list.add(jiluEntity);
        }
        if(list != null && list.size() >0){
            jiluService.updateBatchById(list);
        }

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
            List<JiluEntity> jiluList = new ArrayList<>();//上传的东西
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
                            JiluEntity jiluEntity = new JiluEntity();
//                            jiluEntity.setYonghuId(Integer.valueOf(data.get(0)));   //护工 要改的
//                            jiluEntity.setLaorenId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            jiluEntity.setJiluName(data.get(0));                    //记录名称 要改的
//                            jiluEntity.setJiluUuidNumber(data.get(0));                    //记录编号 要改的
//                            jiluEntity.setJiluPhoto("");//详情和图片
//                            jiluEntity.setJiluTiwen(data.get(0));                    //体温 要改的
//                            jiluEntity.setJiluXueya(data.get(0));                    //血压 要改的
//                            jiluEntity.setJiluContent("");//详情和图片
//                            jiluEntity.setJiluDelete(1);//逻辑删除字段
//                            jiluEntity.setInsertTime(date);//时间
//                            jiluEntity.setCreateTime(date);//时间
                            jiluList.add(jiluEntity);


                            //把要查询是否重复的字段放入map中
                                //记录编号
                                if(seachFields.containsKey("jiluUuidNumber")){
                                    List<String> jiluUuidNumber = seachFields.get("jiluUuidNumber");
                                    jiluUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiluUuidNumber = new ArrayList<>();
                                    jiluUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiluUuidNumber",jiluUuidNumber);
                                }
                        }

                        //查询是否重复
                         //记录编号
                        List<JiluEntity> jiluEntities_jiluUuidNumber = jiluService.selectList(new EntityWrapper<JiluEntity>().in("jilu_uuid_number", seachFields.get("jiluUuidNumber")).eq("jilu_delete", 1));
                        if(jiluEntities_jiluUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiluEntity s:jiluEntities_jiluUuidNumber){
                                repeatFields.add(s.getJiluUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [记录编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiluService.insertBatch(jiluList);
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
        PageUtils page = jiluService.queryPage(params);

        //字典表数据转换
        List<JiluView> list =(List<JiluView>)page.getList();
        for(JiluView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiluEntity jilu = jiluService.selectById(id);
            if(jilu !=null){


                //entity转view
                JiluView view = new JiluView();
                BeanUtils.copyProperties( jilu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jilu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    LaorenEntity laoren = laorenService.selectById(jilu.getLaorenId());
                if(laoren != null){
                    BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
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
    public R add(@RequestBody JiluEntity jilu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jilu:{}",this.getClass().getName(),jilu.toString());
        Wrapper<JiluEntity> queryWrapper = new EntityWrapper<JiluEntity>()
            .eq("yonghu_id", jilu.getYonghuId())
            .eq("laoren_id", jilu.getLaorenId())
            .eq("jilu_name", jilu.getJiluName())
            .eq("jilu_uuid_number", jilu.getJiluUuidNumber())
            .eq("jilu_delete", jilu.getJiluDelete())
//            .notIn("jilu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiluEntity jiluEntity = jiluService.selectOne(queryWrapper);
        if(jiluEntity==null){
            jilu.setJiluDelete(1);
            jilu.setInsertTime(new Date());
            jilu.setCreateTime(new Date());
        jiluService.insert(jilu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

