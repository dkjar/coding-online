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
import com.dragon.codingol.domain.system.UserEntity;
import com.dragon.codingol.domain.system.DepartmentuserEntity;
import com.dragon.codingol.domain.system.DepartmentEntity;   
import com.dragon.codingol.service.system.DepartmentService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 组织机构
 * @author dx
 * @date 1,431,931,542,110
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/departmentController")
public class DepartmentController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 组织机构列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/department/index.jsp";
	}

	/**
	 * 组织机构选择页面 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/select")
	public String select(HttpServletRequest request) {
		return "system/department/select.jsp";
	}
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, DepartmentEntity department, HttpServletRequest request, HttpServletResponse response, Pager page) {
		String pid = department.getId();
		department.setId(null);
		
		cu.installParams(department, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		departmentService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(DepartmentEntity.class, cu.getPager(), response);
	}

	/**
	 * 组织机构编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/department/edit.jsp";
	}
	
	/**
	 * 组织机构查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/department/view.jsp";
	}
	
	/**
	 * 组织机构编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(DepartmentEntity department, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(department.getId())){
			department = this.departmentService.get(DepartmentEntity.class, department.getId());
			jsonCommon.jsonReturn(department, response);
		}
	}
	
	/**
	 * 添加组织机构
	 * 
	 * @param DepartmentEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(DepartmentEntity department, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			if(!StringUtils.isEmpty(department.getPid())){
				DepartmentEntity parent = this.departmentService.get(DepartmentEntity.class, department.getPid());
				parent.setState(0);
				departmentService.saveOrUpdate(parent);
			}
			departmentService.saveOrUpdate(department);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除组织机构
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
		departmentService.deleteEntityByIds(DepartmentEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	@RequestMapping("/departmentuser")
	public String departmentuser(HttpServletRequest request) {
		request.setAttribute("departid", request.getParameter("departid"));
		return "system/department/departmentuser.jsp";
	}
	
 
	@RequestMapping("/departmentuserdata")
	public void departmentuserdata(CriteriaUtil cu,	UserEntity user,  DepartmentuserEntity departmentuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(user, request.getParameterMap());
		
		cu.exists(departmentuser);
		
		departmentService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	

	/**
	 * 选择系统用户
	 * 
	 * @return
	 */
	@RequestMapping("/selectuser")
	public String selectuser(HttpServletRequest request) {
		request.setAttribute("departid", request.getParameter("departid"));
		return "system/department/selectuser.jsp";
	}
	
	@RequestMapping("/selectuserdata")
	public void selectuserdata(CriteriaUtil cu,	UserEntity user,  DepartmentuserEntity departmentuser,
			HttpServletRequest request, HttpServletResponse response, Pager page) {
		
		cu.installParams(user, request.getParameterMap());
		
		cu.notexists(departmentuser);
		
		departmentService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	/**
	 * 添加用户管理部门
	 * 
	 * @return
	 */
	@RequestMapping("/adddepartmentuser")
	@ResponseBody
	public void adddepartmentuser(String id, String departid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id) || StringUtils.isEmpty(departid)){
			r.setFailure(Globals.ADD_FAILURE);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			DepartmentuserEntity departmentuser = new DepartmentuserEntity();
			departmentuser.setDepartid(departid);
			departmentuser.setUserid(i);
			try {
				this.departmentService.save(departmentuser);
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
	@RequestMapping("/deldepartmentuser")
	@ResponseBody
	public void deldepartmentuser(String id, String departid, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		String ids[] = id.split(",");
		for(String i : ids){
			DepartmentuserEntity departmentuser = new DepartmentuserEntity();
			departmentuser.setDepartid(departid);
			departmentuser.setUserid(i);
			try {
				this.departmentService.delete(departmentuser);
			} catch (Exception e) {
				 break;
			}
		}
		
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}	
	
}
