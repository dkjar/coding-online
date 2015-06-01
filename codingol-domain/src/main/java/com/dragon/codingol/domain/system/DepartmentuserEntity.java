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
 * @Description: 用户管理部门
 * @author dx
 * @date 2015-05-10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_department_user", schema = "")
@SuppressWarnings("serial")
public class DepartmentuserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**departid*/
	@Valiform(title = "departid", notNull = true)
	private java.lang.String departid;
	/**userid*/
	@Valiform(title = "userid", notNull = true)
	private java.lang.String userid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@Column(name ="[id]",nullable=false,precision=64,length=64)
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
	 *@return: java.lang.String  departid
	 */
	@RelativeTable(table="sys_department")
	@Column(name ="[departid]",nullable=false,precision=60,length=60)
	public java.lang.String getDepartid(){
		return this.departid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departid
	 */
	public void setDepartid(java.lang.String departid){
		this.departid = departid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userid
	 */
	@RelativeTable(table="sys_user")
	@Column(name ="[userid]",nullable=false,precision=60,length=60)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  userid
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
}
