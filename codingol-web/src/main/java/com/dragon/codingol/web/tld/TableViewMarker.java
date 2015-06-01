package com.dragon.codingol.web.tld;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
 

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class TableViewMarker implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		Object name = params.get("name");
		Object extend = params.get("extend");
		Object defaultVal = params.get("defaultVal");
		Object type = params.get("type");
		Object url = params.get("url");
		Object map = params.get("map");
		Object readonly = params.get("readonly");
		
		StringBuffer sb = new StringBuffer();
		if(!StringUtils.isEmpty(type) && type.toString().equals("view")){
			sb.append("<p class=\"form-control-static\" name=\"");
			sb.append(name);
			sb.append("\"></p>");
			env.getOut().write(sb.toString());  
			return;
		}
		sb.append("<div class=\"input-group select-table\"  >");
        sb.append("<input type=\"text\" class=\"form-control select-text\" ");
        if(StringUtils.isEmpty(readonly) ||  readonly.toString().equals("true")){
        	sb.append(" readonly ");
        }
        sb.append("id=\"");
        sb.append(name);
        sb.append("\" name=\"");
        sb.append(name);
        sb.append("\" datatype='*'>");
        sb.append("<span class=\"input-group-btn\">");
        sb.append("	<button class=\"btn btn-default glyphicon glyphicon-search\" data-url=\"");
        sb.append(url);
        sb.append("\" data-map=\"");
        sb.append(map);
    	sb.append("\" type=\"button\"></button>");
        sb.append("</span>");
        sb.append("</div>");
		
        env.getOut().write(sb.toString());  
	}
	
}
