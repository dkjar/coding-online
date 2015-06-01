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


/**
 * 根据用户权限，生成不同功能按钮
 * @author deng
 *
 */
@Component
public class ImageUploadMarker implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		Object name = params.get("name");
		Object title = params.get("title");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<div class=\"image-upload\" data-url=\"../systemController/imageUpload.htm\">");
		sb.append("<div class=\"progress\">");
		sb.append("<div class=\"progress-bar progress-bar-success\"></div>");
		sb.append("</div>");
		sb.append("<div>");
		sb.append("<img class=\"icon\"/>");
		sb.append("</div>");
		sb.append("<span class=\"btn btn-success fileinput-button\">");
		sb.append("<i class=\"glyphicon glyphicon-plus\"></i>");
		sb.append("<span>");
		if(!StringUtils.isEmpty(title))
			sb.append(title);
		sb.append("</span>");
		sb.append("<input class=\"fileupload\" type=\"file\" multiple  accept='image/png,image/gif,image/jpg,image/jpeg'>");
		sb.append("<input type='hidden' name='");
		if(!StringUtils.isEmpty(name))
			sb.append(name);
		sb.append("' class='form-control' >");
		sb.append("</span>");
		sb.append("</div>");
		
		env.getOut().write(sb.toString());  
	}

}
