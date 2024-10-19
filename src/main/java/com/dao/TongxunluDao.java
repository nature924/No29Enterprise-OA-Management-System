package com.dao;

import com.entity.TongxunluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TongxunluVO;
import com.entity.view.TongxunluView;


/**
 * 通讯录
 * 
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface TongxunluDao extends BaseMapper<TongxunluEntity> {
	
	List<TongxunluVO> selectListVO(@Param("ew") Wrapper<TongxunluEntity> wrapper);
	
	TongxunluVO selectVO(@Param("ew") Wrapper<TongxunluEntity> wrapper);
	
	List<TongxunluView> selectListView(@Param("ew") Wrapper<TongxunluEntity> wrapper);

	List<TongxunluView> selectListView(Pagination page,@Param("ew") Wrapper<TongxunluEntity> wrapper);
	
	TongxunluView selectView(@Param("ew") Wrapper<TongxunluEntity> wrapper);
	
}
