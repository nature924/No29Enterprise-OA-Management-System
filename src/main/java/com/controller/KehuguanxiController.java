package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KehuguanxiEntity;
import com.entity.view.KehuguanxiView;

import com.service.KehuguanxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 客户关系
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@RestController
@RequestMapping("/kehuguanxi")
public class KehuguanxiController {
    @Autowired
    private KehuguanxiService kehuguanxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KehuguanxiEntity kehuguanxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			kehuguanxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KehuguanxiEntity> ew = new EntityWrapper<KehuguanxiEntity>();
		PageUtils page = kehuguanxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kehuguanxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KehuguanxiEntity kehuguanxi, 
		HttpServletRequest request){
        EntityWrapper<KehuguanxiEntity> ew = new EntityWrapper<KehuguanxiEntity>();
		PageUtils page = kehuguanxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kehuguanxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KehuguanxiEntity kehuguanxi){
       	EntityWrapper<KehuguanxiEntity> ew = new EntityWrapper<KehuguanxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kehuguanxi, "kehuguanxi")); 
        return R.ok().put("data", kehuguanxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KehuguanxiEntity kehuguanxi){
        EntityWrapper< KehuguanxiEntity> ew = new EntityWrapper< KehuguanxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kehuguanxi, "kehuguanxi")); 
		KehuguanxiView kehuguanxiView =  kehuguanxiService.selectView(ew);
		return R.ok("查询客户关系成功").put("data", kehuguanxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KehuguanxiEntity kehuguanxi = kehuguanxiService.selectById(id);
        return R.ok().put("data", kehuguanxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KehuguanxiEntity kehuguanxi = kehuguanxiService.selectById(id);
        return R.ok().put("data", kehuguanxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KehuguanxiEntity kehuguanxi, HttpServletRequest request){
    	kehuguanxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kehuguanxi);
        kehuguanxiService.insert(kehuguanxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KehuguanxiEntity kehuguanxi, HttpServletRequest request){
    	kehuguanxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kehuguanxi);
        kehuguanxiService.insert(kehuguanxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KehuguanxiEntity kehuguanxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kehuguanxi);
        kehuguanxiService.updateById(kehuguanxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kehuguanxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<KehuguanxiEntity> wrapper = new EntityWrapper<KehuguanxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = kehuguanxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
