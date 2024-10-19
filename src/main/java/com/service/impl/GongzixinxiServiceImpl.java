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


import com.dao.GongzixinxiDao;
import com.entity.GongzixinxiEntity;
import com.service.GongzixinxiService;
import com.entity.vo.GongzixinxiVO;
import com.entity.view.GongzixinxiView;

@Service("gongzixinxiService")
public class GongzixinxiServiceImpl extends ServiceImpl<GongzixinxiDao, GongzixinxiEntity> implements GongzixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzixinxiEntity> page = this.selectPage(
                new Query<GongzixinxiEntity>(params).getPage(),
                new EntityWrapper<GongzixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzixinxiEntity> wrapper) {
		  Page<GongzixinxiView> page =new Query<GongzixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzixinxiVO> selectListVO(Wrapper<GongzixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzixinxiVO selectVO(Wrapper<GongzixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzixinxiView> selectListView(Wrapper<GongzixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzixinxiView selectView(Wrapper<GongzixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
