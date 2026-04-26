package com.dao;

import com.entity.LandlordApplicationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LandlordApplicationVO;
import com.entity.view.LandlordApplicationView;


/**
 * 我要当房主
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface LandlordApplicationDao extends BaseMapper<LandlordApplicationEntity> {
	
	List<LandlordApplicationVO> selectListVO(@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);
	
	LandlordApplicationVO selectVO(@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);
	
	List<LandlordApplicationView> selectListView(@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);

	List<LandlordApplicationView> selectListView(Pagination page,@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);
	
	LandlordApplicationView selectView(@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);
	
}
