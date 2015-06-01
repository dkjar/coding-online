package ${packageName}.${projectName}.service.${parentMenu};

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${packageName}.${projectName}.service.${parentMenu}.${entityName?cap_first}Service;
import ${packageName}.${projectName}.service.CommonServiceImpl;

@Service("${entityName?uncap_first}Service")
@Transactional(rollbackFor=Exception.class)
public class ${entityName?cap_first}ServiceImpl extends CommonServiceImpl implements ${entityName?cap_first}Service {
 	
}