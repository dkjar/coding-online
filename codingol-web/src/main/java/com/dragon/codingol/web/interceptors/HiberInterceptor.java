package com.dragon.codingol.web.interceptors;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.util.ResourceUtil;
import com.dragon.codingol.domain.system.DepartmentEntity;
import com.dragon.codingol.domain.system.UserEntity;

 
@Component
public class HiberInterceptor extends EmptyInterceptor  {
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 708863117963544056L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		UserEntity currentUser = null;
		try {
			currentUser = ResourceUtil.getSessionUserName();
		} catch (RuntimeException e1) {
			e1.printStackTrace();
		}
		if (currentUser == null) {
			return true;
		}
		try {
			for (int index = 0; index < propertyNames.length; index++) {
				if ("createdate".equals(propertyNames[index])) {
					if (StringUtils.isEmpty(state[index])) {
						state[index] = new Date();
					}
					continue;
				} else if ("creatorId".equals(propertyNames[index])) {
					if (StringUtils.isEmpty(state[index])) {
						state[index] = currentUser.getId();
					}
					continue;
				}
				else if("creatorDepartmentId".equals(propertyNames[index])){
					if (StringUtils.isEmpty(state[index])) {
						state[index] = currentUser.getDepartmentid();
					}
					continue;
				} 
				else if("status".equals(propertyNames[index])){
					if (StringUtils.isEmpty(state[index])) {
						state[index] = 1; //正常状态
					}
					continue;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		return super.onLoad(entity, id, state, propertyNames, types);
	}
  
	
	
	
}
