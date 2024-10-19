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


import com.dao.GongzuorizhiDao;
import com.entity.GongzuorizhiEntity;
import com.service.GongzuorizhiService;
import com.entity.vo.GongzuorizhiVO;
import com.entity.view.GongzuorizhiView;

@Service("gongzuorizhiService")
public class GongzuorizhiServiceImpl extends ServiceImpl<GongzuorizhiDao, GongzuorizhiEntity> implements GongzuorizhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuorizhiEntity> page = this.selectPage(
                new Query<GongzuorizhiEntity>(params).getPage(),
                new EntityWrapper<GongzuorizhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuorizhiEntity> wrapper) {
		  Page<GongzuorizhiView> page =new Query<GongzuorizhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzuorizhiVO> selectListVO(Wrapper<GongzuorizhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzuorizhiVO selectVO(Wrapper<GongzuorizhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzuorizhiView> selectListView(Wrapper<GongzuorizhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuorizhiView selectView(Wrapper<GongzuorizhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
