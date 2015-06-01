package com.dragon.codingol.service.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.admin.FieldsTypeService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("fieldsTypeService")
@Transactional(rollbackFor=Exception.class)
public class FieldsTypeServiceImpl extends CommonServiceImpl implements FieldsTypeService {
 	
}