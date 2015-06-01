package com.dragon.codingol.service.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.admin.FieldsService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("fieldsService")
@Transactional(rollbackFor=Exception.class)
public class FieldsServiceImpl extends CommonServiceImpl implements FieldsService {
 	
}