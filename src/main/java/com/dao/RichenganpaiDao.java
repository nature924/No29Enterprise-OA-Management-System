package com.dao;

import com.entity.RichenganpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RichenganpaiVO;
import com.entity.view.RichenganpaiView;


/**
 * 日程安排
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface RichenganpaiDao extends BaseMapper<RichenganpaiEntity> {
	
	List<RichenganpaiVO> selectListVO(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
	
	RichenganpaiVO selectVO(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
	
	List<RichenganpaiView> selectListView(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);

	List<RichenganpaiView> selectListView(Pagination page,@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
	
	RichenganpaiView selectView(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
	
}
