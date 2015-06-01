package com.dragon.codingol.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.util.Base64;
import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.common.base.Globals;
import com.dragon.codingol.common.base.SessionInfo;
import com.dragon.codingol.common.util.ContextHolderUtils;
import com.dragon.codingol.common.util.LogUtil;
import com.dragon.codingol.common.util.ResourceUtil;
import com.dragon.codingol.domain.system.DepartmentEntity;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.UserEntity;
import com.dragon.codingol.service.system.HomeService;
import com.dragon.codingol.web.common.JsonCommon;

@Controller("homeController")
@RequestMapping("/homeController")
public class HomeController {

	@Autowired
	private HomeService homeService;
	@Autowired
	private JsonCommon jsonCommon;

	private String decryptBASE64(String key) throws Exception {
		byte[] bytes = Base64.base64ToByteArray(key);
		return new String(bytes);
	}

	@RequestMapping("/login")
	public void login(UserEntity user, HttpServletRequest request,
			HttpServletResponse response) {
		ResultJson r = new ResultJson();
		HttpSession session = ContextHolderUtils.getSession();
		try {
			user.setPassword(decryptBASE64(user.getPassword()));

			UserEntity u = homeService.checkUserExits(user);
			if (u != null) {
				if (u.getStatus() == 0) {
					r.setFailure("该用户已被禁用");
					jsonCommon.jsonReturn(r, response);
					return;
				}
				String message = "用户: " + u.getNumber() + "登录成功";
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setUser(u);

				DepartmentEntity depart = homeService.get(DepartmentEntity.class, u.getDepartmentid());
				if (depart == null) {
					r.setFailure("该用户未设置所在部门!");
					jsonCommon.jsonReturn(r, response);
					return;
				}

				List<RoleEntity> roleList = this.homeService.getRoleByUser(u.getId());
				if (roleList == null || roleList.size() == 0) {
					r.setFailure("该用户还未分配角色!");
					jsonCommon.jsonReturn(r, response);
					return;
				}
				sessionInfo.setRoleList(roleList);

				List<FunctionEntity> functionList = this.homeService
						.getFunctionByUser(u.getId());
				if (functionList == null || functionList.size() == 0) {
					r.setFailure("该用户还未分配任何菜单!");
					jsonCommon.jsonReturn(r, response);
					return;
				}
				sessionInfo.setFunctionList(functionList);

				session.setMaxInactiveInterval(60 * 30);
				session.setAttribute(Globals.USER_SESSION, sessionInfo);

				// 添加登陆日志
				LogUtil.info(message);

				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				jsonCommon.jsonReturn(r, response);
			} else {
				r.setFailure("用户名或密码错误!");
				jsonCommon.jsonReturn(r, response);
				return;
			}
		} catch (Exception e) {
			r.setFailure("用户名或密码错误!");
		}
		jsonCommon.jsonReturn(r, response);
	}

	@RequestMapping("/main")
	public String main(HttpServletRequest request) {
		List<FunctionEntity> functions = ResourceUtil.getFunctions();
		List<FunctionEntity> roots = new ArrayList<FunctionEntity>();
		FunctionEntity first = null;
		for (FunctionEntity f : functions) {
			if (StringUtils.isEmpty(f.getPid())) {
				if (first == null)
					first = f;
				roots.add(f);
			}
		}
		request.setAttribute("funs", roots);
		request.setAttribute("first", first);
		return "system/main.jsp";
	}

	@RequestMapping("/maindata")
	public void maindata(Pager page, HttpServletRequest request,
			HttpServletResponse response) {
		List<UserEntity> users = homeService.loadAll(UserEntity.class);
		page.setTotal(200);
		page.setRows(users);
		jsonCommon.jsonReturn(page, response);
	}

	@RequestMapping("/menudata")
	public void menudata(Pager page, FunctionEntity fun,
			HttpServletRequest request, HttpServletResponse response) {
		jsonCommon.jsonReturn(ResourceUtil.getChildren(fun), response);
	}

	@RequestMapping("/quit")
	public void quit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = ContextHolderUtils.getSession();
		Enumeration e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			session.removeAttribute(e.nextElement().toString());
		}
		// 判断用户是否为空不为空则清空session中的用户object
		session.removeAttribute(Globals.USER_SESSION);// 注销该操作用户
		session.invalidate();
		try {

			response.sendRedirect("../login.html");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
