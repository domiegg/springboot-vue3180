
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
 * 成绩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chengji")
public class ChengjiController {
    private static final Logger logger = LoggerFactory.getLogger(ChengjiController.class);

    @Autowired
    private ChengjiService chengjiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiazhangxueshengService jiazhangxueshengService;
    @Autowired
    private KaoshiService kaoshiService;

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
        params.put("orderBy","paiming");
        PageUtils page = chengjiService.queryPage(params);

        //字典表数据转换
        List<ChengjiView> list =(List<ChengjiView>)page.getList();
        for(ChengjiView c:list){
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
        ChengjiEntity chengji = chengjiService.selectById(id);
        if(chengji !=null){
            //entity转view
            ChengjiView view = new ChengjiView();
            BeanUtils.copyProperties( chengji , view );//把实体数据重构到view中

                //级联表
                JiazhangxueshengEntity jiazhangxuesheng = jiazhangxueshengService.selectById(chengji.getJiazhangxueshengId());
                if(jiazhangxuesheng != null){
                    BeanUtils.copyProperties( jiazhangxuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiazhangxueshengId(jiazhangxuesheng.getId());
                }
                //级联表
                KaoshiEntity kaoshi = kaoshiService.selectById(chengji.getKaoshiId());
                if(kaoshi != null){
                    BeanUtils.copyProperties( kaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKaoshiId(kaoshi.getId());
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
    public R save(@RequestBody ChengjiEntity chengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chengji:{}",this.getClass().getName(),chengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("家长学生".equals(role))
            chengji.setJiazhangxueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChengjiEntity> queryWrapper = new EntityWrapper<ChengjiEntity>()
            .eq("kaoshi_id", chengji.getKaoshiId())
            .eq("jiazhangxuesheng_id", chengji.getJiazhangxueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengjiEntity chengjiEntity = chengjiService.selectOne(queryWrapper);
        if(chengjiEntity==null){
            chengji.setInsertTime(new Date());
            chengji.setCreateTime(new Date());
            chengjiService.insert(chengji);
            return R.ok();
        }else {
            return R.error(511,"该考试已经该学生的成绩");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChengjiEntity chengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chengji:{}",this.getClass().getName(),chengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("家长学生".equals(role))
//            chengji.setJiazhangxueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChengjiEntity> queryWrapper = new EntityWrapper<ChengjiEntity>()
            .notIn("id",chengji.getId())
            .andNew()
            .eq("kaoshi_id", chengji.getKaoshiId())
            .eq("jiazhangxuesheng_id", chengji.getJiazhangxueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengjiEntity chengjiEntity = chengjiService.selectOne(queryWrapper);
        if("".equals(chengji.getChengjiFile()) || "null".equals(chengji.getChengjiFile())){
                chengji.setChengjiFile(null);
        }
        if(chengjiEntity==null){
            chengjiService.updateById(chengji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该考试已经该学生的成绩");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chengjiService.deleteBatchIds(Arrays.asList(ids));
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
            List<ChengjiEntity> chengjiList = new ArrayList<>();//上传的东西
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
                            ChengjiEntity chengjiEntity = new ChengjiEntity();
//                            chengjiEntity.setKaoshiId(Integer.valueOf(data.get(0)));   //考试 要改的
//                            chengjiEntity.setJiazhangxueshengId(Integer.valueOf(data.get(0)));   //家长学生 要改的
//                            chengjiEntity.setChengjiFile(data.get(0));                    //试卷答题文件 要改的
//                            chengjiEntity.setHuidaDefen(data.get(0));                    //考试得分 要改的
//                            chengjiEntity.setPaiming(Integer.valueOf(data.get(0)));   //排名 要改的
//                            chengjiEntity.setHuidaContent("");//详情和图片
//                            chengjiEntity.setInsertTime(date);//时间
//                            chengjiEntity.setCreateTime(date);//时间
                            chengjiList.add(chengjiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chengjiService.insertBatch(chengjiList);
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
