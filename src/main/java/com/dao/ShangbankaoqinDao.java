package com.dao;

import com.entity.ShangbankaoqinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangbankaoqinVO;
import com.entity.view.ShangbankaoqinView;


/**
 * 上班考勤
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface ShangbankaoqinDao extends BaseMapper<ShangbankaoqinEntity> {
	
	List<ShangbankaoqinVO> selectListVO(@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);
	
	ShangbankaoqinVO selectVO(@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);
	
	List<ShangbankaoqinView> selectListView(@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);

	List<ShangbankaoqinView> selectListView(Pagination page,@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);
	
	ShangbankaoqinView selectView(@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);
	
}
