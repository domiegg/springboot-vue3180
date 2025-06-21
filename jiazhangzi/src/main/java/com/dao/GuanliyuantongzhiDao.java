package com.dao;

import com.entity.GuanliyuantongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanliyuantongzhiView;

/**
 * 管理员通知 Dao 接口
 *
 * @author 
 */
public interface GuanliyuantongzhiDao extends BaseMapper<GuanliyuantongzhiEntity> {

   List<GuanliyuantongzhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
