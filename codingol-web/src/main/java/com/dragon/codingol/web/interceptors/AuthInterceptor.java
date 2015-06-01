package com.dragon.codingol.web.interceptors;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dragon.codingol.common.util.ResourceUtil;
import com.dragon.codingol.domain.system.UserEntity;


/**
 * 权限拦截器
 * 
 * @author
 * 
 */
public class AuthInterceptor implements HandlerInterceptor {
	  
 
	private List<String> exclude;
	 
	public List<String> getExclude() {
		return exclude;
	}

	public void setExclude(List<String> exclude) {
		this.exclude = exclude;
	}

	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		 
	}

	/**
	 * 在controller前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = ResourceUtil.getRequestPath(request);
		if(!exclude.contains(requestPath)){
			UserEntity user  = ResourceUtil.getSessionUserName();
			if(user==null){
				forward(request, response);
				return false;
			}
		}
		
		request.setAttribute("functionid",  request.getParameter("functionid"));
		request.setAttribute("ProjectPath", request.getContextPath());
		return true;
	}
	
 
	/**
	 * 转发
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) { 
		return new ModelAndView(new RedirectView("loginController.htm?login2"));
	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../login.html");
	}

}
