# Host: localhost  (Version: 5.5.40)
# Date: 2015-06-10 21:13:20
# Generator: MySQL-Front 5.3  (Build 4.205)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin_system"
#

DROP TABLE IF EXISTS `admin_system`;
CREATE TABLE `admin_system` (
  `id` varchar(64) NOT NULL,
  `CODE` varchar(50) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `packageName` varchar(200) DEFAULT NULL,
  `projectName` varchar(100) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `databaseName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "admin_system"
#

INSERT INTO `admin_system` VALUES ('1','ssms','codingol-web','com.dragon','codingol',1,'D:\\workspace\\java\\codingonline','codingol');

#
# Structure for table "salary_note"
#

DROP TABLE IF EXISTS `salary_note`;
CREATE TABLE `salary_note` (
  `id` varchar(64) NOT NULL,
  `DEPARTID` varchar(50) DEFAULT NULL,
  `DEPARTNAME` varchar(100) DEFAULT NULL,
  `EMPLOYEEID` varchar(50) DEFAULT NULL,
  `MONTH` datetime DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `NUMBER` varchar(50) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `UPDATEDATE` datetime DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "salary_note"
#


#
# Structure for table "sys_application"
#

DROP TABLE IF EXISTS `sys_application`;
CREATE TABLE `sys_application` (
  `id` varchar(255) NOT NULL,
  `APPICON` varchar(100) DEFAULT NULL,
  `APPNAME` varchar(50) DEFAULT NULL,
  `APPORDER` int(11) DEFAULT NULL,
  `apptype` int(11) DEFAULT NULL,
  `APPURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_application"
#

INSERT INTO `sys_application` VALUES ('1','1','代码管理',1,1,'1'),('402880844cc5eead014cc5f0440b0001',NULL,'系统管理',NULL,NULL,'e'),('402881e44cc769d5014cc7a8cc090001',NULL,'员工管理',NULL,NULL,'test');

#
# Structure for table "sys_department"
#

DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `pid` varchar(50) DEFAULT NULL COMMENT '父id',
  `parentname` varchar(100) DEFAULT NULL COMMENT '上级部门',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '部门名称',
  `deptdesc` varchar(500) DEFAULT NULL COMMENT '描述',
  `deptdir` varchar(1000) DEFAULT NULL COMMENT 'dir',
  `depticon` varchar(100) DEFAULT NULL COMMENT '图标',
  `state` int(11) DEFAULT NULL COMMENT '叶子',
  `level` int(11) DEFAULT NULL COMMENT 'level',
  `deptstate` int(11) DEFAULT NULL COMMENT '部门状态',
  `order` int(11) DEFAULT NULL COMMENT '顺序',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_department"
#

INSERT INTO `sys_department` VALUES ('402881e44d1a2f13014d1a3001430000',NULL,NULL,'成都分公司','',NULL,'',0,1,NULL,1,1,NULL),('402881e44d1a2f13014d1a32acee0001','402881e44d1a2f13014d1a3001430000',NULL,'武侯事业部','武侯事业部',NULL,'',1,2,NULL,1,1,NULL),('402881e44d57543a014d5797d8290001','402881e44d1a2f13014d1a3001430000',NULL,'双流事业部','双流事业部',NULL,'',0,2,NULL,NULL,1,'2015-05-15 20:41:18'),('402881e44d6231ef014d623b51e00001','402881e44d57543a014d5797d8290001','双流事业部','双流业务部','双流业务部',NULL,'',1,NULL,NULL,1,1,'2015-05-17 22:16:04');

#
# Structure for table "sys_department_user"
#

DROP TABLE IF EXISTS `sys_department_user`;
CREATE TABLE `sys_department_user` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT 'id',
  `departid` varchar(60) NOT NULL DEFAULT '' COMMENT 'departid',
  `userid` varchar(60) NOT NULL DEFAULT '' COMMENT 'userid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_department_user"
#

INSERT INTO `sys_department_user` VALUES ('402881e44d3d96e6014d3dfc55130003','402881e44d1a2f13014d1a32acee0001','1'),('402881e44d9a9bf7014d9ac26a6a0001','402881e44d57543a014d5797d8290001','1');

#
# Structure for table "sys_fields"
#

DROP TABLE IF EXISTS `sys_fields`;
CREATE TABLE `sys_fields` (
  `id` varchar(64) NOT NULL,
  `tableid` varchar(60) NOT NULL DEFAULT '' COMMENT '数据表ID',
  `columnname` varchar(100) NOT NULL DEFAULT '' COMMENT '列名',
  `columncode` varchar(100) DEFAULT '' COMMENT '列编码',
  `columnlength` int(11) DEFAULT NULL COMMENT '列长度',
  `datatypeid` varchar(60) NOT NULL DEFAULT '' COMMENT '数据类型ID',
  `datatype` varchar(100) NOT NULL DEFAULT '' COMMENT '数据类型',
  `scale` int(11) DEFAULT NULL COMMENT '保留位数',
  `defaultvalue` varchar(50) DEFAULT NULL COMMENT '默认值',
  `islist` int(11) DEFAULT NULL COMMENT '列表页显示',
  `isquery` int(11) DEFAULT NULL COMMENT '可查询',
  `istreefield` int(11) DEFAULT NULL COMMENT '树型表操作列',
  `isunique` int(11) DEFAULT NULL COMMENT '不能重复',
  `isnullable` int(11) DEFAULT NULL COMMENT '允许为空',
  `visiable` int(11) NOT NULL DEFAULT '1' COMMENT '显示',
  `inputtype` int(11) NOT NULL DEFAULT '1' COMMENT '输入框类型',
  `diccode` varchar(50) DEFAULT NULL COMMENT '字典分类',
  `foreignid` varchar(100) DEFAULT NULL COMMENT '外键',
  `tablecode` varchar(50) DEFAULT NULL COMMENT '数据表名',
  `maps` text COMMENT '映射关系',
  `order` int(11) DEFAULT NULL COMMENT '顺序',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_fields"
#

INSERT INTO `sys_fields` VALUES ('1','8','id','id',60,'1','varchar',NULL,NULL,0,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,NULL),('10','4','employeeid','employeeid',60,'1','varchar',NULL,'',0,0,0,0,1,0,1,'','','','',5,1,NULL),('11','4','真实姓名','realname',100,'1','varchar',NULL,NULL,1,1,0,0,1,1,1,NULL,NULL,NULL,NULL,6,1,NULL),('12','4','姓名','name',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,7,1,NULL),('13','4','编号','number',50,'1','varchar',NULL,NULL,1,1,0,0,0,1,1,NULL,NULL,NULL,NULL,8,1,NULL),('14','4','email','email',50,'1','varchar',NULL,NULL,0,0,0,0,1,1,1,NULL,NULL,NULL,NULL,9,1,NULL),('15','4','电话号码','telephone',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,10,1,NULL),('16','4','身份证号','idc',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,11,1,NULL),('17','4','QQ','qq',50,'1','varchar',NULL,NULL,0,0,0,0,1,1,1,NULL,NULL,NULL,NULL,12,1,NULL),('18','4','password','password',50,'1','varchar',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,13,1,NULL),('19','4','状态','status',11,'2','int',NULL,'1',0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,14,1,NULL),('2','8','typegoupid','typegroupid',60,'1','varchar',NULL,NULL,NULL,0,0,0,0,1,1,NULL,NULL,NULL,NULL,2,1,NULL),('20','4','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,15,1,NULL),('21','4','性别','sex',11,'2','int',NULL,NULL,1,0,0,0,1,1,2,'sex',NULL,NULL,'',16,1,NULL),('3','8','名称','name',100,'1','varchar',NULL,NULL,NULL,1,0,0,0,1,1,NULL,NULL,NULL,NULL,3,1,NULL),('4','8','编码','code',100,'1','varchar',NULL,NULL,NULL,1,0,0,0,1,1,NULL,NULL,NULL,NULL,4,1,NULL),('402880844d31fb69014d322292c70002','402880844d31fb69014d321802390001','id','id',64,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-08 14:07:16'),('402880844d31fb69014d322292c70003','402880844d31fb69014d321802390001','角色编码','rolecode',50,'1','varchar',NULL,NULL,1,1,0,0,0,1,1,NULL,NULL,NULL,NULL,2,1,'2015-05-08 14:07:16'),('402880844d31fb69014d322292c70004','402880844d31fb69014d321802390001','角色名称','rolename',100,'1','varchar',NULL,NULL,1,1,0,0,0,1,1,NULL,NULL,NULL,NULL,3,1,'2015-05-08 14:07:16'),('402880844d31fb69014d322292d60005','402880844d31fb69014d321802390001','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,4,1,'2015-05-08 14:07:16'),('402880844d31fb69014d322292d60006','402880844d31fb69014d321802390001','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,5,1,'2015-05-08 14:07:16'),('402880844d56753c014d568b304e0000','15','pid','pid',60,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,NULL,NULL,2,1,'2015-05-15 15:47:52'),('402880844d56753c014d568b309c0001','15','叶子','state',NULL,'2','int',0,NULL,2,0,0,0,1,2,1,NULL,NULL,NULL,NULL,10,1,'2015-05-15 15:47:52'),('402880844d56753c014d568d45a20002','15','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-15 15:50:08'),('402880844d569145014d56b8039b0000','9','叶子','state',NULL,'2','int',0,NULL,2,0,0,0,1,2,2,'treestate',NULL,NULL,NULL,8,1,'2015-05-15 16:36:49'),('402880844d65be40014d65e2b6870000','3','上级菜单','parentname',100,'1','varchar',NULL,NULL,0,0,0,0,1,1,3,NULL,'pid','sys_table','pid:id,parentname:name',3,1,'2015-05-18 15:17:46'),('402880844d6ffadc014d701b02c10005','402880844d6ffadc014d701a54320004','id','id',64,'1','varchar',NULL,NULL,2,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,'2015-05-20 14:55:27'),('402880844d6ffadc014d701b02cb0006','402880844d6ffadc014d701a54320004','别名','alias',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,2,1,'2015-05-20 14:55:27'),('402880844d6ffadc014d701b02cb0007','402880844d6ffadc014d701a54320004','编码','code',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,3,1,'2015-05-20 14:55:27'),('402880844d6ffadc014d701b02d50008','402880844d6ffadc014d701a54320004','名称','name',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,4,1,'2015-05-20 14:55:27'),('402880844d755dce014d755e54f10001','13','主表名称','tablename',100,'1','varchar',NULL,'',1,1,0,0,1,1,3,'','tableid','sys_table','tableid:id,tablename:name',4,1,'2015-05-21 15:27:05'),('402880844d755dce014d755e54f10002','13','映射表名','mapname',100,'1','varchar',NULL,'',1,0,0,0,1,1,3,'','mapid','sys_table','mapid:id,mapname:name',6,1,'2015-05-21 15:27:05'),('402880844d755dce014d755e55010003','13','中间表名','middlename',100,'1','varchar',NULL,'',1,0,0,0,1,1,3,'','middleid','sys_table','middleid:id,middlename:name',8,1,'2015-05-21 15:27:05'),('402880844d75669d014d75708c0c0003','15','排序','order',NULL,'2','int',0,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,11,1,'2015-05-21 15:46:59'),('402880844dd1dc18014dd1fc212b0001','13','操作名称','name',100,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,2,1,'2015-06-08 15:04:31'),('402880844dd2307f014dd23dc1560001','6','id','id',64,'1','varchar',NULL,NULL,2,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,'2015-06-08 16:16:12'),('402880844dd2307f014dd23dc15a0002','6','类型名称','name',255,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,2,1,'2015-06-08 16:16:12'),('402880844dd2307f014dd23dc15e0003','6','类型编码','code',255,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,3,1,'2015-06-08 16:16:12'),('402880844dd2307f014dd23dc1640004','6','数据库类型','type',255,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,4,1,'2015-06-08 16:16:12'),('402880844dd2307f014dd23dc16b0005','6','状态','status',NULL,'2','int',0,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,5,1,'2015-06-08 16:16:12'),('402880844dd2307f014dd23dc1710006','6','创建时间','createdate',NULL,'3','datetime',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,6,1,'2015-06-08 16:16:12'),('402881e44cfb358d014cfb40e8d00000','7','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,'2015-04-27 22:21:17'),('402881e44cfb358d014cfb40e9200001','7','分类名称','groupname',100,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,2,1,'2015-04-27 22:21:17'),('402881e44cfb358d014cfb40e9200002','7','分类编码','groupcode',100,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,3,1,'2015-04-27 22:21:17'),('402881e44cfb358d014cfb40e92a0003','7','排序','order',NULL,'2','int',0,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,4,1,'2015-04-27 22:21:17'),('402881e44cfb358d014cfb40e92a0004','7','状态','status',NULL,'2','int',0,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,5,1,'2015-04-27 22:21:17'),('402881e44cfb358d014cfb40e9340005','7','创建时间','createdate',NULL,'3','datetime',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,6,1,'2015-04-27 22:21:17'),('402881e44d18fe6a014d1982c1ea0000','9','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c2300001','9','父id','pid',50,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,NULL,NULL,2,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c2300002','9','部门名称','name',100,'1','varchar',NULL,NULL,1,1,1,0,0,1,1,NULL,NULL,NULL,NULL,4,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c2300003','9','描述','deptdesc',500,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,5,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c23a0004','9','dir','deptdir',1000,'1','varchar',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,6,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c23a0005','9','图标','depticon',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,7,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c2440009','9','部门状态','deptstate',NULL,'2','int',0,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,10,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c24e000a','9','顺序','order',NULL,'2','int',0,NULL,0,0,0,0,1,1,1,NULL,NULL,NULL,NULL,11,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c24e000b','9','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,12,1,'2015-05-03 19:21:49'),('402881e44d18fe6a014d1982c258000d','9','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,13,1,'2015-05-03 19:21:49'),('402881e44d2e3ac7014d2e3af5a20000','5','id','id',64,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5d10001','5','数据表ID','tableid',60,'1','varchar',NULL,NULL,0,0,0,0,0,2,1,NULL,NULL,'sys_table',NULL,2,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5d10002','5','列名','columnname',100,'1','varchar',NULL,NULL,1,1,0,0,0,1,1,NULL,NULL,NULL,NULL,3,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5d10003','5','列编码','columncode',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,4,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5e00004','5','数据类型ID','datatypeid',60,'1','varchar',NULL,NULL,0,0,0,0,0,2,1,NULL,NULL,NULL,NULL,5,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5e00005','5','数据类型','datatype',100,'1','varchar',NULL,NULL,1,0,0,0,0,1,3,NULL,'datatypeid','sys_fields_type','datatypeid:id,datatype:code',6,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5e00006','5','默认值','defaultvalue',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,7,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5e00007','5','字典分类','diccode',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,8,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5f00008','5','外键','foreignid',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,9,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5f00009','5','数据表名','tablecode',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,10,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5f0000a','5','列长度','columnlength',NULL,'2','int',0,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,11,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af5f0000b','5','保留位数','scale',NULL,'2','int',0,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,12,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af600000c','5','列表页显示','islist',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,13,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af600000d','5','可查询','isquery',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,14,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af600000e','5','树型表操作列','istreefield',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,15,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af60f000f','5','不能重复','isunique',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,16,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af60f0010','5','允许为空','isnullable',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,17,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af60f0011','5','显示','visiable',NULL,'2','int',0,NULL,1,0,0,0,0,1,2,'yes',NULL,NULL,NULL,18,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af61f0012','5','输入框类型','inputtype',NULL,'2','int',0,NULL,1,0,0,0,0,1,2,'input',NULL,NULL,NULL,19,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af61f0013','5','顺序','order',NULL,'2','int',0,NULL,0,0,0,0,1,1,1,NULL,NULL,NULL,NULL,20,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af61f0014','5','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,21,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af61f0015','5','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,22,1,'2015-05-07 19:55:25'),('402881e44d2e3ac7014d2e3af62e0016','5','映射关系','maps',65535,'5','text',NULL,NULL,0,0,0,0,1,1,1,NULL,NULL,NULL,NULL,23,1,'2015-05-07 19:55:25'),('402881e44d2e3bb6014d2e9312e70000','3','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313260001','3','父id','pid',60,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,NULL,NULL,2,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313260002','3','模块名称','name',100,'1','varchar',NULL,NULL,1,1,1,0,1,1,1,NULL,NULL,NULL,NULL,4,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313260003','3','模块编码','code',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,5,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313260004','3','所有父模块代码','codedir',500,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,6,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313350005','3','数据表名','tablename',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,7,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313350006','3','数据实体名','entityname',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,8,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313350007','3','编辑页面列数','colcount',NULL,'2','int',0,NULL,2,0,0,0,1,1,1,NULL,NULL,NULL,NULL,9,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313350008','3','显示顺序','tableorder',NULL,'2','int',0,NULL,0,0,0,0,1,1,1,NULL,NULL,NULL,NULL,10,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e9313350009','3','叶子','state',NULL,'2','int',0,NULL,2,0,0,0,1,1,2,'treestate',NULL,NULL,NULL,11,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e931335000a','3','是否缓存','iscache',NULL,'2','int',0,NULL,1,0,0,0,0,1,2,'yes',NULL,NULL,NULL,12,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e931345000b','3','同步菜单','isfunsync',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,13,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e931345000d','3','单选','singleselect',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'yes',NULL,NULL,NULL,14,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e931345000e','3','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,15,1,'2015-05-07 21:31:40'),('402881e44d2e3bb6014d2e931355000f','3','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,16,1,'2015-05-07 21:31:40'),('402881e44d2eb613014d2eb7ef8e0000','10','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efbd0001','10','pid','pid',60,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,NULL,NULL,2,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efbd0002','10','tableid','tableid',60,'1','varchar',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,3,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efcd0003','10','菜单名称','name',50,'1','varchar',NULL,NULL,1,1,1,0,0,1,1,NULL,NULL,NULL,NULL,4,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efcd0004','10','菜单路径','functionurl',100,'1','varchar',NULL,'',0,0,0,0,1,1,1,'','','','',5,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efcd0005','10','导航图标','navicon',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,6,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efcd0006','10','菜单图标','icon',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,7,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efdc0007','10','叶子','state',NULL,'2','int',0,NULL,2,0,0,0,1,0,2,'treestate',NULL,NULL,NULL,8,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efdc0008','10','顺序','order',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,9,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efdc0009','10','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,10,1,'2015-05-07 22:11:55'),('402881e44d2eb613014d2eb7efdc000a','10','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,11,1,'2015-05-07 22:11:55'),('402881e44d38808b014d38deb3090002','11','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,'2015-05-09 21:30:28'),('402881e44d38808b014d38deb31e0003','11','roleid','roleid',60,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,'sys_role',NULL,2,1,'2015-05-09 21:30:28'),('402881e44d38808b014d38deb31e0004','11','userid','userid',60,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,'sys_user',NULL,3,1,'2015-05-09 21:30:28'),('402881e44d3d66a0014d3d67b6eb0000','12','id','id',64,'1','varchar',NULL,NULL,2,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,'2015-05-10 18:38:36'),('402881e44d3d66a0014d3d67b71d0001','12','departid','departid',60,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,'sys_department',NULL,2,1,'2015-05-10 18:38:36'),('402881e44d3d66a0014d3d67b7270002','12','userid','userid',60,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,'sys_user',NULL,3,1,'2015-05-10 18:38:36'),('402881e44d3d66a0014d3d691d8f0003','13','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-10 18:40:08'),('402881e44d3d66a0014d3d691d900004','13','主表id','tableid',60,'1','varchar',NULL,NULL,0,0,0,0,1,2,1,NULL,NULL,NULL,NULL,3,1,'2015-05-10 18:40:08'),('402881e44d3d66a0014d3d691d9a0005','13','映射表id','mapid',60,'1','varchar',NULL,NULL,0,0,0,0,1,2,1,NULL,NULL,NULL,NULL,5,1,'2015-05-10 18:40:08'),('402881e44d3d66a0014d3d691d9a0006','13','中间表id','middleid',60,'1','varchar',NULL,NULL,0,0,0,0,1,2,1,NULL,NULL,NULL,NULL,7,1,'2015-05-10 18:40:08'),('402881e44d3d66a0014d3d691d9a0007','13','映射类型','maptype',NULL,'2','int',0,'',1,0,0,0,1,1,2,'mapping','','','',9,1,'2015-05-10 18:40:08'),('402881e44d3d66a0014d3d691da40008','13','状态','status',NULL,'2','int',0,'',0,0,0,0,1,0,1,'','','','',10,1,'2015-05-10 18:40:08'),('402881e44d3d66a0014d3d691da40009','13','创建时间','createdate',NULL,'3','datetime',NULL,'',0,0,0,0,1,0,1,'','','','',11,1,'2015-05-10 18:40:08'),('402881e44d3e08f9014d3e1453710002','14','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,1,1,NULL,NULL,NULL,NULL,1,1,'2015-05-10 21:47:09'),('402881e44d3e08f9014d3e14537b0003','14','functionid','functionid',60,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,'sys_function',NULL,2,1,'2015-05-10 21:47:09'),('402881e44d3e08f9014d3e14537b0004','14','roleid','roleid',60,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,'sys_role',NULL,3,1,'2015-05-10 21:47:09'),('402881e44d429af0014d42b188ba0001','15','菜单id','functionid',60,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,'sys_function',NULL,3,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188ba0002','15','按钮名称','name',100,'1','varchar',NULL,NULL,1,1,1,0,1,1,1,NULL,NULL,NULL,NULL,4,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188ba0003','15','事件','action',500,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,5,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188c90004','15','图标id','iconid',60,'1','varchar',NULL,NULL,0,0,0,0,1,2,1,NULL,NULL,NULL,NULL,6,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188c90005','15','图标名称','iconname',100,'1','varchar',NULL,NULL,1,0,0,0,1,1,3,NULL,'iconid','sys_icon','iconid:id,iconname:name,iconcode:style',7,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188c90006','15','图标编码','iconcode',50,'1','varchar',NULL,NULL,1,0,0,0,1,1,1,NULL,NULL,NULL,NULL,8,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188c90007','15','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,12,1,'2015-05-11 19:17:20'),('402881e44d429af0014d42b188d90008','15','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,13,1,'2015-05-11 19:17:20'),('402881e44d48818a014d48957dcc0000','16','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-12 22:44:26'),('402881e44d48818a014d48957dfb0001','16','图标名称','name',100,'1','varchar',NULL,NULL,1,1,0,0,0,1,1,NULL,NULL,NULL,NULL,2,1,'2015-05-12 22:44:26'),('402881e44d48818a014d48957dfb0002','16','图标样式','style',100,'1','varchar',NULL,NULL,1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,3,1,'2015-05-12 22:44:26'),('402881e44d48818a014d48957dfb0003','16','图标路径','iconpath',500,'1','varchar',NULL,NULL,1,0,0,0,0,1,5,NULL,NULL,NULL,NULL,2,1,NULL),('402881e44d48818a014d48957dfb0004','16','图标类型','icontype',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'icontype',NULL,NULL,NULL,4,1,'2015-05-12 22:44:26'),('402881e44d48818a014d48957e0b0005','16','状态','status',NULL,'2','int',0,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,5,1,'2015-05-12 22:44:26'),('402881e44d48818a014d48957e0c0006','16','创建时间','createdate',NULL,'3','datetime',NULL,NULL,0,0,0,0,1,0,1,NULL,NULL,NULL,NULL,6,1,'2015-05-12 22:44:26'),('402881e44d5a3f60014d5a44dd100000','17','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,'2015-05-16 09:09:32'),('402881e44d5a3f60014d5a44dd3f0001','17','rfunctionid','rfunctionid',60,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,'sys_role_function',NULL,2,1,'2015-05-16 09:09:32'),('402881e44d5a3f60014d5a44dd3f0002','17','fbuttonid','fbuttonid',60,'1','varchar',NULL,NULL,2,0,0,0,1,2,1,NULL,NULL,'sys_function_button',NULL,3,1,'2015-05-16 09:09:32'),('402881e44d5b61d4014d5b6e9ea70000','15','按钮位置','side',NULL,'2','int',0,NULL,1,0,0,0,1,1,2,'sidetype',NULL,NULL,NULL,9,1,'2015-05-16 14:34:45'),('402881e44d5f9614014d5fa7052a0000','9','level','level',NULL,'2','int',0,NULL,0,0,0,0,1,2,1,NULL,NULL,NULL,NULL,9,1,'2015-05-17 10:14:50'),('402881e44d621c77014d621f38960000','9','上级部门','parentname',100,'1','varchar',NULL,NULL,0,0,0,0,1,1,3,NULL,'pid','sys_department','pid:id,parentname:name',3,1,'2015-05-17 21:45:22'),('5','8','状态','status',11,'2','int',NULL,NULL,NULL,0,0,0,1,1,1,NULL,NULL,NULL,NULL,5,1,NULL),('6','8','创建时间','createdate',NULL,'3','datetime',NULL,NULL,NULL,0,0,0,1,1,1,NULL,NULL,NULL,NULL,6,1,NULL),('7','4','id','id',60,'1','varchar',NULL,NULL,2,0,0,1,0,2,1,NULL,NULL,NULL,NULL,1,1,NULL),('8','4','departmentid','departmentid',60,'1','varchar',NULL,NULL,2,0,0,0,0,2,1,NULL,NULL,NULL,NULL,3,1,NULL),('9','4','部门名称','departmentname',100,'1','varchar',NULL,NULL,1,1,0,0,0,1,3,NULL,'departmentid','sys_department','departmentid:id,departmentname:name',4,1,NULL);

#
# Structure for table "sys_fields_type"
#

DROP TABLE IF EXISTS `sys_fields_type`;
CREATE TABLE `sys_fields_type` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '类型名称',
  `code` varchar(255) NOT NULL DEFAULT '' COMMENT '类型编码',
  `type` varchar(255) NOT NULL DEFAULT '' COMMENT '数据库类型',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_fields_type"
#

INSERT INTO `sys_fields_type` VALUES ('1','字符串','varchar','mysql',1,NULL),('2','整型','int','mysql',1,NULL),('3','日期','datetime','mysql',1,NULL),('4','小数','double','mysql',1,NULL),('5','文本','text','mysql',1,NULL);

#
# Structure for table "sys_function"
#

DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `pid` varchar(60) DEFAULT NULL COMMENT 'pid',
  `tableid` varchar(60) DEFAULT NULL COMMENT 'tableid',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `functionurl` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `navicon` varchar(100) DEFAULT NULL COMMENT '导航图标',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `state` int(11) DEFAULT NULL COMMENT '叶子',
  `order` int(11) DEFAULT NULL COMMENT '顺序',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_function"
#

INSERT INTO `sys_function` VALUES ('1',NULL,'1','系统管理','../appController/index.htm','../resources/images/system.png',NULL,0,1,1,NULL),('2','1','4','用户管理','../userController/index.htm',NULL,NULL,1,1,1,NULL),('3','4','6','基础数据类型','../fieldsTypeController/index.htm',NULL,NULL,1,3,1,NULL),('4',NULL,'2','数据库管理','../nullController/index.htm','../resources/images/code.png',NULL,0,2,1,NULL),('402880844d31fb69014d3205dc5a0000','1','402880844d31fb69014d321802390001','角色管理','../roleController/index.htm','','',1,5,1,NULL),('402880844d6ffadc014d701a54130002','402880844d6ffadc014d701a54320003',NULL,'测试用户','../Controller/index.htm',NULL,NULL,1,3,1,'2015-05-20 14:54:43'),('402880844d6ffadc014d701a54320003',NULL,NULL,'测试','../excelController/index.htm',NULL,NULL,0,1,1,'2015-05-20 14:54:43'),('402880844d75669d014d7568bada0002','4','13','表映射关系','../tablemapController/index.htm',NULL,NULL,1,3,1,'2015-05-21 15:38:27'),('5','4','3','系统数据表','../tableController/index.htm',NULL,NULL,1,2,1,NULL),('6','1','7','字典分类管理','../typegroupController/index.htm',NULL,NULL,1,2,1,NULL),('7','1','9','组织机构','../departmentController/index.htm',NULL,NULL,1,2,1,NULL),('8','1','10','系统菜单','../functionController/index.htm',NULL,NULL,1,4,1,NULL),('9','1','16','图标管理','../iconController/index.htm',NULL,NULL,1,5,1,NULL);

#
# Structure for table "sys_function_button"
#

DROP TABLE IF EXISTS `sys_function_button`;
CREATE TABLE `sys_function_button` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `pid` varchar(60) DEFAULT NULL COMMENT 'pid',
  `functionid` varchar(60) DEFAULT NULL COMMENT '菜单id',
  `name` varchar(100) DEFAULT NULL COMMENT '按钮名称',
  `action` varchar(500) DEFAULT NULL COMMENT '事件',
  `iconid` varchar(60) DEFAULT NULL COMMENT '图标id',
  `iconname` varchar(100) DEFAULT NULL COMMENT '图标名称',
  `iconcode` varchar(50) DEFAULT NULL COMMENT '图标编码',
  `side` int(11) DEFAULT NULL COMMENT '按钮位置',
  `state` int(11) DEFAULT NULL COMMENT '叶子',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单功能按钮';

#
# Data for table "sys_function_button"
#

INSERT INTO `sys_function_button` VALUES ('402880844d55d22d014d564d100b0002',NULL,'6','查询','method:\'query\'','3','查询','icon-search',1,1,1,1,'2015-05-15 14:40:00'),('402880844d75669d014d756757af0000',NULL,'402880844d755dce014d755e54830000','删除','method:\'delete\'','4','删除','icon-delete',1,1,NULL,1,'2015-05-21 15:36:56'),('402880844dd1dc18014dd1fc20370000',NULL,'402880844d75669d014d7568bada0002','删除','method:\'delete\'','4','删除','icon-delete',1,1,5,1,'2015-06-08 15:04:31'),('402880844dd1dc18014dd2157f110002',NULL,'402880844d75669d014d7568bada0002','查看','method:\'view\'','7','查看','icon-view',1,1,4,1,'2015-06-08 15:32:13'),('402880844dd1dc18014dd216390c0003',NULL,'402880844d75669d014d7568bada0002','修改','method:\'edit\'','2','修改','icon-edit',1,1,3,1,'2015-06-08 15:33:01'),('402880844dd1dc18014dd217e91b0004',NULL,'402880844d75669d014d7568bada0002','添加','method:\'add\'','1','添加','icon-add',1,1,2,1,'2015-06-08 15:34:51'),('402880844dd1dc18014dd21e40700005',NULL,'402880844d75669d014d7568bada0002','查询','method:\'query\'','3','添加','icon-search',1,1,1,1,'2015-06-08 15:41:47'),('402880844dd2307f014dd23dc1210000',NULL,'3','删除','method:\'delete\'','4','删除','icon-delete',1,1,NULL,1,'2015-06-08 16:16:12'),('402881e44d431aca014d432014a30000',NULL,'2','查询','method:\'query\'','3','查询','icon-search',1,1,1,1,'2015-05-11 21:18:05'),('402881e44d431aca014d4323c41a0001',NULL,'7','查询','method:\'query\'','3','查询','icon-search',1,1,1,1,'2015-05-11 21:22:07'),('402881e44d57a372014d57ac29070000','','2','添加','method:\'add\'','1','添加','icon-add',1,1,2,1,'2015-05-15 21:03:30'),('402881e44d57a372014d57add20e0001','','2','修改','method:\'edit\'','2','修改','icon-edit',1,1,3,1,'2015-05-15 21:05:18'),('402881e44d57a372014d57b162c50002','','2','查看','method:\'view\'','7','查看','icon-view',1,1,4,1,'2015-05-15 21:09:12'),('402881e44d57a372014d57b1c9290003','','2','删除','method:\'delete\'','4','删除','icon-delete',1,1,5,1,'2015-05-15 21:09:38'),('402881e44d9a9bf7014d9aa4ac910000',NULL,'7','删除','method:\'delete\'','4','删除','icon-delete',1,1,NULL,1,'2015-05-28 21:09:52');

#
# Structure for table "sys_icon"
#

DROP TABLE IF EXISTS `sys_icon`;
CREATE TABLE `sys_icon` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '图标名称',
  `iconpath` varchar(500) DEFAULT NULL COMMENT '图标路径',
  `icontype` int(11) DEFAULT NULL COMMENT '图标类型',
  `style` varchar(100) DEFAULT NULL COMMENT '图标样式',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统图标';

#
# Data for table "sys_icon"
#

INSERT INTO `sys_icon` VALUES ('1','添加','icon-add.png',3,'icon-add',1,NULL),('2','修改','icon-edit.png',3,'icon-edit',1,NULL),('3','查询','icon-search.png',3,'icon-search',1,NULL),('4','删除','icon-delete.png',3,'icon-delete',1,NULL),('402881e44d527d5c014d527ffd690000','用户','15d9177b-890c-4b4a-9dc0-38298fe7470e.png',1,'user',1,'2015-05-14 20:57:09'),('5','列表','icon-list.png',3,'icon-list',1,NULL),('6','回收站','icon-recycle.png',3,'icon-recycle',1,NULL),('7','查看','icon-view.png',3,'icon-view',1,NULL);

#
# Structure for table "sys_role"
#

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT 'id',
  `rolecode` varchar(50) NOT NULL DEFAULT '' COMMENT '角色编码',
  `rolename` varchar(100) NOT NULL DEFAULT '' COMMENT '角色名称',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_role"
#

INSERT INTO `sys_role` VALUES ('1','admin','超级管理员',1,NULL),('2','user','普通用户',1,NULL),('3','mananger','管理员',1,NULL);

#
# Structure for table "sys_role_function"
#

DROP TABLE IF EXISTS `sys_role_function`;
CREATE TABLE `sys_role_function` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `functionid` varchar(60) NOT NULL DEFAULT '' COMMENT 'functionid',
  `roleid` varchar(60) NOT NULL DEFAULT '' COMMENT 'roleid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_role_function"
#

INSERT INTO `sys_role_function` VALUES ('402881e44d3e15a7014d3e1ae6c50000','1','1'),('402881e44d3e15a7014d3e1ae70b0001','2','1'),('402881e44d3e15a7014d3e1ae7150002','6','1'),('402881e44d3e15a7014d3e1ae7150003','7','1'),('402881e44d3e15a7014d3e1ae71f0004','8','1'),('402881e44d3e15a7014d3e1ae7200005','402880844d31fb69014d3205dc5a0000','1'),('402881e44d3e15a7014d3e1ae7200006','4','1'),('402881e44d3e15a7014d3e1ae72a0007','5','1'),('402881e44d3e15a7014d3e1ae72a0008','3','1'),('402881e44d489855014d48997c980000','9','1'),('402881e44d75ea39014d75f15b950000','402880844d75669d014d7568bada0002','1');

#
# Structure for table "sys_role_function_button"
#

DROP TABLE IF EXISTS `sys_role_function_button`;
CREATE TABLE `sys_role_function_button` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `rfunctionid` varchar(60) DEFAULT NULL COMMENT 'rfunctionid',
  `fbuttonid` varchar(60) DEFAULT NULL COMMENT 'fbuttonid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_role_function_button"
#

INSERT INTO `sys_role_function_button` VALUES ('402881e44d5ad6f3014d5ad9be7d0000','402881e44d3e15a7014d3e1ae70b0001','402881e44d431aca014d432014a30000'),('402881e44d5ad6f3014d5adb01110001','402881e44d3e15a7014d3e1ae70b0001','402881e44d57a372014d57ac29070000'),('402881e44d5ad6f3014d5ade12360005','402881e44d3e15a7014d3e1ae70b0001','402881e44d57a372014d57add20e0001'),('402881e44d5ad6f3014d5ade12360006','402881e44d3e15a7014d3e1ae70b0001','402881e44d57a372014d57b162c50002');

#
# Structure for table "sys_role_user"
#

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `roleid` varchar(60) DEFAULT NULL COMMENT 'roleid',
  `userid` varchar(60) DEFAULT NULL COMMENT 'userid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_role_user"
#

INSERT INTO `sys_role_user` VALUES ('1','1','1'),('402881e44d3d9251014d3d94e3d20001','1','402880844d22d898014d230dcc0f0002');

#
# Structure for table "sys_table"
#

DROP TABLE IF EXISTS `sys_table`;
CREATE TABLE `sys_table` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `pid` varchar(60) DEFAULT NULL COMMENT '父id',
  `parentname` varchar(100) DEFAULT NULL COMMENT '上级菜单',
  `name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  `code` varchar(100) DEFAULT NULL COMMENT '模块编码',
  `codedir` varchar(500) DEFAULT NULL COMMENT '所有父模块代码',
  `tablename` varchar(100) DEFAULT NULL COMMENT '数据表名',
  `entityname` varchar(100) DEFAULT NULL COMMENT '数据实体名',
  `colcount` int(11) DEFAULT NULL COMMENT '编辑页面列数',
  `tableorder` int(11) DEFAULT NULL COMMENT '显示顺序',
  `state` int(11) DEFAULT NULL COMMENT '叶子',
  `iscache` int(11) NOT NULL DEFAULT '0' COMMENT '是否缓存',
  `isfunsync` int(11) DEFAULT NULL COMMENT '同步菜单',
  `singleselect` int(11) DEFAULT NULL COMMENT '单选',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_table"
#

INSERT INTO `sys_table` VALUES ('1',NULL,NULL,'系统管理','system','system',NULL,NULL,NULL,1,0,0,1,NULL,1,NULL),('10','1',NULL,'系统菜单',NULL,NULL,'sys_function','function',1,5,1,0,1,1,1,NULL),('11','1',NULL,'用户角色关系表',NULL,NULL,'sys_role_user','roleuser',1,1,1,0,0,1,2,NULL),('12','1',NULL,'用户管理部门',NULL,NULL,'sys_department_user','departmentuser',1,1,1,0,0,1,2,NULL),('13','2','数据库管理','表映射关系','','','sys_table_map','tablemap',1,3,1,0,1,1,1,NULL),('14','1',NULL,'角色菜单管理',NULL,NULL,'sys_role_function','rolefunction',1,1,1,0,0,1,2,NULL),('15','1',NULL,'菜单功能管理',NULL,NULL,'sys_function_button','functionbutton',1,1,1,0,0,1,1,NULL),('16','1',NULL,'图标管理',NULL,NULL,'sys_icon','icon',1,1,1,0,1,1,1,NULL),('17','1',NULL,'菜单功能权限',NULL,NULL,'sys_role_function_button','rolefunctionbutton',1,1,1,0,0,1,2,NULL),('2',NULL,NULL,'数据库管理','admin','admin',NULL,NULL,NULL,2,0,0,1,NULL,1,NULL),('3','2','数据库管理','系统数据表','','','sys_table','table',2,1,1,0,1,1,1,NULL),('4','1',NULL,'系统用户',NULL,NULL,'sys_user','user',1,1,1,0,1,1,1,NULL),('402880844d31fb69014d321802390001','1',NULL,'角色管理','','','sys_role','role',1,5,1,0,1,1,1,NULL),('402880844d6ffadc014d701903890001','',NULL,'测试用户','test','','','',NULL,3,0,0,1,1,1,'2015-05-20 14:53:17'),('402880844d6ffadc014d701a54320004','402880844d6ffadc014d701903890001','测试用户','测试','','','wage_excel','excel',1,1,1,0,1,1,1,'2015-05-20 14:54:43'),('5','2','数据库管理','系统数据列',NULL,NULL,'sys_fields','fields',2,2,1,0,0,NULL,1,NULL),('6','2','数据库管理','基础数据类型','','','sys_fields_type','fieldsType',NULL,3,1,0,1,1,1,NULL),('7','1',NULL,'字典分类管理',NULL,NULL,'sys_typegroup','typegroup',NULL,3,1,0,1,1,1,NULL),('8','1',NULL,'字典信息',NULL,NULL,'sys_type','type',NULL,4,1,0,0,NULL,1,NULL),('9','1','','组织机构','','','sys_department','department',1,2,1,0,1,1,1,NULL);

#
# Structure for table "sys_table_map"
#

DROP TABLE IF EXISTS `sys_table_map`;
CREATE TABLE `sys_table_map` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '操作名称',
  `maptype` int(11) DEFAULT NULL COMMENT '映射类型',
  `tableid` varchar(60) DEFAULT NULL COMMENT '主表id',
  `tablename` varchar(100) DEFAULT NULL COMMENT '主表名称',
  `mapid` varchar(60) DEFAULT NULL COMMENT '映射表id',
  `mapname` varchar(100) DEFAULT NULL COMMENT '映射表名',
  `middleid` varchar(60) DEFAULT NULL COMMENT '中间表id',
  `middlename` varchar(100) DEFAULT NULL COMMENT '中间表名',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_table_map"
#

INSERT INTO `sys_table_map` VALUES ('1','角色管理',3,'4','系统用户','402880844d31fb69014d321802390001','角色管理','11','用户角色关系表',1,NULL),('2','系统用户',3,'402880844d31fb69014d321802390001','角色管理','4','系统用户','11','用户角色关系表',1,NULL),('3','组织机构',3,'4','系统用户','9','组织机构','12','用户管理部门',1,NULL),('4','系统用户',3,'9','组织机构','4','系统用户','12','用户管理部门',1,NULL),('5','系统菜单',3,'402880844d31fb69014d321802390001','角色管理','10','系统菜单','14','角色菜单管理',1,NULL),('6','菜单功能管理',1,'10','系统菜单','15','菜单功能管理',NULL,NULL,1,NULL),('7','角色管理',3,'10','系统菜单','402880844d31fb69014d321802390001','角色管理','14','角色菜单管理',1,NULL),('8','系统数据列',1,'3','系统数据表','5','系统数据列',NULL,NULL,1,NULL);

#
# Structure for table "sys_type"
#

DROP TABLE IF EXISTS `sys_type`;
CREATE TABLE `sys_type` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `typegroupid` varchar(60) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(100) NOT NULL DEFAULT '' COMMENT '编码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_type"
#

INSERT INTO `sys_type` VALUES ('1','1','男','1',1,1,NULL),('10','4','多对一','2',1,2,NULL),('11','4','多对多','3',1,3,NULL),('12','5','closed','0',1,1,NULL),('13','6','导航图标','1',1,1,NULL),('14','6','菜单图标','2',1,2,NULL),('15','3','图片上传','5',1,5,NULL),('16','3','文件上传','6',1,6,NULL),('17','6','按钮图标','3',1,1,NULL),('18','7','左面','1',1,1,NULL),('19','7','右面','2',1,2,NULL),('2','1','女','0',1,2,NULL),('3','2','是','1',1,1,NULL),('4','2','否','0',1,2,NULL),('5','3','单行输入框','1',1,1,NULL),('6','3','下拉选择框','2',1,2,NULL),('7','3','选择输入框','3',1,3,NULL),('8','3','多行输入框','4',1,4,NULL),('9','4','一对多','1',1,1,NULL);

#
# Structure for table "sys_typegroup"
#

DROP TABLE IF EXISTS `sys_typegroup`;
CREATE TABLE `sys_typegroup` (
  `id` varchar(60) NOT NULL DEFAULT '' COMMENT 'id',
  `groupname` varchar(100) NOT NULL DEFAULT '' COMMENT '分类名称',
  `groupcode` varchar(100) NOT NULL DEFAULT '' COMMENT '分类编码',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_typegroup"
#

INSERT INTO `sys_typegroup` VALUES ('1','性别','sex',1,1,NULL),('2','是否','yes',2,1,NULL),('3','输入框类型','input',3,1,NULL),('4','映射关系','mapping',4,1,NULL),('5','树形状态','treestate',5,1,NULL),('6','图标类型','icontype',6,1,NULL),('7','按钮位置','sidetype',7,1,NULL);

#
# Structure for table "sys_user"
#

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL,
  `departmentid` varchar(60) NOT NULL DEFAULT '',
  `departmentname` varchar(100) DEFAULT NULL,
  `employeeid` varchar(50) NOT NULL,
  `realname` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `number` varchar(32) NOT NULL,
  `telephone` varchar(32) NOT NULL,
  `idc` varchar(32) NOT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT '',
  `status` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES ('1','402881e44d1a2f13014d1a3001430000','成都分公司','','dengl','admin',0,'admin','18982935467','','','592966328@qq.com','cd1e5921a6c20c86',1,NULL),('10','402881e44d1a2f13014d1a3001430000','成都分公司','','1','10',1,'1','','','','1','',1,NULL),('11','402881e44d1a2f13014d1a3001430000','成都分公司','','11','11',1,'1','','','','1','',1,NULL),('12','',NULL,'','','12',NULL,'','','',NULL,NULL,'',1,NULL),('13','',NULL,'','','13',NULL,'','','',NULL,NULL,'',1,NULL),('14','',NULL,'','','14',NULL,'','','',NULL,NULL,'',1,NULL),('15','',NULL,'','','15',NULL,'','','',NULL,NULL,'',1,NULL),('2','',NULL,'','','user1',NULL,'','','',NULL,NULL,'',1,NULL),('3','',NULL,'','','3',NULL,'','','',NULL,NULL,'',1,NULL),('4','',NULL,'','','4',NULL,'','','',NULL,NULL,'',1,NULL),('402880844d22d898014d230dcc0f0002','402881e44d1a2f13014d1a32acee0001','武侯事业部','','abbccdef','a',1,'a','','','','a',NULL,1,NULL),('402881e44d3e08f9014d3e0fe8c10000','402881e44d1a2f13014d1a32acee0001','武侯事业部','','test','test',1,'test','','','','',NULL,1,'2015-05-10 21:42:19'),('5','',NULL,'','','5',NULL,'','','',NULL,NULL,'',1,NULL),('6','',NULL,'','','6',NULL,'','','',NULL,NULL,'',1,NULL),('7','',NULL,'','','7',NULL,'','','',NULL,NULL,'',1,NULL),('8','',NULL,'','','8',NULL,'','','',NULL,NULL,'',1,NULL),('9','',NULL,'','','9',NULL,'','','',NULL,NULL,'',1,NULL);

#
# Structure for table "wage_account"
#

DROP TABLE IF EXISTS `wage_account`;
CREATE TABLE `wage_account` (
  `id` varchar(64) NOT NULL,
  `ALIAS` varchar(100) DEFAULT NULL,
  `calclevel` int(11) DEFAULT NULL,
  `CODE` varchar(50) DEFAULT NULL,
  `colorder` int(11) DEFAULT NULL,
  `colspan` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `ENABLE` int(11) DEFAULT NULL,
  `EXCELID` varchar(50) DEFAULT NULL,
  `extendcode` varchar(100) DEFAULT NULL,
  `formula` varchar(500) DEFAULT NULL,
  `formulacode` varchar(500) DEFAULT NULL,
  `isextend` int(11) DEFAULT NULL,
  `ismanager` int(11) DEFAULT NULL,
  `issum` int(11) DEFAULT NULL,
  `ISSYSTEM` int(11) DEFAULT NULL,
  `istitle` int(11) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `rowspan` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "wage_account"
#


#
# Structure for table "wage_excel"
#

DROP TABLE IF EXISTS `wage_excel`;
CREATE TABLE `wage_excel` (
  `id` varchar(64) NOT NULL,
  `alias` varchar(50) DEFAULT NULL,
  `CODE` varchar(50) DEFAULT NULL,
  `filepath` varchar(50) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `tablename` varchar(50) DEFAULT NULL,
  `titlerow` int(11) DEFAULT NULL,
  `URL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "wage_excel"
#

