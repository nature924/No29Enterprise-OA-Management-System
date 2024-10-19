package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangbankaoqinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangbankaoqinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangbankaoqinView;


/**
 * 上班考勤
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface ShangbankaoqinService extends IService<ShangbankaoqinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangbankaoqinVO> selectListVO(Wrapper<ShangbankaoqinEntity> wrapper);
   	
   	ShangbankaoqinVO selectVO(@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);
   	
   	List<ShangbankaoqinView> selectListView(Wrapper<ShangbankaoqinEntity> wrapper);
   	
   	ShangbankaoqinView selectView(@Param("ew") Wrapper<ShangbankaoqinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangbankaoqinEntity> wrapper);
   	
}

