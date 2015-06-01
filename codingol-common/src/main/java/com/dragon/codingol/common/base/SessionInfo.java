package com.dragon.codingol.common.base;

import java.io.Serializable;
import java.util.List;

import com.dragon.codingol.domain.system.DepartmentEntity;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.UserEntity;
 
public class SessionInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4111114096574689797L;
	
	//当前图层显示状态 
 	private UserEntity user;
	private DepartmentEntity department; //当前部门
	private DepartmentEntity parentDepart; //当前用户上级部门
	private List<RoleEntity> roleList;
	private List<FunctionEntity> functionList;
	  
	public DepartmentEntity getParentDepart() {
		return parentDepart;
	}

	public void setParentDepart(DepartmentEntity parentDepart) {
		this.parentDepart = parentDepart;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<RoleEntity> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleEntity> roleList) {
		this.roleList = roleList;
	}

	public List<FunctionEntity> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<FunctionEntity> functionList) {
		this.functionList = functionList;
	}
	
}
