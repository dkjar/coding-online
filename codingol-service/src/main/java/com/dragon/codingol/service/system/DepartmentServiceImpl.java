package com.dragon.codingol.service.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.system.DepartmentService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("departmentService")
@Transactional(rollbackFor=Exception.class)
public class DepartmentServiceImpl extends CommonServiceImpl implements DepartmentService {
 	
}