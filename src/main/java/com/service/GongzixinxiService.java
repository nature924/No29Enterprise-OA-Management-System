package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzixinxiView;


/**
 * 工资信息
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface GongzixinxiService extends IService<GongzixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzixinxiVO> selectListVO(Wrapper<GongzixinxiEntity> wrapper);
   	
   	GongzixinxiVO selectVO(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
   	
   	List<GongzixinxiView> selectListView(Wrapper<GongzixinxiEntity> wrapper);
   	
   	GongzixinxiView selectView(@Param("ew") Wrapper<GongzixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzixinxiEntity> wrapper);
   	
}

