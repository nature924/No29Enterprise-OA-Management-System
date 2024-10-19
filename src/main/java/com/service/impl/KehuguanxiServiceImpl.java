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


import com.dao.KehuguanxiDao;
import com.entity.KehuguanxiEntity;
import com.service.KehuguanxiService;
import com.entity.vo.KehuguanxiVO;
import com.entity.view.KehuguanxiView;

@Service("kehuguanxiService")
public class KehuguanxiServiceImpl extends ServiceImpl<KehuguanxiDao, KehuguanxiEntity> implements KehuguanxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KehuguanxiEntity> page = this.selectPage(
                new Query<KehuguanxiEntity>(params).getPage(),
                new EntityWrapper<KehuguanxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KehuguanxiEntity> wrapper) {
		  Page<KehuguanxiView> page =new Query<KehuguanxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KehuguanxiVO> selectListVO(Wrapper<KehuguanxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KehuguanxiVO selectVO(Wrapper<KehuguanxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KehuguanxiView> selectListView(Wrapper<KehuguanxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KehuguanxiView selectView(Wrapper<KehuguanxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
