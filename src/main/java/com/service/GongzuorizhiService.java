package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzuorizhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzuorizhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuorizhiView;


/**
 * 工作日志
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface GongzuorizhiService extends IService<GongzuorizhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuorizhiVO> selectListVO(Wrapper<GongzuorizhiEntity> wrapper);
   	
   	GongzuorizhiVO selectVO(@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);
   	
   	List<GongzuorizhiView> selectListView(Wrapper<GongzuorizhiEntity> wrapper);
   	
   	GongzuorizhiView selectView(@Param("ew") Wrapper<GongzuorizhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuorizhiEntity> wrapper);
   	
}

