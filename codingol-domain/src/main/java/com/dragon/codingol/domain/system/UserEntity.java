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
 * @Description: 系统用户
 * @author dx
 * @date 2015-05-10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_user", schema = "")
@SuppressWarnings("serial")
public class UserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**departmentid*/
	@Valiform(title = "departmentid", notNull = true)
	private java.lang.String departmentid;
	/**部门名称*/
	@Valiform(title = "部门名称", notNull = true)
	private java.lang.String departmentname;
	/**employeeid*/
	private java.lang.String employeeid;
	/**真实姓名*/
	private java.lang.String realname;
	/**姓名*/
	private java.lang.String name;
	/**编号*/
	@Valiform(title = "编号", notNull = true)
	private java.lang.String number;
	/**email*/
	private java.lang.String email;
	/**电话号码*/
	private java.lang.String telephone;
	/**身份证号*/
	private java.lang.String idc;
	/**QQ*/
	private java.lang.String qq;
	/**password*/
	private java.lang.String password;
	/**状态*/
	private java.lang.Integer status;
	/**创建时间*/
	private java.util.Date createdate;
	/**性别*/
	@Dictionary(name="sex")
	private java.lang.Integer sex;
	
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
	 *@return: java.lang.String  departmentid
	 */
	@Column(name ="[departmentid]",nullable=false,precision=60,length=60)
	public java.lang.String getDepartmentid(){
		return this.departmentid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departmentid
	 */
	public void setDepartmentid(java.lang.String departmentid){
		this.departmentid = departmentid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门名称
	 */
	@Column(name ="[departmentname]",nullable=false,precision=100,length=100)
	public java.lang.String getDepartmentname(){
		return this.departmentname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门名称
	 */
	public void setDepartmentname(java.lang.String departmentname){
		this.departmentname = departmentname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  employeeid
	 */
	@Column(name ="[employeeid]",nullable=true,precision=60,length=60)
	public java.lang.String getEmployeeid(){
		return this.employeeid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  employeeid
	 */
	public void setEmployeeid(java.lang.String employeeid){
		this.employeeid = employeeid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="[realname]",nullable=true,precision=100,length=100)
	public java.lang.String getRealname(){
		return this.realname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setRealname(java.lang.String realname){
		this.realname = realname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="[name]",nullable=true,precision=50,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	@Column(name ="[number]",nullable=false,precision=50,length=50)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  email
	 */
	@Column(name ="[email]",nullable=true,precision=50,length=50)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  email
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话号码
	 */
	@Column(name ="[telephone]",nullable=true,precision=50,length=50)
	public java.lang.String getTelephone(){
		return this.telephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话号码
	 */
	public void setTelephone(java.lang.String telephone){
		this.telephone = telephone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="[idc]",nullable=true,precision=50,length=50)
	public java.lang.String getIdc(){
		return this.idc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdc(java.lang.String idc){
		this.idc = idc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ
	 */
	@Column(name ="[qq]",nullable=true,precision=50,length=50)
	public java.lang.String getQq(){
		return this.qq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ
	 */
	public void setQq(java.lang.String qq){
		this.qq = qq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  password
	 */
	@Column(name ="[password]",nullable=true,precision=50,length=50)
	public java.lang.String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  password
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="[status]",nullable=true,precision=11,length=11)
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  性别
	 */
	@Column(name ="[sex]",nullable=true,precision=11,length=11)
	public java.lang.Integer getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  性别
	 */
	public void setSex(java.lang.Integer sex){
		this.sex = sex;
	}
}
