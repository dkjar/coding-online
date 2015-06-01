package com.dragon.codingol.service.system;

import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.service.CommonService;

public interface SystemService extends CommonService {
	public SystemEntity getEnableSystemEntity();
}
