package com.dao;

import com.entity.GongzuorizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzuorizhiVO;
import com.entity.view.GongzuorizhiView;


/**
 * 工作日志
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface GongzuorizhiDao extends BaseMapper<GongzuorizhiEntity> {
	
	List<GongzuorizhiVO> selectListVO(@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);
	
	GongzuorizhiVO selectVO(@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);
	
	List<GongzuorizhiView> selectListView(@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);

	List<GongzuorizhiView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);
	
	GongzuorizhiView selectView(@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);
	
}
