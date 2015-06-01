package com.dragon.codingol.web.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dragon.codingol.domain.system.TypeEntity;
import com.dragon.codingol.domain.system.TypegroupEntity;
import com.dragon.codingol.repository.redis.RedisClientTemplate;
import com.dragon.codingol.service.system.TypeService;
import com.dragon.codingol.service.system.TypegroupService;

public class SystemInit  implements javax.servlet.ServletContextListener{
 
	
	@Autowired
	private TypegroupService typegroupService;
	
	@Autowired
	private TypeService typeService;
	
	public static Map<String, Map<String, TypeEntity>> typeMaps = new LinkedHashMap<String, Map<String, TypeEntity>>();
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		if(null == typegroupService )
			typegroupService = (TypegroupService) webApplicationContext.getBean("typegroupService");
		if(null == typeService )
			typeService = (TypeService) webApplicationContext.getBean("typeService");
		
		//initTypes();
		
	}
	
	private void initTypes(){
		if(typeMaps==null || typeMaps.size()==0){
			List<TypegroupEntity> groupList  = typegroupService.loadAll(TypegroupEntity.class);
			List<TypeEntity> types = typeService.loadAll(TypeEntity.class);
			for(TypegroupEntity t : groupList){
				Map<String, TypeEntity> list = new LinkedHashMap<String, TypeEntity>();
				for(TypeEntity type: types){
					 if(type.getTypegroupid().equals(t.getId())){
						 list.put(type.getCode(), type);
					 }
				}
				typeMaps.put(t.getGroupcode(), list);
			}
		}
	}
	
	public static String getType(String groupName, String code){
		
		Map<String, TypeEntity> type  = typeMaps.get(groupName);
		if(type!=null){
			TypeEntity t =  type.get(code);
			if(t!=null)
				return t.getName();
		}
		return "";
	}
	
}
