package com.dragon.codingol.service.system;

import com.dragon.codingol.domain.system.IconEntity;
import com.dragon.codingol.service.CommonService;

/**   
 * @Title: Entity
 * @Description: 图标管理
 * @author dx
 * @date 1,431,663,819,424
 * @version V1.0   
 *
 */
public interface IconService extends CommonService{
	public void saveOrUpdate(IconEntity icon) throws Exception ;
}
