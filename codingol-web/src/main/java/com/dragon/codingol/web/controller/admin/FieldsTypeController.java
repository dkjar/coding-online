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
import com.dragon.codingol.domain.admin.FieldsTypeEntity;   
import com.dragon.codingol.service.admin.FieldsTypeService;
import com.dragon.codingol.web.common.JsonCommon;

/**   
 * @Title: Controller
 * @Description: 基础数据类型
 * @author dx
 * @date 1,429,670,424,295
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/fieldsTypeController")
public class FieldsTypeController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FieldsTypeController.class);

	@Autowired
	private FieldsTypeService fieldsTypeService;
	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 基础数据类型列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "admin/fieldsType/index.jsp";
	}
	
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, FieldsTypeEntity fieldsType, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(fieldsType, request.getParameterMap());
		fieldsTypeService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(FieldsTypeEntity.class, cu.getPager(), response);
	}

	/**
	 * 基础数据类型编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "admin/fieldsType/edit.jsp";
	}
	
	/**
	 * 基础数据类型查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "admin/fieldsType/view.jsp";
	}
	/**
	 * 基础数据类型编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(FieldsTypeEntity fieldsType, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(fieldsType.getId())){
			fieldsType = this.fieldsTypeService.get(FieldsTypeEntity.class, fieldsType.getId());
			jsonCommon.jsonReturn(fieldsType, response);
		}
	}
	
	/**
	 * 添加基础数据类型
	 * 
	 * @param FieldsTypeEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(FieldsTypeEntity fieldsType, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			fieldsTypeService.saveOrUpdate(fieldsType);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除基础数据类型
	 * 
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(String ids, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		if(StringUtils.isEmpty(ids)){
			r.setFailure(Globals.DELETE_SELECT);
			jsonCommon.jsonReturn(r, response);
			return;
		}
		fieldsTypeService.deleteEntityByIds(FieldsTypeEntity.class, ids);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
}
