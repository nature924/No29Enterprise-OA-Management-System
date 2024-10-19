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

import com.entity.RichenganpaiEntity;
import com.entity.view.RichenganpaiView;

import com.service.RichenganpaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 日程安排
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-19 14:54:43
 */
@RestController
@RequestMapping("/richenganpai")
public class RichenganpaiController {
    @Autowired
    private RichenganpaiService richenganpaiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RichenganpaiEntity richenganpai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			richenganpai.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RichenganpaiEntity> ew = new EntityWrapper<RichenganpaiEntity>();
		PageUtils page = richenganpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, richenganpai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RichenganpaiEntity richenganpai, 
		HttpServletRequest request){
        EntityWrapper<RichenganpaiEntity> ew = new EntityWrapper<RichenganpaiEntity>();
		PageUtils page = richenganpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, richenganpai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RichenganpaiEntity richenganpai){
       	EntityWrapper<RichenganpaiEntity> ew = new EntityWrapper<RichenganpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( richenganpai, "richenganpai")); 
        return R.ok().put("data", richenganpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RichenganpaiEntity richenganpai){
        EntityWrapper< RichenganpaiEntity> ew = new EntityWrapper< RichenganpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( richenganpai, "richenganpai")); 
		RichenganpaiView richenganpaiView =  richenganpaiService.selectView(ew);
		return R.ok("查询日程安排成功").put("data", richenganpaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RichenganpaiEntity richenganpai = richenganpaiService.selectById(id);
        return R.ok().put("data", richenganpai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RichenganpaiEntity richenganpai = richenganpaiService.selectById(id);
        return R.ok().put("data", richenganpai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RichenganpaiEntity richenganpai, HttpServletRequest request){
    	richenganpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(richenganpai);
        richenganpaiService.insert(richenganpai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RichenganpaiEntity richenganpai, HttpServletRequest request){
    	richenganpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(richenganpai);
        richenganpaiService.insert(richenganpai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RichenganpaiEntity richenganpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(richenganpai);
        richenganpaiService.updateById(richenganpai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        richenganpaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<RichenganpaiEntity> wrapper = new EntityWrapper<RichenganpaiEntity>();
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

		int count = richenganpaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
