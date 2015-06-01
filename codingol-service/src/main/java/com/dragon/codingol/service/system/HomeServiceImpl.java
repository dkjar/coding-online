package com.dragon.codingol.service.system;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.common.util.PasswordUtil;
import com.dragon.codingol.domain.system.FunctionEntity;
import com.dragon.codingol.domain.system.RoleEntity;
import com.dragon.codingol.domain.system.UserEntity;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("homeService")
@Transactional(rollbackFor = Exception.class)
public class HomeServiceImpl extends CommonServiceImpl implements HomeService {
	
	/**
	 * 用户登陆
	 */
	public UserEntity checkUserExits(UserEntity user) {
		String password = PasswordUtil.encrypt(user.getNumber(), user.getPassword(), PasswordUtil.getStaticSalt());
		List<UserEntity> users = this.genericCommonDao.findEffectiveByProperty(UserEntity.class, "number", user.getNumber());
		if (users != null && users.size() == 1) {
			if(users.get(0).getPassword().equals(password)){
				return users.get(0);
			}
		}
		return null;
	}
	
	public List<RoleEntity> getRoleByUser(String userid){
		String sql = "select * from sys_role r where exists(select 1 from sys_role_user u where r.id = u.roleid and u.userid = ? )";
		
		return this.findListbySql(RoleEntity.class, sql, userid);
	}
	
	
	public List<FunctionEntity> getFunctionByUser(String userid){
		String sql  = " select distinct f.* from sys_function f "+
				" inner join sys_role_function rf on f.id = rf.functionid "+
				" inner join sys_role_user ru on rf.roleid = ru.roleid "+
				" where ru.userid = ? order by `order` ";
		
		return this.findListbySql(FunctionEntity.class, sql, userid);
		
	}
}
