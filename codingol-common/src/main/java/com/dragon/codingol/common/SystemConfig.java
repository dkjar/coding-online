package com.dragon.codingol.common;

import java.util.ResourceBundle;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.domain.admin.SystemEntity;

public class SystemConfig {
	private static final ResourceBundle config = ResourceBundle.getBundle("config");
	
	private static final String basePath = "src\\main\\java";
	private static final String baseWebPath = "src\\main\\webapp\\templates";
	private static final String baseCssPath = "src\\main\\webapp\\resources\\easyui\\themes";
	
	private static final String domainPath = "domain";
	private static final String domainFileName = "entityTemplate.ftl";
	
	private static final String serviceFileName = "serviceTemplate.ftl";
	private static final String servicePath = "service";
	
	private static final String controllerFileName = "controllerTemplate.ftl";
	private static final String controllerPath = "web";
	
	private static final String pageListFileName = "pageListTemplate.ftl";
	private static final String pageListPath = "web";
	
	private static final String pageFormFileName = "pageFormTemplate.ftl";
	private static final String pageViewFileName = "pageViewTemplate.ftl";
	private static final String pageSelectFileName = "pageSelectTemplate.ftl";
	private static final String pageTablePath = "web";
	
	private static final String uploadPath = "/temp";
	private static final String dataStatus = "status"; //数据删除状态字段
	
	
	public static String getConfigByName(String key){
		return config.getString(key);
	}
	
	/**
	 * 获取domain模板文件名称
	 * @return
	 */
	public static final String getDomainFileName(){
		return config.containsKey("domain-file-name") ? config.getString("domain-file-name"):domainFileName;
	}
	/**
	 * 获取实体路径
	 * @return
	 */
	public static final String getDomainPath(SystemEntity system){
		String domain = config.containsKey("domain-name") ? config.getString("domain-name"):null;
		 
		if(StringUtils.isEmpty(domain)){
			domain = domainPath;
		}
		StringBuffer path = new StringBuffer();
		path.append(system.getPath());
		path.append("\\");
		path.append(system.getProjectName());
		path.append("-");
		path.append(domain);
		path.append("\\");
		path.append(basePath);
		path.append("\\");
		path.append(system.getPackageName().replace(".", "\\"));
		path.append("\\");
		path.append(system.getProjectName());
		path.append("\\");
		path.append(domain);
		path.append("\\");
		return path.toString();
	}

	/**
	 * 获取service模板文件名称
	 * @return
	 */
	public static final String getServiceFileName(){
		return config.containsKey("service-file-name") ? config.getString("service-file-name"):serviceFileName;
	}
	
	/**
	 * 获取service模板文件名称
	 * @return
	 */
	public static final String getServiceImplFileName(){
		return config.containsKey("serviceimpl-file-name") ? config.getString("serviceimpl-file-name"):serviceFileName;
	}
	
	/**
	 * 获取service路径
	 * @return
	 */
	public static final String getServicePath(SystemEntity system){
		String service = config.containsKey("service-name") ? config.getString("service-name"):null;
		 
		if(StringUtils.isEmpty(service)){
			service = servicePath;
		}
		StringBuffer path = new StringBuffer();
		path.append(system.getPath());
		path.append("\\");
		path.append(system.getProjectName());
		path.append("-");
		path.append(service);
		path.append("\\");
		path.append(basePath);
		path.append("\\");
		path.append(system.getPackageName().replace(".", "\\"));
		path.append("\\");
		path.append(system.getProjectName());
		path.append("\\");
		path.append(service);
		path.append("\\");
		return path.toString();
	}
	
	/**
	 * 获取controller模板文件名称
	 * @return
	 */
	public static final String getControllerFileName(){
		return config.containsKey("controller-file-name") ? config.getString("controller-file-name"): controllerFileName;
	}
	
	/**
	 * 获取controller路径
	 * @return
	 */
	public static final String getControllerPath(SystemEntity system){
		String controller = config.containsKey("controller-name") ? config.getString("controller-name"):null;
		 
		if(StringUtils.isEmpty(controller)){
			controller = controllerPath;
		}
		StringBuffer path = new StringBuffer();
		path.append(system.getPath());
		path.append("\\");
		path.append(system.getProjectName());
		path.append("-");
		path.append(controller);
		path.append("\\");
		path.append(basePath);
		path.append("\\");
		path.append(system.getPackageName().replace(".", "\\"));
		path.append("\\");
		path.append(system.getProjectName());
		path.append("\\");
		path.append(controller);
		path.append("\\controller\\");
		return path.toString();
	}
	
	
	/**
	 * 获取pagelist模板文件名称
	 * @return
	 */
	public static final String getPageListFileName(){
		return config.containsKey("pagelist-file-name") ? config.getString("pagelist-file-name"): pageListFileName;
	}
	
	/**
	 * 获取pagelist路径
	 * @return
	 */
	public static final String getPageListPath(SystemEntity system){
		String pagelist = config.containsKey("pagelist-name") ? config.getString("pagelist-name"):null;
		 
		if(StringUtils.isEmpty(pagelist)){
			pagelist = pageListPath;
		}
		StringBuffer path = new StringBuffer();
		path.append(system.getPath());
		path.append("\\");
		path.append(system.getProjectName());
		path.append("-");
		path.append(pagelist);
		path.append("\\");
		path.append(baseWebPath);
		path.append("\\");
		return path.toString();
	}
	
	
	/**
	 * 获取pagetable模板文件名称
	 * @return
	 */
	public static final String getPageFormFileName(){
		return config.containsKey("pageform-file-name") ? config.getString("pageform-file-name"): pageFormFileName;
	}
	
	/**
	 * 获取pageview模板文件名称
	 * @return
	 */
	public static final String getPageViewFileName(){
		return config.containsKey("pageview-file-name") ? config.getString("pageview-file-name"): pageViewFileName;
	}
	
	/**
	 * 获取pageselect模板文件名称
	 * @return
	 */
	public static final String getPageSelectFileName(){
		return config.containsKey("pageselect-file-name") ? config.getString("pageselect-file-name"): pageSelectFileName;
	}
	
	/**
	 * 获取pagetable路径
	 * @return
	 */
	public static final String getPageTablePath(SystemEntity system){
		String pagetable = config.containsKey("pagetable-name") ? config.getString("pagetable-name"):null;
		 
		if(StringUtils.isEmpty(pagetable)){
			pagetable = pageTablePath;
		}
		StringBuffer path = new StringBuffer();
		path.append(system.getPath());
		path.append("\\");
		path.append(system.getProjectName());
		path.append("-");
		path.append(pagetable);
		path.append("\\");
		path.append(baseWebPath);
		path.append("\\");
		return path.toString();
	}
	
	/**
	 * 获取icons css路径
	 * @param system
	 * @return
	 */
	public static final String getIconCssPath(SystemEntity system){
		String pagetable = config.containsKey("pagetable-name") ? config.getString("pagetable-name"):null;
		 
		if(StringUtils.isEmpty(pagetable)){
			pagetable = pageTablePath;
		}
		StringBuffer path = new StringBuffer();
		path.append(system.getPath());
		path.append("\\");
		path.append(system.getProjectName());
		path.append("-");
		path.append(pagetable);
		path.append("\\");
		path.append(baseCssPath);
		path.append("\\");
		return path.toString();
	}
	/**
	 * icon文件名
	 * @return
	 */
	public static final String getIconCssFileName(){
		return config.containsKey("icon-file-name") ? config.getString("icon-file-name"): "icon.css";
	}
	
	
	public static String getDatastatus() {
		return config.containsKey("data-status") ? config.getString("data-status"): dataStatus;
	}
	
	
	public static final String getPageManyEntityFileName(){
		return "many2many\\pageManyEntityTemplate.ftl";
	}
	
	
	public static final String getPagSelectEntityFileName(){
		return "many2many\\pageSelectEntityTemplate.ftl";
	}
	
	public static final String getPageOneListFileName(){
		return "one2many\\pageOneListTemplate.ftl";
	}
	 
	
	/**
	 * 文件上传目录
	 * @return
	 */
	public static final String getFileUploadTemp(){
		return  config.containsKey("upload-temp") ? config.getString("upload-temp"): uploadPath;
	}
}
