package com.dragon.codingol.domain.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dictionary {
	/**
	 * 字典名称 e.g: sex(1:man:0:female)
	 * @return
	 */
	String name();
}
