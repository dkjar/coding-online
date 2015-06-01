package com.dragon.codingol.web.controller.admin;
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
import com.dragon.codingol.domain.admin.FieldsEntity;
import com.dragon.codingol.domain.admin.TableEntity;   
import com.dragon.codingol.service.admin.TableService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 系统数据表
 * @author dx
 * @date 1,431,935,241,166
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/tableController")
public class TableController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TableController.class);

	@Autowired
	private TableService tableService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 系统数据表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "admin/table/index.jsp";
	}

	/**
	 * 系统数据表选择页面 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/select")
	public String select(HttpServletRequest request) {
		return "admin/table/select.jsp";
	}
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, TableEntity table, HttpServletRequest request, HttpServletResponse response, Pager page) {
		String pid = table.getId();
		table.setId(null);
		
		cu.installParams(table, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		tableService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(TableEntity.class, cu.getPager(), response);
	}

	/**
	 * 系统数据表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "admin/table/edit.jsp";
	}
	
	/**
	 * 系统数据表查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "admin/table/view.jsp";
	}
	
	/**
	 * 系统数据表编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(TableEntity table, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(table.getId())){
			table = this.tableService.get(TableEntity.class, table.getId());
			jsonCommon.jsonReturn(table, response);
		}
	}
	
	/**
	 * 添加系统数据表
	 * 
	 * @param TableEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(TableEntity table, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			if(!StringUtils.isEmpty(table.getPid())){
				TableEntity parent = this.tableService.get(TableEntity.class, table.getPid());
				parent.setState(0);
				tableService.saveOrUpdate(parent);
			}
			tableService.saveOrUpdate(table);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除系统数据表
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
		tableService.deleteEntityByIds(TableEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
	@RequestMapping("/fields")
	public String fields(HttpServletRequest request) {
		request.setAttribute("tableid", request.getParameter("tableid"));
		return "admin/fields/fields.jsp"; 
	}
	
	@RequestMapping("/fieldsdata")
	public void fieldsdata(CriteriaUtil cu, FieldsEntity fields,
			HttpServletRequest request, HttpServletResponse response) {
		cu.installParams(fields, request.getParameterMap());
		tableService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}
	
	
	@RequestMapping("/initcolumn")
	@ResponseBody
	public void initcolumn(String id, HttpServletRequest request, HttpServletResponse response){
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(id)){
			r.setFailure("初始化失败,请选择需要导入的表！");
			jsonCommon.jsonReturn(r, response);
			return;
		}
		try {
			tableService.initcolumn(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.setMsg("初始化成功");
		jsonCommon.jsonReturn(r, response);
	}
}
