package com.dragon.codingol.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.dragon.codingol.domain.base.Valiform;

/**
 * @Title: Entity
 * @Description: 表格管理
 * @author dx
 * @date 2014-10-12 09:26:08
 * @version V1.0
 *
 */
@Entity
@Table(name = "wage_excel", schema = "")
public class WageExcelEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2033709506817072818L;
	private String id;

	/** 编码 */
	@Valiform(title = "编码", isUnique = true, notNull = true)
	private java.lang.String code;
	/** 表格名称 */
	@Valiform(title = "表格名称", isUnique = true, notNull = true)
	private java.lang.String name;
	/** 科目信息 */
	private java.lang.String url;

	private java.lang.String filepath;

	private java.lang.String tablename;

	private java.lang.String alias;
	/** 状态 */
	private java.lang.Integer status;

	private java.lang.Integer titlerow;

	public WageExcelEntity() {
		status = 1;
	}

	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 64)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	 * @return: java.lang.String 表格名称
	 */
	@Column(name = "[NAME]", nullable = true, precision = 100, length = 100)
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 表格名称
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 科目信息
	 */
	@Column(name = "[URL]", nullable = true, precision = 50, length = 50)
	public java.lang.String getUrl() {
		return this.url;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 科目信息
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
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

	@Column(name = "[filepath]", nullable = true, precision = 50, length = 50)
	public java.lang.String getFilepath() {
		return filepath;
	}

	public void setFilepath(java.lang.String filepath) {
		this.filepath = filepath;
	}

	@Column(name = "[tablename]", nullable = true, precision = 50, length = 50)
	public java.lang.String getTablename() {
		return tablename;
	}

	public void setTablename(java.lang.String tablename) {
		this.tablename = tablename;
	}

	@Column(name = "[alias]", nullable = true, precision = 50, length = 50)
	public java.lang.String getAlias() {
		return alias;
	}

	public void setAlias(java.lang.String alias) {
		this.alias = alias;
	}

	@Column(name = "[titlerow]", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getTitlerow() {
		return titlerow;
	}

	public void setTitlerow(java.lang.Integer titlerow) {
		this.titlerow = titlerow;
	}

}
