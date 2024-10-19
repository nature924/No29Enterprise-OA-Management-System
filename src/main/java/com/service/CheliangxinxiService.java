package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangxinxiView;


/**
 * 车辆信息
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface CheliangxinxiService extends IService<CheliangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangxinxiVO> selectListVO(Wrapper<CheliangxinxiEntity> wrapper);
   	
   	CheliangxinxiVO selectVO(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
   	
   	List<CheliangxinxiView> selectListView(Wrapper<CheliangxinxiEntity> wrapper);
   	
   	CheliangxinxiView selectView(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangxinxiEntity> wrapper);
   	
}

