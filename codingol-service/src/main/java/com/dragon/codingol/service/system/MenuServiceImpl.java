package com.dragon.codingol.service.system;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.CommonServiceImpl;

@Service("menuService")
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends CommonServiceImpl implements MenuService{
	
}
