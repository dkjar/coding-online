package com.dragon.codingol.web.controller.system;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.common.base.Globals;
import com.dragon.codingol.common.util.CriteriaUtil;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.RolefunctionEntity;
import com.dragon.codingol.domain.system.RolefunctionbuttonEntity;
import com.dragon.codingol.domain.system.RoleuserEntity;
import com.dragon.codingol.domain.system.UserEntity;
import com.dragon.codingol.service.system.RoleService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 角色管理
 * @author dx
 * @date 1,431,265,690,984
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/roleController")
public class RoleController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 角色管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/role/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, RoleEntity role, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(role, request.getParameterMap());
		roleService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}

	/**
	 * 角色管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/role/edit.jsp";
	}
	
	/**
	 * 角色管理查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/role/view.jsp";
	}
	
	/**
	 * 角色管理编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(RoleEntity role, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(role.getId())){
			role = this.roleService.get(RoleEntity.class, role.getId());
			jsonCommon.jsonReturn(role, response);
		}
	}
	
	/**
	 * 添加角色管理
	 * 
	 * @param RoleEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(RoleEntity role, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			roleService.saveOrUpdate(role);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除角色管理
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
		roleService.deleteEntityByIds(RoleEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	@RequestMapping("/roleuser")
	public String roleuser(HttpServletRequest request) {
		request.setAttribute("roleid", request.getParameter("roleid"));
		return "system/role/roleuser.jsp";
	}
	
 
	@RequestMapping("/roleuserdata")
	public void roleuserdata(CriteriaUtil cu,	UserEntity user,  RoleuserEntity roleuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(user, request.getParameterMap());
		
		cu.exists(roleuser);
		
		roleService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	

	/**
	 * 选择系统用户
	 * 
	 * @return
	 */
	@RequestMapping("/selectuser")
	public String selectuser(HttpServletRequest request) {
		request.setAttribute("roleid", request.getParameter("roleid"));
		return "system/role/selectuser.jsp";
	}
	
	@RequestMapping("/selectuserdata")
	public void selectuserdata(CriteriaUtil cu,	UserEntity user,  RoleuserEntity roleuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(user, request.getParameterMap());
		
		cu.notexists(roleuser);
		
		roleService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加用户角色关系表
	 * 
	 * @return
	 */
	@RequestMapping("/addroleuser")
	@ResponseBody
	public void addroleuser(String id, String roleid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(roleid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RoleuserEntity roleuser = new RoleuserEntity();
			roleuser.setRoleid(roleid);
			roleuser.setUserid(i);
			try {
				this.roleService.save(roleuser);
			} catch (Exception e) {
				 break;
			}
		}
		r.setMsg(Globals.ADD_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
	/**
	 * 删除用户角色关系表
	 * 
	 * @return
	 */
	@RequestMapping("/delroleuser")
	@ResponseBody
	public void delroleuser(String id, String roleid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RoleuserEntity roleuser = new RoleuserEntity();
			roleuser.setRoleid(roleid);
			roleuser.setUserid(i);
			try {
				this.roleService.delete(roleuser);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	
	@RequestMapping("/rolefunction")
	public String rolefunction(HttpServletRequest request) {
		request.setAttribute("roleid", request.getParameter("roleid"));
		return "system/role/rolefunction.jsp";
	}
	
 
	@RequestMapping("/rolefunctiondata")
	public void rolefunctiondata(CriteriaUtil cu,	FunctionEntity function,  RolefunctionEntity rolefunction,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		String pid = function.getId();
		function.setId(null);
		rolefunction.setId(null);
		
		cu.installParams(function, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		cu.exists(rolefunction);
		
		roleService.queryCriteriaPage(cu);
		
		jsonCommon.jsonTranlateReturn(FunctionEntity.class, cu.getPager(), response);
	}
	
	

	/**
	 * 选择系统菜单
	 * 
	 * @return
	 */
	@RequestMapping("/selectfunction")
	public String selectfunction(HttpServletRequest request) {
		request.setAttribute("roleid", request.getParameter("roleid"));
		return "system/role/selectfunction.jsp";
	}
	
	@RequestMapping("/selectfunctiondata")
	public void selectfunctiondata(CriteriaUtil cu,	FunctionEntity function,  RolefunctionEntity rolefunction,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(function, request.getParameterMap());
		
		cu.notexists(rolefunction);
		
		roleService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加角色菜单管理
	 * 
	 * @return
	 */
	@RequestMapping("/addrolefunction")
	@ResponseBody
	public void addrolefunction(String id, String roleid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(roleid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RolefunctionEntity rolefunction = new RolefunctionEntity();
			rolefunction.setRoleid(roleid);
			rolefunction.setFunctionid(i);
			try {
				this.roleService.save(rolefunction);
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
	@RequestMapping("/delrolefunction")
	@ResponseBody
	public void delrolefunction(String id, String roleid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RolefunctionEntity rolefunction = new RolefunctionEntity();
			rolefunction.setRoleid(roleid);
			rolefunction.setFunctionid(i);
			try {
				this.roleService.delete(rolefunction);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	
	
	
	

	@RequestMapping("/rolefunctionbutton")
	public String rolefunctionbutton(HttpServletRequest request, RolefunctionEntity rolefunction) {
		List<RolefunctionEntity> rolelist = this.roleService.findByExample(rolefunction);
		if(rolelist!=null && rolelist.size() == 1){
			request.setAttribute("rfunctionid",  rolelist.get(0).getId());
		}
		request.setAttribute("functionid",  rolefunction.getFunctionid());
		return "system/role/rolefunctionbutton.jsp";
	}
	
 
	@RequestMapping("/rolefunctionbuttondata")
	public void rolefunctionbuttondata(CriteriaUtil cu,	FunctionbuttonEntity functionbutton,  RolefunctionbuttonEntity rolefunctionbutton,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		String pid = functionbutton.getId();
		functionbutton.setId(null);
		rolefunctionbutton.setId(null);
		
		cu.installParams(functionbutton, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		cu.exists(rolefunctionbutton);
		
		roleService.queryCriteriaPage(cu);
		
		jsonCommon.jsonTranlateReturn(FunctionbuttonEntity.class, cu.getPager(), response);
	}
	

	/**
	 * 选择系统菜单
	 * 
	 * @return
	 */
	@RequestMapping("/selectfunctionbutton")
	public String selectfunctionbutton(HttpServletRequest request) {
		request.setAttribute("rfunctionid", request.getParameter("rfunctionid"));
		request.setAttribute("functionid", request.getParameter("functionid"));
		return "system/role/selectfunctionbutton.jsp";
	}
	
	@RequestMapping("/selectfunctionbuttondata")
	public void selectfunctionbuttondata(CriteriaUtil cu,	FunctionbuttonEntity functionbutton,  RolefunctionbuttonEntity rolefunctionbutton,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(functionbutton, request.getParameterMap());
		
		cu.notexists(rolefunctionbutton);
		
		roleService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加角色菜单管理
	 * 
	 * @return
	 */
	@RequestMapping("/addrolefunctionbutton")
	@ResponseBody
	public void addrolefunctionbutton(String id, String rfunctionid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(rfunctionid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RolefunctionbuttonEntity rolefunctionbutton = new RolefunctionbuttonEntity();
			rolefunctionbutton.setRfunctionid(rfunctionid);
			rolefunctionbutton.setFbuttonid(i);
			try {
				this.roleService.save(rolefunctionbutton);
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
	@RequestMapping("/delrolefunctionbutton")
	@ResponseBody
	public void delrolefunctionbutton(String id, String rfunctionid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RolefunctionbuttonEntity rolefunctionbutton = new RolefunctionbuttonEntity();
			rolefunctionbutton.setRfunctionid(rfunctionid);
			rolefunctionbutton.setFbuttonid(i);
			try {
				this.roleService.delete(rolefunctionbutton);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	
	
}
