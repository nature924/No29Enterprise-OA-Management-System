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


import com.dao.WenjianxinxiDao;
import com.entity.WenjianxinxiEntity;
import com.service.WenjianxinxiService;
import com.entity.vo.WenjianxinxiVO;
import com.entity.view.WenjianxinxiView;

@Service("wenjianxinxiService")
public class WenjianxinxiServiceImpl extends ServiceImpl<WenjianxinxiDao, WenjianxinxiEntity> implements WenjianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenjianxinxiEntity> page = this.selectPage(
                new Query<WenjianxinxiEntity>(params).getPage(),
                new EntityWrapper<WenjianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenjianxinxiEntity> wrapper) {
		  Page<WenjianxinxiView> page =new Query<WenjianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WenjianxinxiVO> selectListVO(Wrapper<WenjianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenjianxinxiVO selectVO(Wrapper<WenjianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenjianxinxiView> selectListView(Wrapper<WenjianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenjianxinxiView selectView(Wrapper<WenjianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
