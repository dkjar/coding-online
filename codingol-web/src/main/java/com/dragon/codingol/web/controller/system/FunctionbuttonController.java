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
import com.dragon.codingol.domain.system.FunctionbuttonEntity;   
import com.dragon.codingol.service.system.FunctionbuttonService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 菜单功能管理
 * @author dx
 * @date 1,432,196,980,368
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/functionbuttonController")
public class FunctionbuttonController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FunctionbuttonController.class);

	@Autowired
	private FunctionbuttonService functionbuttonService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 菜单功能管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/functionbutton/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, FunctionbuttonEntity functionbutton, HttpServletRequest request, HttpServletResponse response, Pager page) {
		String pid = functionbutton.getId();
		functionbutton.setId(null);
		
		cu.installParams(functionbutton, request.getParameterMap());
		if(StringUtils.isEmpty(pid)){
			cu.empty("pid");
		}else{
			cu.eq("pid", pid);
		}
		
		functionbuttonService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(FunctionbuttonEntity.class, cu.getPager(), response);
	}

	/**
	 * 菜单功能管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/functionbutton/edit.jsp";
	}
	
	/**
	 * 菜单功能管理查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/functionbutton/view.jsp";
	}
	
	/**
	 * 菜单功能管理编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(FunctionbuttonEntity functionbutton, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(functionbutton.getId())){
			functionbutton = this.functionbuttonService.get(FunctionbuttonEntity.class, functionbutton.getId());
			jsonCommon.jsonReturn(functionbutton, response);
		}
	}
	
	/**
	 * 添加菜单功能管理
	 * 
	 * @param FunctionbuttonEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(FunctionbuttonEntity functionbutton, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			if(!StringUtils.isEmpty(functionbutton.getPid())){
				FunctionbuttonEntity parent = this.functionbuttonService.get(FunctionbuttonEntity.class, functionbutton.getPid());
				parent.setState(0);
				functionbuttonService.saveOrUpdate(parent);
			}
			functionbuttonService.saveOrUpdate(functionbutton);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除菜单功能管理
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
		functionbuttonService.deleteEntityByIds(FunctionbuttonEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
}
