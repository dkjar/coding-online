package com.dragon.codingol.common;

import com.dragon.codingol.domain.base.VlidateType;

public class ValidateExistsCommon {
	public static boolean validateExists(String type, String value){
		if(type.equals(VlidateType.DEPARTMENT)){
			return validateDepartment(value);
		}
		return true;
	}
	
	
	public static boolean validateDepartment(String value){
		return true;
	}
	
}
