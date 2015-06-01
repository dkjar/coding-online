package com.dragon.codingol.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.dragon.codingol.domain.base.Valiform;
/**   
 * @Title: Entity
 * @Description: 字典分类管理
 * @author dx
 * @date 1,429,769,666,078
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_typegroup", schema = "")
@SuppressWarnings("serial")
public class TypegroupEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**分类名称*/
	@Valiform(title = "分类名称", notNull = true)
	private java.lang.String groupname;
	/**分类编码*/
	@Valiform(title = "分类编码", notNull = true)
	private java.lang.String groupcode;
	/**排序*/
	private java.lang.Integer order;
	/**状态*/
	@Valiform(title = "状态", notNull = true)
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
	 *@return: java.lang.String  分类名称
	 */
	@Column(name ="[groupname]",nullable=false,length=100)
	public java.lang.String getGroupname(){
		return this.groupname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类名称
	 */
	public void setGroupname(java.lang.String groupname){
		this.groupname = groupname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类编码
	 */
	@Column(name ="[groupcode]",nullable=false,length=100)
	public java.lang.String getGroupcode(){
		return this.groupcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类编码
	 */
	public void setGroupcode(java.lang.String groupcode){
		this.groupcode = groupcode;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="[status]",nullable=false,precision=10,scale=0)
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
