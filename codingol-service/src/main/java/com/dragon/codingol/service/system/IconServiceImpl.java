package com.dragon.codingol.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.base.IconMaker;
import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.domain.system.IconEntity;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("iconService")
@Transactional(rollbackFor=Exception.class)
public class IconServiceImpl extends CommonServiceImpl implements IconService {
	@Autowired
	private SystemService systemService;
	
	public void saveOrUpdate(IconEntity icon) throws Exception {
		SystemEntity system = systemService.getEnableSystemEntity();
		IconMaker maker  = new IconMaker();
		if(StringUtils.isEmpty(icon.getId())){
			maker.addicon(system, icon);
		}else{
			String k = icon.getClass().getName()+icon.getId();
			Object old = redisClientTemplate.getObject(k);
			maker.addicon(system, (IconEntity)old, icon);
		}
		
		super.saveOrUpdate(icon);
	}
}