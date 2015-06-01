package com.dragon.codingol.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.DateCommon;
import com.dragon.codingol.domain.admin.ColumnsEntity;
import com.dragon.codingol.domain.admin.FieldsEntity;
import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.domain.admin.TableEntity;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.service.CommonServiceImpl;
import com.dragon.codingol.service.system.SystemService;

@Service("tableService")
@Transactional(rollbackFor=Exception.class)
public class TableServiceImpl extends CommonServiceImpl implements TableService {
	@Autowired
	private SystemService systemService;
	
	
	//生成功能按钮
	public boolean publishFunctionButton(TableEntity table) throws Exception{
		
		FunctionEntity function = this.systemService.findUniqueByProperty(FunctionEntity.class, "tableid", table.getId());
		if(function != null){
			List<FunctionbuttonEntity> buttons = this.systemService.findByProperty(FunctionbuttonEntity.class, "functionid", function.getId());
			List<String> names = new ArrayList<String>();
			for(FunctionbuttonEntity f : buttons){
				names.add(f.getName());
			}
			FunctionbuttonEntity button = new FunctionbuttonEntity();
			button.setFunctionid(function.getId());
			button.setSide(1);
			button.setState(1);
			if(!names.contains("查询")){
				button.setName("查询");
				button.setAction("method:'query'");
				button.setIconid("3");
				button.setIconname("添加");
				button.setIconcode("icon-search");
				this.systemService.save(button);
			}
			
			if(!names.contains("添加")){
				button.setName("添加");
				button.setAction("method:'add'");
				button.setIconid("1");
				button.setIconname("添加");
				button.setIconcode("icon-add");
				this.systemService.save(button);
			}
			
			if(!names.contains("修改")){
				button.setName("修改");
				button.setAction("method:'edit'");
				button.setIconid("2");
				button.setIconname("修改");
				button.setIconcode("icon-edit");
				this.systemService.save(button);
			}
			
			
			if(!names.contains("查看")){
				button.setName("查看");
				button.setAction("method:'view'");
				button.setIconid("7");
				button.setIconname("查看");
				button.setIconcode("icon-view");
				this.systemService.save(button);
			}
			
			
			if(!names.contains("删除")){
				button.setName("删除");
				button.setAction("method:'delete'");
				button.setIconid("4");
				button.setIconname("删除");
				button.setIconcode("icon-delete");
				this.systemService.save(button);
			}
			
		}
		return true;
	}
	
	private void aysncFunction(TableEntity t) throws Exception{
		
		if(t.getIsfunsync() == 1){
			FunctionEntity function = null;
			if(!StringUtils.isEmpty(t.getId())){
				function = this.systemService.findUniqueByProperty(FunctionEntity.class, "tableid", t.getId());
			}
			if(function == null){
				function = new FunctionEntity();
			}
			
			if(!StringUtils.isEmpty(t.getPid())){
				TableEntity table = this.systemService.get(TableEntity.class, t.getPid());
				FunctionEntity parent = this.systemService.findUniqueByProperty(FunctionEntity.class, "tableid", table.getId());
				if(parent!=null){
					function.setPid(parent.getId());
				}
			}
			
			function.setName(t.getName());
			function.setState(t.getState());
			function.setOrder(t.getTableorder());
			function.setTableid(t.getId());
			function.setFunctionurl("../"+t.getEntityname()+"Controller/index.htm");
			this.systemService.saveOrUpdate(function);
		}else{
			if(!StringUtils.isEmpty(t.getId())){
				FunctionEntity function = this.systemService.findUniqueByProperty(FunctionEntity.class, "tableid", t.getId());
				if(function!=null){
					this.systemService.delete(function);
				}
			}
		}
	}
	
	 
	public void initcolumn(String ids) throws Exception{
		List<TableEntity> tables = this.getEntitys(TableEntity.class, ids);
		SystemEntity system = systemService.getEnableSystemEntity();
		for(TableEntity t : tables){
			
			//同步function
			this.aysncFunction(t);
			
			//同步function button
			this.publishFunctionButton(t);
			
			String sql  = "select column_name as columnName,data_type dataType,column_comment columnComment,numeric_precision numericPrecision,numeric_scale numericScale, " +
					" character_maximum_length characterMaximumLength,is_nullable isNullable, p.id as typeid " +
					" from information_schema.columns c " +
					" inner join sys_fields_type p on c.data_type = p.code where table_name = ? and table_schema = ? ";
			
			List<ColumnsEntity> databaseColumns = this.findListbySql(ColumnsEntity.class, sql, t.getTablename(), system.getDatabaseName());
			List<FieldsEntity> settingfields =  this.findByProperty(FieldsEntity.class, "tableid", t.getId());
			
			if(databaseColumns == null || databaseColumns.size() == 0){
				StringBuilder create = new StringBuilder("create table `");
				create.append(t.getTablename());
				create.append("` ( ");
				
				for(FieldsEntity f : settingfields){
					create.append("`");
					create.append(f.getColumncode());
					create.append("` ");
					
					create.append(f.getDatatype());
					if(f.getDatatypeid().equals("1")){
						create.append("(");
						create.append(f.getColumnlength());
						create.append(") ");
					}else if(f.getDatatype().equals("2")){
						create.append("(11) ");
					}
					
					if(f.getIsnullable()!=null && f.getIsnullable().intValue() == 0){
						create.append(" NOT NULL ");
					}else{
						if(!StringUtils.isEmpty(f.getDefaultvalue())){
							create.append(" DEFAULT '");
							create.append(f.getDefaultvalue());
							create.append("' ");
						}else {
							create.append(" DEFAULT NULL ");
						}
					}
					
					if(StringUtils.isEmpty(f.getColumnname())){
						create.append(" COMMENT '");
						create.append(f.getColumncode());
						create.append("',");
					}else{
						create.append(" COMMENT '");
						create.append(f.getColumnname());
						create.append("',");
					}
				}
				
				create.append("PRIMARY KEY (`id`) )  ENGINE=InnoDB DEFAULT CHARSET=utf8;");
				
				this.genericCommonDao.executeSql(create.toString(), null);
				continue;
			}
			
			int i = 1;
			for(ColumnsEntity c : databaseColumns){
				boolean exists = false;
				for(int index =0; index< settingfields.size(); index++){
					FieldsEntity f = settingfields.get(index);
					if(f.getColumncode().equals(c.getColumnName())){
						f.setColumnname(c.getColumnComment());
						f.setColumnlength(c.getCharacterMaximumLength());
						f.setDatatypeid(c.getTypeid());
						f.setDatatype(c.getDataType());
						f.setScale(c.getNumericScale()!=null?c.getNumericScale().intValue():null);
						f.setIsnullable(c.getIsNullable().equals("Y")?1:0);
						f.setOrder(i);
						i++;
						this.saveOrUpdate(f);
						settingfields.remove(index);
						exists = true;
						break;
					}
				}
				if(exists)
					continue;
				
				FieldsEntity f = new FieldsEntity();
				f.setId(UUID.randomUUID().toString());
				f.setTableid(t.getId());
				f.setColumnname(c.getColumnComment());
				f.setColumncode(c.getColumnName());
				f.setDatatypeid(c.getTypeid());
				f.setDatatype(c.getDataType());
				f.setColumnlength(c.getCharacterMaximumLength());
				f.setScale(c.getNumericScale()!=null?c.getNumericScale().intValue():null);
				f.setIsnullable(c.getIsNullable().equals("Y")?1:0);
				
				f.setIslist(c.getColumnName().equals("id")?2:1); 
				f.setIsquery(0);
				f.setIstreefield(0);
				f.setInputtype(1);
				f.setIsunique(c.getColumnName().equals("id")?1:0);
				f.setVisiable(1);
				f.setStatus(1);
				f.setCreatedate(DateCommon.currentDate());
				
				f.setOrder(i);
				i++;
				try {
					this.save(f);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			 
			this.genericCommonDao.deleteAllEntitie(settingfields);
			 
		}
	}
}