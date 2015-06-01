package com.dragon.codingol.service.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.admin.TablemapService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("tablemapService")
@Transactional(rollbackFor=Exception.class)
public class TablemapServiceImpl extends CommonServiceImpl implements TablemapService {
 	
}