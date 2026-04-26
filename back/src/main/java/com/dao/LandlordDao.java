package com.dao;

import com.entity.LandlordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LandlordVO;
import com.entity.view.LandlordView;


/**
 * 房主
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface LandlordDao extends BaseMapper<LandlordEntity> {
	
	List<LandlordVO> selectListVO(@Param("ew") Wrapper<LandlordEntity> wrapper);
	
	LandlordVO selectVO(@Param("ew") Wrapper<LandlordEntity> wrapper);
	
	List<LandlordView> selectListView(@Param("ew") Wrapper<LandlordEntity> wrapper);

	List<LandlordView> selectListView(Pagination page,@Param("ew") Wrapper<LandlordEntity> wrapper);
	
	LandlordView selectView(@Param("ew") Wrapper<LandlordEntity> wrapper);
	
}
