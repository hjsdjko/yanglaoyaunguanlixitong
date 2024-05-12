
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
 * 家属
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiashu")
public class JiashuController {
    private static final Logger logger = LoggerFactory.getLogger(JiashuController.class);

    private static final String TABLE_NAME = "jiashu";

    @Autowired
    private JiashuService jiashuService;


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
        PageUtils page = jiashuService.queryPage(params);

        //字典表数据转换
        List<JiashuView> list =(List<JiashuView>)page.getList();
        for(JiashuView c:list){
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
        JiashuEntity jiashu = jiashuService.selectById(id);
        if(jiashu !=null){
            //entity转view
            JiashuView view = new JiashuView();
            BeanUtils.copyProperties( jiashu , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiashuEntity jiashu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiashu:{}",this.getClass().getName(),jiashu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiashuEntity> queryWrapper = new EntityWrapper<JiashuEntity>()
            .eq("username", jiashu.getUsername())
            .or()
            .eq("jiashu_phone", jiashu.getJiashuPhone())
            .or()
            .eq("jiashu_id_number", jiashu.getJiashuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashuEntity jiashuEntity = jiashuService.selectOne(queryWrapper);
        if(jiashuEntity==null){
            jiashu.setCreateTime(new Date());
            jiashu.setPassword("123456");
            jiashuService.insert(jiashu);
            return R.ok();
        }else {
            return R.error(511,"账户或者家属手机号或者家属身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiashuEntity jiashu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiashu:{}",this.getClass().getName(),jiashu.toString());
        JiashuEntity oldJiashuEntity = jiashuService.selectById(jiashu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiashu.getJiashuPhoto()) || "null".equals(jiashu.getJiashuPhoto())){
                jiashu.setJiashuPhoto(null);
        }

            jiashuService.updateById(jiashu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiashuEntity> oldJiashuList =jiashuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiashuService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiashuEntity> jiashuList = new ArrayList<>();//上传的东西
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
                            JiashuEntity jiashuEntity = new JiashuEntity();
//                            jiashuEntity.setUsername(data.get(0));                    //账户 要改的
//                            jiashuEntity.setPassword("123456");//密码
//                            jiashuEntity.setJiashuUuidNumber(data.get(0));                    //家属编号 要改的
//                            jiashuEntity.setJiashuName(data.get(0));                    //家属姓名 要改的
//                            jiashuEntity.setJiashuPhone(data.get(0));                    //家属手机号 要改的
//                            jiashuEntity.setJiashuIdNumber(data.get(0));                    //家属身份证号 要改的
//                            jiashuEntity.setJiashuPhoto("");//详情和图片
//                            jiashuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiashuEntity.setJiashuEmail(data.get(0));                    //家属邮箱 要改的
//                            jiashuEntity.setCreateTime(date);//时间
                            jiashuList.add(jiashuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //家属编号
                                if(seachFields.containsKey("jiashuUuidNumber")){
                                    List<String> jiashuUuidNumber = seachFields.get("jiashuUuidNumber");
                                    jiashuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiashuUuidNumber = new ArrayList<>();
                                    jiashuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiashuUuidNumber",jiashuUuidNumber);
                                }
                                //家属手机号
                                if(seachFields.containsKey("jiashuPhone")){
                                    List<String> jiashuPhone = seachFields.get("jiashuPhone");
                                    jiashuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiashuPhone = new ArrayList<>();
                                    jiashuPhone.add(data.get(0));//要改的
                                    seachFields.put("jiashuPhone",jiashuPhone);
                                }
                                //家属身份证号
                                if(seachFields.containsKey("jiashuIdNumber")){
                                    List<String> jiashuIdNumber = seachFields.get("jiashuIdNumber");
                                    jiashuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiashuIdNumber = new ArrayList<>();
                                    jiashuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("jiashuIdNumber",jiashuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JiashuEntity> jiashuEntities_username = jiashuService.selectList(new EntityWrapper<JiashuEntity>().in("username", seachFields.get("username")));
                        if(jiashuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiashuEntity s:jiashuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //家属编号
                        List<JiashuEntity> jiashuEntities_jiashuUuidNumber = jiashuService.selectList(new EntityWrapper<JiashuEntity>().in("jiashu_uuid_number", seachFields.get("jiashuUuidNumber")));
                        if(jiashuEntities_jiashuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiashuEntity s:jiashuEntities_jiashuUuidNumber){
                                repeatFields.add(s.getJiashuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [家属编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //家属手机号
                        List<JiashuEntity> jiashuEntities_jiashuPhone = jiashuService.selectList(new EntityWrapper<JiashuEntity>().in("jiashu_phone", seachFields.get("jiashuPhone")));
                        if(jiashuEntities_jiashuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiashuEntity s:jiashuEntities_jiashuPhone){
                                repeatFields.add(s.getJiashuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [家属手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //家属身份证号
                        List<JiashuEntity> jiashuEntities_jiashuIdNumber = jiashuService.selectList(new EntityWrapper<JiashuEntity>().in("jiashu_id_number", seachFields.get("jiashuIdNumber")));
                        if(jiashuEntities_jiashuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiashuEntity s:jiashuEntities_jiashuIdNumber){
                                repeatFields.add(s.getJiashuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [家属身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiashuService.insertBatch(jiashuList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiashuEntity jiashu = jiashuService.selectOne(new EntityWrapper<JiashuEntity>().eq("username", username));
        if(jiashu==null || !jiashu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(jiashu.getId(),username, "jiashu", "家属");
        R r = R.ok();
        r.put("token", token);
        r.put("role","家属");
        r.put("username",jiashu.getJiashuName());
        r.put("tableName","jiashu");
        r.put("userId",jiashu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiashuEntity jiashu, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiashuEntity> queryWrapper = new EntityWrapper<JiashuEntity>()
            .eq("username", jiashu.getUsername())
            .or()
            .eq("jiashu_phone", jiashu.getJiashuPhone())
            .or()
            .eq("jiashu_id_number", jiashu.getJiashuIdNumber())
            ;
        JiashuEntity jiashuEntity = jiashuService.selectOne(queryWrapper);
        if(jiashuEntity != null)
            return R.error("账户或者家属手机号或者家属身份证号已经被使用");
        jiashu.setJiashuUuidNumber(String.valueOf(new Date().getTime()));
        jiashu.setCreateTime(new Date());
        jiashuService.insert(jiashu);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        JiashuEntity jiashu = jiashuService.selectById(id);
        jiashu.setPassword("123456");
        jiashuService.updateById(jiashu);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        JiashuEntity jiashu = jiashuService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(jiashu.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(jiashu.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        jiashu.setPassword(newPassword);
		jiashuService.updateById(jiashu);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiashuEntity jiashu = jiashuService.selectOne(new EntityWrapper<JiashuEntity>().eq("username", username));
        if(jiashu!=null){
            jiashu.setPassword("123456");
            jiashuService.updateById(jiashu);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiashu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiashuEntity jiashu = jiashuService.selectById(id);
        if(jiashu !=null){
            //entity转view
            JiashuView view = new JiashuView();
            BeanUtils.copyProperties( jiashu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiashuService.queryPage(params);

        //字典表数据转换
        List<JiashuView> list =(List<JiashuView>)page.getList();
        for(JiashuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiashuEntity jiashu = jiashuService.selectById(id);
            if(jiashu !=null){


                //entity转view
                JiashuView view = new JiashuView();
                BeanUtils.copyProperties( jiashu , view );//把实体数据重构到view中

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
    public R add(@RequestBody JiashuEntity jiashu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiashu:{}",this.getClass().getName(),jiashu.toString());
        Wrapper<JiashuEntity> queryWrapper = new EntityWrapper<JiashuEntity>()
            .eq("username", jiashu.getUsername())
            .or()
            .eq("jiashu_phone", jiashu.getJiashuPhone())
            .or()
            .eq("jiashu_id_number", jiashu.getJiashuIdNumber())
//            .notIn("jiashu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashuEntity jiashuEntity = jiashuService.selectOne(queryWrapper);
        if(jiashuEntity==null){
            jiashu.setCreateTime(new Date());
            jiashu.setPassword("123456");
        jiashuService.insert(jiashu);

            return R.ok();
        }else {
            return R.error(511,"账户或者家属手机号或者家属身份证号已经被使用");
        }
    }

}

