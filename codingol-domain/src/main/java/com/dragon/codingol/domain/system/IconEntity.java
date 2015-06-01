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
 * @Description: 图标管理
 * @author dx
 * @date 2015-05-15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_icon", schema = "")
@SuppressWarnings("serial")
public class IconEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**图标名称*/
	@Valiform(title = "图标名称", notNull = true)
	private java.lang.String name;
	/**图标路径*/
	@Valiform(title = "图标路径", notNull = true)
	private java.lang.String iconpath;
	/**图标样式*/
	@Valiform(title = "图标样式", notNull = true)
	private java.lang.String style;
	/**图标类型*/
	@Dictionary(name="icontype")
	private java.lang.Integer icontype;
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
	 *@return: java.lang.String  图标名称
	 */
	@Column(name ="[name]",nullable=false,precision=100,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标路径
	 */
	@Column(name ="[iconpath]",nullable=false,precision=500,length=500)
	public java.lang.String getIconpath(){
		return this.iconpath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标路径
	 */
	public void setIconpath(java.lang.String iconpath){
		this.iconpath = iconpath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标样式
	 */
	@Column(name ="[style]",nullable=false,precision=100,length=100)
	public java.lang.String getStyle(){
		return this.style;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标样式
	 */
	public void setStyle(java.lang.String style){
		this.style = style;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图标类型
	 */
	@Column(name ="[icontype]",nullable=true,scale=0)
	public java.lang.Integer getIcontype(){
		return this.icontype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  图标类型
	 */
	public void setIcontype(java.lang.Integer icontype){
		this.icontype = icontype;
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
