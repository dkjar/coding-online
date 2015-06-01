package com.dragon.codingol.domain.admin;

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
 * @Description: 系统数据表
 * @author dx
 * @date 2015-05-18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_table", schema = "")
@SuppressWarnings("serial")
public class TableEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**父id*/
	private java.lang.String pid;
	/**上级菜单*/
	private java.lang.String parentname;
	/**模块名称*/
	private java.lang.String name;
	/**模块编码*/
	private java.lang.String code;
	/**所有父模块代码*/
	private java.lang.String codedir;
	/**数据表名*/
	private java.lang.String tablename;
	/**数据实体名*/
	private java.lang.String entityname;
	/**编辑页面列数*/
	private java.lang.Integer colcount;
	/**显示顺序*/
	private java.lang.Integer tableorder;
	/**叶子*/
	@Dictionary(name="treestate")
	private java.lang.Integer state;
	/**是否缓存*/
	@Valiform(title = "是否缓存", notNull = true)
	@Dictionary(name="yes")
	private java.lang.Integer iscache;
	/**同步菜单*/
	@Dictionary(name="yes")
	private java.lang.Integer isfunsync;
	/**单选*/
	@Dictionary(name="yes")
	private java.lang.Integer singleselect;
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
	@Column(name ="[pid]",nullable=true,precision=60,length=60)
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
	 *@return: java.lang.String  上级菜单
	 */
	@Column(name ="[parentname]",nullable=true,precision=100,length=100)
	public java.lang.String getParentname(){
		return this.parentname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上级菜单
	 */
	public void setParentname(java.lang.String parentname){
		this.parentname = parentname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模块名称
	 */
	@Column(name ="[name]",nullable=true,precision=100,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模块名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模块编码
	 */
	@Column(name ="[code]",nullable=true,precision=100,length=100)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模块编码
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所有父模块代码
	 */
	@Column(name ="[codedir]",nullable=true,precision=500,length=500)
	public java.lang.String getCodedir(){
		return this.codedir;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所有父模块代码
	 */
	public void setCodedir(java.lang.String codedir){
		this.codedir = codedir;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据表名
	 */
	@Column(name ="[tablename]",nullable=true,precision=100,length=100)
	public java.lang.String getTablename(){
		return this.tablename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据表名
	 */
	public void setTablename(java.lang.String tablename){
		this.tablename = tablename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据实体名
	 */
	@Column(name ="[entityname]",nullable=true,precision=100,length=100)
	public java.lang.String getEntityname(){
		return this.entityname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据实体名
	 */
	public void setEntityname(java.lang.String entityname){
		this.entityname = entityname;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编辑页面列数
	 */
	@Column(name ="[colcount]",nullable=true,scale=0)
	public java.lang.Integer getColcount(){
		return this.colcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编辑页面列数
	 */
	public void setColcount(java.lang.Integer colcount){
		this.colcount = colcount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  显示顺序
	 */
	@Column(name ="[tableorder]",nullable=true,scale=0)
	public java.lang.Integer getTableorder(){
		return this.tableorder;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  显示顺序
	 */
	public void setTableorder(java.lang.Integer tableorder){
		this.tableorder = tableorder;
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
	 *@return: java.lang.Integer  是否缓存
	 */
	@Column(name ="[iscache]",nullable=false,scale=0)
	public java.lang.Integer getIscache(){
		return this.iscache;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否缓存
	 */
	public void setIscache(java.lang.Integer iscache){
		this.iscache = iscache;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  同步菜单
	 */
	@Column(name ="[isfunsync]",nullable=true,scale=0)
	public java.lang.Integer getIsfunsync(){
		return this.isfunsync;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  同步菜单
	 */
	public void setIsfunsync(java.lang.Integer isfunsync){
		this.isfunsync = isfunsync;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  单选
	 */
	@Column(name ="[singleselect]",nullable=true,scale=0)
	public java.lang.Integer getSingleselect(){
		return this.singleselect;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  单选
	 */
	public void setSingleselect(java.lang.Integer singleselect){
		this.singleselect = singleselect;
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
