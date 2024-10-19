package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TongxunluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TongxunluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TongxunluView;


/**
 * 通讯录
 *
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public interface TongxunluService extends IService<TongxunluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TongxunluVO> selectListVO(Wrapper<TongxunluEntity> wrapper);
   	
   	TongxunluVO selectVO(@Param("ew") Wrapper<TongxunluEntity> wrapper);
   	
   	List<TongxunluView> selectListView(Wrapper<TongxunluEntity> wrapper);
   	
   	TongxunluView selectView(@Param("ew") Wrapper<TongxunluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TongxunluEntity> wrapper);
   	
}

