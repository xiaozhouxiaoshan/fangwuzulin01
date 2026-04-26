package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FavoriteEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FavoriteVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FavoriteView;


/**
 * 收藏表
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface FavoriteService extends IService<FavoriteEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FavoriteVO> selectListVO(Wrapper<FavoriteEntity> wrapper);
   	
   	FavoriteVO selectVO(@Param("ew") Wrapper<FavoriteEntity> wrapper);
   	
   	List<FavoriteView> selectListView(Wrapper<FavoriteEntity> wrapper);
   	
   	FavoriteView selectView(@Param("ew") Wrapper<FavoriteEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FavoriteEntity> wrapper);
   	
}

