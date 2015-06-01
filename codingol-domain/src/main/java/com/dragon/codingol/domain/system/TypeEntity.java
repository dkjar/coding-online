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

import com.dragon.codingol.domain.base.Valiform;
/**   
 * @Title: Entity
 * @Description: 字典信息
 * @author dx
 * @date 1,429,769,670,291
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_type", schema = "")
@SuppressWarnings("serial")
public class TypeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/***/
	@Valiform(title = "", notNull = true)
	private java.lang.String typegroupid;
	/**名称*/
	@Valiform(title = "名称", notNull = true)
	private java.lang.String name;
	/**编码*/
	@Valiform(title = "编码", notNull = true)
	private java.lang.String code;
	/**状态*/
	private java.lang.Integer status;
	/**排序*/
	private java.lang.Integer order;
	/**创建时间*/
	private java.util.Date createdate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@Column(name ="[id]",nullable=false,length=60)
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
	 *@return: java.lang.String  
	 */
	@Column(name ="[typegroupid]",nullable=false,length=60)
	public java.lang.String getTypegroupid(){
		return this.typegroupid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  
	 */
	public void setTypegroupid(java.lang.String typegroupid){
		this.typegroupid = typegroupid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="[name]",nullable=false,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编码
	 */
	@Column(name ="[code]",nullable=false,length=100)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编码
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="[status]",nullable=true,precision=10,scale=0)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="[order]",nullable=true,precision=10,scale=0)
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
