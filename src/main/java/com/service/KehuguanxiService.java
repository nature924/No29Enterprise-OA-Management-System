package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KehuguanxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KehuguanxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KehuguanxiView;


/**
 * 客户关系
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface KehuguanxiService extends IService<KehuguanxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KehuguanxiVO> selectListVO(Wrapper<KehuguanxiEntity> wrapper);
   	
   	KehuguanxiVO selectVO(@Param("ew") Wrapper<KehuguanxiEntity> wrapper);
   	
   	List<KehuguanxiView> selectListView(Wrapper<KehuguanxiEntity> wrapper);
   	
   	KehuguanxiView selectView(@Param("ew") Wrapper<KehuguanxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KehuguanxiEntity> wrapper);
   	
}

