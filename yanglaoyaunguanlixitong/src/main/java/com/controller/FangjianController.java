
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
 * 房间
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangjian")
public class FangjianController {
    private static final Logger logger = LoggerFactory.getLogger(FangjianController.class);

    private static final String TABLE_NAME = "fangjian";

    @Autowired
    private FangjianService fangjianService;


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
        params.put("fangjianDeleteStart",1);params.put("fangjianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = fangjianService.queryPage(params);

        //字典表数据转换
        List<FangjianView> list =(List<FangjianView>)page.getList();
        for(FangjianView c:list){
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
        FangjianEntity fangjian = fangjianService.selectById(id);
        if(fangjian !=null){
            //entity转view
            FangjianView view = new FangjianView();
            BeanUtils.copyProperties( fangjian , view );//把实体数据重构到view中
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
    public R save(@RequestBody FangjianEntity fangjian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangjian:{}",this.getClass().getName(),fangjian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FangjianEntity> queryWrapper = new EntityWrapper<FangjianEntity>()
            .eq("fangjian_name", fangjian.getFangjianName())
            .eq("fangjian_address", fangjian.getFangjianAddress())
            .eq("fangjian_types", fangjian.getFangjianTypes())
            .eq("fangjian_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianEntity fangjianEntity = fangjianService.selectOne(queryWrapper);
        if(fangjianEntity==null){
            fangjian.setFangjianDelete(1);
            fangjian.setInsertTime(new Date());
            fangjian.setCreateTime(new Date());
            fangjianService.insert(fangjian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjianEntity fangjian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangjian:{}",this.getClass().getName(),fangjian.toString());
        FangjianEntity oldFangjianEntity = fangjianService.selectById(fangjian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(fangjian.getFangjianPhoto()) || "null".equals(fangjian.getFangjianPhoto())){
                fangjian.setFangjianPhoto(null);
        }
        if("".equals(fangjian.getFangjianContent()) || "null".equals(fangjian.getFangjianContent())){
                fangjian.setFangjianContent(null);
        }

            fangjianService.updateById(fangjian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangjianEntity> oldFangjianList =fangjianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FangjianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FangjianEntity fangjianEntity = new FangjianEntity();
            fangjianEntity.setId(id);
            fangjianEntity.setFangjianDelete(2);
            list.add(fangjianEntity);
        }
        if(list != null && list.size() >0){
            fangjianService.updateBatchById(list);
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
            List<FangjianEntity> fangjianList = new ArrayList<>();//上传的东西
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
                            FangjianEntity fangjianEntity = new FangjianEntity();
//                            fangjianEntity.setFangjianName(data.get(0));                    //房间名称 要改的
//                            fangjianEntity.setFangjianUuidNumber(data.get(0));                    //房间编号 要改的
//                            fangjianEntity.setFangjianPhoto("");//详情和图片
//                            fangjianEntity.setFangjianAddress(data.get(0));                    //房间地点 要改的
//                            fangjianEntity.setFangjianTypes(Integer.valueOf(data.get(0)));   //房间类型 要改的
//                            fangjianEntity.setFangjianContent("");//详情和图片
//                            fangjianEntity.setFangjianDelete(1);//逻辑删除字段
//                            fangjianEntity.setInsertTime(date);//时间
//                            fangjianEntity.setCreateTime(date);//时间
                            fangjianList.add(fangjianEntity);


                            //把要查询是否重复的字段放入map中
                                //房间编号
                                if(seachFields.containsKey("fangjianUuidNumber")){
                                    List<String> fangjianUuidNumber = seachFields.get("fangjianUuidNumber");
                                    fangjianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangjianUuidNumber = new ArrayList<>();
                                    fangjianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangjianUuidNumber",fangjianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //房间编号
                        List<FangjianEntity> fangjianEntities_fangjianUuidNumber = fangjianService.selectList(new EntityWrapper<FangjianEntity>().in("fangjian_uuid_number", seachFields.get("fangjianUuidNumber")).eq("fangjian_delete", 1));
                        if(fangjianEntities_fangjianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangjianEntity s:fangjianEntities_fangjianUuidNumber){
                                repeatFields.add(s.getFangjianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [房间编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangjianService.insertBatch(fangjianList);
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
        PageUtils page = fangjianService.queryPage(params);

        //字典表数据转换
        List<FangjianView> list =(List<FangjianView>)page.getList();
        for(FangjianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjianEntity fangjian = fangjianService.selectById(id);
            if(fangjian !=null){


                //entity转view
                FangjianView view = new FangjianView();
                BeanUtils.copyProperties( fangjian , view );//把实体数据重构到view中

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
    public R add(@RequestBody FangjianEntity fangjian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangjian:{}",this.getClass().getName(),fangjian.toString());
        Wrapper<FangjianEntity> queryWrapper = new EntityWrapper<FangjianEntity>()
            .eq("fangjian_name", fangjian.getFangjianName())
            .eq("fangjian_uuid_number", fangjian.getFangjianUuidNumber())
            .eq("fangjian_address", fangjian.getFangjianAddress())
            .eq("fangjian_types", fangjian.getFangjianTypes())
            .eq("fangjian_delete", fangjian.getFangjianDelete())
//            .notIn("fangjian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianEntity fangjianEntity = fangjianService.selectOne(queryWrapper);
        if(fangjianEntity==null){
            fangjian.setFangjianDelete(1);
            fangjian.setInsertTime(new Date());
            fangjian.setCreateTime(new Date());
        fangjianService.insert(fangjian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

