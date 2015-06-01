package com.dragon.codingol.service.system;

import com.dragon.codingol.service.CommonService;

/**   
 * @Title: Entity
 * @Description: 字典信息
 * @author dx
 * @date 1,429,769,670,322
 * @version V1.0   
 *
 */
public interface TypeService extends CommonService{
	
	void getType(String groupid, String code);
}
