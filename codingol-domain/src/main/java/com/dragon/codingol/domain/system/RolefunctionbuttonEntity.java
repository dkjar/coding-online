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
 * @Description: 菜单功能权限
 * @author dx
 * @date 2015-05-16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_role_function_button", schema = "")
@SuppressWarnings("serial")
public class RolefunctionbuttonEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**rfunctionid*/
	private java.lang.String rfunctionid;
	/**fbuttonid*/
	private java.lang.String fbuttonid;
	
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
	 *@return: java.lang.String  rfunctionid
	 */
	@RelativeTable(table="sys_role_function")
	@Column(name ="[rfunctionid]",nullable=true,precision=60,length=60)
	public java.lang.String getRfunctionid(){
		return this.rfunctionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  rfunctionid
	 */
	public void setRfunctionid(java.lang.String rfunctionid){
		this.rfunctionid = rfunctionid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fbuttonid
	 */
	@RelativeTable(table="sys_function_button")
	@Column(name ="[fbuttonid]",nullable=true,precision=60,length=60)
	public java.lang.String getFbuttonid(){
		return this.fbuttonid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fbuttonid
	 */
	public void setFbuttonid(java.lang.String fbuttonid){
		this.fbuttonid = fbuttonid;
	}
}
