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
 * @Description: 系统数据列
 * @author dx
 * @date 2015-05-18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_fields", schema = "")
@SuppressWarnings("serial")
public class FieldsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**数据表ID*/
	@Valiform(title = "数据表ID", notNull = true)
	private java.lang.String tableid;
	/**列名*/
	@Valiform(title = "列名", notNull = true)
	private java.lang.String columnname;
	/**列编码*/
	private java.lang.String columncode;
	/**数据类型ID*/
	@Valiform(title = "数据类型ID", notNull = true)
	private java.lang.String datatypeid;
	/**数据类型*/
	@Valiform(title = "数据类型", notNull = true)
	private java.lang.String datatype;
	/**默认值*/
	private java.lang.String defaultvalue;
	/**字典分类*/
	private java.lang.String diccode;
	/**外键*/
	private java.lang.String foreignid;
	/**数据表名*/
	private java.lang.String tablecode;
	/**列长度*/
	private java.lang.Integer columnlength;
	/**保留位数*/
	private java.lang.Integer scale;
	/**列表页显示*/
	@Dictionary(name="yes")
	private java.lang.Integer islist;
	/**可查询*/
	@Dictionary(name="yes")
	private java.lang.Integer isquery;
	/**树型表操作列*/
	@Dictionary(name="yes")
	private java.lang.Integer istreefield;
	/**不能重复*/
	@Dictionary(name="yes")
	private java.lang.Integer isunique;
	/**允许为空*/
	@Dictionary(name="yes")
	private java.lang.Integer isnullable;
	/**显示*/
	@Valiform(title = "显示", notNull = true)
	@Dictionary(name="yes")
	private java.lang.Integer visiable;
	/**输入框类型*/
	@Valiform(title = "输入框类型", notNull = true)
	@Dictionary(name="input")
	private java.lang.Integer inputtype;
	/**顺序*/
	private java.lang.Integer order;
	/**状态*/
	private java.lang.Integer status;
	/**创建时间*/
	private java.util.Date createdate;
	/**映射关系*/
	private java.lang.String maps;
	
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
	 *@return: java.lang.String  数据表ID
	 */
	@RelativeTable(table="sys_table")
	@Column(name ="[tableid]",nullable=false,precision=60,length=60)
	public java.lang.String getTableid(){
		return this.tableid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据表ID
	 */
	public void setTableid(java.lang.String tableid){
		this.tableid = tableid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  列名
	 */
	@Column(name ="[columnname]",nullable=false,precision=100,length=100)
	public java.lang.String getColumnname(){
		return this.columnname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  列名
	 */
	public void setColumnname(java.lang.String columnname){
		this.columnname = columnname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  列编码
	 */
	@Column(name ="[columncode]",nullable=true,precision=100,length=100)
	public java.lang.String getColumncode(){
		return this.columncode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  列编码
	 */
	public void setColumncode(java.lang.String columncode){
		this.columncode = columncode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据类型ID
	 */
	@Column(name ="[datatypeid]",nullable=false,precision=60,length=60)
	public java.lang.String getDatatypeid(){
		return this.datatypeid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据类型ID
	 */
	public void setDatatypeid(java.lang.String datatypeid){
		this.datatypeid = datatypeid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据类型
	 */
	@Column(name ="[datatype]",nullable=false,precision=100,length=100)
	public java.lang.String getDatatype(){
		return this.datatype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据类型
	 */
	public void setDatatype(java.lang.String datatype){
		this.datatype = datatype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  默认值
	 */
	@Column(name ="[defaultvalue]",nullable=true,precision=50,length=50)
	public java.lang.String getDefaultvalue(){
		return this.defaultvalue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  默认值
	 */
	public void setDefaultvalue(java.lang.String defaultvalue){
		this.defaultvalue = defaultvalue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字典分类
	 */
	@Column(name ="[diccode]",nullable=true,precision=50,length=50)
	public java.lang.String getDiccode(){
		return this.diccode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字典分类
	 */
	public void setDiccode(java.lang.String diccode){
		this.diccode = diccode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键
	 */
	@Column(name ="[foreignid]",nullable=true,precision=100,length=100)
	public java.lang.String getForeignid(){
		return this.foreignid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setForeignid(java.lang.String foreignid){
		this.foreignid = foreignid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据表名
	 */
	@Column(name ="[tablecode]",nullable=true,precision=50,length=50)
	public java.lang.String getTablecode(){
		return this.tablecode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据表名
	 */
	public void setTablecode(java.lang.String tablecode){
		this.tablecode = tablecode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  列长度
	 */
	@Column(name ="[columnlength]",nullable=true,scale=0)
	public java.lang.Integer getColumnlength(){
		return this.columnlength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  列长度
	 */
	public void setColumnlength(java.lang.Integer columnlength){
		this.columnlength = columnlength;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  保留位数
	 */
	@Column(name ="[scale]",nullable=true,scale=0)
	public java.lang.Integer getScale(){
		return this.scale;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  保留位数
	 */
	public void setScale(java.lang.Integer scale){
		this.scale = scale;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  列表页显示
	 */
	@Column(name ="[islist]",nullable=true,scale=0)
	public java.lang.Integer getIslist(){
		return this.islist;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  列表页显示
	 */
	public void setIslist(java.lang.Integer islist){
		this.islist = islist;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  可查询
	 */
	@Column(name ="[isquery]",nullable=true,scale=0)
	public java.lang.Integer getIsquery(){
		return this.isquery;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  可查询
	 */
	public void setIsquery(java.lang.Integer isquery){
		this.isquery = isquery;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  树型表操作列
	 */
	@Column(name ="[istreefield]",nullable=true,scale=0)
	public java.lang.Integer getIstreefield(){
		return this.istreefield;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  树型表操作列
	 */
	public void setIstreefield(java.lang.Integer istreefield){
		this.istreefield = istreefield;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  不能重复
	 */
	@Column(name ="[isunique]",nullable=true,scale=0)
	public java.lang.Integer getIsunique(){
		return this.isunique;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  不能重复
	 */
	public void setIsunique(java.lang.Integer isunique){
		this.isunique = isunique;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  允许为空
	 */
	@Column(name ="[isnullable]",nullable=true,scale=0)
	public java.lang.Integer getIsnullable(){
		return this.isnullable;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  允许为空
	 */
	public void setIsnullable(java.lang.Integer isnullable){
		this.isnullable = isnullable;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  显示
	 */
	@Column(name ="[visiable]",nullable=false,scale=0)
	public java.lang.Integer getVisiable(){
		return this.visiable;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  显示
	 */
	public void setVisiable(java.lang.Integer visiable){
		this.visiable = visiable;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  输入框类型
	 */
	@Column(name ="[inputtype]",nullable=false,scale=0)
	public java.lang.Integer getInputtype(){
		return this.inputtype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  输入框类型
	 */
	public void setInputtype(java.lang.Integer inputtype){
		this.inputtype = inputtype;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  映射关系
	 */
	@Column(name ="[maps]",nullable=true,precision=65535,length=65535)
	public java.lang.String getMaps(){
		return this.maps;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  映射关系
	 */
	public void setMaps(java.lang.String maps){
		this.maps = maps;
	}
}
