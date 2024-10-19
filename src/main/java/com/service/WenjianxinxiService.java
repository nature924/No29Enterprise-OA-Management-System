package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenjianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenjianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenjianxinxiView;


/**
 * 文件信息
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface WenjianxinxiService extends IService<WenjianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenjianxinxiVO> selectListVO(Wrapper<WenjianxinxiEntity> wrapper);
   	
   	WenjianxinxiVO selectVO(@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);
   	
   	List<WenjianxinxiView> selectListView(Wrapper<WenjianxinxiEntity> wrapper);
   	
   	WenjianxinxiView selectView(@Param("ew") Wrapper<WenjianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenjianxinxiEntity> wrapper);
   	
}

