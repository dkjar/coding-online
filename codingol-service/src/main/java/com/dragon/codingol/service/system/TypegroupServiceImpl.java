package com.dragon.codingol.service.system;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.CommonServiceImpl;

@Service("typegroupService")
@Transactional(rollbackFor=Exception.class)
public class TypegroupServiceImpl extends CommonServiceImpl implements TypegroupService {
	 
	public TypegroupServiceImpl(){
		iscache = true;
		key = this.getClass().getName();
	}
	
}