package com.dao;

import com.entity.ChuangweiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangweiYuyueView;

/**
 * 床位调动申请 Dao 接口
 *
 * @author 
 */
public interface ChuangweiYuyueDao extends BaseMapper<ChuangweiYuyueEntity> {

   List<ChuangweiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
