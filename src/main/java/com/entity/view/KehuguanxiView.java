package com.entity.view;

import com.entity.KehuguanxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 客户关系
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@TableName("kehuguanxi")
public class KehuguanxiView  extends KehuguanxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KehuguanxiView(){
	}
 
 	public KehuguanxiView(KehuguanxiEntity kehuguanxiEntity){
 	try {
			BeanUtils.copyProperties(this, kehuguanxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
