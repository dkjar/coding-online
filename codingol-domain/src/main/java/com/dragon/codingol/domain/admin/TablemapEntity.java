package com.dragon.codingol.domain.admin;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

import com.dragon.codingol.domain.base.Dictionary;
import com.dragon.codingol.domain.base.Valiform;

import com.dragon.codingol.domain.base.RelativeTable;
/**   
 * @Title: Entity
 * @Description: 表映射关系
 * @author dx
 * @date 2015-05-21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_table_map", schema = "")
@SuppressWarnings("serial")
public class TablemapEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**主表id*/
	private java.lang.String tableid;
	/**主表名称*/
	@Dictionary(name="")
	private java.lang.String tablename;
	/**映射表id*/
	private java.lang.String mapid;
	/**映射表名*/
	@Dictionary(name="")
	private java.lang.String mapname;
	/**中间表id*/
	private java.lang.String middleid;
	/**中间表名*/
	@Dictionary(name="")
	private java.lang.String middlename;
	/**映射类型*/
	@Dictionary(name="mapping")
	private java.lang.Integer maptype;
	/**状态*/
	@Dictionary(name="")
	private java.lang.Integer status;
	/**创建时间*/
	@Dictionary(name="")
	private java.util.Date createdate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@Column(name ="[id]",nullable=false,precision=60,length=60)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表id
	 */
	@Column(name ="[tableid]",nullable=true,precision=60,length=60)
	public java.lang.String getTableid(){
		return this.tableid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表id
	 */
	public void setTableid(java.lang.String tableid){
		this.tableid = tableid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表名称
	 */
	@Column(name ="[tablename]",nullable=true,precision=100,length=100)
	public java.lang.String getTablename(){
		return this.tablename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表名称
	 */
	public void setTablename(java.lang.String tablename){
		this.tablename = tablename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  映射表id
	 */
	@Column(name ="[mapid]",nullable=true,precision=60,length=60)
	public java.lang.String getMapid(){
		return this.mapid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  映射表id
	 */
	public void setMapid(java.lang.String mapid){
		this.mapid = mapid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  映射表名
	 */
	@Column(name ="[mapname]",nullable=true,precision=100,length=100)
	public java.lang.String getMapname(){
		return this.mapname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  映射表名
	 */
	public void setMapname(java.lang.String mapname){
		this.mapname = mapname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中间表id
	 */
	@Column(name ="[middleid]",nullable=true,precision=60,length=60)
	public java.lang.String getMiddleid(){
		return this.middleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中间表id
	 */
	public void setMiddleid(java.lang.String middleid){
		this.middleid = middleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中间表名
	 */
	@Column(name ="[middlename]",nullable=true,precision=100,length=100)
	public java.lang.String getMiddlename(){
		return this.middlename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中间表名
	 */
	public void setMiddlename(java.lang.String middlename){
		this.middlename = middlename;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  映射类型
	 */
	@Column(name ="[maptype]",nullable=true,scale=0)
	public java.lang.Integer getMaptype(){
		return this.maptype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  映射类型
	 */
	public void setMaptype(java.lang.Integer maptype){
		this.maptype = maptype;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@RelativeTable(table="")
	@Column(name ="[status]",nullable=true,scale=0)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@RelativeTable(table="")
	@Column(name ="[createdate]",nullable=true)
	public java.util.Date getCreatedate(){
		return this.createdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatedate(java.util.Date createdate){
		this.createdate = createdate;
	}
}
