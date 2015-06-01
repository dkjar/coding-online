package com.dragon.codingol.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 子系统
 * @author dx
 * @date 2014-02-24 09:19:38
 * @version V1.0
 * 
 */
@Entity
@Table(name = "sys_application", schema = "") 
public class ApplicationEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7540524013202656310L;
	/** appname */
	private String appname;
	/** appurl */
	private String appurl;
	/** apporder */
	private Integer apporder;

	private String appicon;

	private Integer apptype;

	private String id;
	
	private Integer usable;
	
	/**
	 * id一样，则认为是相同的
	 */
	@Override
	public boolean equals(Object other) {
		if(this == null) return true;
		if(this == other) return true;
		if(other == this) return true;
		if(!(other instanceof ApplicationEntity)) return false;
		
		final ApplicationEntity o = (ApplicationEntity)other;
		if(this.getId().equals(o.getId())) return true;
		
		return false;
	}

	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "apptype", nullable = true, precision = 10, scale = 0, length = 4)
	public Integer getApptype() {
		return apptype;
	}

	public void setApptype(Integer apptype) {
		this.apptype = apptype;
	}

	@Column(name = "APPICON", length = 100)
	public java.lang.String getAppicon() {
		return appicon;
	}

	public void setAppicon(java.lang.String appicon) {
		this.appicon = appicon;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String appname
	 */
	@Column(name = "APPNAME", length = 50)
	public java.lang.String getAppname() {
		return this.appname;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String appname
	 */
	public void setAppname(java.lang.String appname) {
		this.appname = appname;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String appurl
	 */
	@Column(name = "APPURL", length = 255)
	public java.lang.String getAppurl() {
		return this.appurl;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String appurl
	 */
	public void setAppurl(java.lang.String appurl) {
		this.appurl = appurl;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer apporder
	 */
	@Column(name = "APPORDER", nullable = true, precision = 10, scale = 0, length = 4)
	public java.lang.Integer getApporder() {
		return this.apporder;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer apporder
	 */
	public void setApporder(java.lang.Integer apporder) {
		this.apporder = apporder;
	}

	@Transient
	public Integer getUsable() {
		return usable;
	}

	public void setUsable(Integer usable) {
		this.usable = usable;
	}
	
	
}
