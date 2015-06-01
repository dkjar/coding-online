package com.dragon.codingol.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 系统管理
 * @author dx
 * @date 2014-10-12 09:26:08
 * @version V1.0
 *
 */
@Entity
@Table(name = "admin_system", schema = "")
public class SystemEntity  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2033709506817072818L;
	private String id;

	/** 编码 */
	private java.lang.String code;
	/** 表格名称 */
	private java.lang.String name;

	private java.lang.String packageName;

	private java.lang.String projectName;
 
	private java.lang.String path;
	
	private java.lang.String databaseName;
	/** 状态 */
	private java.lang.Integer status;
 
	public SystemEntity() {
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

	@Column(name = "[packageName]", nullable = true, precision = 200, length = 200)
	public java.lang.String getPackageName() {
		return packageName;
	}

	public void setPackageName(java.lang.String packageName) {
		this.packageName = packageName;
	}

	@Column(name = "[projectName]", nullable = true, precision = 100, length = 100)
	public java.lang.String getProjectName() {
		return projectName;
	}

	public void setProjectName(java.lang.String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "[path]", nullable = true, precision = 100, length = 100)
	public java.lang.String getPath() {
		return path;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	@Column(name = "[databaseName]", nullable = true, precision = 100, length = 100)
	public java.lang.String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(java.lang.String databaseName) {
		this.databaseName = databaseName;
	}
	
	
}
