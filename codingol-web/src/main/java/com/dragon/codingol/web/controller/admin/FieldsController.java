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
import com.dragon.codingol.service.admin.FieldsService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 系统数据列
 * @author dx
 * @date 1,431,938,499,030
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/fieldsController")
public class FieldsController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FieldsController.class);

	@Autowired
	private FieldsService fieldsService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 系统数据列列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "admin/fields/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, FieldsEntity fields, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(fields, request.getParameterMap());
		fieldsService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(FieldsEntity.class, cu.getPager(), response);
	}

	/**
	 * 系统数据列编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "admin/fields/edit.jsp";
	}
	
	/**
	 * 系统数据列查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "admin/fields/view.jsp";
	}
	
	/**
	 * 系统数据列编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(FieldsEntity fields, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(fields.getId())){
			fields = this.fieldsService.get(FieldsEntity.class, fields.getId());
			jsonCommon.jsonReturn(fields, response);
		}
	}
	
	/**
	 * 添加系统数据列
	 * 
	 * @param FieldsEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(FieldsEntity fields, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			fieldsService.saveOrUpdate(fields);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除系统数据列
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
		fieldsService.deleteEntityByIds(FieldsEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
}
