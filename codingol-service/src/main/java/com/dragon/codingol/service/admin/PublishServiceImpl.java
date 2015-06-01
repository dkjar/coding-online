package com.dragon.codingol.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.DateCommon;
import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.common.base.CommonHelper;
import com.dragon.codingol.common.freemarker.LocalConfiguration;
import com.dragon.codingol.domain.admin.ColumnsEntity;
import com.dragon.codingol.domain.admin.FieldsEntity;
import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.domain.admin.TableEntity;
import com.dragon.codingol.domain.admin.TablemapEntity;
import com.dragon.codingol.domain.common.ManyEntity;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.service.CommonServiceImpl;
import com.dragon.codingol.service.system.SystemService;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service("publishService")
@Transactional(rollbackFor = Exception.class)
public class PublishServiceImpl extends CommonServiceImpl implements PublishService {
	
	@Autowired
	private SystemService systemService;
	
	public List<ColumnsEntity> getColumnsEntitys(String tableName){
		SystemEntity system = systemService.getEnableSystemEntity();
		String sql  = "select column_name as columnName,data_type dataType,column_comment columnComment,numeric_precision numericPrecision,numeric_scale numericScale, " +
				" character_maximum_length characterMaximumLength,is_nullable isNullable " +
				" from information_schema.columns where table_name = ? and table_schema = ? ";
		
		return this.findListbySql(ColumnsEntity.class, sql, tableName, system.getDatabaseName());
	}
	
	/**
	 * 生成domain类
	 */
	public boolean publishModel(List<FieldsEntity> columns, TableEntity table) {
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		SystemEntity system = systemService.getEnableSystemEntity();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("packageName", system.getPackageName());
		parameters.put("projectName", system.getProjectName());
		parameters.put("parentMenu",  parent.getCodedir());
		parameters.put("description", table.getName());
		parameters.put("createTime", DateCommon.getCurrentDate());
		
		parameters.put("tableName", table.getTablename());
		parameters.put("entityName", table.getEntityname());
		parameters.put("keyPolicy", "uuid");
		parameters.put("tablePrimaryName", "id");
		parameters.put("sequenceCode", "id");
		
		parameters.put("columns", columns);
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getDomainPath(system)+ parent.getCodedir().replace(".", "\\") +"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getDomainFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+  CommonHelper.captureName(table.getEntityname())  +"Entity.java"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	/**
	 * 生成Service类
	 */
	public boolean publishService(TableEntity table) {
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("packageName", system.getPackageName());
		parameters.put("projectName", system.getProjectName());
		parameters.put("parentMenu", parent.getCodedir());
		parameters.put("description", table.getName());
		parameters.put("createTime", System.currentTimeMillis());
		
		parameters.put("entityName", table.getEntityname());
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getServicePath(system)+   parent.getCodedir().replace(".", "\\") +"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getServiceFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+CommonHelper.captureName(table.getEntityname())  +"Service.java"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}

	
	/**
	 * 生成ServiceImpl类
	 */
	public boolean publishServiceImpl(TableEntity table) {
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("packageName", system.getPackageName());
		parameters.put("projectName", system.getProjectName());
		parameters.put("parentMenu", parent.getCodedir());
		parameters.put("description", table.getName());
		parameters.put("createTime", System.currentTimeMillis());
		
		parameters.put("entityName", table.getEntityname());
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getServicePath(system)+ parent.getCodedir().replace(".", "\\") +"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getServiceImplFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+CommonHelper.captureName(table.getEntityname())  +"ServiceImpl.java"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}

	/**
	 * 生成Controller类
	 */
	public boolean publishController(TableEntity table, boolean haveSelect, boolean haveDic, boolean isTreeGrid) {
		
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("packageName", system.getPackageName());
		parameters.put("projectName", system.getProjectName());
		parameters.put("parentMenu", parent.getCodedir());
		parameters.put("description", table.getName());
		parameters.put("createTime", System.currentTimeMillis());
		
		parameters.put("entityName", table.getEntityname());
		parameters.put("haveSelect", haveSelect);
		parameters.put("haveDic", haveDic);
		parameters.put("isTreeGrid", isTreeGrid);
		
		List<TablemapEntity> maps = this.systemService.findByProperty(TablemapEntity.class, "tableid", table.getId());
		List<ManyEntity> manys = new ArrayList<ManyEntity>(); //多对多
		List<ManyEntity> ones = new ArrayList<ManyEntity>(); //一对多
		if(maps!=null && maps.size() > 0){
			for(TablemapEntity m : maps){
				if(m.getMaptype()!=null && m.getMaptype().intValue() == 3){
					ManyEntity many = new ManyEntity();
					TableEntity middle = systemService.get(TableEntity.class, m.getMiddleid());
					TableEntity other = systemService.get(TableEntity.class, m.getMapid());
					many.setMiddle(middle); //中间表
					many.setTable(other); //多对多表
					List<FieldsEntity>  columns = this.systemService.findByProperty(FieldsEntity.class, "tableid", middle.getId());
					for(FieldsEntity c : columns){
						if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
							many.setFcolumn(c); //外键列
						}else if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(other.getTablename())){
							many.setOcolumn(c); //外键列
						}
					}
					
					this.publishPageManyEntity(table, middle, other);
					this.publishPageSelectEntity(table, middle, other);
					manys.add(many);
				}else if(m.getMaptype()!=null && m.getMaptype().intValue() == 1){
					ManyEntity many = new ManyEntity();
					TableEntity other = systemService.get(TableEntity.class, m.getMapid());
					
					many.setTable(other); //一对多表
					
					List<FieldsEntity>  columns = this.systemService.findByProperty(FieldsEntity.class, "tableid", other.getId());
					for(FieldsEntity c : columns){
						if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
							many.setFcolumn(c); //外键列
						}
					}
					this.publishPageOneList(columns, other);
					ones.add(many);
				}
			}
		}
		parameters.put("manys", manys);
		parameters.put("ones", ones);
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getControllerPath(system)+   parent.getCodedir().replace(".", "\\") +"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getControllerFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+CommonHelper.captureName(table.getEntityname())  +"Controller.java"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}

	/**
	 * 生成PageList页面
	 */
	public boolean publishPageList(List<FieldsEntity> columns, TableEntity table, TableEntity selecttable) {
		
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("entityName", table.getEntityname());
		parameters.put("singleselect", table.getSingleselect());
		
		parameters.put("columns", columns);
		
		if(selecttable!=null){
			parameters.put("selecttable", selecttable); //列表中文字连接
		}
		FieldsEntity parentColumn = null;
		for(FieldsEntity f: columns){
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				parameters.put("treeField", f.getColumncode());
			}
			if(!StringUtils.isEmpty(f.getTablecode()) && f.getTablecode().equals(table.getTablename())){
				parentColumn = f;
			}
		}
		parameters.put("parentColumn", parentColumn);
		
		List<TablemapEntity> maps = this.systemService.findByProperty(TablemapEntity.class, "tableid", table.getId());
		List<ManyEntity> manys = new ArrayList<ManyEntity>();
		List<ManyEntity> ones = new ArrayList<ManyEntity>(); //一对多
		if(maps!=null && maps.size() > 0){
			for(TablemapEntity m : maps){
				if(m.getMaptype()!=null && m.getMaptype().intValue() == 3){
					ManyEntity many = new ManyEntity();
					TableEntity middle = systemService.get(TableEntity.class, m.getMiddleid());
					TableEntity other = systemService.get(TableEntity.class, m.getMapid());
					many.setTable(other);//多对多表
					List<FieldsEntity>  mcolumns = this.systemService.findByProperty(FieldsEntity.class, "tableid", middle.getId());
					for(FieldsEntity c : mcolumns){
						if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
							many.setFcolumn(c); //外键列
							break;
						} 
					}
					manys.add(many);
				}else if(m.getMaptype()!=null && m.getMaptype().intValue() == 1){
					ManyEntity many = new ManyEntity();
					TableEntity other = systemService.get(TableEntity.class, m.getMapid());
					
					many.setTable(other); //一对多表
					
					List<FieldsEntity>  ocolumns = this.systemService.findByProperty(FieldsEntity.class, "tableid", other.getId());
					for(FieldsEntity c : ocolumns){
						if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
							many.setFcolumn(c); //外键列
						}
					}
					 
					ones.add(many);
				}
			}
		}
		parameters.put("manys", manys);
		parameters.put("ones", ones);
		
		 
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageListPath(system)+  parent.getCodedir().replace(".", "\\") +"\\" +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPageListFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+ "index.jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	/**
	 * 生成PageTable页面
	 */
	public boolean publishPageForm(List<FieldsEntity> columns, TableEntity table, TableEntity selecttable) {
		
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("description", table.getName());
		parameters.put("entityName", table.getEntityname());
		parameters.put("tableName", table.getTablename());
		parameters.put("colcount", table.getColcount()!=null?table.getColcount():1);
		
		List<FieldsEntity> hiddens = new ArrayList<FieldsEntity>();
		List<FieldsEntity> views = new ArrayList<FieldsEntity>();
		FieldsEntity treeField = null;
		FieldsEntity parentColumn = null;
		
		for(FieldsEntity f: columns){
			if(f.getVisiable()!=null && f.getVisiable() == 2){
				hiddens.add(f);
			}else if(f.getVisiable()!=null && f.getVisiable() == 1 ){
				if(!(!StringUtils.isEmpty(f.getTablecode()) && f.getTablecode().equals(table.getTablename()))){
					views.add(f);
				}
			}
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				treeField = f;
			}
			if(!StringUtils.isEmpty(f.getTablecode()) && f.getTablecode().equals(table.getTablename())){
				parentColumn = f;
			}
		}
		
		parameters.put("parentColumn", parentColumn);
		
		parameters.put("hiddens", hiddens);
		parameters.put("views", views);
		parameters.put("count", views.size());
		if(selecttable!=null){
			parameters.put("selecttable", selecttable);
		}
		parameters.put("treeField", treeField);
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageTablePath(system)  +  parent.getCodedir().replace(".", "\\") +"\\"  +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPageFormFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+  "edit.jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	
	/**
	 * 生成ViewPage页面
	 */
	public boolean publishPageView(List<FieldsEntity> columns, TableEntity table) {
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("description", table.getName());
		parameters.put("entityName", table.getEntityname());

		parameters.put("colcount", table.getColcount()!=null?table.getColcount():1);
		
		List<FieldsEntity> hiddens = new ArrayList<FieldsEntity>();
		List<FieldsEntity> views = new ArrayList<FieldsEntity>();
		
		FieldsEntity treeField = null;
		for(FieldsEntity f: columns){
			if(f.getVisiable()!=null && f.getVisiable() == 0){
				hiddens.add(f);
			}else if(f.getVisiable()!=null && f.getVisiable() == 1){
				views.add(f);
			}
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				treeField = f;
			}
		}
		parameters.put("hiddens", hiddens);
		parameters.put("views", views);
		parameters.put("count", views.size());
		parameters.put("treeField", treeField);
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageTablePath(system)  +  parent.getCodedir().replace(".", "\\") +"\\"  +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPageViewFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+  "view.jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	
	public boolean publishPageSelect(List<FieldsEntity> columns, TableEntity table){

		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("entityName", table.getEntityname());
		
		parameters.put("columns", columns);
		for(FieldsEntity f: columns){
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				parameters.put("treeField", f.getColumncode());
				break;
			}
		}
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageListPath(system)+  parent.getCodedir().replace(".", "\\") +"\\" +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPageSelectFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+ "select.jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	//多对多页面
	public boolean publishPageSelectEntity(TableEntity table, TableEntity middle, TableEntity other){

		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("entityName", table.getEntityname());
		
		String fileName = "";
		fileName = other.getEntityname();
		parameters.put("table", other);//多对多表
		
		parameters.put("singleselect", 0);
		List<FieldsEntity>  columns = this.systemService.findByProperty(FieldsEntity.class, "tableid", other.getId());
		parameters.put("columns", columns);
		for(FieldsEntity f: columns){
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				parameters.put("treeField", f.getColumncode());
				break;
			}
		}
		
		
		List<FieldsEntity>  mcolumns = this.systemService.findByProperty(FieldsEntity.class, "tableid", middle.getId());
		for(FieldsEntity c : mcolumns){
			if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
				parameters.put("fcolumn", c); //外键列
				break;
			} 
		}
		
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageListPath(system)+  parent.getCodedir().replace(".", "\\") +"\\" +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPagSelectEntityFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+ "select"+fileName+".jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	
	public boolean publishPageManyEntity(TableEntity table, TableEntity middle, TableEntity other){

		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("entityName", table.getEntityname());
		
		String fileName = "";
		parameters.put("table", other);//多对多表
		fileName = table.getEntityname() + other.getEntityname();
		
		parameters.put("singleselect", 0);
		List<FieldsEntity>  columns = this.systemService.findByProperty(FieldsEntity.class, "tableid", other.getId());
		parameters.put("columns", columns);
		for(FieldsEntity f: columns){
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				parameters.put("treeField", f.getColumncode());
				break;
			}
		}
		
		List<FieldsEntity>  mcolumns = this.systemService.findByProperty(FieldsEntity.class, "tableid", middle.getId());
		for(FieldsEntity c : mcolumns){
			if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
				parameters.put("fcolumn", c); //外键列
				break;
			} 
		}
		
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageListPath(system)+  parent.getCodedir().replace(".", "\\") +"\\" +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPageManyEntityFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+ fileName+ ".jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	
	
	//一对多页面
	public boolean publishPageOneList(List<FieldsEntity> columns, TableEntity table) {
		
		SystemEntity system = systemService.getEnableSystemEntity();
		TableEntity parent = systemService.get(TableEntity.class, table.getPid());
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("entityName", table.getEntityname());
		parameters.put("singleselect", table.getSingleselect());
		
		parameters.put("columns", columns);
		
		for(FieldsEntity f: columns){
			if(f.getIstreefield()!=null && f.getIstreefield().intValue() == 1){
				parameters.put("treeField", f.getColumncode());
			}
			if(f.getInputtype().intValue() == 1 && !StringUtils.isEmpty(f.getTablecode())){
				parameters.put("fcolumn", f);
			}
		}
		
		List<TablemapEntity> maps = this.systemService.findByProperty(TablemapEntity.class, "tableid", table.getId());
		List<ManyEntity> manys = new ArrayList<ManyEntity>();
		if(maps!=null && maps.size() > 0){
			for(TablemapEntity m : maps){
				if(m.getMaptype()!=null && m.getMaptype().intValue() == 3){
					ManyEntity many = new ManyEntity();
					TableEntity middle = systemService.get(TableEntity.class, m.getMiddleid());
					TableEntity other = systemService.get(TableEntity.class, m.getMapid());
					many.setTable(other);//多对多表
					List<FieldsEntity>  mcolumns = this.systemService.findByProperty(FieldsEntity.class, "tableid", middle.getId());
					for(FieldsEntity c : mcolumns){
						if(!StringUtils.isEmpty(c.getTablecode()) && c.getTablecode().equals(table.getTablename())){
							many.setFcolumn(c); //外键列
							break;
						} 
					}
					manys.add(many);
				}
			}
		}
		parameters.put("manys", manys);
		 
		LocalConfiguration local = LocalConfiguration.getInstance();
		Template localTemplate;
		OutputStreamWriter localOutputStreamWriter = null;
		try {
			String filePath = SystemConfig.getPageListPath(system)+  parent.getCodedir().replace(".", "\\") +"\\" +table.getEntityname()+"\\";
			
			localTemplate = local.getConfiguration().getTemplate(SystemConfig.getPageOneListFileName());
			
			FileUtils.forceMkdir(new File(filePath));
			localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath+ table.getEntityname()+".jsp"), "utf-8");
			localTemplate.process(parameters, localOutputStreamWriter);
			
		} catch (  IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			try {
				if(localOutputStreamWriter !=null)
					localOutputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return true;
	}
	
	
	 
}
