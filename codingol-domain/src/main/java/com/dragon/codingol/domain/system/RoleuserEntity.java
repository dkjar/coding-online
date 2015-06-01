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
 * @Description: 用户角色关系表
 * @author dx
 * @date 2015-05-09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_role_user", schema = "")
@SuppressWarnings("serial")
public class RoleuserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**roleid*/
	private java.lang.String roleid;
	/**userid*/
	private java.lang.String userid;
	
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
	 *@return: java.lang.String  roleid
	 */
	@RelativeTable(table="sys_role")
	@Column(name ="[roleid]",nullable=true,precision=60,length=60)
	public java.lang.String getRoleid(){
		return this.roleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  roleid
	 */
	public void setRoleid(java.lang.String roleid){
		this.roleid = roleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userid
	 */
	@RelativeTable(table="sys_user")
	@Column(name ="[userid]",nullable=true,precision=60,length=60)
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
