package com.dragon.codingol.common.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.common.util.ResourceUtil;
import com.dragon.codingol.domain.system.DepartmentEntity;
import com.dragon.codingol.domain.system.SalaryNoteEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.UserEntity;

public class CommonHelper {

	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String captureName(String str){
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * mysql数据类型转java数据类型
	 * @param dataType
	 * @param scale
	 * @return
	 */
	public static String mysqlTypeConvert(String dataType, Integer scale){
		if (dataType.contains("char"))
			return "java.lang.String";
		else if (dataType.contains("int"))
			return "java.lang.Integer";
		else if (dataType.contains("float"))
			return "java.lang.Float";
		else if (dataType.contains("double"))
			return "java.lang.Double";
		else if (dataType.contains("number"))
			if (scale.intValue() > 0)
				return "java.math.BigDecimal";
			else if (scale.intValue() > 10)
				return "java.lang.Long";
			else
				return "java.lang.Integer";
		else if (dataType.contains("decimal"))
			return "BigDecimal";
		else if (dataType.contains("date"))
			return "java.util.Date";
		else if (dataType.contains("time"))
			return "java.util.Date";
		else if (dataType.contains("blob"))
			return "byte[]";
		else if (dataType.contains("clob"))
			return "java.sql.Clob";
		else if (dataType.contains("numeric"))
			return "BigDecimal";
		else if (dataType.contains("text"))
			return "java.lang.String";
		else
			return "java.lang.Object";
	}
	
	 
	
	public static String toUtf8String(String s){ 
	     StringBuffer sb = new StringBuffer(); 
	       for (int i=0;i<s.length();i++){ 
	          char c = s.charAt(i); 
	          if (c >= 0 && c <= 255){sb.append(c);} 
	        else{ 
	        byte[] b; 
	         try { b = Character.toString(c).getBytes("utf-8");} 
	         catch (Exception ex) { 
	             System.out.println(ex); 
	                  b = new byte[0]; 
	         } 
	            for (int j = 0; j < b.length; j++) { 
	             int k = b[j]; 
	              if (k < 0) k += 256; 
	              sb.append("%" + Integer.toHexString(k).toUpperCase()); 
	              } 
	     } 
	  } 
	  return sb.toString(); 
	}
	
	/**
	 * 普通用户登陆
	 * @return
	 */
	public static boolean isUser(){
		String users = SystemConfig.getConfigByName("user");
		if(StringUtils.isEmpty(users)){
			users = "user";
		}
		boolean isUser = false;
		String user[] = users.split(",");
		List<RoleEntity> roleList = ResourceUtil.getSessionRoles();
		if(roleList.size() == 1)
			for(RoleEntity r :roleList ){
				for(String u :user){
					if(r.getRolecode().equals(u)){
						isUser = true;
						break;
					}
				}
				if(isUser)
					break;
			}
		return isUser;
	}
	
	/**
	 * 管理员登陆
	 * @return
	 */
	public static boolean isMananger(){
		String users = SystemConfig.getConfigByName("super");
		if(StringUtils.isEmpty(users)){
			users = "admin,super";
		}
		boolean isSuper = false;
		String user[] = users.split(",");
		List<RoleEntity> roleList = ResourceUtil.getSessionRoles();
		if(roleList.size() >= 1)
			for(RoleEntity r :roleList ){
				for(String u :user){
					if(r.getRolecode().equals(u)){
						isSuper = true;
						break;
					}
				}
				if(isSuper)
					break;
			}
		return isSuper;
	}
	
	/**
	 * 当前登陆用户
	 * @param params
	 */
	public static void addUserId(Map<String, Object> params){
		List<RoleEntity> roleList = ResourceUtil.getSessionRoles();
		//管理用户
		String roles = SystemConfig.getConfigByName("super");
		//普通用户
		String users = SystemConfig.getConfigByName("user");
		if(StringUtils.isEmpty(roles)){
			roles = "admin,super";
		}
		if(StringUtils.isEmpty(users)){
			users = "user";
		}
		boolean isSuper = false;
		boolean isUser = true;
		String role[] = roles.split(",");
		String user[] = users.split(",");
		for(RoleEntity r :roleList ){
			for(String e :role){
				if(r.getRolecode().equals(e)){
					isSuper = true;
					break;
				}
			}
			for(String u :user){
				if(!r.getRolecode().equals(u)){
					isUser = false;
					break;
				}
			}
			if(isSuper)
				break;
		}
		if(isUser){
			//只查看自己的信息
			UserEntity u = ResourceUtil.getSessionUserName();
			params.put("employeeid", u.getEmployeeid());
		}else if(!isSuper){
			UserEntity u = ResourceUtil.getSessionUserName();
			params.put("userid", u.getId());
		} 
	}
	
	/**
	 * 添加当前所在部门
	 * @param params
	 */
	public static void addDepartId(Map<String, Object> params){
		List<RoleEntity> roleList = ResourceUtil.getSessionRoles();
		//管理用户
		String roles = SystemConfig.getConfigByName("super");
		//普通用户
		String users = SystemConfig.getConfigByName("user");
		if(StringUtils.isEmpty(roles)){
			roles = "admin,super";
		}
		if(StringUtils.isEmpty(users)){
			users = "user";
		}
		boolean isSuper = false;
		boolean isUser = false;
		String role[] = roles.split(",");
		String user[] = users.split(",");
		for(RoleEntity r :roleList ){
			for(String e :role){
				if(r.getRolecode().equals(e)){
					isSuper = true;
					break;
				}
			}
			for(String u :user){
				if(r.getRolecode().equals(u)){
					isUser = true;
					break;
				}
			}
			if(isSuper)
				break;
			if(isUser)
				break;
		}
		if(isUser){
			 
		}else if(!isSuper){
			DepartmentEntity depart = ResourceUtil.getSessionDepartment();
			params.put("departid", depart.getId());
		} 
	}
	
	/**
	 * 当前管辖部门
	 * @param str
	 * @return
	 */
	public static List<DepartmentEntity> getAuthDepartment(){
		
		List<RoleEntity> roleList = ResourceUtil.getSessionRoles();
		String roles = SystemConfig.getConfigByName("super");
		if(StringUtils.isEmpty(roles)){
			roles = "admin,super";
		}
		boolean isSuper = false;
		String role[] = roles.split(",");
		for(RoleEntity r :roleList ){
			for(String e :role){
				if(r.getRolecode().equals(e)){
					isSuper = true;
					break;
				}
			}
			if(isSuper)
				break;
		}
		if(!isSuper){
			DepartmentEntity currentdepart = ResourceUtil.getSessionDepartment();
			List<DepartmentEntity> systemDepartList = new ArrayList<DepartmentEntity>();
			systemDepartList.add(currentdepart);
			systemDepartList.addAll(getChirldDepartments(currentdepart));
			return systemDepartList;
		}else{
			List<DepartmentEntity> systemDepartList = new ArrayList<DepartmentEntity>();
			/*for(DepartmentEntity d : DepartmentEntity.getDepartmentList().values()){
				systemDepartList.add(d);
			}*/
			return systemDepartList;
		}
	}
	
	private static List<DepartmentEntity> getChirldDepartments(DepartmentEntity parent){
		List<DepartmentEntity> systemDepartList = new ArrayList<DepartmentEntity>();
	/*	for(DepartmentEntity d : DepartmentEntity.getDepartmentList().values()){
			if(d.getPid().equals(parent.getId())){
				systemDepartList.add(d);
			}
		}*/
		return systemDepartList;
	}
	
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("^-?(?:\\d+|\\d{1,3}(?:,\\d{3})+)(?:\\.\\d+)?$"); 
	    return pattern.matcher(str).matches();    
	} 

	
	public static SalaryNoteEntity getSalaryNoteEntity(){
		SalaryNoteEntity n = new SalaryNoteEntity();
		n.setId(UUID.randomUUID().toString());
		DepartmentEntity d = ResourceUtil.getSessionDepartment();
		n.setDepartid(d.getId());
		n.setDepartname(d.getName());
		UserEntity u = ResourceUtil.getSessionUserName();
		n.setEmployeeid(u.getEmployeeid());
		n.setName(u.getRealname());
		n.setNumber(u.getNumber());
		return n;
	}
	
	/**
	 * 得到总列数
	 * @return
	 */
	public static Integer getColumnTotal(){
		Integer total = 0;
		/*for(List l : WageAccountEntity.getAccountList().values()){
			total += l.size();
		}*/
		return total;
	}
	
	 
	
	/**
	 * 由数字转excel列
	 * @param number
	 * @return
	 */
	public static String getNumberToLetter(int number){
		if(number == 26){
			return "z";
		}else if(number == 0){
			return "";
		}else if(number % 26 == 0){
			return getNumberToLetter(number/26 - 1)+ "z";
		}else if(number / 26 > 0){
			return getNumberToLetter(number/26) + getNumberToLetter(number % 26);
		}else{
			return ""+(char)(number + 96);
		}
	}
	
	public static final boolean isChineseCharacter(String chineseStr) { 
		char[] charArray = chineseStr.toCharArray();  
		for (int i = 0; i < charArray.length; i++) {  
			 if ((charArray[i] >= 0x4e00) && (charArray[i] <= 0x9fbb)) {  
				 return true;
			 }
		}
		return false;
	}
}
