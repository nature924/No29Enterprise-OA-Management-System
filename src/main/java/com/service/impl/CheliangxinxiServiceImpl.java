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


import com.dao.CheliangxinxiDao;
import com.entity.CheliangxinxiEntity;
import com.service.CheliangxinxiService;
import com.entity.vo.CheliangxinxiVO;
import com.entity.view.CheliangxinxiView;

@Service("cheliangxinxiService")
public class CheliangxinxiServiceImpl extends ServiceImpl<CheliangxinxiDao, CheliangxinxiEntity> implements CheliangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangxinxiEntity> page = this.selectPage(
                new Query<CheliangxinxiEntity>(params).getPage(),
                new EntityWrapper<CheliangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangxinxiEntity> wrapper) {
		  Page<CheliangxinxiView> page =new Query<CheliangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CheliangxinxiVO> selectListVO(Wrapper<CheliangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheliangxinxiVO selectVO(Wrapper<CheliangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheliangxinxiView> selectListView(Wrapper<CheliangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangxinxiView selectView(Wrapper<CheliangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
