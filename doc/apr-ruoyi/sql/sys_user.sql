/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : estate

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2021-03-19 10:47:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '2021-02-26 10:41:22', '2021-03-11 15:20:54');
INSERT INTO `sys_user` VALUES ('2', 'ry', '若依', 'ry@163.com', '15888888888', '0', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '1', '0', '2021-02-26 10:41:22', '2021-03-12 16:22:59');
INSERT INTO `sys_user` VALUES ('3', 'test111', 'test', 'r@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '2021-02-26 10:41:22', '2021-03-02 16:55:43');
INSERT INTO `sys_user` VALUES ('4', 'newuser', 'newuser', '2770281812@qq.com', '15612369842', '0', '', '$2a$10$oOmD95gAUMvVNdQvxJBWvOy3pphKWU8QnSHWFzgvTqu0ct5HXpEhm', '0', '2', '2021-03-11 15:20:46', '2021-03-19 15:20:51');
INSERT INTO `sys_user` VALUES ('5', 'no1', 'no1', '27812@qq.com', '15612369234', '0', '', '$2a$10$/a13wFMPj10Ge/LB8clWyuC070WCjX21J7zXBURq7i6wyVzEpBkE.', '0', '0', '2021-03-12 15:19:07', '2021-03-13 16:57:33');
INSERT INTO `sys_user` VALUES ('6', 'no2', 'no2', 'r2@163.com', '15236845120', '0', '', '$2a$10$NmQ6W.tBAWK4xxb5BkV2XOqiwgAIB8Zpm4Co1l8ZYzJw3AIJPlCm.', '0', '2', '2021-03-13 15:59:03', '2021-03-13 15:59:03');
INSERT INTO `sys_user` VALUES ('7', 'no3', 'no3', 'r3@163.com', '15364102023', '1', '', '$2a$10$ldQwC5EQ8D6jyL7zMfmc4eK/oIH60WAhb6XdtxyIgBNXB6N9CfUGe', '0', '2', '2021-03-13 15:59:32', '2021-03-13 15:59:32');
INSERT INTO `sys_user` VALUES ('8', 'no5', 'no5', 'r5@163.com', '15553641560', '0', '', '$2a$10$HwBmL9lK.V2U00W0aomcT..iUyH9Ofua5pykn3JQSLlzhG89DQ7Pq', '0', '0', '2021-03-14 15:11:41', '2021-03-14 20:01:38');
INSERT INTO `sys_user` VALUES ('9', 'user01', 'user01', 'r01@163.com', '15148966695', '0', '', '$2a$10$WbrM8dYrm59nlh1bwfeJC.pjxVmAvJNamSnD7Y2A8wjU8YU5QtFQO', '0', '0', '2021-03-15 19:02:11', '2021-03-15 19:02:11');
INSERT INTO `sys_user` VALUES ('10', 'user02', 'user02', 'r02@163.com', '15269845623', '0', '', '$2a$10$HW534BlmRlqjetPM7mBCz.JahezDuyCaB85O./Um2YNqf6GMBMYIq', '0', '0', '2021-03-18 20:41:05', '2021-03-18 20:41:05');
