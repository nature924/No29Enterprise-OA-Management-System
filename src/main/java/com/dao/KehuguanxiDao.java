package com.dao;

import com.entity.KehuguanxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KehuguanxiVO;
import com.entity.view.KehuguanxiView;


/**
 * 客户关系
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface KehuguanxiDao extends BaseMapper<KehuguanxiEntity> {
	
	List<KehuguanxiVO> selectListVO(@Param("ew") Wrapper<KehuguanxiEntity> wrapper);
	
	KehuguanxiVO selectVO(@Param("ew") Wrapper<KehuguanxiEntity> wrapper);
	
	List<KehuguanxiView> selectListView(@Param("ew") Wrapper<KehuguanxiEntity> wrapper);

	List<KehuguanxiView> selectListView(Pagination page,@Param("ew") Wrapper<KehuguanxiEntity> wrapper);
	
	KehuguanxiView selectView(@Param("ew") Wrapper<KehuguanxiEntity> wrapper);
	
}
