package com.entity.view;

import com.entity.ShangbankaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 上班考勤
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@TableName("shangbankaoqin")
public class ShangbankaoqinView  extends ShangbankaoqinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangbankaoqinView(){
	}
 
 	public ShangbankaoqinView(ShangbankaoqinEntity shangbankaoqinEntity){
 	try {
			BeanUtils.copyProperties(this, shangbankaoqinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
