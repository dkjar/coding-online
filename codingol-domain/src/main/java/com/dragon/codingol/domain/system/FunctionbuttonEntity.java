package com.dragon.codingol.domain.system;

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
 * @Description: 菜单功能管理
 * @author dx
 * @date 2015-05-21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_function_button", schema = "")
@SuppressWarnings("serial")
public class FunctionbuttonEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**pid*/
	private java.lang.String pid;
	/**菜单id*/
	private java.lang.String functionid;
	/**按钮名称*/
	private java.lang.String name;
	/**事件*/
	private java.lang.String action;
	/**图标id*/
	private java.lang.String iconid;
	/**图标名称*/
	private java.lang.String iconname;
	/**图标编码*/
	private java.lang.String iconcode;
	/**按钮位置*/
	@Dictionary(name="sidetype")
	private java.lang.Integer side;
	/**叶子*/
	private java.lang.Integer state;
	/**排序*/
	private java.lang.Integer order;
	/**状态*/
	private java.lang.Integer status;
	/**创建时间*/
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
	 *@return: java.lang.String  pid
	 */
	@Column(name ="[pid]",nullable=true,precision=60,length=60)
	public java.lang.String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pid
	 */
	public void setPid(java.lang.String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜单id
	 */
	@RelativeTable(table="sys_function")
	@Column(name ="[functionid]",nullable=true,precision=60,length=60)
	public java.lang.String getFunctionid(){
		return this.functionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜单id
	 */
	public void setFunctionid(java.lang.String functionid){
		this.functionid = functionid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  按钮名称
	 */
	@Column(name ="[name]",nullable=true,precision=100,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  按钮名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事件
	 */
	@Column(name ="[action]",nullable=true,precision=500,length=500)
	public java.lang.String getAction(){
		return this.action;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事件
	 */
	public void setAction(java.lang.String action){
		this.action = action;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标id
	 */
	@Column(name ="[iconid]",nullable=true,precision=60,length=60)
	public java.lang.String getIconid(){
		return this.iconid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标id
	 */
	public void setIconid(java.lang.String iconid){
		this.iconid = iconid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标名称
	 */
	@Column(name ="[iconname]",nullable=true,precision=100,length=100)
	public java.lang.String getIconname(){
		return this.iconname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标名称
	 */
	public void setIconname(java.lang.String iconname){
		this.iconname = iconname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标编码
	 */
	@Column(name ="[iconcode]",nullable=true,precision=50,length=50)
	public java.lang.String getIconcode(){
		return this.iconcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标编码
	 */
	public void setIconcode(java.lang.String iconcode){
		this.iconcode = iconcode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  按钮位置
	 */
	@Column(name ="[side]",nullable=true,scale=0)
	public java.lang.Integer getSide(){
		return this.side;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  按钮位置
	 */
	public void setSide(java.lang.Integer side){
		this.side = side;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  叶子
	 */
	@Column(name ="[state]",nullable=true,scale=0)
	public java.lang.Integer getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  叶子
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="[order]",nullable=true,scale=0)
	public java.lang.Integer getOrder(){
		return this.order;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setOrder(java.lang.Integer order){
		this.order = order;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
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
