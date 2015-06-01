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
import com.dragon.codingol.domain.system.RoleuserEntity;
import com.dragon.codingol.domain.system.DepartmentEntity;
import com.dragon.codingol.domain.system.DepartmentuserEntity;
import com.dragon.codingol.domain.system.UserEntity;   
import com.dragon.codingol.service.system.UserService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 系统用户
 * @author dx
 * @date 1,431,257,359,031
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/userController")
public class UserController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 系统用户列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		
		return "system/user/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, UserEntity user, HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		
		cu.installParams(user, request.getParameterMap());
		userService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(UserEntity.class, cu.getPager(), response);
	}

	/**
	 * 系统用户编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/user/edit.jsp";
	}
	
	/**
	 * 系统用户查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/user/view.jsp";
	}
	
	/**
	 * 系统用户编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(UserEntity user, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(user.getId())){
			user = this.userService.get(UserEntity.class, user.getId());
			jsonCommon.jsonReturn(user, response);
		}
	}
	
	/**
	 * 添加系统用户
	 * 
	 * @param UserEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(UserEntity user, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			userService.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除系统用户
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
		userService.deleteEntityByIds(UserEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	@RequestMapping("/userrole")
	public String userrole(HttpServletRequest request) {
		request.setAttribute("userid", request.getParameter("userid"));
		return "system/user/userrole.jsp";
	}
	
 
	@RequestMapping("/userroledata")
	public void userroledata(CriteriaUtil cu,	RoleEntity role,  RoleuserEntity roleuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(role, request.getParameterMap());
		
		cu.exists(roleuser);
		
		userService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	

	/**
	 * 选择角色管理
	 * 
	 * @return
	 */
	@RequestMapping("/selectrole")
	public String selectrole(HttpServletRequest request) {
		request.setAttribute("userid", request.getParameter("userid"));
		return "system/user/selectrole.jsp";
	}
	
	@RequestMapping("/selectroledata")
	public void selectroledata(CriteriaUtil cu,	RoleEntity role,  RoleuserEntity roleuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(role, request.getParameterMap());
		
		cu.notexists(roleuser);
		
		userService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加用户角色关系表
	 * 
	 * @return
	 */
	@RequestMapping("/adduserrole")
	@ResponseBody
	public void adduserrole(String id, String userid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(userid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RoleuserEntity roleuser = new RoleuserEntity();
			roleuser.setUserid(userid);
			roleuser.setRoleid(i);
			try {
				this.userService.save(roleuser);
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
	@RequestMapping("/deluserrole")
	@ResponseBody
	public void deluserrole(String id, String userid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			RoleuserEntity roleuser = new RoleuserEntity();
			roleuser.setUserid(userid);
			roleuser.setRoleid(i);
			try {
				this.userService.delete(roleuser);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	@RequestMapping("/userdepartment")
	public String userdepartment(HttpServletRequest request) {
		request.setAttribute("userid", request.getParameter("userid"));
		return "system/user/userdepartment.jsp";
	}
	
 
	@RequestMapping("/userdepartmentdata")
	public void userdepartmentdata(CriteriaUtil cu,	DepartmentEntity department,  DepartmentuserEntity departmentuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(department, request.getParameterMap());
		
		cu.exists(departmentuser);
		
		userService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	

	/**
	 * 选择组织机构
	 * 
	 * @return
	 */
	@RequestMapping("/selectdepartment")
	public String selectdepartment(HttpServletRequest request) {
		request.setAttribute("userid", request.getParameter("userid"));
		return "system/user/selectdepartment.jsp";
	}
	
	@RequestMapping("/selectdepartmentdata")
	public void selectdepartmentdata(CriteriaUtil cu,	DepartmentEntity department,  DepartmentuserEntity departmentuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(department, request.getParameterMap());
		
		cu.notexists(departmentuser);
		
		userService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加用户管理部门
	 * 
	 * @return
	 */
	@RequestMapping("/adduserdepartment")
	@ResponseBody
	public void adduserdepartment(String id, String userid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(userid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			DepartmentuserEntity departmentuser = new DepartmentuserEntity();
			departmentuser.setUserid(userid);
			departmentuser.setDepartid(i);
			try {
				this.userService.save(departmentuser);
			} catch (Exception e) {
				 break;
			}
		}
		r.setMsg(Globals.ADD_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
	/**
	 * 删除用户管理部门
	 * 
	 * @return
	 */
	@RequestMapping("/deluserdepartment")
	@ResponseBody
	public void deluserdepartment(String id, String userid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			DepartmentuserEntity departmentuser = new DepartmentuserEntity();
			departmentuser.setUserid(userid);
			departmentuser.setDepartid(i);
			try {
				this.userService.delete(departmentuser);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
}
