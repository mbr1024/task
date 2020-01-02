/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : 127.0.0.1:3306
Source Database       : task

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-06-22 07:24:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `dutyname` varchar(255) NOT NULL,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `staff` varchar(20) DEFAULT NULL,
  `concrete` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `feedback` varchar(20) DEFAULT NULL,
  `leader` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dutyname`),
  KEY `fk_name` (`leader`),
  KEY `fk_staff` (`staff`),
  CONSTRAINT `fk_staff` FOREIGN KEY (`staff`) REFERENCES `employee` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES ('写报告', '2018-06-21', '2018-06-22', '李达', '', '已完成', null, '张小');
INSERT INTO `duty` VALUES ('写论文', '2018-06-06', '2018-06-07', '王大拿', '', '已完成', null, '张小');
INSERT INTO `duty` VALUES ('啥啥啥', '2018-06-09', '2018-06-10', '李丽', '阿萨斯', '未实施', null, '赵奔三');
INSERT INTO `duty` VALUES ('开发仓库管理系统', '2018-06-12', '2018-06-20', '刘德华', '开发一个仓库管理系统', '未实施', null, '赵奔三');
INSERT INTO `duty` VALUES ('开发银行系统', '2018-06-05', '2018-06-21', '刘德华', '开发一个银行系统', '实施中', null, '赵奔三');
INSERT INTO `duty` VALUES ('的货架上', '2018-06-09', '2018-06-14', '刘德华', '', '实施中', null, '赵奔三');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `password` varchar(9) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `leader` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `leader` (`leader`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('6', '123456', '王四', '男', '2018-06-21', '主管', '本科', '软件工程师', '2018-06-04', '两年', null);
INSERT INTO `employee` VALUES ('7', '123456', '张小', '男', '2018-06-26', '主管', '本科', '软件工程师', '2018-06-12', '一年', null);
INSERT INTO `employee` VALUES ('9', '123456', '杨四', '男', '2018-06-26', '员工', '本科', '软件工程师', '2018-06-12', '一年', '张小');
INSERT INTO `employee` VALUES ('17', '123456', '刘德华', '男', '2018-06-04', '员工', '研究生', '软件工程师', '2018-06-20', '一年', '张小');
INSERT INTO `employee` VALUES ('22', '123456', '李丽', '女', '2017-07-11', '员工', '研究生', '员工', '2018-06-02', '', '张小');
INSERT INTO `employee` VALUES ('23', '123456', '李达', '男', '2018-06-04', '员工', '本科', '员工', '2018-06-22', '', '张小');
INSERT INTO `employee` VALUES ('24', '123456', '王大拿', '男', '2018-05-28', '员工', '本科', '员工', '2018-05-31', '', '张小');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `planname` varchar(255) NOT NULL,
  `planstatus` varchar(255) DEFAULT NULL,
  `planfeedback` varchar(255) DEFAULT NULL,
  `planstarttime` date DEFAULT NULL,
  `planendtime` date DEFAULT NULL,
  `dutyname` varchar(255) DEFAULT NULL,
  `planconcrete` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `backmessage` varchar(255) DEFAULT NULL,
  KEY `fk_dutyname` (`dutyname`),
  KEY `fk_name` (`name`),
  CONSTRAINT `fk_dutyname` FOREIGN KEY (`dutyname`) REFERENCES `duty` (`dutyname`),
  CONSTRAINT `fk_name` FOREIGN KEY (`name`) REFERENCES `employee` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('需求分析', '未实施', '未反馈', '2018-06-12', '2018-06-20', '开发银行系统', '了解客户需求', '刘德华', null);
INSERT INTO `plan` VALUES ('大萨达所', '已完成', '已反馈', '2018-06-09', '2018-06-10', '的货架上', '大声道', '刘德华', '');
INSERT INTO `plan` VALUES ('大声道', '未实施', '未反馈', '2018-06-10', '2018-06-12', '的货架上', '大声道', '刘德华', null);
INSERT INTO `plan` VALUES ('写作业', '未实施', '未反馈', '2018-06-21', '2018-06-21', '写报告', '', '李达', '完成了 请验收');
INSERT INTO `plan` VALUES ('收集资料', '实施中', '已反馈', '2018-06-19', '2018-06-20', '写论文', '资料收集', '王大拿', '资料完成收集');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(9) NOT NULL,
  `id` int(3) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('苏依林', '123456', '1');
