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

import com.entity.FavoriteEntity;
import com.entity.view.FavoriteView;

import com.service.FavoriteService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 收藏表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FavoriteEntity favorite, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		favorite.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<FavoriteEntity> ew = new EntityWrapper<FavoriteEntity>();
		PageUtils page = favoriteService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, favorite), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FavoriteEntity favorite, HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		favorite.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<FavoriteEntity> ew = new EntityWrapper<FavoriteEntity>();
		PageUtils page = favoriteService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, favorite), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FavoriteEntity favorite){
       	EntityWrapper<FavoriteEntity> ew = new EntityWrapper<FavoriteEntity>();
      	ew.allEq(MPUtil.allEQMapPre( favorite, "favorite")); 
        return R.ok().put("data", favoriteService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FavoriteEntity favorite){
        EntityWrapper< FavoriteEntity> ew = new EntityWrapper< FavoriteEntity>();
 		ew.allEq(MPUtil.allEQMapPre( favorite, "favorite")); 
		FavoriteView favoriteView =  favoriteService.selectView(ew);
		return R.ok("查询收藏表成功").put("data", favoriteView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FavoriteEntity favorite = favoriteService.selectById(id);
        return R.ok().put("data", favorite);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FavoriteEntity favorite = favoriteService.selectById(id);
        return R.ok().put("data", favorite);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FavoriteEntity favorite, HttpServletRequest request){
    	favorite.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(favorite);
    	Long userId = (Long)request.getSession().getAttribute("userId");
    	favorite.setUserid(userId);
    	FavoriteEntity exist = favoriteService.selectOne(new EntityWrapper<FavoriteEntity>()
    			.eq("userId", userId)
    			.eq("referenceId", favorite.getRefid())
    			.eq("tableName", favorite.getTablename()));
    	if(exist != null) {
    		return R.error("宸叉敹钘忥紝璇峰嬁閲嶅鎿嶄綔");
    	}
        favoriteService.insert(favorite);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FavoriteEntity favorite, HttpServletRequest request){
    	favorite.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(favorite);
    	Long userId = (Long)request.getSession().getAttribute("userId");
    	favorite.setUserid(userId);
    	FavoriteEntity exist = favoriteService.selectOne(new EntityWrapper<FavoriteEntity>()
    			.eq("userId", userId)
    			.eq("referenceId", favorite.getRefid())
    			.eq("tableName", favorite.getTablename()));
    	if(exist != null) {
    		return R.error("宸叉敹钘忥紝璇峰嬁閲嶅鎿嶄綔");
    	}
        favoriteService.insert(favorite);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FavoriteEntity favorite, HttpServletRequest request){
        //ValidatorUtils.validateEntity(favorite);
        favoriteService.updateById(favorite);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        favoriteService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<FavoriteEntity> wrapper = new EntityWrapper<FavoriteEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userId", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = favoriteService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
