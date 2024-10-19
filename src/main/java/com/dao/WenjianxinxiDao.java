package com.dao;

import com.entity.WenjianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenjianxinxiVO;
import com.entity.view.WenjianxinxiView;


/**
 * 文件信息
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface WenjianxinxiDao extends BaseMapper<WenjianxinxiEntity> {
	
	List<WenjianxinxiVO> selectListVO(@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);
	
	WenjianxinxiVO selectVO(@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);
	
	List<WenjianxinxiView> selectListView(@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);

	List<WenjianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);
	
	WenjianxinxiView selectView(@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);
	
}
