package com.dao;

import com.entity.JiazhangxueshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiazhangxueshengView;

/**
 * 家长学生 Dao 接口
 *
 * @author 
 */
public interface JiazhangxueshengDao extends BaseMapper<JiazhangxueshengEntity> {

   List<JiazhangxueshengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
