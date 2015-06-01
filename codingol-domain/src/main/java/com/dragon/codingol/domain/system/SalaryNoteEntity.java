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
 * @Description: 导入日志
 * @author dx
 * @date 2014-10-18 09:40:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "salary_note", schema = "")
public class SalaryNoteEntity  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2042151614107469770L;
	private String id;
	/**月份*/
	@Valiform(title = "月份", notNull = true)
	private java.util.Date month;
	/**departid*/
	@Valiform(title = "departid",  notNull = true)
	private java.lang.String departid;
	/**机构名称*/
	@Valiform(title = "机构名称",  notNull = true)
	private java.lang.String departname;
	/*导入内容*/
	private java.lang.String title;
	/**employeeid*/
	private java.lang.String employeeid;
	/**导入人员*/
	private java.lang.String name;
	/**工号*/
	@Valiform(title = "工号",  notNull = true)
	private java.lang.String number;
	/**导入文件*/
	@Valiform(title = "导入文件",  notNull = true)
	private java.lang.String url;
	/**状态*/
	private java.lang.Integer status;
	/**导入时间*/
	private java.util.Date updatedate;
	
	public SalaryNoteEntity(){
		status = 1;
	}
	
	@Id
    @GeneratedValue(generator="hibernate-uuid") 
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")   
	@Column(name ="id", unique = true, nullable=false,length=64)
    public String getId() {
        return id;
    }
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  月份
	 */
	@Column(name ="[MONTH]",nullable=true,precision=10,scale=0,length=3)
	public java.util.Date getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  月份
	 */
	public void setMonth(java.util.Date month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departid
	 */
	@Column(name ="[DEPARTID]",nullable=true,precision=50,length=50)
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
	 *@return: java.lang.String  机构名称
	 */
	@Column(name ="[DEPARTNAME]",nullable=true,precision=100,length=100)
	public java.lang.String getDepartname(){
		return this.departname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  机构名称
	 */
	public void setDepartname(java.lang.String departname){
		this.departname = departname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  employeeid
	 */
	@Column(name ="[EMPLOYEEID]",nullable=true,precision=50,length=50)
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
	 *@return: java.lang.String  导入人员
	 */
	@Column(name ="[NAME]",nullable=true,precision=100,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入人员
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工号
	 */
	@Column(name ="[NUMBER]",nullable=true,precision=50,length=50)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工号
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导入文件
	 */
	@Column(name ="[URL]",nullable=true,precision=100,length=100)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入文件
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="[STATUS]",nullable=true,precision=10,scale=0,length=4)
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
	 *@return: java.util.Date  导入时间
	 */
	@Column(name ="[UPDATEDATE]",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getUpdatedate(){
		return this.updatedate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  导入时间
	 */
	public void setUpdatedate(java.util.Date updatedate){
		this.updatedate = updatedate;
	}
	

	@Column(name ="[title]",nullable=true,precision=100,length=100)
	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
 
	
}
