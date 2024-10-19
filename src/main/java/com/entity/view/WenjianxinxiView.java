package com.entity.view;

import com.entity.WenjianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 文件信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@TableName("wenjianxinxi")
public class WenjianxinxiView  extends WenjianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WenjianxinxiView(){
	}
 
 	public WenjianxinxiView(WenjianxinxiEntity wenjianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, wenjianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
