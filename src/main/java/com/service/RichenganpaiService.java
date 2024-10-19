package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RichenganpaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RichenganpaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RichenganpaiView;


/**
 * 日程安排
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface RichenganpaiService extends IService<RichenganpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RichenganpaiVO> selectListVO(Wrapper<RichenganpaiEntity> wrapper);
   	
   	RichenganpaiVO selectVO(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
   	
   	List<RichenganpaiView> selectListView(Wrapper<RichenganpaiEntity> wrapper);
   	
   	RichenganpaiView selectView(@Param("ew") Wrapper<RichenganpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RichenganpaiEntity> wrapper);
   	
}

