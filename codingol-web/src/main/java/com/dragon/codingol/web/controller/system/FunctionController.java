package com.dragon.codingol.web.controller.system;
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
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.base.Globals;
import com.dragon.codingol.common.util.CriteriaUtil;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.RolefunctionEntity;
import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.domain.system.FunctionEntity;   
import com.dragon.codingol.service.system.FunctionService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 系统菜单
 * @author dx
 * @date 1,431,739,118,293
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/functionController")
public class FunctionController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FunctionController.class);

	@Autowired
	private FunctionService functionService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 系统菜单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/function/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, FunctionEntity function, HttpServletRequest request, HttpServletResponse response, Pager page) {
		String pid = function.getId();
		function.setId(null);
		
		cu.installParams(function, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		functionService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(FunctionEntity.class, cu.getPager(), response);
	}

	/**
	 * 系统菜单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/function/edit.jsp";
	}
	
	/**
	 * 系统菜单查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/function/view.jsp";
	}
	
	/**
	 * 系统菜单编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(FunctionEntity function, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(function.getId())){
			function = this.functionService.get(FunctionEntity.class, function.getId());
			jsonCommon.jsonReturn(function, response);
		}
	}
	
	/**
	 * 添加系统菜单
	 * 
	 * @param FunctionEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(FunctionEntity function, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			functionService.saveOrUpdate(function);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除系统菜单
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
		functionService.deleteEntityByIds(FunctionEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	@RequestMapping("/functionrole")
	public String functionrole(HttpServletRequest request) {
		request.setAttribute("functionid", request.getParameter("functionid"));
		return "system/function/functionrole.jsp";
	}
	
 
	@RequestMapping("/functionroledata")
	public void functionroledata(CriteriaUtil cu,	RoleEntity role,  RolefunctionEntity rolefunction,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(role, request.getParameterMap());
		
		cu.exists(rolefunction);
		
		functionService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	

	/**
	 * 选择角色管理
	 * 
	 * @return
	 */
	@RequestMapping("/selectrole")
	public String selectrole(HttpServletRequest request) {
		request.setAttribute("functionid", request.getParameter("functionid"));
		return "system/function/selectrole.jsp";
	}
	
	@RequestMapping("/selectroledata")
	public void selectroledata(CriteriaUtil cu,	RoleEntity role,  RolefunctionEntity rolefunction,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(role, request.getParameterMap());
		
		cu.notexists(rolefunction);
		
		functionService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加角色菜单管理
	 * 
	 * @return
	 */
	@RequestMapping("/addfunctionrole")
	@ResponseBody
	public void addfunctionrole(String id, String functionid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(functionid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RolefunctionEntity rolefunction = new RolefunctionEntity();
			rolefunction.setFunctionid(functionid);
			rolefunction.setRoleid(i);
			try {
				this.functionService.save(rolefunction);
			} catch (Exception e) {
				 break;
			}
		}
		r.setMsg(Globals.ADD_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
	/**
	 * 删除角色菜单管理
	 * 
	 * @return
	 */
	@RequestMapping("/delfunctionrole")
	@ResponseBody
	public void delfunctionrole(String id, String functionid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RolefunctionEntity rolefunction = new RolefunctionEntity();
			rolefunction.setFunctionid(functionid);
			rolefunction.setRoleid(i);
			try {
				this.functionService.delete(rolefunction);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	
	@RequestMapping("/functionbutton")
	public String functionbutton(HttpServletRequest request) {
		request.setAttribute("functionid", request.getParameter("functionid"));
		return "system/functionbutton/functionbutton.jsp";
	}
	
	@RequestMapping("/functionbuttondata")
	public void functionbuttondata(CriteriaUtil cu, FunctionbuttonEntity functionbutton,
			HttpServletRequest request, HttpServletResponse response) {
		cu.installParams(functionbutton, request.getParameterMap());
		functionService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
}
