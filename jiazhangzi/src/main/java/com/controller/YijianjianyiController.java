
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
 * 意见建议
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yijianjianyi")
public class YijianjianyiController {
    private static final Logger logger = LoggerFactory.getLogger(YijianjianyiController.class);

    @Autowired
    private YijianjianyiService yijianjianyiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiazhangxueshengService jiazhangxueshengService;

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
        PageUtils page = yijianjianyiService.queryPage(params);

        //字典表数据转换
        List<YijianjianyiView> list =(List<YijianjianyiView>)page.getList();
        for(YijianjianyiView c:list){
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
        YijianjianyiEntity yijianjianyi = yijianjianyiService.selectById(id);
        if(yijianjianyi !=null){
            //entity转view
            YijianjianyiView view = new YijianjianyiView();
            BeanUtils.copyProperties( yijianjianyi , view );//把实体数据重构到view中

                //级联表
                JiazhangxueshengEntity jiazhangxuesheng = jiazhangxueshengService.selectById(yijianjianyi.getJiazhangxueshengId());
                if(jiazhangxuesheng != null){
                    BeanUtils.copyProperties( jiazhangxuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiazhangxueshengId(jiazhangxuesheng.getId());
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
    public R save(@RequestBody YijianjianyiEntity yijianjianyi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yijianjianyi:{}",this.getClass().getName(),yijianjianyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("家长学生".equals(role))
            yijianjianyi.setJiazhangxueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YijianjianyiEntity> queryWrapper = new EntityWrapper<YijianjianyiEntity>()
            .eq("jiazhangxuesheng_id", yijianjianyi.getJiazhangxueshengId())
            .eq("yijianjianyi_name", yijianjianyi.getYijianjianyiName())
            .eq("yijianjianyi_types", yijianjianyi.getYijianjianyiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YijianjianyiEntity yijianjianyiEntity = yijianjianyiService.selectOne(queryWrapper);
        if(yijianjianyiEntity==null){
            yijianjianyi.setInsertTime(new Date());
            yijianjianyi.setCreateTime(new Date());
            yijianjianyiService.insert(yijianjianyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YijianjianyiEntity yijianjianyi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yijianjianyi:{}",this.getClass().getName(),yijianjianyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("家长学生".equals(role))
//            yijianjianyi.setJiazhangxueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YijianjianyiEntity> queryWrapper = new EntityWrapper<YijianjianyiEntity>()
            .notIn("id",yijianjianyi.getId())
            .andNew()
            .eq("jiazhangxuesheng_id", yijianjianyi.getJiazhangxueshengId())
            .eq("yijianjianyi_name", yijianjianyi.getYijianjianyiName())
            .eq("yijianjianyi_types", yijianjianyi.getYijianjianyiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YijianjianyiEntity yijianjianyiEntity = yijianjianyiService.selectOne(queryWrapper);
        if(yijianjianyiEntity==null){
            yijianjianyiService.updateById(yijianjianyi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yijianjianyiService.deleteBatchIds(Arrays.asList(ids));
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
            List<YijianjianyiEntity> yijianjianyiList = new ArrayList<>();//上传的东西
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
                            YijianjianyiEntity yijianjianyiEntity = new YijianjianyiEntity();
//                            yijianjianyiEntity.setJiazhangxueshengId(Integer.valueOf(data.get(0)));   //家长学生 要改的
//                            yijianjianyiEntity.setYijianjianyiName(data.get(0));                    //意见建议名称 要改的
//                            yijianjianyiEntity.setYijianjianyiTypes(Integer.valueOf(data.get(0)));   //意见建议类型 要改的
//                            yijianjianyiEntity.setYijianjianyiContent("");//详情和图片
//                            yijianjianyiEntity.setInsertTime(date);//时间
//                            yijianjianyiEntity.setCreateTime(date);//时间
                            yijianjianyiList.add(yijianjianyiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yijianjianyiService.insertBatch(yijianjianyiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
