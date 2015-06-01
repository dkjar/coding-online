package com.dragon.codingol.service.system;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("systemService")
@Transactional(rollbackFor = Exception.class)
public class SystemServiceImpl extends CommonServiceImpl implements SystemService {
	
	public SystemEntity getEnableSystemEntity() {
		List<SystemEntity> systems = this.loadAll(SystemEntity.class);
		return systems.get(0);
	}
}
