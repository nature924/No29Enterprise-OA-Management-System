package com.entity.view;

import com.entity.GongzuorizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工作日志
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@TableName("gongzuorizhi")
public class GongzuorizhiView  extends GongzuorizhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzuorizhiView(){
	}
 
 	public GongzuorizhiView(GongzuorizhiEntity gongzuorizhiEntity){
 	try {
			BeanUtils.copyProperties(this, gongzuorizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
