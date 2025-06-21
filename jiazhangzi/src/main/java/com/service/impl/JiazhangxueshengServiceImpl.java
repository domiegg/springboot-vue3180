package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.JiazhangxueshengDao;
import com.entity.JiazhangxueshengEntity;
import com.service.JiazhangxueshengService;
import com.entity.view.JiazhangxueshengView;

/**
 * 家长学生 服务实现类
 */
@Service("jiazhangxueshengService")
@Transactional
public class JiazhangxueshengServiceImpl extends ServiceImpl<JiazhangxueshengDao, JiazhangxueshengEntity> implements JiazhangxueshengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiazhangxueshengView> page =new Query<JiazhangxueshengView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
