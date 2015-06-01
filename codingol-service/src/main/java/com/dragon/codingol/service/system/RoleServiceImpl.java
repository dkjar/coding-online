package com.dragon.codingol.service.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.system.RoleService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("roleService")
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl extends CommonServiceImpl implements RoleService {
 	
}