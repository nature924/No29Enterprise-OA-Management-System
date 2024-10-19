package com.dao;

import com.entity.GongzixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzixinxiVO;
import com.entity.view.GongzixinxiView;


/**
 * 工资信息
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface GongzixinxiDao extends BaseMapper<GongzixinxiEntity> {
	
	List<GongzixinxiVO> selectListVO(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
	
	GongzixinxiVO selectVO(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
	
	List<GongzixinxiView> selectListView(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);

	List<GongzixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
	
	GongzixinxiView selectView(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
	
}
