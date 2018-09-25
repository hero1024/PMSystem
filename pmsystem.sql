/*
Navicat MySQL Data Transfer

Source Host           : localhost:3306
Source Database       : pmsystem
Target Server Type    : MYSQL
Date: 2018-01-03
*/

-- ----------------------------
-- Table structure for staffinfo
-- ----------------------------

DROP TABLE IF EXISTS `staffinfo`;
CREATE TABLE `staffinfo` (
  `id` int  NOT NULL  AUTO_INCREMENT,
  `username` varchar(255)  NOT NULL,
  `password` varchar(255)  NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT 'staff',
  `sex` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `businessgrade` varchar(255) DEFAULT NULL,
  `behaviorgrade` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `reward` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
)  ENGINE=InnoDB AUTO_INCREMENT=1001  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of  staffinfo
-- ----------------------------

INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1001', '1001', '张三', '男', '青岛','技术部', '90', '80', '6000' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1002', '1002', '李四', '男', '烟台','后勤部', '80', '76', '5000' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1003', '1003', '王五', '男', '烟台','销售部', '92', '84', '8300' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1004', '1004', '赵六', '男', '东营','销售部', '78', '88', '7300' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1005', '1005', '赵洪芳', '女', '石家庄','后勤部', '82', '97', '4600' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1006', '1006', '李红英', '女', '济南','销售部', '74', '84', '6200' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1007', '1007', '杨勇军', '男', '上海','销售部', '68', '86', '5200' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1008', '1008', '黄桂兰', '女', '威海','财务部', '63', '82', '4800' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1009', '1009', '李素芳', '女', '大同','财务部', '82', '99', '6400' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1010', '1010', '张泽云', '男', '苏州','人力资源部', '92', '97', '9100' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1011', '1011', '刘明成', '男', '东营','采购部', '62', '43', '3900' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1012', '1012', '帅军', '男', '德州','技术部', '78', '63', '5300' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1013', '1013', '朱洁', '女', '莱芜','采购部', '85', '93', '6000' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1014', '1014', '侯宝昆', '男', '哈尔滨','销售部', '72', '51', '5200' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1015', '1015', '罗丹', '女', '东营','后勤部', '74', '83', '6100' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1016','1016', '陈世贵', '男', '南京','人力资源部', '73', '67', '6400' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1017', '1017', '王文龙', '男', '贵州','销售部', '68', '76', '5800' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1018', '1018', '周丽', '女', '拉萨','生产部', '87', '88', '6300' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1019', '1019', '李三', '男', '东营','生产部', '88', '66', '6100' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1020', '1020', '马凯', '男', '北京','生产部', '56', '68', '4300' );
INSERT INTO `staffinfo`(`username`, `password`, `name`, `sex`, `location`, `department`, `businessgrade`, `behaviorgrade`, `salary`) 
VALUES ('a_1021', '1021', '童军', '男', '太原','生产部', '72', '72', '5800' );
INSERT INTO `staffinfo`(`username`, `password`, `role`) 
VALUES ('admin', 'admin' ,'hrs' );
