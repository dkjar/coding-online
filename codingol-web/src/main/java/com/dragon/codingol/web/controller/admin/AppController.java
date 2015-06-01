package com.dragon.codingol.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.domain.system.ApplicationEntity;
import com.dragon.codingol.service.CommonService;
import com.dragon.codingol.web.common.JsonCommon;


@Controller("appController")
@RequestMapping("/appController")
public class AppController {
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private JsonCommon jsonCommon;
	
	@RequestMapping("/index")
	public String index(){
		return "admin/application/index";
	}
	
	
	@RequestMapping("/indexdata")
	public void indexdata(Pager page, HttpServletRequest request, HttpServletResponse response){
		List<ApplicationEntity> applications =	commonService.loadAll(ApplicationEntity.class);
		page.setTotal(200);
		page.setRows(applications);
		jsonCommon.jsonReturn(page, response);
	}
	
	@RequestMapping("/edit")
	public String edit(){
		return "admin/application/edit";
	}
	
	@RequestMapping("/editdata")
	public void editdata(ApplicationEntity application, HttpServletRequest request, HttpServletResponse response){
		if(!StringUtils.isEmpty(application.getId())){
			application = this.commonService.get(ApplicationEntity.class, application.getId());
			jsonCommon.jsonReturn(application, response);
		}
	}
	
	
	@RequestMapping("/editsave")
	public void editsave(ApplicationEntity application, HttpServletRequest request, HttpServletResponse response){
		ResultJson r = new ResultJson();
		try {
			commonService.saveOrUpdate(application);
		} catch (Exception e) {
			e.printStackTrace();
			r.setFailure(e.getMessage());
		}
		jsonCommon.jsonReturn(r, response);
	}
}
