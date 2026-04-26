package com.entity.view;

import com.entity.RentalContractEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 合同信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("rentalContract")
public class RentalContractView  extends RentalContractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RentalContractView(){
	}
 
 	public RentalContractView(RentalContractEntity rentalContractEntity){
 	try {
			BeanUtils.copyProperties(this, rentalContractEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
