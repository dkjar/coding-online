package ${packageName}.${projectName}.web.controller.${parentMenu};
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import ${packageName}.${projectName}.common.ResultJson;
import ${packageName}.${projectName}.common.Pager;
import ${packageName}.${projectName}.common.base.Globals;
import ${packageName}.${projectName}.common.util.CriteriaUtil;
<#list manys as m>
import ${packageName}.${projectName}.domain.${parentMenu}.${m.table.entityname?cap_first}Entity;
import ${packageName}.${projectName}.domain.${parentMenu}.${m.middle.entityname?cap_first}Entity;
</#list>
<#list ones as o>
import ${packageName}.${projectName}.domain.${parentMenu}.${o.table.entityname?cap_first}Entity;
</#list>
import ${packageName}.${projectName}.domain.${parentMenu}.${entityName?cap_first}Entity;   
import ${packageName}.${projectName}.service.${parentMenu}.${entityName?cap_first}Service;
import ${packageName}.${projectName}.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: ${description}
 * @author dx
 * @date ${createTime}
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/${entityName?uncap_first}Controller")
public class ${entityName?cap_first}Controller {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(${entityName?cap_first}Controller.class);

	@Autowired
	private ${entityName?cap_first}Service ${entityName?uncap_first}Service;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * ${description}列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "${parentMenu}/${entityName?uncap_first}/index.jsp";
	}

	<#if haveSelect??&&haveSelect>
	/**
	 * ${description}选择页面 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/select")
	public String select(HttpServletRequest request) {
		return "${parentMenu}/${entityName?uncap_first}/select.jsp";
	}
	</#if>
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, ${entityName?cap_first}Entity ${entityName?uncap_first}, HttpServletRequest request, HttpServletResponse response, Pager page) {
		<#if isTreeGrid?? && isTreeGrid>
		String pid = ${entityName?uncap_first}.getId();
		${entityName?uncap_first}.setId(null);
		
		cu.installParams(${entityName?uncap_first}, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		${entityName?uncap_first}Service.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(${entityName?cap_first}Entity.class, cu.getPager(), response);
		<#else>
		cu.installParams(${entityName?uncap_first}, request.getParameterMap());
		${entityName?uncap_first}Service.queryCriteriaPage(cu);
		<#if haveDic??&&haveDic>
		jsonCommon.jsonTranlateReturn(${entityName?cap_first}Entity.class, cu.getPager(), response);
		<#else>
		jsonCommon.jsonReturn(cu.getPager(), response);
		</#if>
		</#if>
	}

	/**
	 * ${description}编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "${parentMenu}/${entityName?uncap_first}/edit.jsp";
	}
	
	/**
	 * ${description}查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "${parentMenu}/${entityName?uncap_first}/view.jsp";
	}
	
	/**
	 * ${description}编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(${entityName?cap_first}Entity ${entityName?uncap_first}, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(${entityName?uncap_first}.getId())){
			${entityName?uncap_first} = this.${entityName?uncap_first}Service.get(${entityName?cap_first}Entity.class, ${entityName?uncap_first}.getId());
			jsonCommon.jsonReturn(${entityName?uncap_first}, response);
		}
	}
	
	/**
	 * 添加${description}
	 * 
	 * @param ${entityName?cap_first}Entity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(${entityName?cap_first}Entity ${entityName?uncap_first}, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			<#if isTreeGrid?? && isTreeGrid>
			if(!StringUtils.isEmpty(${entityName?uncap_first}.getPid())){
				${entityName?cap_first}Entity parent = this.${entityName?uncap_first}Service.get(${entityName?cap_first}Entity.class, ${entityName?uncap_first}.getPid());
				parent.setState(0);
				${entityName?uncap_first}Service.saveOrUpdate(parent);
			}
			</#if>
			${entityName?uncap_first}Service.saveOrUpdate(${entityName?uncap_first});
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除${description}
	 * 
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(String id, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		${entityName?uncap_first}Service.deleteEntityByIds(${entityName?cap_first}Entity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	<#list manys as m>
	@RequestMapping("/${entityName?uncap_first}${m.table.entityname?uncap_first}")
	public String ${entityName?uncap_first}${m.table.entityname?uncap_first}(HttpServletRequest request) {
		request.setAttribute("${m.fcolumn.columncode}", request.getParameter("${m.fcolumn.columncode}"));
		return "${parentMenu}/${entityName?uncap_first}/${entityName?uncap_first}${m.table.entityname?uncap_first}.jsp";
	}
	
 
	@RequestMapping("/${entityName?uncap_first}${m.table.entityname?uncap_first}data")
	public void ${entityName?uncap_first}${m.table.entityname?uncap_first}data(CriteriaUtil cu,	${m.table.entityname?cap_first}Entity ${m.table.entityname?uncap_first},  ${m.middle.entityname?cap_first}Entity ${m.middle.entityname?uncap_first},
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(${m.table.entityname?uncap_first}, request.getParameterMap());
		
		cu.exists(${m.middle.entityname?uncap_first});
		
		${entityName?uncap_first}Service.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	

	/**
	 * 选择${m.table.name}
	 * 
	 * @return
	 */
	@RequestMapping("/select${m.table.entityname?uncap_first}")
	public String select${m.table.entityname?uncap_first}(HttpServletRequest request) {
		request.setAttribute("${m.fcolumn.columncode}", request.getParameter("${m.fcolumn.columncode}"));
		return "${parentMenu}/${entityName?uncap_first}/select${m.table.entityname?uncap_first}.jsp";
	}
	
	@RequestMapping("/select${m.table.entityname?uncap_first}data")
	public void select${m.table.entityname?uncap_first}data(CriteriaUtil cu,	${m.table.entityname?cap_first}Entity ${m.table.entityname?uncap_first},  ${m.middle.entityname?cap_first}Entity ${m.middle.entityname?uncap_first},
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(${m.table.entityname?uncap_first}, request.getParameterMap());
		
		cu.notexists(${m.middle.entityname?uncap_first});
		
		${entityName?uncap_first}Service.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加${m.middle.name}
	 * 
	 * @return
	 */
	@RequestMapping("/add${entityName?uncap_first}${m.table.entityname?uncap_first}")
	@ResponseBody
	public void add${entityName?uncap_first}${m.table.entityname?uncap_first}(String id, String ${m.fcolumn.columncode}, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(${m.fcolumn.columncode})){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			${m.middle.entityname?cap_first}Entity ${m.middle.entityname?uncap_first} = new ${m.middle.entityname?cap_first}Entity();
			${m.middle.entityname?uncap_first}.set${m.fcolumn.columncode?cap_first}(${m.fcolumn.columncode});
			${m.middle.entityname?uncap_first}.set${m.ocolumn.columncode?cap_first}(i);
			try {
				this.${entityName?uncap_first}Service.save(${m.middle.entityname?uncap_first});
			} catch (Exception e) {
				 break;
			}
		}
		r.setMsg(Globals.ADD_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
	/**
	 * 删除${m.middle.name}
	 * 
	 * @return
	 */
	@RequestMapping("/del${entityName?uncap_first}${m.table.entityname?uncap_first}")
	@ResponseBody
	public void del${entityName?uncap_first}${m.table.entityname?uncap_first}(String id, String ${m.fcolumn.columncode}, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			${m.middle.entityname?cap_first}Entity ${m.middle.entityname?uncap_first} = new ${m.middle.entityname?cap_first}Entity();
			${m.middle.entityname?uncap_first}.set${m.fcolumn.columncode?cap_first}(${m.fcolumn.columncode});
			${m.middle.entityname?uncap_first}.set${m.ocolumn.columncode?cap_first}(i);
			try {
				this.${entityName?uncap_first}Service.delete(${m.middle.entityname?uncap_first});
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	</#list>
	
	<#list ones as o>
	@RequestMapping("/${o.table.entityname?uncap_first}")
	public String ${o.table.entityname?uncap_first}(HttpServletRequest request) {
		request.setAttribute("${o.fcolumn.columncode}", request.getParameter("${o.fcolumn.columncode}"));
		return "${parentMenu}/${o.table.entityname?uncap_first}/${o.table.entityname?uncap_first}.jsp"; 
	}
	
	@RequestMapping("/${o.table.entityname?uncap_first}data")
	public void ${o.table.entityname?uncap_first}data(CriteriaUtil cu, ${o.table.entityname?cap_first}Entity ${o.table.entityname?uncap_first},
			HttpServletRequest request, HttpServletResponse response) {
		cu.installParams(${o.table.entityname?uncap_first}, request.getParameterMap());
		${entityName?uncap_first}Service.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	</#list>
}
