package com.dragon.codingol.service.system;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.domain.system.TypeEntity;
import com.dragon.codingol.domain.system.TypegroupEntity;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("typeService")
@Transactional(rollbackFor=Exception.class)
public class TypeServiceImpl extends CommonServiceImpl implements TypeService {
 	
	 
	public TypeServiceImpl(){
		iscache = true;
		key = this.getClass().getName();
	}
	
	public void getType(String groupid, String code){
		 
	}
}