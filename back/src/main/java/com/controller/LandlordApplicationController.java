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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LandlordApplicationEntity;
import com.entity.view.LandlordApplicationView;

import com.service.LandlordApplicationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 我要当房主
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@RestController
@RequestMapping("/landlordApplication")
public class LandlordApplicationController {
    @Autowired
    private LandlordApplicationService landlordApplicationService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LandlordApplicationEntity landlordApplication, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("tenant")) {
			landlordApplication.setTenantming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LandlordApplicationEntity> ew = new EntityWrapper<LandlordApplicationEntity>();
		PageUtils page = landlordApplicationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, landlordApplication), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LandlordApplicationEntity landlordApplication, HttpServletRequest request){
        EntityWrapper<LandlordApplicationEntity> ew = new EntityWrapper<LandlordApplicationEntity>();
		PageUtils page = landlordApplicationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, landlordApplication), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LandlordApplicationEntity landlordApplication){
       	EntityWrapper<LandlordApplicationEntity> ew = new EntityWrapper<LandlordApplicationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( landlordApplication, "landlordApplication")); 
        return R.ok().put("data", landlordApplicationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LandlordApplicationEntity landlordApplication){
        EntityWrapper< LandlordApplicationEntity> ew = new EntityWrapper< LandlordApplicationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( landlordApplication, "landlordApplication")); 
		LandlordApplicationView landlordApplicationView =  landlordApplicationService.selectView(ew);
		return R.ok("查询我要当房主成功").put("data", landlordApplicationView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LandlordApplicationEntity landlordApplication = landlordApplicationService.selectById(id);
        return R.ok().put("data", landlordApplication);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LandlordApplicationEntity landlordApplication = landlordApplicationService.selectById(id);
        return R.ok().put("data", landlordApplication);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LandlordApplicationEntity landlordApplication, HttpServletRequest request){
    	landlordApplication.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(landlordApplication);
        landlordApplicationService.insert(landlordApplication);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LandlordApplicationEntity landlordApplication, HttpServletRequest request){
    	landlordApplication.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(landlordApplication);
        landlordApplicationService.insert(landlordApplication);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LandlordApplicationEntity landlordApplication, HttpServletRequest request){
        //ValidatorUtils.validateEntity(landlordApplication);
        landlordApplicationService.updateById(landlordApplication);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        landlordApplicationService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LandlordApplicationEntity> wrapper = new EntityWrapper<LandlordApplicationEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("tenant")) {
			wrapper.eq("tenantming", (String)request.getSession().getAttribute("username"));
		}

		int count = landlordApplicationService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
