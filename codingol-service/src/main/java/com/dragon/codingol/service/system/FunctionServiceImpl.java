package com.dragon.codingol.service.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.codingol.service.system.FunctionService;
import com.dragon.codingol.service.CommonServiceImpl;

@Service("functionService")
@Transactional(rollbackFor=Exception.class)
public class FunctionServiceImpl extends CommonServiceImpl implements FunctionService {
 	
}