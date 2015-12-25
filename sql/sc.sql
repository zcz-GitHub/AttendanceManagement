/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : amdb
Target Host     : localhost:3306
Target Database : amdb
Date: 2015-12-25 20:12:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sno` char(8) NOT NULL,
  `cno` char(8) NOT NULL,
  `tno` char(8) NOT NULL,
  `absence_num` int(11) DEFAULT '0',
  PRIMARY KEY (`sno`,`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('13301081', 'cs001', '1111114', '4');
INSERT INTO `sc` VALUES ('13301081', 'cs002', '1111113', '4');
INSERT INTO `sc` VALUES ('13301081', 'cs003', '1111115', '8');
INSERT INTO `sc` VALUES ('13301085', 'cs001', '1111114', '2');
INSERT INTO `sc` VALUES ('13301087', 'cs001', '1111114', '2');
INSERT INTO `sc` VALUES ('13301087', 'cs002', '1111114', '3');
INSERT INTO `sc` VALUES ('13301089', 'cs001', '1111115', '2');
INSERT INTO `sc` VALUES ('13301089', 'cs002', '1111113', '0');
