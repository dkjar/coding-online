package com.dragon.codingol.web.tld;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.dragon.codingol.domain.system.TypeEntity;
import com.dragon.codingol.domain.system.TypegroupEntity;
import com.dragon.codingol.service.system.TypeService;
import com.dragon.codingol.service.system.TypegroupService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class SelectViewMarker implements TemplateDirectiveModel{

	@Autowired
	private TypegroupService typegroupService;
	
	@Autowired
	private TypeService typeService;
	
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Object name = params.get("name");
		Object extend = params.get("extend");
		Object empty = params.get("empty");
		Object defaultVal = params.get("defaultVal");
		Object typeGroupCode = params.get("typeGroupCode");
		Object type = params.get("type");
		if(StringUtils.isEmpty(typeGroupCode)){
			env.getOut().write("");  
			return ;
		}
		TypegroupEntity group  = typegroupService.findUniqueByProperty(TypegroupEntity.class, "groupcode", typeGroupCode.toString());
		if(group ==null){
			env.getOut().write("");  
			return ;
		}
		List<TypeEntity> types = typeService.findEffectiveByProperty(TypeEntity.class, "typegroupid", group.getId());
		if(types == null){
			env.getOut().write(""); 
			return ;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<select class=\"form-control\" name=\"" + name + "\"");
		sb.append(" id=\"" + name + "\"");
		
		if (!StringUtils.isEmpty(extend)) {
			sb.append(extend);
		}
		if(!StringUtils.isEmpty(type) && type.toString().equals("view")){
			sb.append(" disabled");
		}
		sb.append(" >");
		if (!StringUtils.isEmpty(empty)) {
			sb.append(" <option value=''>--");
			sb.append(empty);
			sb.append("--</option>");
		}
		
		for (TypeEntity key : types) {
			if (key.getCode().equals(defaultVal))
				sb.append(" <option value=\"" + key.getCode()
						+ "\" selected=\"selected\">");
			else {
				sb.append(" <option value=\"" + key.getCode() + "\">");
			}
			sb.append(key.getName());
			sb.append(" </option>");
		}
		
		sb.append("</select>");
		 
		env.getOut().write(sb.toString());  
	}
}
