package com.dragon.codingol.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.DateCommon;
import com.dragon.codingol.common.ValidateExistsCommon;
import com.dragon.codingol.common.base.CommonHelper;
import com.dragon.codingol.domain.admin.WageAccountEntity;
import com.dragon.codingol.domain.admin.WageExcelEntity;
import com.dragon.codingol.domain.base.Valiform;

public final class ExcelUtil {

	public ExcelUtil() {
	}
	/**
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题集合
	 * @param field_list
	 *            Excel文件Field标题集合
	 * @param dataList
	 *            Excel文件数据内容部分
	 * @throws Exception
	 */
	public static void createExcel(String excel_name, String[] headList, String[] fieldList, List<Map<String, Object>> dataList) throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.length; i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList[i]);
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.length; i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList[i])));
			}
			// ===============================================================
		}

		// 新建一输出文件流
		FileOutputStream fOut = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fOut);
		fOut.flush();
		// 操作结束，关闭文件
		fOut.close();
		// System.out.println("[" + excel_name + "]" + "文件生成...");
	}

	/**
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题集合
	 * @param field_list
	 *            Excel文件Field标题集合
	 * @param dataList
	 *            Excel文件数据内容部分
	 * @throws Exception
	 */
	public static void createExcel(String excel_name, List<String> headList, List<String> fieldList, List<Map<String, Object>> dataList)
			throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.size(); i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList.get(i));
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.size(); i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList.get(i))));
			}
			// ===============================================================
		}

		// 新建一输出文件流
		FileOutputStream fOut = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fOut);
		fOut.flush();
		// 操作结束，关闭文件
		fOut.close();
		// System.out.println("[" + excel_name + "]" + "文件生成...");
	}

	/**
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题集合
	 * @param field_list
	 *            Excel文件Field标题集合
	 * @param dataList
	 *            Excel文件数据内容部分
	 * @throws HSSFWorkbook
	 */
	public static HSSFWorkbook createExcel(List<String> headList, List<String> fieldList, List<Map<String, Object>> dataList) throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.size(); i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList.get(i));
		}
		// ===============================================================

		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.size(); i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(objToString(dataMap.get(fieldList.get(i))));
			}
			// ===============================================================
		}
		return workbook;
	}

	private static String objToString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			if (obj instanceof String) {
				return (String) obj;
			} else if (obj instanceof Date) {
				return null;// DateUtil.dateToString((Date)
							// obj,DateUtil.DATESTYLE_SHORT_EX);
			} else {
				return obj.toString();
			}
		}
	}

	/**
	 * 
	 * @param excel_name
	 *            生成的Excel文件路径+名称
	 * @param headList
	 *            Excel文件Head标题部分
	 * @param valueList
	 *            Excel文件数据内容部分
	 * @throws Exception
	 */
	public static void bulidExcel(String excel_name, String[] headList, List<String[]> valueList) throws Exception {
		// 创建新的Excel 工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 在Excel工作簿中建一工作表，其名为缺省值
		// 如要新建一名为"效益指标"的工作表，其语句为：
		// HSSFSheet sheet = workbook.createSheet("效益指标");
		HSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		HSSFRow row = sheet.createRow(0);
		// ===============================================================
		for (int i = 0; i < headList.length; i++) {

			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList[i]);
		}
		// ===============================================================

		for (int n = 0; n < valueList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			HSSFRow row_value = sheet.createRow(n + 1);
			String[] valueArray = valueList.get(n);
			// ===============================================================
			for (int i = 0; i < valueArray.length; i++) {

				// 在索引0的位置创建单元格（左上端）
				HSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue(valueArray[i]);
			}
			// ===============================================================
		}

		// 新建一输出文件流
		FileOutputStream fOut = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fOut);
		fOut.flush();
		// 操作结束，关闭文件
		fOut.close();
		// System.out.println("[" + excel_name + "]" + "文件生成...");
	}

	/**
	 * 读取 Excel文件内容
	 * 
	 * @param excel_name
	 * @return
	 * @throws Exception
	 */
	public static List<String[]> readExcel(String excel_name) throws Exception {
		// 结果集
		List<String[]> list = new ArrayList<String[]>();

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(new FileInputStream(excel_name));

		// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);

		// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数
		for (int j = 0; j < hssfsheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow hssfrow = hssfsheet.getRow(j);
			if (hssfrow != null) {
				int col = hssfrow.getPhysicalNumberOfCells();
				// 单行数据
				String[] arrayString = new String[col];
				for (int i = 0; i < col; i++) {
					HSSFCell cell = hssfrow.getCell(i);
					if (cell == null) {
						arrayString[i] = "";
					} else if (cell.getCellType() == 0) {
						// arrayString[i] = new
						// Double(cell.getNumericCellValue()).toString();
						if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date d = cell.getDateCellValue();
								// SimpleDateFormat("yyyy-MM-dd");
								DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								arrayString[i] = formater.format(d);
							} else {
								arrayString[i] = new BigDecimal(cell.getNumericCellValue()).longValue() + "";
							}
						}
					} else {// 如果EXCEL表格中的数据类型为字符串型
						arrayString[i] = cell.getStringCellValue().trim();
					}
				}
				list.add(arrayString);
			}
		}
		return list;
	}

	/**
	 * 读取 Excel文件内容
	 * 
	 * @param excel_name
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> readExcelByList(String excel_name) throws Exception {
		// 结果集
		List<List<Object>> list = new ArrayList<List<Object>>();

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(new FileInputStream(excel_name));

		// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);

		// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数
		for (int j = 0; j < hssfsheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow hssfrow = hssfsheet.getRow(j);
			if (hssfrow != null) {
				int col = hssfrow.getPhysicalNumberOfCells();
				// 单行数据
				List<Object> arrayString = new ArrayList<Object>();
				for (int i = 0; i < col; i++) {
					HSSFCell cell = hssfrow.getCell(i);
					if (cell == null) {
						arrayString.add("");
					} else if (cell.getCellType() == 0) {
						arrayString.add(new Double(cell.getNumericCellValue()).toString());
					} else {// 如果EXCEL表格中的数据类型为字符串型
						arrayString.add(cell.getStringCellValue().trim());
					}
				}
				list.add(arrayString);
			}
		}
		return list;
	}

	/**
	 * 读取 Excel文件内容
	 * 
	 * @param excel_name
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> readExcelByInputStream(InputStream inputstream) throws Exception {
		// 结果集
		List<List<Object>> list = new ArrayList<List<Object>>();

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(inputstream);

		// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);

		// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数

		// //System.out.println("excel行数： "+hssfsheet.getPhysicalNumberOfRows());
		for (int j = 0; j < hssfsheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow hssfrow = hssfsheet.getRow(j);
			if (hssfrow != null) {
				int col = hssfrow.getPhysicalNumberOfCells();
				// 单行数据
				List<Object> arrayString = new ArrayList<Object>();
				for (int i = 0; i < col; i++) {
					HSSFCell cell = hssfrow.getCell(i);
					if (cell == null) {
						arrayString.add("");
					} else if (cell.getCellType() == 0) {
						arrayString.add(new Double(cell.getNumericCellValue()).toString());
					} else {// 如果EXCEL表格中的数据类型为字符串型
						arrayString.add(cell.getStringCellValue().trim());
					}
				}
				list.add(arrayString);
			}
		}
		return list;
	}

	/**
	 * 导入 excel
	 * 
	 * @param file
	 *            : Excel文件
	 * @param pojoClass
	 *            : 对应的导入对象 (每行记录)
	 * @return
	 * @throws Exception
	 */
	public Collection importExcel(File file, Class pojoClass, Map<String, String> itemparam, boolean validateItem) throws Exception {
		try {
			// 将传入的File构造为FileInputStream;
			FileInputStream in = new FileInputStream(file);
			return importExcelByIs(in, pojoClass, itemparam, validateItem);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	private List<CellRangeAddress> getCombineCell(Sheet sheet){
		List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();
		int sheetmergerCount = sheet.getNumMergedRegions();		 	
		for (int i = 0; i < sheetmergerCount; i++) {		 		
			CellRangeAddress ca = sheet.getMergedRegion(i);			
			list.add(ca); 
		}
		return list;
	}
	
	private CellRangeAddress getCellRangeAddress( List<CellRangeAddress> list, Cell cell){
		for (CellRangeAddress ca : list) {
			if (cell.getColumnIndex() <= ca.getLastColumn() && cell.getColumnIndex()>= ca.getFirstColumn() &&
					cell.getRowIndex() <= ca.getLastRow() && cell.getRowIndex() >= ca.getFirstRow()) {
				return ca;
			}
		}
		return null;
	}
	
	
	/**
	 * 
	 * 导入 excel
	 * 
	 * @param inputstream
	 *            : 文件输入流
	 * @param pojoClass
	 *            : 对应的导入对象 (每行记录)
	 * @return
	 * @throws Exception
	 */
	public Collection importExcelByIs(Object inputstream, Class pojoClass, Map<String, String> itemparam, boolean validateItem) throws Exception {
		boolean ismanager =  CommonHelper.isMananger();
		//导入管理 
		Map<String, Integer> importMonths = new HashMap<String, Integer>();
	/*	for(SalaryImportEntity s : SalaryImportEntity.getSalaryImport()){
			String t = DateCommon.getDateString(s.getMonth(), "yyyy-MM");
			if(!importMonths.containsKey(t)){
				importMonths.put(t, s.getTimes());
			} 
		}*/
		
		List<Object> dist = new ArrayList<Object>();
		try {
			// 得到目标目标类的所有的字段列表
			Field filed[] = pojoClass.getDeclaredFields();
			
			Map<String , List<WageAccountEntity>> mapAccountList = null;//WageAccountEntity.getAccountList();
			
			Map<String, WageAccountEntity> importFieldTitle = new HashMap<String, WageAccountEntity>();
			List<String> importNotNullFieldTitle = new ArrayList<String>();
			List<String> importDateFieldTitle = new ArrayList<String>();
			List<String> importUniqueFieldTitle = new ArrayList<String>();
			List<String> importExcelUnFieldTitle = new ArrayList<String>();
			List<String> importMontFiheldTitle = new ArrayList<String>();
			List<String> importNumberField = new ArrayList<String>(); //只能输入数字
			List<String> importPercentField = new ArrayList<String>(); //百分数精度
			List<String> importIntegerField = new ArrayList<String>(); //整型
			Map<String, String> importExistsFieldTitle = new HashMap<String, String>();
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				if(f.getType().getName().equals("java.math.BigDecimal") ){
					importNumberField.add(f.getName());
				}else if(f.getType().getName().equals("java.lang.Integer")){
					importIntegerField.add(f.getName());
				}
				
				Valiform vali = f.getAnnotation(Valiform.class);
				if (vali != null) {
					// 非空验证
					if (vali.notNull() || vali.importNotNull()) {
						importNotNullFieldTitle.add(f.getName());
					}
					if(vali.isUnique()){
						importUniqueFieldTitle.add(f.getName());
					}
					if(vali.isDate()){
						importDateFieldTitle.add(f.getName());
					}
					if(!StringUtils.isEmpty(vali.exists())){
						importExistsFieldTitle.put(f.getName(), vali.exists());
					}
					if(vali.isUnmonth()){
						importMontFiheldTitle.add(f.getName());
					}
					if(vali.excelUnique()){
						importExcelUnFieldTitle.add(f.getName());
					}
				}
			}
			String key = pojoClass.getSimpleName(); 
			List<WageAccountEntity> accountList = null;
			Integer titlerow = 1;
			if(key.equals("SalaryEntity")){
				accountList = new ArrayList<WageAccountEntity>();
				//accountList.addAll( WageAccountEntity.getSalaryList().values());
			}else{
				WageExcelEntity w =  null;//WageExcelEntity.getExcelList().get(key);
				titlerow = w.getTitlerow();
				accountList =  mapAccountList.get(w.getId());
			}
			String head = "";
			int headindex = 0;
			for(WageAccountEntity a : accountList){
				String title = "";
				if(!StringUtils.isEmpty(a.getAlias())){
					title = a.getAlias();
				}else if(!StringUtils.isEmpty(a.getName())){
					title = a.getName();
				}else{
					title = a.getCode();
				}
				
				//跨列的 合并标题 避免重复标题
				if(headindex >=1){
					title = head+title;
					headindex--;
				}
				if(title.equals("发放次数")){
					continue;
				}
				importFieldTitle.put(title, a);
				if(a.getIstitle() != null && a.getIstitle() == 1){
					head = title;
					headindex = a.getColspan();
				}
				
				//自定义列， 为数字的
				if(a.getIssum() !=null && a.getIssum() >0){
					if(!importNumberField.contains(a.getCode())){
						importNumberField.add(a.getCode());
					}
					if(a.getIssum() == 2){
						importPercentField.add(a.getCode());
					}
				}
			}
			 
			 
			// 将传入的File构造为FileInputStream;
			// // 得到工作表
			Workbook book = null;
			if(inputstream.getClass().getSimpleName().equals("FileInputStream")){
				book =   WorkbookFactory.create((InputStream)inputstream);
			}else if(inputstream.getClass().getSimpleName().equals("HSSFWorkbook") || "XSSFWorkbook".equals(inputstream.getClass().getSimpleName())){
				book = (Workbook)inputstream;
			}
			
			// // 得到第一页
			Sheet sheet = book.getSheetAt(0);
			Iterator<Row> row = sheet.rowIterator();
			Row title = row.next();
			// 得到第一行的所有列
			Iterator<Cell> cellTitle = title.cellIterator();
			// 将标题的文字内容放入到一个map中。
			Map<Integer, Object> titlemap = new HashMap<Integer, Object>();
			// 从标题第一列开始
			int i = 0;
			
			List<String> importAccount = new ArrayList<String>();
			// 循环标题所有的列 , 只有一行标题
			if(titlerow == 1){
				while (cellTitle.hasNext()) {
					Cell cell = cellTitle.next();
					String value = cell.getStringCellValue();
					if(StringUtils.isEmpty(value)){
						throw new Exception("第"+(cell.getColumnIndex() +1)+"列、列名不能为空");
					}else{
						value = value.trim();
						if(StringUtils.isEmpty(value)){
							throw new Exception("第"+(cell.getColumnIndex() +1)+"列、列名不能为空");
						}
					}
					
					if(importAccount.contains(value)){
						throw new Exception("科目："+value+" 存在重复!");
					}else{
						importAccount.add(value);
					}
					titlemap.put(i, value);
					i++;
				}
			}else if(titlerow == 2){
				List<CellRangeAddress> rangelist =  getCombineCell(sheet);
				while (cellTitle.hasNext()) {
					Cell cell = cellTitle.next();
					String value = cell.getStringCellValue();
				    titlemap.put(i, value);
					i++;
					CellRangeAddress range = getCellRangeAddress(rangelist, cell);
					if(range!=null && range.getFirstColumn() < range.getLastColumn()){
						int rangex = range.getLastColumn() -range.getFirstColumn();
						for(int m =0;m<rangex;m++){
							Cell c = cellTitle.next(); 
							titlemap.put(i, value);
							i++;
						}
					}
				}
				
				i = 0;
				title = row.next();
				cellTitle = title.cellIterator();
				while (cellTitle.hasNext()) {
					Cell cell = cellTitle.next();
					String value = cell.getStringCellValue();
					if(!StringUtils.isEmpty(value)){
						value = titlemap.get(i).toString() + value;
						
						if(importAccount.contains(value)){
							throw new Exception("科目："+value+" 存在重复!");
						}else{
							importAccount.add(value);
						}
						titlemap.put(i, value);
					}
					
					i++;
					CellRangeAddress range = getCellRangeAddress(rangelist, cell);
					if(range!=null && range.getFirstColumn() < range.getLastColumn()){
						int rangex = range.getLastColumn() -range.getFirstColumn();
						for(int m =1;m<rangex;m++){
							Cell c = cellTitle.next();
							String v = c.getStringCellValue();
							v =  titlemap.get(i).toString() + v;
							
							if(importAccount.contains(v)){
								throw new Exception("科目："+v+" 存在重复!");
							}else{
								importAccount.add(v);
							}
							titlemap.put(i, v);
							i++;
						}
					}
				}
			}
			
			DecimalFormat df = new DecimalFormat("0.00"); 
			DecimalFormat dfpercent = new DecimalFormat("0.0000");
			// 用来格式化日期的DateFormat
			List<String> months = new ArrayList<String>();  //导入月份 ，唯一检测
			List<String> unique = new ArrayList<String>();
			Integer times = null;
			
			while (row.hasNext()) {
				// 标题下的第一行
				Row rown = row.next();
				// 得到传入类的实例
				Map<String, Object> object = new HashMap<String, Object>();
				List<Object> fields = new ArrayList<Object>();
				int k = 0;
				String titleString = "";
				// 遍历一行的列
				try {
					String mutiunique = "";
					for (int ki = 0; ki < i; ki++) {
						Cell cell = rown.getCell(ki);
						// 这里得到此列的对应的标题
						titleString = (String) titlemap.get(k);
						//如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
						if (importFieldTitle.containsKey(titleString)) {
							WageAccountEntity account = importFieldTitle.get(titleString);
							String code = account.getCode();
							
							Map<String, Object> field = new HashMap<String, Object>();
							field.put("field", code);
							if (importNotNullFieldTitle.contains(code)) {
								if (cell == null) {
									throw new Exception("不能为空");
								}
							}else{
								if (cell == null) {
									field.put("value", null);
									fields.add(field);
									k++;
									continue;
								}
							}
							
							switch(cell.getCellType()){	
							case Cell.CELL_TYPE_FORMULA:
								String formula = cell.getCellFormula();
								if( rown.getRowNum() == 2 && ismanager){
									if(!StringUtils.isEmpty(formula)){
										formula = formula.replace(String.valueOf(cell.getRowIndex() +1), "_");
										account.setExtendcode(formula);
									}else{
										account.setExtendcode(null);
									}
									
									//WageAccountEntity.extendCodeList.add(account);
								} 
								
								cell.setCellType(Cell.CELL_TYPE_STRING);
								String v  = cell.getStringCellValue();
								if(!StringUtils.isEmpty(v)){
									if(importPercentField.contains(code)){
										field.put("value", dfpercent.format(Double.parseDouble(v)));
									}else if(importIntegerField.contains(code)){
										cell.setCellType(Cell.CELL_TYPE_STRING);
										String o  = cell.getStringCellValue();
										if(!StringUtils.isEmpty(o))
											field.put("value", Integer.parseInt(o));
										else
											field.put("value", null);
									}else if(importNumberField.contains(code)){
										field.put("value", df.format(Double.parseDouble(v)));
									}else{
										field.put("value",  v);
									}
								}else{
									field.put("value", null);
								}
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								field.put("value", cell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if(importDateFieldTitle.contains(code)){
									Date d  = cell.getDateCellValue();
									if(d != null)
										field.put("value", d);
									else 
										field.put("value", null);
								}else if(code.equals("number")){
									cell.setCellType(Cell.CELL_TYPE_STRING); 
									field.put("value", cell.getStringCellValue());
								} else if(!importNumberField.contains(code)){
									cell.setCellType(Cell.CELL_TYPE_STRING); 
									field.put("value",  cell.getStringCellValue());
								}else if(importIntegerField.contains(code)){
									Double o  = cell.getNumericCellValue();
									if(o != null)
										field.put("value", Integer.parseInt(o.toString()));
									else
										field.put("value", null);
								} else{
									
									cell.setCellType(Cell.CELL_TYPE_STRING);  
									String vn = cell.getStringCellValue();
									if(!StringUtils.isEmpty(vn))
										field.put("value", new BigDecimal(vn));
									else
										field.put("value", null);
								}
								break;
							default:
								if(importDateFieldTitle.contains(code)){
									cell.setCellType(Cell.CELL_TYPE_STRING); 
									String vd  = cell.getStringCellValue();
									if(!StringUtils.isEmpty(vd)){
										field.put("value", stringToDate(vd));
									}else{
										field.put("value", null);
									}
								}else if(importNumberField.contains(code)){//如何导入为数字， 按数字类型读取
									cell.setCellType(Cell.CELL_TYPE_STRING);
									String s = cell.getStringCellValue().trim();
									if(!StringUtils.isEmpty(s)){
										field.put("value", new BigDecimal(s));
									}
								}else if(importIntegerField.contains(code)){
									cell.setCellType(Cell.CELL_TYPE_STRING);
									String o  = cell.getStringCellValue();
									if(!StringUtils.isEmpty(o))
										field.put("value", Integer.parseInt(o));
									else
										field.put("value", null);
								} else{
									cell.setCellType(Cell.CELL_TYPE_STRING);
									field.put("value", cell.getStringCellValue());
								}
							}
							
							// 非空验证
							if (importNotNullFieldTitle.contains(code)) {
								if (field.get("value") == null || field.get("value") .equals("")) {
									throw new Exception("不能为空");
								}
								if(importExistsFieldTitle.containsKey(code)){
									if(!ValidateExistsCommon.validateExists(importExistsFieldTitle.get(code), field.get("value").toString())){
										throw new Exception("科目不能存在，请先添加");
									}
								}
								
								//一次导入唯一验证
								if(importExcelUnFieldTitle.contains(code)){
									if(unique.contains(field.get("value").toString())){
										throw new Exception("不能重复.");
									}else{
										unique.add(field.get("value").toString());
									}
								}
								
								//验证月份
								if(importMontFiheldTitle.contains(code)){
									String m = DateCommon.getDateString(field.get("value"), "yyyy-MM");
									
									if(months.size() > 0 && !months.contains(m)){
										throw new Exception("一次只能导入一个月的数据.");
									}else{
										if(!importMonths.containsKey(m)){
											throw new Exception( m +"月份数据不能导入，请联系管理员设置");
										}
										months.add(m);
										times = importMonths.get(months.get(0));
										if(times == null){
											throw new Exception("导入失败");
										}
									}
								}
							}
							//数字验证
							if(importNumberField.contains(code)){
								if(field.get("value")==null || field.get("value").equals("")){
									field.put("value", null);
								}else if(field.get("value").equals("#DIV/0!")){
									field.put("value", null);
								}else if(!CommonHelper.isNumeric(field.get("value").toString())){
									throw new Exception("只能输入数字");
								}
							}
							
							if(importUniqueFieldTitle.contains(code)){
								switch(cell.getCellType()){	
								case Cell.CELL_TYPE_BOOLEAN:
									object.put(code, cell.getBooleanCellValue());
									break;
								case Cell.CELL_TYPE_NUMERIC:
									if(importDateFieldTitle.contains(code)){
										object.put(code, cell.getDateCellValue());
									}else{
										object.put(code, cell.getNumericCellValue());
									}
									break;
								default:
									cell.setCellType(Cell.CELL_TYPE_STRING);
									object.put(code, cell.getStringCellValue());
								}
							}
							
							//excel 导入 ， 自定义变量 
							if(itemparam !=null && itemparam.containsKey(code)){
								Object o = field.get("value");
								object.put(code, o);
								if(o != null){
									mutiunique += o.toString();
								}
							}
							
							fields.add(field);
						}
						k++;
					}
					//if(validateItem){
					if(!StringUtils.isEmpty(mutiunique)){
						if(unique.contains(mutiunique)){
							titleString = "";
							throw new Exception("导入信息"+itemparam.values().toString()+"存在重复");
						}else{
							unique.add(mutiunique);
						}
					}
					//}
				} catch (Exception e) {
					if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
						throw new Exception("第" + rown.getRowNum() + "行 \"" + titleString + "\"列 只能填写数字");
					}
					throw new Exception("第" + rown.getRowNum() + "行 \"" + titleString + "\"" + e.getMessage());
				}
				 
				if(times != null){
					object.put("times", times);
				}
				
				object.put("list", fields);
				dist.add(object);
			}
			//WageAccountEntity.setAccountList(mapAccountList);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return dist;
	}

	/**
	 * 字符串转换为Date类型数据（限定格式 YYYY-MM-DD hh:mm:ss）或（YYYY/MM/DD hh:mm:ss）
	 * 
	 * @param cellValue
	 *            : 字符串类型的日期数据
	 * @return
	 * @throws Exception
	 */
	private static Date stringToDate(String cellValue) throws Exception {
		if(cellValue.length() == 7){
			cellValue += "-01";
		}
		if (cellValue.length() > 19)
			cellValue = cellValue.substring(0, 19);

		Calendar calendar = Calendar.getInstance();
		String[] dateStr = cellValue.split(" ");
		String[] dateInfo = dateStr[0].split("-");
		if (dateInfo.length != 3) {
			dateInfo = dateStr[0].split("/"); // 让 yyyy/mm/dd 的格式也支持
		}
		if (dateInfo.length == 3) {
			int year = Integer.parseInt(dateInfo[0]);
			int month = Integer.parseInt(dateInfo[1]) - 1; // 0~11
			int day = Integer.parseInt(dateInfo[2]);
			calendar.set(year, month, day);
		} else {
			throw new Exception("日期格式不正确");
		}
		if (dateStr.length > 1) {// 有时间（限定格式 hh:mm:ss）
			String[] timeStr = dateStr[1].split(":");
			if (timeStr.length == 3) {
				int hour = Integer.parseInt(timeStr[0]);
				int minute = Integer.parseInt(timeStr[1]);
				int second = Integer.parseInt(timeStr[2]);
				calendar.set(Calendar.HOUR_OF_DAY, hour);
				calendar.set(Calendar.MINUTE, minute);
				calendar.set(Calendar.SECOND, second);
			} else {
				return null; // 格式不正确
			}
		}
		return calendar.getTime();
	}

}
