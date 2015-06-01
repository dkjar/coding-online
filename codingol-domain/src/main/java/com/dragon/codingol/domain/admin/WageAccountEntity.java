package com.dragon.codingol.domain.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.dragon.codingol.domain.base.Valiform;

/**
 * @Title: Entity
 * @Description: 科目管理
 * @author dx
 * @date 2014-10-12 09:42:30
 * @version V1.0
 * 
 */
@Entity
@Table(name = "wage_account", schema = "")
public class WageAccountEntity  implements
		java.io.Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8268440262955694677L;
	private String id;
	/** 表格id */
	@Valiform(title = "表格id", notNull = true)
	private java.lang.String excelid;
	/** 编码 */
	@Valiform(title = "编码", notNull = true)
	private java.lang.String code;
	/** 科目名称 */
	@Valiform(title = "科目名称", notNull = true)
	private java.lang.String name;
	/** 自定义名称 */
	private java.lang.String alias;
	/** 系统字段 */
	@Valiform(title = "系统字段", notNull = true)
	private java.lang.Integer issystem;
	/** 启用 */
	@Valiform(title = "启用", notNull = true)
	private java.lang.Integer enable;
	/** 状态 */
	private java.lang.Integer status;
	/** 程序计算科目 */
	private java.lang.String formula;
	/*是否合计*/
	private java.lang.Integer issum;
	/*是否在列显示*/
	private java.lang.Integer isextend;
	
	private java.lang.Integer calclevel;
	/** 程序计算科目 */
	private java.lang.String formulacode;
	
	private java.lang.Integer istitle;
	
	private java.lang.Integer colspan;
	
	private java.lang.Integer rowspan;
	
	private java.lang.String extendcode;
	
	//是否只永许管理员导入
	private java.lang.Integer ismanager;
	
	@Valiform(title = "显示顺序", notNull = true)
	private java.lang.Integer colorder;
	
	private Date createdate;

	public WageAccountEntity() {
		status = 1;
		issystem = 0;
	}

	
	@Id
    @GeneratedValue(generator="hibernate-uuid") 
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")   
	@Column(name ="id", unique = true, nullable=false,length=64)
    public String getId() {
        return id;
    }
	
	
	
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 表格id
	 */
	@Column(name = "[EXCELID]", nullable = true, precision = 50, length = 50)
	public java.lang.String getExcelid() {
		return this.excelid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 表格id
	 */
	public void setExcelid(java.lang.String excelid) {
		this.excelid = excelid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 编码
	 */
	@Column(name = "[CODE]", nullable = true, precision = 50, length = 50)
	public java.lang.String getCode() {
		return this.code;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 编码
	 */
	public void setCode(java.lang.String code) {
		this.code = code;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 科目名称
	 */
	@Column(name = "[NAME]", nullable = true, precision = 100, length = 100)
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 科目名称
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 自定义名称
	 */
	@Column(name = "[ALIAS]", nullable = true, precision = 100, length = 100)
	public java.lang.String getAlias() {
		return this.alias;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 自定义名称
	 */
	public void setAlias(java.lang.String alias) {
		this.alias = alias;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 系统字段
	 */
	@Column(name = "[ISSYSTEM]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getIssystem() {
		return this.issystem;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 系统字段
	 */
	public void setIssystem(java.lang.Integer issystem) {
		this.issystem = issystem;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 启用
	 */
	@Column(name = "[ENABLE]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getEnable() {
		return this.enable;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 启用
	 */
	public void setEnable(java.lang.Integer enable) {
		this.enable = enable;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 状态
	 */
	@Column(name = "[STATUS]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getStatus() {
		return this.status;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 状态
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	@Column(name = "[formula]", nullable = true, precision = 500, length = 500)
	public java.lang.String getFormula() {
		return formula;
	}

	public void setFormula(java.lang.String formula) {
		this.formula = formula;
	}

	@Column(name = "[formulacode]", nullable = true, precision = 500, length = 500)
	public java.lang.String getFormulacode() {
		return formulacode;
	}

	public void setFormulacode(java.lang.String formulacode) {
		this.formulacode = formulacode;
	}

	@Column(name = "[colorder]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getColorder() {
		return colorder;
	}

	public void setColorder(java.lang.Integer colorder) {
		this.colorder = colorder;
	}

	@Column(name = "[issum]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getIssum() {
		return issum;
	}

	public void setIssum(java.lang.Integer issum) {
		this.issum = issum;
	}

	@Column(name = "[isextend]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getIsextend() {
		return isextend;
	}

	public void setIsextend(java.lang.Integer isextend) {
		this.isextend = isextend;
	}
	
	@Column(name = "[calclevel]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getCalclevel() {
		return calclevel;
	}

	public void setCalclevel(java.lang.Integer calclevel) {
		this.calclevel = calclevel;
	}

	@Column(name = "[istitle]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getIstitle() {
		return istitle;
	}

	public void setIstitle(java.lang.Integer istitle) {
		this.istitle = istitle;
	}

	@Column(name = "[colspan]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getColspan() {
		return colspan;
	}

	public void setColspan(java.lang.Integer colspan) {
		this.colspan = colspan;
	}

	@Column(name = "[rowspan]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getRowspan() {
		return rowspan;
	}

	public void setRowspan(java.lang.Integer rowspan) {
		this.rowspan = rowspan;
	}

	@Column(name = "[extendcode]", nullable = true, precision = 100,  length = 100)
	public java.lang.String getExtendcode() {
		return extendcode;
	}

	public void setExtendcode(java.lang.String extendcode) {
		this.extendcode = extendcode;
	}

	@Column(name ="[createdate]",nullable=true,precision=10,scale=0,length=3)
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "[ismanager]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getIsmanager() {
		return ismanager;
	}

	public void setIsmanager(java.lang.Integer ismanager) {
		this.ismanager = ismanager;
	}
	
}