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
import com.dragon.codingol.domain.system.TypeEntity;   
import com.dragon.codingol.service.system.TypeService;
import com.dragon.codingol.web.common.JsonCommon;

/**   
 * @Title: Controller
 * @Description: 字典信息
 * @author dx
 * @date 1,429,769,670,354
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/typeController")
public class TypeController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TypeController.class);

	@Autowired
	private TypeService typeService;
	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 字典信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/type/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, TypeEntity type, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(type, request.getParameterMap());
		typeService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}

	/**
	 * 字典信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/type/edit.jsp";
	}
	
	/**
	 * 字典信息查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/type/view.jsp";
	}
	
	/**
	 * 字典信息编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(TypeEntity type, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(type.getId())){
			type = this.typeService.get(TypeEntity.class, type.getId());
			jsonCommon.jsonReturn(type, response);
		}
	}
	
	/**
	 * 添加字典信息
	 * 
	 * @param TypeEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(TypeEntity type, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			typeService.saveOrUpdate(type);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除字典信息
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
		typeService.deleteEntityByIds(TypeEntity.class, ids);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
}
