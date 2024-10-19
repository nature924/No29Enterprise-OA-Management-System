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

import com.entity.GongzixinxiEntity;
import com.entity.view.GongzixinxiView;

import com.service.GongzixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 工资信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@RestController
@RequestMapping("/gongzixinxi")
public class GongzixinxiController {
    @Autowired
    private GongzixinxiService gongzixinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzixinxiEntity gongzixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			gongzixinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzixinxiEntity> ew = new EntityWrapper<GongzixinxiEntity>();
		PageUtils page = gongzixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzixinxiEntity gongzixinxi, 
		HttpServletRequest request){
        EntityWrapper<GongzixinxiEntity> ew = new EntityWrapper<GongzixinxiEntity>();
		PageUtils page = gongzixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzixinxiEntity gongzixinxi){
       	EntityWrapper<GongzixinxiEntity> ew = new EntityWrapper<GongzixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzixinxi, "gongzixinxi")); 
        return R.ok().put("data", gongzixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzixinxiEntity gongzixinxi){
        EntityWrapper< GongzixinxiEntity> ew = new EntityWrapper< GongzixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzixinxi, "gongzixinxi")); 
		GongzixinxiView gongzixinxiView =  gongzixinxiService.selectView(ew);
		return R.ok("查询工资信息成功").put("data", gongzixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzixinxiEntity gongzixinxi = gongzixinxiService.selectById(id);
        return R.ok().put("data", gongzixinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzixinxiEntity gongzixinxi = gongzixinxiService.selectById(id);
        return R.ok().put("data", gongzixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzixinxiEntity gongzixinxi, HttpServletRequest request){
    	gongzixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzixinxi);
        gongzixinxiService.insert(gongzixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzixinxiEntity gongzixinxi, HttpServletRequest request){
    	gongzixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzixinxi);
        gongzixinxiService.insert(gongzixinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GongzixinxiEntity gongzixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzixinxi);
        gongzixinxiService.updateById(gongzixinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzixinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GongzixinxiEntity> wrapper = new EntityWrapper<GongzixinxiEntity>();
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

		int count = gongzixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
