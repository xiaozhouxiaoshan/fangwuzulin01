package com.entity.view;

import com.entity.ViewingAppointmentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预约看房
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("viewingAppointment")
public class ViewingAppointmentView  extends ViewingAppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ViewingAppointmentView(){
	}
 
 	public ViewingAppointmentView(ViewingAppointmentEntity viewingAppointmentEntity){
 	try {
			BeanUtils.copyProperties(this, viewingAppointmentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
