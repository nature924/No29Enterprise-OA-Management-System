package com.entity.model;

import com.entity.ShangbankaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 上班考勤
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
public class ShangbankaoqinModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 名称
	 */
	
	private String mingcheng;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 部门
	 */
	
	private String bumen;
		
	/**
	 * 职位
	 */
	
	private String zhiwei;
		
	/**
	 * 早退次数
	 */
	
	private String zaotuicishu;
		
	/**
	 * 迟到次数
	 */
	
	private String chidaocishu;
		
	/**
	 * 请假次数
	 */
	
	private String qingjiacishu;
		
	/**
	 * 旷工次数
	 */
	
	private String kuanggongcishu;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：名称
	 */
	 
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	/**
	 * 获取：名称
	 */
	public String getMingcheng() {
		return mingcheng;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：部门
	 */
	 
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	
	/**
	 * 获取：部门
	 */
	public String getBumen() {
		return bumen;
	}
				
	
	/**
	 * 设置：职位
	 */
	 
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	
	/**
	 * 获取：职位
	 */
	public String getZhiwei() {
		return zhiwei;
	}
				
	
	/**
	 * 设置：早退次数
	 */
	 
	public void setZaotuicishu(String zaotuicishu) {
		this.zaotuicishu = zaotuicishu;
	}
	
	/**
	 * 获取：早退次数
	 */
	public String getZaotuicishu() {
		return zaotuicishu;
	}
				
	
	/**
	 * 设置：迟到次数
	 */
	 
	public void setChidaocishu(String chidaocishu) {
		this.chidaocishu = chidaocishu;
	}
	
	/**
	 * 获取：迟到次数
	 */
	public String getChidaocishu() {
		return chidaocishu;
	}
				
	
	/**
	 * 设置：请假次数
	 */
	 
	public void setQingjiacishu(String qingjiacishu) {
		this.qingjiacishu = qingjiacishu;
	}
	
	/**
	 * 获取：请假次数
	 */
	public String getQingjiacishu() {
		return qingjiacishu;
	}
				
	
	/**
	 * 设置：旷工次数
	 */
	 
	public void setKuanggongcishu(String kuanggongcishu) {
		this.kuanggongcishu = kuanggongcishu;
	}
	
	/**
	 * 获取：旷工次数
	 */
	public String getKuanggongcishu() {
		return kuanggongcishu;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
