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
import com.dragon.codingol.domain.admin.TablemapEntity;   
import com.dragon.codingol.service.admin.TablemapService;
import com.dragon.codingol.web.common.JsonCommon;
/**   
 * @Title: Controller
 * @Description: 表映射关系
 * @author dx
 * @date 1,432,194,407,107
 * @version V1.0   
 * 
 */
@Controller
@RequestMapping("/tablemapController")
public class TablemapController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TablemapController.class);

	@Autowired
	private TablemapService tablemapService;

	@Autowired
	private JsonCommon jsonCommon;
	/**
	 * 表映射关系列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "admin/tablemap/index.jsp";
	}

	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/indexdata")
	public void indexdata(CriteriaUtil cu, TablemapEntity tablemap, HttpServletRequest request, HttpServletResponse response, Pager page) {
		cu.installParams(tablemap, request.getParameterMap());
		tablemapService.queryCriteriaPage(cu);
		jsonCommon.jsonTranlateReturn(TablemapEntity.class, cu.getPager(), response);
	}

	/**
	 * 表映射关系编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit() {
		return "admin/tablemap/edit.jsp";
	}
	
	/**
	 * 表映射关系查看页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view() {
		return "admin/tablemap/view.jsp";
	}
	
	/**
	 * 表映射关系编辑页面数据
	 * 
	 * @return
	 */
	@RequestMapping("/editdata")
	public void editdata(TablemapEntity tablemap, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(tablemap.getId())){
			tablemap = this.tablemapService.get(TablemapEntity.class, tablemap.getId());
			jsonCommon.jsonReturn(tablemap, response);
		}
	}
	
	/**
	 * 添加表映射关系
	 * 
	 * @param TablemapEntity
	 * @return
	 */
	@RequestMapping("/editsave")
	@ResponseBody
	public void editsave(TablemapEntity tablemap, HttpServletRequest request, HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			tablemapService.saveOrUpdate(tablemap);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	/**
	 * 删除表映射关系
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
		tablemapService.deleteEntityByIds(TablemapEntity.class, id);
		r.setMsg(Globals.DELETE_SUCCESS);
		jsonCommon.jsonReturn(r, response);
	}
	
	
}
