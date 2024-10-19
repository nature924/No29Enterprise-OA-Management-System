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


import com.dao.ShangbankaoqinDao;
import com.entity.ShangbankaoqinEntity;
import com.service.ShangbankaoqinService;
import com.entity.vo.ShangbankaoqinVO;
import com.entity.view.ShangbankaoqinView;

@Service("shangbankaoqinService")
public class ShangbankaoqinServiceImpl extends ServiceImpl<ShangbankaoqinDao, ShangbankaoqinEntity> implements ShangbankaoqinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangbankaoqinEntity> page = this.selectPage(
                new Query<ShangbankaoqinEntity>(params).getPage(),
                new EntityWrapper<ShangbankaoqinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangbankaoqinEntity> wrapper) {
		  Page<ShangbankaoqinView> page =new Query<ShangbankaoqinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangbankaoqinVO> selectListVO(Wrapper<ShangbankaoqinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangbankaoqinVO selectVO(Wrapper<ShangbankaoqinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangbankaoqinView> selectListView(Wrapper<ShangbankaoqinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangbankaoqinView selectView(Wrapper<ShangbankaoqinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
