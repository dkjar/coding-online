package com.dragon.codingol.common.base;

 

public class Globals {

	/**
	 * 
	 */
	public static String ADD_FAILURE = "添加失败!";
	public static String ADD_SUCCESS = "添加成功!";
	public static String DELETE_SUCCESS = "删除成功!";
	public static String DELETE_SELECT = "请选择删除数据!";
	/**
	 * 保存用户到SESSION
	 */
	public static String USER_SESSION="USER_SESSION";
	public static String SYS_APP = "SYS_APP_";
	public static int TOTAL_MODEL = 50;
	
	public static String columnName = "uextend";
	public static String userColumnSign = "u";
	/**
	 * 人员类型
	 */
	public static Short User_Normal=1;//正常
	public static Short User_Forbidden=0;//禁用
	public static Short User_ADMIN=-1;//超级管理员
	/**
	 *日志级别定义
	 */
	public static Short Log_Leavel_INFO=1;
	public static Short Log_Leavel_WARRING=2;
	public static Short Log_Leavel_ERROR=3;
	 /**
	  * 日志类型
	  */
	 public static Short Log_Type_LOGIN=1; //登陆
	 public static Short Log_Type_EXIT=2;  //退出
	 public static Short Log_Type_INSERT=3; //插入
	 public static Short Log_Type_DEL=4; //删除
	 public static Short Log_Type_UPDATE=5; //更新
	 public static Short Log_Type_UPLOAD=6; //上传
	 public static Short Log_Type_OTHER=7; //其他
	 
	 
 
}
