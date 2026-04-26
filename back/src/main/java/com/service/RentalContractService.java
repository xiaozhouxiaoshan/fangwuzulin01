package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RentalContractEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RentalContractVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RentalContractView;


/**
 * 合同信息
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface RentalContractService extends IService<RentalContractEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RentalContractVO> selectListVO(Wrapper<RentalContractEntity> wrapper);
   	
   	RentalContractVO selectVO(@Param("ew") Wrapper<RentalContractEntity> wrapper);
   	
   	List<RentalContractView> selectListView(Wrapper<RentalContractEntity> wrapper);
   	
   	RentalContractView selectView(@Param("ew") Wrapper<RentalContractEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RentalContractEntity> wrapper);
   	
}

