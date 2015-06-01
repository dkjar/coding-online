package com.dragon.codingol.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class ContextHolderUtils {

	public static String getIp(){
		return getRequest().getRemoteAddr();
	}
	
	
	public static String getBrowse(){
		return BrowserUtils.checkBrowse(getRequest());
	}
	/**
	 * SpringMvc下获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	/**
	 * SpringMvc下获取session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;
	}

	public static String getRealPath(String path){
		return getRequest().getSession().getServletContext().getRealPath("/");
	}
}
