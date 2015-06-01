package com.dragon.codingol.domain.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Valiform {
	/**
	 * 不能为空
	 * 
	 * @return
	 */
	boolean notNull() default false;

	/**
	 * 验证日期格式
	 * 
	 * @return
	 */
	boolean isDate() default false;

	/**
	 * 验证身份证格式
	 * 
	 * @return
	 */
	boolean idCard() default false;

	/**
	 * 此属性的值唯一
	 * 
	 * @return
	 */
	boolean isUnique() default false;
	/**
	 * 一次导入不能重复
	 * @return
	 */
	boolean excelUnique() default false;
	/**
	 * 导入数据不能为空
	 * @return
	 */
	boolean importNotNull() default false;
	
	/**
	 * 验证导入科目是否存在
	 * @return
	 */
	String exists() default "";
	/**
	 * 验证导入月份，  一次只能导入一个月， 并且该月份设置为启用状态.
	 */
	boolean isUnmonth() default false;
	
	/**
	 * 属性名称
	 * 
	 * @return
	 */
	String title();
}
