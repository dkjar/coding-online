package com.dragon.codingol.common.excel;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.DateCommon;
import com.dragon.codingol.common.base.CommonHelper;
import com.dragon.codingol.domain.admin.WageAccountEntity;
import com.dragon.codingol.domain.admin.WageExcelEntity;
import com.dragon.codingol.domain.base.Valiform;
 
public class ExcelExportUtil {
	
	/**
	 * 导出模板
	 * @param title
	 * @param pojoClass
	 * @param out
	 */
	public static void exportExcel(String title, Class<?> pojoClass, OutputStream out) {
		// 使用userModel模式实现的，当excel文档出现10万级别的大数据文件可能导致OOM内存溢出
		exportExcelInUserModel(title, pojoClass, null, out);
		// 使用eventModel实现，可以一边读一边处理，效率较高，但是实现复杂，暂时未实现
	}
	
	/**
	 * 
	 * @param title     Sheet名字
	 * @param pojoClass Excel对象Class
	 * @param dataSet   Excel对象数据List
	 * @param out       输出流
	 */
	public static void exportExcel(String title, Class<?> pojoClass,
			Collection<?> dataSet, OutputStream out) {
		// 使用userModel模式实现的，当excel文档出现10万级别的大数据文件可能导致OOM内存溢出
		exportExcelInUserModel(title, pojoClass, dataSet, out);
		// 使用eventModel实现，可以一边读一边处理，效率较高，但是实现复杂，暂时未实现
	}

	private static void exportExcelInUserModel(String title, Class<?> pojoClass, Collection<?> dataSet, OutputStream out) {
		try {
			if (title == null || out == null || pojoClass == null) {
				throw new Exception("传入参数不能为空！");
			}
			//excel 列名
			Map<String, WageAccountEntity> exportFieldTitle = new LinkedHashMap<String, WageAccountEntity>();
			String key = pojoClass.getSimpleName();
			Integer titlerow = 1; //标题行数
			Map<String, String> formlua = new HashMap<String, String>();
			List<WageAccountEntity> accountList = null;
			if(key.equals("SalaryEntity")){
				accountList = new ArrayList<WageAccountEntity>();
				//accountList.addAll(WageAccountEntity.getSalaryList().values());
			}else{
				WageExcelEntity w =  null;//WageExcelEntity.getExcelList().get(key);
				titlerow = w.getTitlerow();
				accountList =  null;//WageAccountEntity.getAccountList().get(w.getId());
			}
			for(WageAccountEntity a : accountList){
				if(a.getIssystem() != 0 ){
					continue;
				}
				if(StringUtils.isEmpty(a.getAlias())){
					a.setAlias(a.getName());
				}
				if(StringUtils.isEmpty(a.getAlias())){
					a.setAlias(a.getCode());
				} 
				exportFieldTitle.put(a.getCode(), a);
				if(!StringUtils.isEmpty(a.getFormula()) && !key.equals("SalaryBaseEntity")){
					formlua.put(a.getCode(), a.getFormula());
				}
			}
			Field filed[] = pojoClass.getDeclaredFields();
			if(dataSet != null && dataSet.size() >0){
				Iterator its = dataSet.iterator();
				if(its.hasNext()){
					Object t = its.next();
					filed = t.getClass().getDeclaredFields();
				}
			}
			List<String> importNotNullFieldTitle = new ArrayList<String>();
			List<String> importDateFieldTitle = new ArrayList<String>();
			List<String> importMontFiheldTitle = new ArrayList<String>();
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				Valiform vali = f.getAnnotation(Valiform.class);
				if (vali != null) {
					if (vali.notNull() || vali.importNotNull()) {
						importNotNullFieldTitle.add(f.getName());
					}
					if(vali.isDate()){
						importDateFieldTitle.add(f.getName());
					}
					if(vali.isUnmonth()){
						importMontFiheldTitle.add(f.getName());
					}
				}
			}
			// 声明一个工作薄
			Workbook workbook = new HSSFWorkbook();
			// 生成一个表格
			Sheet sheet = workbook.createSheet(title);
			
			// 标题
			int index = 0;
			Row row = sheet.createRow(index);
			// 产生表格标题行
			int  i  = 0;
			if(titlerow==1){
				for (String k : exportFieldTitle.keySet()) {
					Cell cell = row.createCell(i);
					String t =exportFieldTitle.get(k).getAlias();
					RichTextString text = new HSSFRichTextString(t);
					CellStyle style =  workbook.createCellStyle();
					Font font = workbook.createFont();
			        font.setFontName("仿宋_GB2312");
			        if(importNotNullFieldTitle.contains(k)){
			        	font.setColor(HSSFColor.RED.index);
			        }
			        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
					style.setFont(font);
					
					style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
					style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			        cell.setCellStyle(style);
					cell.setCellValue(text);
					i++;
					for(String c : formlua.keySet()){
						String f = formlua.get(c);
						if(f.indexOf(t) >=0){
							f = f.replace("["+t+"]", CommonHelper.getNumberToLetter(i)+(index+2));
							formlua.put(c, f);
						}
					}
				}
			}else{
				index++;
				boolean issrow = false;
				int srowindex = 0;
				Row srow = sheet.createRow(index);
				for (String k : exportFieldTitle.keySet()) {
					Cell cell =  row.getCell(i) !=null? row.getCell(i) :row.createCell(i); 
					Cell scell = srow.createCell(i);
					WageAccountEntity account = exportFieldTitle.get(k);
					String t =account.getAlias();
					RichTextString text = new HSSFRichTextString(t);
					CellStyle style =  workbook.createCellStyle();
					Font font = workbook.createFont();
			        font.setFontName("仿宋_GB2312");
			        if(importNotNullFieldTitle.contains(k)){
			        	font.setColor(HSSFColor.RED.index);
			        }
			        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
			        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
					style.setFont(font);
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
					style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
					
					style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
					style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(style);
			        if(!issrow){
			        	cell.setCellValue(text);
					}
					
					if(srowindex>0){
						scell = srow.createCell(i);
						scell.setCellStyle(style);
						scell.setCellValue(text);
						srowindex--;
					}else{
						scell.setCellStyle(style);
						if(account.getRowspan() == 2 && account.getColspan() == 1){
							sheet.addMergedRegion(new CellRangeAddress(cell.getRowIndex(), cell.getRowIndex() + 1, cell.getColumnIndex(), cell.getColumnIndex()));
						}
					}
					
					if(account.getColspan()  >1  && account.getRowspan() == 1){
						sheet.addMergedRegion(new CellRangeAddress(cell.getRowIndex(), cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex()+account.getColspan()-1 ));
						issrow = true;
						i--;
						srowindex = account.getColspan();
					}
					if(srowindex==0){
						issrow = false;
					}
					i++;
				}
				for(int j = 0; j<i;j++){
					sheet.autoSizeColumn(j, true);
				}
			}
			
			
			//导出数据
			if(dataSet != null){
				// 拿到所有列名，以及导出的字段的get方法
				List<Method> methodObj = new ArrayList<Method>();
				Iterator its = dataSet.iterator();
				// 循环插入剩下的集合
				while (its.hasNext()) {
					// 从第二行开始写，第一行是标题
					index++;
					row = sheet.createRow(index);
					Object t = its.next();
					int k = 0;
					for (String code : exportFieldTitle.keySet()) {
						WageAccountEntity account = exportFieldTitle.get(code);
						if(account.getIstitle() != null && account.getIstitle() == 1){
							continue;
						}
						StringBuffer getMethodName = new StringBuffer("get");
						getMethodName.append(code.substring(0, 1).toUpperCase());
						getMethodName.append(code.substring(1));
						
						Method getMethod = null;
						try{
							getMethod = t.getClass().getMethod(getMethodName.toString(), new Class[] {});
						}catch(Exception a){
							
						}
						if(getMethod == null){
							k++;
							continue;
						}
						Cell cell = row.createCell(k);
						if(formlua.containsKey(code)){
							String f = formlua.get(code);
							if(!CommonHelper.isChineseCharacter(f)){
								if(index>1){
									f = f.replace("2", String.valueOf((index+1)));
								}
								cell.setCellFormula(f);
								k++;
								continue;
							} 
						}
						Object value  = getMethod.invoke(t, new Object[] {});
						
						if(importMontFiheldTitle.contains(code)){
							cell.setCellValue(value == null ? "" :  DateCommon.getDateString(value, "yyyy-MM"));
						}else if(importDateFieldTitle.contains(code)){
							cell.setCellValue(value == null ? "" :  DateCommon.getDateString(value, null));
						}else if(value != null){
							if(value.getClass().getName().equals("java.math.BigDecimal")){
								cell.setCellValue(new Double(value.toString()));
							}else{
								cell.setCellValue(value.toString());
								if(index == dataSet.size())
									sheet.autoSizeColumn(k, true);
							}
						}
						//百分数
						if(account.getIssum() != null && account.getIssum() == 2){
							CellStyle style =  workbook.createCellStyle();
							style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%")); 
							cell.setCellStyle(style);
						}
						if(!StringUtils.isEmpty(account.getExtendcode()) && !key.equals("SalaryBaseEntity")){
							CellStyle style =  workbook.createCellStyle();
							style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00")); 
							cell.setCellStyle(style);
							cell.setCellFormula(account.getExtendcode().replace("_", String.valueOf(index+1)));
						}
						k++;
					}
				}
			}else{
				index++;
				Row text = sheet.createRow(index);
				Cell cell = text.createCell(0);
				cell.setCellValue("1.月份以日期的格式填写(如：2014-10-01 或  2014-10);\t\n2.标注为红色的科目为必填;\t\n3.导入excel只能有一个sheet,如果存在其它隐藏sheet需要删除;\t\n4.现只支持excel2003、excel2007,如果是2007以上版本需要保存为2007以下格式(菜单另存为2003格式);\t\n5.导入数据时需要删除该行;");
				CellStyle style =  workbook.createCellStyle();
				style.setAlignment(CellStyle.ALIGN_LEFT);
				style.setWrapText(true);
				cell.setCellStyle(style);
				sheet.addMergedRegion(new CellRangeAddress(index, index, 0, exportFieldTitle.size()-1));
				text.setHeight((short)1500);
				for(int j = 0; j<i;j++){
					sheet.autoSizeColumn(j, true);
				}
				 
			}

			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	  
	/**
	 * 
	 * @param title     Sheet名字
	 * @param pojoClass Excel对象Class
	 * @param dataSet   Excel对象数据List
	 * @param out       输出流
	 */
	public static HSSFWorkbook  exportExcel(String title, Class<?> pojoClass, Collection<?> dataSet) {
		// 使用userModel模式实现的，当excel文档出现10万级别的大数据文件可能导致OOM内存溢出
		return exportExcelInUserModel2File(title, pojoClass, dataSet);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static HSSFWorkbook exportExcelInUserModel2File(String title, Class<?> pojoClass,
			Collection<?> dataSet) {
		// 声明一个工作薄
		HSSFWorkbook  workbook = null;
		try {
			// 首先检查数据看是否是正确的
			// 声明一个工作薄
			workbook = new HSSFWorkbook();
			// 生成一个表格
			Sheet sheet = workbook.createSheet(title);
			// 标题
			List<String> exportFieldTitle = new ArrayList<String>();
			List<Integer> exportFieldWidth = new ArrayList<Integer>();
			// 拿到所有列名，以及导出的字段的get方法
			List<Method> methodObj = new ArrayList<Method>();
			Map<String, Method> convertMethod = new HashMap<String, Method>();
			Map<String, String> convertDict = new HashMap<String, String>();
			// 得到所有字段
			Field fileds[] = pojoClass.getDeclaredFields();
			// 遍历整个filed
			 
			int index = 0;
			// 产生表格标题行
			Row row = sheet.createRow(index);
			row.setHeight((short)450);
			CellStyle titleStyle = getTitleStyle(workbook);
			for (int i = 0, exportFieldTitleSize = exportFieldTitle.size(); i < exportFieldTitleSize; i++) {
				Cell cell = row.createCell(i);
				// cell.setCellStyle(style);
				RichTextString text = new HSSFRichTextString(exportFieldTitle
						.get(i));
				cell.setCellValue(text);
				cell.setCellStyle(titleStyle);
			}

			// 设置每行的列宽
			for (int i = 0; i < exportFieldWidth.size(); i++) {
				// 256=65280/255
				sheet.setColumnWidth(i, 256 * exportFieldWidth.get(i));
			}
			Iterator its = dataSet.iterator();
			// 循环插入剩下的集合
			while (its.hasNext()) {
				// 从第二行开始写，第一行是标题
				index++;
				row = sheet.createRow(index);
				row.setHeight((short)350);
				Object t = its.next();
				for (int k = 0, methodObjSize = methodObj.size(); k < methodObjSize; k++) {
					Cell cell = row.createCell(k);
					Method getMethod = methodObj.get(k);
					Object value = null;
					if (convertMethod.containsKey(getMethod.getName())) {
						Method cm = convertMethod.get(getMethod.getName());
						value = cm.invoke(t, new Object[] {});
					}   else{
						value = getMethod.invoke(t, new Object[] {});
					}
					cell.setCellValue(value==null?"":value.toString());
					
					if(index%2==0)
						cell.setCellStyle(getTwoStyle(workbook));
					else
						cell.setCellStyle(getOneStyle(workbook));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}
		public static HSSFCellStyle getTitleStyle(HSSFWorkbook workbook){
		// 产生Excel表头
				 HSSFCellStyle titleStyle = workbook.createCellStyle();
		 titleStyle.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);    //设置边框样式
        titleStyle.setBorderLeft((short)2);     //左边框
        titleStyle.setBorderRight((short)2);    //右边框
        titleStyle.setBorderTop((short)2);     //左边框
        titleStyle.setBorderBottom((short)2);    //右边框
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);    //顶边框
        titleStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);    //填充的背景颜色
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    //填充图案
	     
		return titleStyle;
	}
	
	public static HSSFCellStyle getTwoStyle(HSSFWorkbook workbook){
		// 产生Excel表头
		// 产生Excel表头
		 HSSFCellStyle style = workbook.createCellStyle(); 
		 style.setBorderLeft((short)1);     //左边框
		 style.setBorderRight((short)1);    //右边框
		 style.setBorderBottom((short)1);
		 style.setBorderTop((short)1);
		 style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);    //填充的背景颜色
		 style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    //填充图案
		return style;
	}
	
	public static HSSFCellStyle getOneStyle(HSSFWorkbook workbook){
		// 产生Excel表头
		// 产生Excel表头
		 HSSFCellStyle style = workbook.createCellStyle(); 
		 style.setBorderLeft((short)1);     //左边框
		 style.setBorderRight((short)1);    //右边框
		 style.setBorderBottom((short)1);
		 style.setBorderTop((short)1); 
		return style;
	}
	
	}
