package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TongxunluDao;
import com.entity.TongxunluEntity;
import com.service.TongxunluService;
import com.entity.vo.TongxunluVO;
import com.entity.view.TongxunluView;

@Service("tongxunluService")
public class TongxunluServiceImpl extends ServiceImpl<TongxunluDao, TongxunluEntity> implements TongxunluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TongxunluEntity> page = this.selectPage(
                new Query<TongxunluEntity>(params).getPage(),
                new EntityWrapper<TongxunluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TongxunluEntity> wrapper) {
		  Page<TongxunluView> page =new Query<TongxunluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TongxunluVO> selectListVO(Wrapper<TongxunluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TongxunluVO selectVO(Wrapper<TongxunluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TongxunluView> selectListView(Wrapper<TongxunluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TongxunluView selectView(Wrapper<TongxunluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
