package com.entity.view;

import com.entity.MessageBoardEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 留言板
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("messageBoard")
public class MessageBoardView  extends MessageBoardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MessageBoardView(){
	}
 
 	public MessageBoardView(MessageBoardEntity messageBoardEntity){
 	try {
			BeanUtils.copyProperties(this, messageBoardEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
