package com.dragon.codingol.web.tld;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.util.ResourceUtil;
import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.service.system.FunctionbuttonService;

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
public class ToolbarViewMarker implements TemplateDirectiveModel{
	
	@Autowired
	private FunctionbuttonService functionbuttonService;
	
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		Object functionid = params.get("functionid");
		
		if(StringUtils.isEmpty(functionid)){
			return;
		}
		
		List<FunctionbuttonEntity> functionbuttons = functionbuttonService.getFunctionbuttons(functionid.toString());
		
		 
		StringBuffer sb = new StringBuffer();
		
		sb.append("<div style=\"float:left;\">");
		
		for(FunctionbuttonEntity f : functionbuttons){
			if(f.getSide()!=null && f.getSide() == 1){
				sb.append("<a href=\"javascript:void(0)\" action=\"");
				sb.append(f.getAction());
				sb.append("\" class=\"easyui-linkbutton\" data-options=\"iconCls:'");
				sb.append(f.getIconcode());
				sb.append("'\" >");
				sb.append(f.getIconname());
				sb.append("</a>");
			}
		}
		/*sb.append("<a href=\"javascript:void(0)\" action=\"method:'query'\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\" >查询</a>");
		sb.append("<a href=\"javascript:void(0)\" action=\"method:'add',url:'../userController/edit.htm'\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" >添加</a>");
		sb.append("<a href=\"javascript:void(0)\" action=\"method:'edit',url:'../userController/edit.htm?id={id}'\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\"  >修改</a>");
		sb.append("<a href=\"javascript:void(0)\" action=\"method:'view',url:'../userController/view.htm?id={id}'\" class=\"easyui-linkbutton\" iconCls=\"icon-view\"  >查看</a>");
		sb.append("<a href=\"javascript:void(0)\" action=\"method:'delete',grid:'id',url:'../userController/delete.htm'\" class=\"easyui-linkbutton\" iconCls=\"icon-delete\"  >删除</a>");
		sb.append("<a href=\"javascript:void(0)\" action=\"method:'add',url:'../userController/userrole.htm?userid={id}'\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" >角色管理</a>");
		sb.append("<a href=\"javascript:void(0)\" action=\"method:'add',url:'../userController/userdepartment.htm?userid={id}'\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" >组织机构</a>");
		*/
		sb.append("</div>");
		
		sb.append("<div style=\"float:right;\">");
		for(FunctionbuttonEntity f : functionbuttons){
			if(f.getSide()!=null && f.getSide() == 2){
				sb.append("<a href=\"javascript:void(0)\" action=\"");
				sb.append(f.getAction());
				sb.append("\" class=\"easyui-linkbutton\" data-options=\"iconCls:'");
				sb.append(f.getIconcode());
				sb.append("'\" >");
				sb.append(f.getIconname());
				sb.append("</a>");
			}
		}
		//sb.append("<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-list\"  >列表重设</a>");
		//sb.append("<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" action=\"method:'recycle'\" iconCls=\"icon-recycle\"   >回收站</a>");
		
		sb.append("</div>");
		env.getOut().write(sb.toString());  
	}

}
