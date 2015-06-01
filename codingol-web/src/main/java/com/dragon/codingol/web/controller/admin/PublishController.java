package com.dragon.codingol.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.common.base.CommonHelper;
import com.dragon.codingol.domain.admin.FieldsEntity;
import com.dragon.codingol.domain.admin.TableEntity;
import com.dragon.codingol.service.admin.FieldsService;
import com.dragon.codingol.service.admin.PublishService;
import com.dragon.codingol.service.admin.TableService;
import com.dragon.codingol.web.common.JsonCommon;


@Controller("publishController")
@RequestMapping("/publishController")
public class PublishController {
	
	@Autowired
	private PublishService publishService;
	@Autowired
	private TableService tableService;
	@Autowired
	private FieldsService fieldsService;
	@Autowired
	private JsonCommon jsonCommon;
	
	@RequestMapping("/index")
	public String index(Model model){
		 
		return "admin/table/index.jsp";
	}
	
	
	@RequestMapping("/publish")
	public void publish(HttpServletRequest request, HttpServletResponse response){
		ResultJson r = new ResultJson();
		String ids = request.getParameter("id");
		if(StringUtils.isEmpty(ids)){
			r.setFailure("发布操作失败！请选择要发布的数据");
		}else{
			List<TableEntity> tables =  tableService.getEntitys(TableEntity.class, ids);
			try{
				for(TableEntity f : tables){
					
					if(f.getTablename().equals("sys_table")){
						continue;
					}
					
					List<FieldsEntity>  columns = this.fieldsService.findByProperty(FieldsEntity.class, "tableid", f.getId());
					List<FieldsEntity>  selectcols = this.fieldsService.findByProperty(FieldsEntity.class, "tablecode", f.getTablename());
					
					boolean haveDic = false; //列表中是否含有字典列
					String selectTable = ""; //列表中是否是其它表的外键
					boolean isTreeGrid = false;
					for(FieldsEntity field : columns){
						//下拉框
						field.setDatatype(CommonHelper.mysqlTypeConvert(field.getDatatype(), field.getStatus()));
						if(field.getInputtype()!=null && field.getInputtype().intValue()==2
								&& field.getIslist() !=null && field.getIslist().intValue() == 1){
							haveDic = true;
						}
						//弹出框选择输入。
						if(field.getInputtype()!=null && field.getInputtype().intValue()==3 && !StringUtils.isEmpty(field.getTablecode())){
							selectTable = field.getTablecode();
						}
						//树形列
						if(field.getIstreefield()!=null && field.getIstreefield().intValue() == 1){
							isTreeGrid = true;
						}
					}
					
					TableEntity table  =  tableService.findUniqueByProperty(TableEntity.class, "tablename", selectTable);
					
					boolean haveSelect  = false;//该表添加选择页面，供其它页面选择。
					if(selectcols != null){
						for(FieldsEntity c : selectcols){
							if(c.getInputtype()!=null && c.getInputtype().intValue() == 3){
								haveSelect = true;
								break;
							}
						}
					}
					
					if(f.getStatus().intValue() == 1){
						publishService.publishModel(columns, f);
						
						publishService.publishService(f);
						
						publishService.publishServiceImpl(f);
						
						publishService.publishController(f, haveSelect, haveDic, isTreeGrid);
						
						publishService.publishPageList(columns, f, table);
						
						publishService.publishPageForm(columns, f, table);
						
						publishService.publishPageView(columns, f);
						 
						if(haveSelect){
							publishService.publishPageSelect(columns, f);
						}
						 
						
					}else if(f.getStatus().intValue() == 2){
						publishService.publishModel(columns, f);
					}
				}
			}catch(Exception e){
				r.setFailure("发布操作失败！"+e.getMessage());
			}
			
		}
		
		jsonCommon.jsonReturn(r, response);
	}
}
