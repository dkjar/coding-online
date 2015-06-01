package com.dragon.codingol.service.system;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.common.util.ResourceUtil;
import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.domain.system.UserEntity;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("functionbuttonService")
@Transactional(rollbackFor=Exception.class)
public class FunctionbuttonServiceImpl extends CommonServiceImpl implements FunctionbuttonService {
	
	public List<FunctionbuttonEntity> getFunctionbuttons(String functionid){
		UserEntity user = ResourceUtil.getSessionUserName();
		String sql  = "  select distinct fb.* from sys_function_button fb "+
				" inner join sys_role_function_button rb on fb.id = rb.fbuttonid "+
				" inner join sys_role_function rf on rb.rfunctionid = rf.id and fb.functionid = rf.functionid " +
				" inner join sys_role_user ru on rf.roleid = ru.roleid "+
				" where rf.functionid = ? and ru.userid = ? ";
		 
		return this.genericCommonDao.findListbySql(FunctionbuttonEntity.class, sql, functionid, user.getId());
	}
}