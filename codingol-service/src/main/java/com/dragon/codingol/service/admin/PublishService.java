package com.dragon.codingol.service.admin;

import java.util.List;

import com.dragon.codingol.domain.admin.ColumnsEntity;
import com.dragon.codingol.domain.admin.FieldsEntity;
import com.dragon.codingol.domain.admin.TableEntity;
import com.dragon.codingol.service.CommonService;

public interface PublishService  extends CommonService{
	
	public List<ColumnsEntity> getColumnsEntitys(String tableName);
	
	public boolean publishModel(List<FieldsEntity>  columns, TableEntity table);
	
	public boolean publishService(TableEntity table);
	
	public boolean publishServiceImpl(TableEntity table) ;
	
	public boolean publishController(TableEntity table, boolean haveSelect, boolean haveDic, boolean isTreeGrid);
	
	public boolean publishPageList(List<FieldsEntity> columns, TableEntity table, TableEntity selecttable);
	
	public boolean publishPageForm(List<FieldsEntity> columns, TableEntity table, TableEntity selecttable);
	
	public boolean publishPageView(List<FieldsEntity> columns, TableEntity table);
	
	public boolean publishPageSelect(List<FieldsEntity> columns, TableEntity table);
	
	//多对多页面
	public boolean publishPageSelectEntity(TableEntity table, TableEntity middle, TableEntity other);
	
	public boolean publishPageManyEntity(TableEntity table, TableEntity middle, TableEntity other);
	
	//一对多页面
	public boolean publishPageOneList(List<FieldsEntity> columns, TableEntity table);
	 
}
