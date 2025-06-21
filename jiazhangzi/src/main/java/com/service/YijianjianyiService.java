package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YijianjianyiEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 意见建议 服务类
 */
public interface YijianjianyiService extends IService<YijianjianyiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}