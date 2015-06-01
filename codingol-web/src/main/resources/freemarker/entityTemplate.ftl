package ${packageName}.${projectName}.domain.${parentMenu};

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

import ${packageName}.${projectName}.domain.base.Dictionary;
import ${packageName}.${projectName}.domain.base.Valiform;

import ${packageName}.${projectName}.domain.base.RelativeTable;
/**   
 * @Title: Entity
 * @Description: ${description}
 * @author dx
 * @date ${createTime}
 * @version V1.0   
 *
 */
@Entity
@Table(name = "${tableName}", schema = "")
@SuppressWarnings("serial")
public class ${entityName?cap_first}Entity implements java.io.Serializable {
	<#list columns as po>
	/**${po.columnname}*/
	<#if po.isnullable  == 0>
	<#if po.columncode?? && po.columncode !="id" >
	@Valiform(title = "${po.columnname}", notNull = true)
	</#if>
	</#if>
	<#if po.diccode??>
	@Dictionary(name="${po.diccode}")
	</#if>
	private ${po.datatype} ${po.columncode};
	</#list>
	
	<#list columns as po>
	/**
	 *方法: 取得${po.datatype}
	 *@return: ${po.datatype}  ${po.columnname}
	 */
	<#if po.columncode == tablePrimaryName>
	
	<#if keyPolicy == 'uuid'>
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	</#if>
	<#if keyPolicy == 'identity'>
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	</#if>
	<#if keyPolicy == 'sequence'>
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="${sequenceCode}",allocationSize=1)
	</#if>
	</#if>
	<#if po.tablecode?? && po.inputtype?? && po.inputtype == 1>
	@RelativeTable(table="${po.tablecode}")
	</#if>
	@Column(name ="[${po.columncode}]",nullable=<#if po.isnullable == 1>true<#else>false</#if><#if po.columnlength??>,precision=${po.columnlength?c}</#if><#if po.scale??>,scale=${po.scale?c}</#if><#if po.columnlength??>,length=${po.columnlength?c}</#if>)
	public ${po.datatype} get${po.columncode?cap_first}(){
		return this.${po.columncode};
	}

	/**
	 *方法: 设置${po.datatype}
	 *@param: ${po.datatype}  ${po.columnname}
	 */
	public void set${po.columncode?cap_first}(${po.datatype} ${po.columncode}){
		this.${po.columncode} = ${po.columncode};
	}
	</#list>
}
