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
 * @Description: 组织机构
 * @author dx
 * @date 2015-05-18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_department", schema = "")
@SuppressWarnings("serial")
public class DepartmentEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**父id*/
	private java.lang.String pid;
	/**上级部门*/
	private java.lang.String parentname;
	/**部门名称*/
	@Valiform(title = "部门名称", notNull = true)
	private java.lang.String name;
	/**描述*/
	private java.lang.String deptdesc;
	/**dir*/
	private java.lang.String deptdir;
	/**图标*/
	private java.lang.String depticon;
	/**叶子*/
	@Dictionary(name="treestate")
	private java.lang.Integer state;
	/**level*/
	private java.lang.Integer level;
	/**部门状态*/
	private java.lang.Integer deptstate;
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
	 *@return: java.lang.String  父id
	 */
	@Column(name ="[pid]",nullable=true,precision=50,length=50)
	public java.lang.String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父id
	 */
	public void setPid(java.lang.String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上级部门
	 */
	@Column(name ="[parentname]",nullable=true,precision=100,length=100)
	public java.lang.String getParentname(){
		return this.parentname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上级部门
	 */
	public void setParentname(java.lang.String parentname){
		this.parentname = parentname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门名称
	 */
	@Column(name ="[name]",nullable=false,precision=100,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="[deptdesc]",nullable=true,precision=500,length=500)
	public java.lang.String getDeptdesc(){
		return this.deptdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDeptdesc(java.lang.String deptdesc){
		this.deptdesc = deptdesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  dir
	 */
	@Column(name ="[deptdir]",nullable=true,precision=1000,length=1000)
	public java.lang.String getDeptdir(){
		return this.deptdir;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  dir
	 */
	public void setDeptdir(java.lang.String deptdir){
		this.deptdir = deptdir;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标
	 */
	@Column(name ="[depticon]",nullable=true,precision=100,length=100)
	public java.lang.String getDepticon(){
		return this.depticon;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标
	 */
	public void setDepticon(java.lang.String depticon){
		this.depticon = depticon;
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
	 *@return: java.lang.Integer  level
	 */
	@Column(name ="[level]",nullable=true,scale=0)
	public java.lang.Integer getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  level
	 */
	public void setLevel(java.lang.Integer level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  部门状态
	 */
	@Column(name ="[deptstate]",nullable=true,scale=0)
	public java.lang.Integer getDeptstate(){
		return this.deptstate;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  部门状态
	 */
	public void setDeptstate(java.lang.Integer deptstate){
		this.deptstate = deptstate;
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
