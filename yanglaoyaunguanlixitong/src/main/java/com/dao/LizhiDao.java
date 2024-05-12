package com.dao;

import com.entity.LizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LizhiView;

/**
 * 离职申请 Dao 接口
 *
 * @author 
 */
public interface LizhiDao extends BaseMapper<LizhiEntity> {

   List<LizhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
