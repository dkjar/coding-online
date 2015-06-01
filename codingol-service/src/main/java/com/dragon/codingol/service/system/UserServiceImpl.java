package com.dragon.codingol.service.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.system.UserService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl extends CommonServiceImpl implements UserService {
 	
}