# Host: localhost  (Version: 5.5.40)
# Date: 2015-06-10 21:17:55
# Generator: MySQL-Front 5.3  (Build 4.205)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "sys_log"
#

DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `Id` varchar(50) NOT NULL DEFAULT '',
  `userid` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `broswer` varchar(255) NOT NULL DEFAULT '',
  `operatetime` datetime DEFAULT NULL,
  `loglevel` varchar(50) DEFAULT NULL,
  `logcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
