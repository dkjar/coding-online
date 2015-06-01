package com.dragon.codingol.web.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.dragon.codingol.domain.base.Dictionary;
import com.dragon.codingol.domain.system.TypeEntity;
import com.dragon.codingol.domain.system.TypegroupEntity;
import com.dragon.codingol.service.system.TypeService;
import com.dragon.codingol.service.system.TypegroupService;

@Component
public class JsonCommon {
	
	@Autowired
	private  TypegroupService typegroupService;
	
	@Autowired
	private TypeService typeService;
	
	public JsonCommon(){
		
	}
	
	/**
	 * 将字典表转成字符串
	 * @param o
	 * @param response
	 */
	public void jsonTranlateReturn(Class<?> cls,  Object o,  HttpServletResponse response){
		  
		Field []fields  = cls.getDeclaredFields();
		final Map<String, String> transList = new HashMap<String, String>();
		for(Field f : fields){
			Dictionary d = f.getAnnotation(Dictionary.class);
			if(d != null){
				transList.put(f.getName(), d.name());
			}
		}
		ValueFilter filter = new ValueFilter() {
            public Object process(Object source, String name, Object value) {
            	if(transList.size()>0){
                    if (transList.containsKey(name) && value !=null) {
                    	TypegroupEntity group  = typegroupService.findUniqueByProperty(TypegroupEntity.class, "groupcode", transList.get(name));
                    	if(group==null)
                    		return value;
                    	List<TypeEntity> types = typeService.findByProperty(TypeEntity.class, "typegroupid", group.getId());
                        for(TypeEntity t :types){
                        	if(t.getCode().equals(value.toString())){
                        		return t.getName();
                        	}
                        }
                    	return value;
                    }
                    return value;
            	}else{
            		return value;
            	}
              
            }
        };
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(JSON.toJSONString(o, filter, new SerializerFeature[0]));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void jsonReturn(Object o,  HttpServletResponse response){
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		try {
			 
			PrintWriter pw = response.getWriter();
			pw.write(JSON.toJSONString(o));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
 
}	
