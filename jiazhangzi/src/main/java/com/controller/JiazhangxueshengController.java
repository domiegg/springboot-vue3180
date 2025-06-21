
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
 * 家长学生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiazhangxuesheng")
public class JiazhangxueshengController {
    private static final Logger logger = LoggerFactory.getLogger(JiazhangxueshengController.class);

    @Autowired
    private JiazhangxueshengService jiazhangxueshengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("家长学生".equals(role))
            params.put("jiazhangxueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiazhangxueshengService.queryPage(params);

        //字典表数据转换
        List<JiazhangxueshengView> list =(List<JiazhangxueshengView>)page.getList();
        for(JiazhangxueshengView c:list){
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
        JiazhangxueshengEntity jiazhangxuesheng = jiazhangxueshengService.selectById(id);
        if(jiazhangxuesheng !=null){
            //entity转view
            JiazhangxueshengView view = new JiazhangxueshengView();
            BeanUtils.copyProperties( jiazhangxuesheng , view );//把实体数据重构到view中

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
    public R save(@RequestBody JiazhangxueshengEntity jiazhangxuesheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiazhangxuesheng:{}",this.getClass().getName(),jiazhangxuesheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiazhangxueshengEntity> queryWrapper = new EntityWrapper<JiazhangxueshengEntity>()
            .eq("username", jiazhangxuesheng.getUsername())
            .or()
            .eq("jiazhangxuesheng_phone", jiazhangxuesheng.getJiazhangxueshengPhone())
            .or()
            .eq("jiazhangxuesheng_id_number", jiazhangxuesheng.getJiazhangxueshengIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiazhangxueshengEntity jiazhangxueshengEntity = jiazhangxueshengService.selectOne(queryWrapper);
        if(jiazhangxueshengEntity==null){
            jiazhangxuesheng.setCreateTime(new Date());
            jiazhangxuesheng.setPassword("123456");
            jiazhangxueshengService.insert(jiazhangxuesheng);
            return R.ok();
        }else {
            return R.error(511,"账户或者家长联系方式或者学生身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiazhangxueshengEntity jiazhangxuesheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiazhangxuesheng:{}",this.getClass().getName(),jiazhangxuesheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiazhangxueshengEntity> queryWrapper = new EntityWrapper<JiazhangxueshengEntity>()
            .notIn("id",jiazhangxuesheng.getId())
            .andNew()
            .eq("username", jiazhangxuesheng.getUsername())
            .or()
            .eq("jiazhangxuesheng_phone", jiazhangxuesheng.getJiazhangxueshengPhone())
            .or()
            .eq("jiazhangxuesheng_id_number", jiazhangxuesheng.getJiazhangxueshengIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiazhangxueshengEntity jiazhangxueshengEntity = jiazhangxueshengService.selectOne(queryWrapper);
        if("".equals(jiazhangxuesheng.getJiazhangxueshengPhoto()) || "null".equals(jiazhangxuesheng.getJiazhangxueshengPhoto())){
                jiazhangxuesheng.setJiazhangxueshengPhoto(null);
        }
        if(jiazhangxueshengEntity==null){
            jiazhangxueshengService.updateById(jiazhangxuesheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者家长联系方式或者学生身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiazhangxueshengService.deleteBatchIds(Arrays.asList(ids));
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
        try {
            List<JiazhangxueshengEntity> jiazhangxueshengList = new ArrayList<>();//上传的东西
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
                            JiazhangxueshengEntity jiazhangxueshengEntity = new JiazhangxueshengEntity();
//                            jiazhangxueshengEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jiazhangxueshengEntity.setPassword("123456");//密码
//                            jiazhangxueshengEntity.setJiazhangxueshengJiazhangname(data.get(0));                    //家长姓名 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengPhone(data.get(0));                    //家长联系方式 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengUuidNumber(data.get(0));                    //学号 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengXuesheng(data.get(0));                    //学生姓名 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengIdNumber(data.get(0));                    //学生身份证号 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengPhoto("");//详情和图片
//                            jiazhangxueshengEntity.setSexTypes(Integer.valueOf(data.get(0)));   //学生性别 要改的
//                            jiazhangxueshengEntity.setBanjiTypes(Integer.valueOf(data.get(0)));   //班级 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengNianji(data.get(0));                    //年级 要改的
//                            jiazhangxueshengEntity.setJiazhangxueshengEmail(data.get(0));                    //联系邮箱 要改的
//                            jiazhangxueshengEntity.setNewMoney(data.get(0));                    //现有余额 要改的
//                            jiazhangxueshengEntity.setCreateTime(date);//时间
                            jiazhangxueshengList.add(jiazhangxueshengEntity);


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
                                //家长联系方式
                                if(seachFields.containsKey("jiazhangxueshengPhone")){
                                    List<String> jiazhangxueshengPhone = seachFields.get("jiazhangxueshengPhone");
                                    jiazhangxueshengPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiazhangxueshengPhone = new ArrayList<>();
                                    jiazhangxueshengPhone.add(data.get(0));//要改的
                                    seachFields.put("jiazhangxueshengPhone",jiazhangxueshengPhone);
                                }
                                //学号
                                if(seachFields.containsKey("jiazhangxueshengUuidNumber")){
                                    List<String> jiazhangxueshengUuidNumber = seachFields.get("jiazhangxueshengUuidNumber");
                                    jiazhangxueshengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiazhangxueshengUuidNumber = new ArrayList<>();
                                    jiazhangxueshengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiazhangxueshengUuidNumber",jiazhangxueshengUuidNumber);
                                }
                                //学生身份证号
                                if(seachFields.containsKey("jiazhangxueshengIdNumber")){
                                    List<String> jiazhangxueshengIdNumber = seachFields.get("jiazhangxueshengIdNumber");
                                    jiazhangxueshengIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiazhangxueshengIdNumber = new ArrayList<>();
                                    jiazhangxueshengIdNumber.add(data.get(0));//要改的
                                    seachFields.put("jiazhangxueshengIdNumber",jiazhangxueshengIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JiazhangxueshengEntity> jiazhangxueshengEntities_username = jiazhangxueshengService.selectList(new EntityWrapper<JiazhangxueshengEntity>().in("username", seachFields.get("username")));
                        if(jiazhangxueshengEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiazhangxueshengEntity s:jiazhangxueshengEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //家长联系方式
                        List<JiazhangxueshengEntity> jiazhangxueshengEntities_jiazhangxueshengPhone = jiazhangxueshengService.selectList(new EntityWrapper<JiazhangxueshengEntity>().in("jiazhangxuesheng_phone", seachFields.get("jiazhangxueshengPhone")));
                        if(jiazhangxueshengEntities_jiazhangxueshengPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiazhangxueshengEntity s:jiazhangxueshengEntities_jiazhangxueshengPhone){
                                repeatFields.add(s.getJiazhangxueshengPhone());
                            }
                            return R.error(511,"数据库的该表中的 [家长联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学号
                        List<JiazhangxueshengEntity> jiazhangxueshengEntities_jiazhangxueshengUuidNumber = jiazhangxueshengService.selectList(new EntityWrapper<JiazhangxueshengEntity>().in("jiazhangxuesheng_uuid_number", seachFields.get("jiazhangxueshengUuidNumber")));
                        if(jiazhangxueshengEntities_jiazhangxueshengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiazhangxueshengEntity s:jiazhangxueshengEntities_jiazhangxueshengUuidNumber){
                                repeatFields.add(s.getJiazhangxueshengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学生身份证号
                        List<JiazhangxueshengEntity> jiazhangxueshengEntities_jiazhangxueshengIdNumber = jiazhangxueshengService.selectList(new EntityWrapper<JiazhangxueshengEntity>().in("jiazhangxuesheng_id_number", seachFields.get("jiazhangxueshengIdNumber")));
                        if(jiazhangxueshengEntities_jiazhangxueshengIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiazhangxueshengEntity s:jiazhangxueshengEntities_jiazhangxueshengIdNumber){
                                repeatFields.add(s.getJiazhangxueshengIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学生身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiazhangxueshengService.insertBatch(jiazhangxueshengList);
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
        JiazhangxueshengEntity jiazhangxuesheng = jiazhangxueshengService.selectOne(new EntityWrapper<JiazhangxueshengEntity>().eq("username", username));
        if(jiazhangxuesheng==null || !jiazhangxuesheng.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(jiazhangxuesheng.getId(),username, "jiazhangxuesheng", "家长学生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","家长学生");
        r.put("username",jiazhangxuesheng.getJiazhangxueshengXuesheng());
        r.put("tableName","jiazhangxuesheng");
        r.put("userId",jiazhangxuesheng.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiazhangxueshengEntity jiazhangxuesheng){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiazhangxueshengEntity> queryWrapper = new EntityWrapper<JiazhangxueshengEntity>()
            .eq("username", jiazhangxuesheng.getUsername())
            .or()
            .eq("jiazhangxuesheng_phone", jiazhangxuesheng.getJiazhangxueshengPhone())
            .or()
            .eq("jiazhangxuesheng_id_number", jiazhangxuesheng.getJiazhangxueshengIdNumber())
            ;
        JiazhangxueshengEntity jiazhangxueshengEntity = jiazhangxueshengService.selectOne(queryWrapper);
        if(jiazhangxueshengEntity != null)
            return R.error("账户或者家长联系方式或者学生身份证号已经被使用");
        jiazhangxuesheng.setNewMoney(0.0);
        jiazhangxuesheng.setCreateTime(new Date());
        jiazhangxueshengService.insert(jiazhangxuesheng);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JiazhangxueshengEntity jiazhangxuesheng = new JiazhangxueshengEntity();
        jiazhangxuesheng.setPassword("123456");
        jiazhangxuesheng.setId(id);
        jiazhangxueshengService.updateById(jiazhangxuesheng);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiazhangxueshengEntity jiazhangxuesheng = jiazhangxueshengService.selectOne(new EntityWrapper<JiazhangxueshengEntity>().eq("username", username));
        if(jiazhangxuesheng!=null){
            jiazhangxuesheng.setPassword("123456");
            boolean b = jiazhangxueshengService.updateById(jiazhangxuesheng);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiazhangxuesheng(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiazhangxueshengEntity jiazhangxuesheng = jiazhangxueshengService.selectById(id);
        if(jiazhangxuesheng !=null){
            //entity转view
            JiazhangxueshengView view = new JiazhangxueshengView();
            BeanUtils.copyProperties( jiazhangxuesheng , view );//把实体数据重构到view中

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





}
