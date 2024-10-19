package com.entity.view;

import com.entity.GongzixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工资信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@TableName("gongzixinxi")
public class GongzixinxiView  extends GongzixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzixinxiView(){
	}
 
 	public GongzixinxiView(GongzixinxiEntity gongzixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, gongzixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
