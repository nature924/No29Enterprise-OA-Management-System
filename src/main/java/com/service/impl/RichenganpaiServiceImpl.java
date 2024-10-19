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


import com.dao.RichenganpaiDao;
import com.entity.RichenganpaiEntity;
import com.service.RichenganpaiService;
import com.entity.vo.RichenganpaiVO;
import com.entity.view.RichenganpaiView;

@Service("richenganpaiService")
public class RichenganpaiServiceImpl extends ServiceImpl<RichenganpaiDao, RichenganpaiEntity> implements RichenganpaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RichenganpaiEntity> page = this.selectPage(
                new Query<RichenganpaiEntity>(params).getPage(),
                new EntityWrapper<RichenganpaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RichenganpaiEntity> wrapper) {
		  Page<RichenganpaiView> page =new Query<RichenganpaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RichenganpaiVO> selectListVO(Wrapper<RichenganpaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RichenganpaiVO selectVO(Wrapper<RichenganpaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RichenganpaiView> selectListView(Wrapper<RichenganpaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RichenganpaiView selectView(Wrapper<RichenganpaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
