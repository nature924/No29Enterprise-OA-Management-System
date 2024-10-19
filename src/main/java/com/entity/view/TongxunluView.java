package com.entity.view;

import com.entity.TongxunluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 通讯录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@TableName("tongxunlu")
public class TongxunluView  extends TongxunluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TongxunluView(){
	}
 
 	public TongxunluView(TongxunluEntity tongxunluEntity){
 	try {
			BeanUtils.copyProperties(this, tongxunluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
