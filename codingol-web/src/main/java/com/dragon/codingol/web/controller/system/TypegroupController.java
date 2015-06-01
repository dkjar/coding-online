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
import com.dragon.codingol.domain.system.TypegroupEntity;   
import com.dragon.codingol.service.system.TypegroupService;
import com.dragon.codingol.web.common.JsonCommon;

/**   
 * @Title: Controller
 * @Description: 字典分类管理
 * @author dx
 * @date 1,429,769,666,687
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/typegroupController")
public class TypegroupController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TypegroupController.class);

	@Autowired
	private TypegroupService typegroupService;
	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 字典分类管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/typegroup/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, TypegroupEntity typegroup, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(typegroup, request.getParameterMap());
		typegroupService.queryCriteriaPage(cu);
		jsonCommon.jsonReturn(cu.getPager(), response);
	}

	/**
	 * 字典分类管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/typegroup/edit.jsp";
	}
	
	/**
	 * 字典分类管理查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/typegroup/view.jsp";
	}
	
	/**
	 * 字典分类管理编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(TypegroupEntity typegroup, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(typegroup.getId())){
			typegroup = this.typegroupService.get(TypegroupEntity.class, typegroup.getId());
			jsonCommon.jsonReturn(typegroup, response);
		}
	}
	
	/**
	 * 添加字典分类管理
	 * 
	 * @param TypegroupEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(TypegroupEntity typegroup, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			typegroupService.saveOrUpdate(typegroup);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除字典分类管理
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
		typegroupService.deleteEntityByIds(TypegroupEntity.class, ids);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
}
