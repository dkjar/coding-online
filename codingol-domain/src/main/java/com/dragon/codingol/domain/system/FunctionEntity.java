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
 * @Description: 系统菜单
 * @author dx
 * @date 2015-05-16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_function", schema = "")
@SuppressWarnings("serial")
public class FunctionEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**pid*/
	private java.lang.String pid;
	/**tableid*/
	private java.lang.String tableid;
	/**菜单名称*/
	@Valiform(title = "菜单名称", notNull = true)
	private java.lang.String name;
	/**菜单路径*/
	private java.lang.String functionurl;
	/**导航图标*/
	private java.lang.String navicon;
	/**菜单图标*/
	private java.lang.String icon;
	/**叶子*/
	@Dictionary(name="treestate")
	private java.lang.Integer state;
	/**顺序*/
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
	 *@return: java.lang.String  tableid
	 */
	@Column(name ="[tableid]",nullable=true,precision=60,length=60)
	public java.lang.String getTableid(){
		return this.tableid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  tableid
	 */
	public void setTableid(java.lang.String tableid){
		this.tableid = tableid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜单名称
	 */
	@Column(name ="[name]",nullable=false,precision=50,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜单名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜单路径
	 */
	@Column(name ="[functionurl]",nullable=true,precision=100,length=100)
	public java.lang.String getFunctionurl(){
		return this.functionurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜单路径
	 */
	public void setFunctionurl(java.lang.String functionurl){
		this.functionurl = functionurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导航图标
	 */
	@Column(name ="[navicon]",nullable=true,precision=100,length=100)
	public java.lang.String getNavicon(){
		return this.navicon;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导航图标
	 */
	public void setNavicon(java.lang.String navicon){
		this.navicon = navicon;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜单图标
	 */
	@Column(name ="[icon]",nullable=true,precision=100,length=100)
	public java.lang.String getIcon(){
		return this.icon;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜单图标
	 */
	public void setIcon(java.lang.String icon){
		this.icon = icon;
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
	 *@return: java.lang.Integer  顺序
	 */
	@Column(name ="[order]",nullable=true,scale=0)
	public java.lang.Integer getOrder(){
		return this.order;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  顺序
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
