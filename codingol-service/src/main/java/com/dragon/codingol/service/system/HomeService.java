package com.dragon.codingol.service.system;

import java.util.List;

import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.UserEntity;
import com.dragon.codingol.service.CommonService;

public interface HomeService extends CommonService {
	
	public UserEntity checkUserExits(UserEntity user);
	
	public List<RoleEntity> getRoleByUser(String userid);
	
	public List<FunctionEntity> getFunctionByUser(String userid);
}
