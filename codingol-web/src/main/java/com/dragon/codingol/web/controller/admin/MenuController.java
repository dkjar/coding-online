package com.dragon.codingol.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.service.system.MenuService;
import com.dragon.codingol.web.common.JsonCommon;


@Controller("menuController")
@RequestMapping("/menuController")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private JsonCommon jsonCommon;
	
	@RequestMapping("/index")
	public String index(){
		return "admin/menu/index.jsp";
	}
	
	@RequestMapping("/indexdata")
	public void indexdata(Pager page, HttpServletRequest request, HttpServletResponse response){
		List<FunctionEntity> funs =	menuService.loadAll(FunctionEntity.class);
		page.setTotal(200);
		page.setRows(funs);
		jsonCommon.jsonReturn(page, response);
	}
	
	@RequestMapping("/edit")
	public String edit(FunctionEntity function, HttpServletRequest request){
		if(function.getId() != null)
			request.setAttribute("systems", menuService.get(FunctionEntity.class, function.getId()));
		return "system/edit.jsp";
	}
	
	@RequestMapping(params="save")
	public void save(FunctionEntity function, HttpServletRequest request, HttpServletResponse response){
		ResultJson r = new ResultJson();
		try{
			 this.menuService.save(function);
		}catch(Exception e){
			r.setSuccess(false);
			r.setMsg(e.getMessage());
		}
		
		jsonCommon.jsonReturn(r, response);
	}
	
	
	//菜单
	@RequestMapping("/menu")
	public String menu(Model model){
		return "system/menu.jsp";
	}
	
	@RequestMapping("/menudata")
	public void menudata(Pager page, HttpServletRequest request, HttpServletResponse response){
		List<SystemEntity> systems =	menuService.loadAll(SystemEntity.class);
		page.setTotal(200);
		page.setRows(systems);
		jsonCommon.jsonReturn(page, response);
	}
	
}
