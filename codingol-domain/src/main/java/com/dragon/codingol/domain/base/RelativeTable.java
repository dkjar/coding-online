package com.dragon.codingol.domain.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RelativeTable {
	/**
	 * 一对多中，该属性对应的表
	 * @return
	 */
	String table();
	
	/**
	 * 该属性对应表的id,
	 * @return
	 */
	String id() default("id");
}
