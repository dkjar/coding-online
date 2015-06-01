package com.dragon.codingol.service.system;

import java.util.List;

import com.dragon.codingol.domain.system.FunctionbuttonEntity;
import com.dragon.codingol.service.CommonService;

/**   
 * @Title: Entity
 * @Description: 菜单功能管理
 * @author dx
 * @date 1,432,196,980,338
 * @version V1.0   
 *
 */
public interface FunctionbuttonService extends CommonService{
	
	public List<FunctionbuttonEntity> getFunctionbuttons(String functionid);
	
}
