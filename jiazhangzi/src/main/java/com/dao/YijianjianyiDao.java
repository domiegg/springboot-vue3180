package com.dao;

import com.entity.YijianjianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YijianjianyiView;

/**
 * 意见建议 Dao 接口
 *
 * @author 
 */
public interface YijianjianyiDao extends BaseMapper<YijianjianyiEntity> {

   List<YijianjianyiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
