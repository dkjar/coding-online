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
import com.dragon.codingol.domain.system.IconEntity;   
import com.dragon.codingol.service.system.IconService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 图标管理
 * @author dx
 * @date 1,431,663,819,444
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/iconController")
public class IconController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(IconController.class);

	@Autowired
	private IconService iconService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 图标管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "system/icon/index.jsp";
	}

	/**
	 * 图标管理选择页面 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/select")
	public String select(HttpServletRequest request) {
		return "system/icon/select.jsp";
	}
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, IconEntity icon, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(icon, request.getParameterMap());
		iconService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(IconEntity.class, cu.getPager(), response);
	}

	/**
	 * 图标管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "system/icon/edit.jsp";
	}
	
	/**
	 * 图标管理查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "system/icon/view.jsp";
	}
	
	/**
	 * 图标管理编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(IconEntity icon, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(icon.getId())){
			icon = this.iconService.get(IconEntity.class, icon.getId());
			jsonCommon.jsonReturn(icon, response);
		}
	}
	
	/**
	 * 添加图标管理
	 * 
	 * @param IconEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(IconEntity icon, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			iconService.saveOrUpdate(icon);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除图标管理
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
		iconService.deleteEntityByIds(IconEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
}
