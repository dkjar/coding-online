package com.dragon.codingol.common.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.dragon.codingol.common.base.Globals;
import com.dragon.codingol.common.base.SessionInfo;
import com.dragon.codingol.domain.system.DepartmentEntity;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.UserEntity;
  

public class ResourceUtil {
	
	//获取应用子系统信息
	public static final Object GetApplications(){
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				return session.getAttribute(Globals.SYS_APP + sessionInfo.getUser().getId().toString()); 
			} else {

				return null;
			}

		} else {
			return null;
		}
	}
	 
	public static final UserEntity getSessionUserName() {
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) { 
				return sessionInfo.getUser();
			} else {
				return null;
			}

		} else {
			return null;
		}
	}
	
	public static final List<RoleEntity> getSessionRoles() {
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				return sessionInfo.getRoleList();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	
	public static final DepartmentEntity getSessionDepartment() {
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				return sessionInfo.getDepartment();
			} else { 
				return null;
			}

		} else {
			return null;
		}
	}
	
	public static final DepartmentEntity getSessionParentDepartment() {
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				return sessionInfo.getParentDepart();
			} else { 
				return null;
			}

		} else {
			return null;
		}
	}
	
	
	
	public static final List<FunctionEntity> getSessionFunctions() {
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				List<FunctionEntity> funs =  sessionInfo.getFunctionList();
				List<FunctionEntity> functionList = new ArrayList<FunctionEntity>();
				if(funs !=null && funs.size() >0){
					for(FunctionEntity f: funs){
						if( f.getPid() != null || f.getPid().equals(0)){
							//f.setChildList(getChildren(funs, f));
							functionList.add(f);
						}
					}
				}
				return functionList;
			}  
		} 
		return null;
	}
	 
	
	public static final List<FunctionEntity> getFunctions() {
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				 return sessionInfo.getFunctionList();
			}  
		} 
		return null;
	}
	public static final List<FunctionEntity> getChildren(FunctionEntity function){
		HttpSession session = ContextHolderUtils.getSession();
		session.setMaxInactiveInterval(-1);
		if (session.getAttributeNames().hasMoreElements()) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Globals.USER_SESSION);
			if (sessionInfo != null) {
				return getChildren( sessionInfo.getFunctionList(), function);
			}  
		} 
		return null;
	}
		
	private static List<FunctionEntity> getChildren(List<FunctionEntity> funs, FunctionEntity function){
		List<FunctionEntity> functionList = null;
		for(FunctionEntity f: funs){
			if(!StringUtils.isEmpty(f.getPid()) && f.getPid().equals(function.getId())){
				if(functionList==null){
					functionList = new ArrayList<FunctionEntity>();
				}
				functionList.add(f);
				List<FunctionEntity> children = getChildren(funs, f);
				if(children!=null)
					functionList.addAll(children);
			}
		}
		return functionList;
	}
	
	 
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
		return requestPath;
	}
	
	public static String getSysPath() {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		String temp = path.replaceFirst("file:/", "").replaceFirst("WEB-INF/classes/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator).replaceAll("%20", " ");
		return resultPath;
	}

	/**
	 * 获取项目根目录
	 * 
	 * @return
	 */
	public static String getPorjectPath() {
		String nowpath; // 当前tomcat的bin目录的路径 如   D:\java\software\apache-tomcat-6.0.14\bin
		String tempdir;
		nowpath = System.getProperty("user.dir");
		tempdir = nowpath.replace("bin", "webapps"); // 把bin 文件夹变到 webapps文件里面
		tempdir += "\\"; // 拼成D:\java\software\apache-tomcat-6.0.14\webapps
		return tempdir;
	}

	public static String getClassPath() {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		String temp = path.replaceFirst("file:/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	public static String getSystempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	public static String getSeparator() {
		return System.getProperty("file.separator");
	}

	public static String getParameter(String field) {
		HttpServletRequest request = ContextHolderUtils.getRequest();
		return request.getParameter(field);
	}
 

}
