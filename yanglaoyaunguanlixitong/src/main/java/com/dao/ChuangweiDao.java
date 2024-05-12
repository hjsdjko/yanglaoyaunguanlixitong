package com.dao;

import com.entity.ChuangweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangweiView;

/**
 * 床位 Dao 接口
 *
 * @author 
 */
public interface ChuangweiDao extends BaseMapper<ChuangweiEntity> {

   List<ChuangweiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
