/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : estate

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2021-03-19 10:46:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '0', '0', '2021-02-26 10:41:22', '2021-02-28 19:23:27', 'admin');
INSERT INTO `sys_role` VALUES ('2', '普通角色', '0', '0', '2021-02-10 19:24:18', '2021-03-04 19:24:21', 'common');
INSERT INTO `sys_role` VALUES ('3', '用户', '0', '0', '2021-03-10 16:56:37', '2021-03-12 16:56:40', 'test');
INSERT INTO `sys_role` VALUES ('4', '测试', '0', '2', '2021-03-13 19:53:53', '2021-03-20 19:53:59', 'test2');
INSERT INTO `sys_role` VALUES ('5', 'dddd', '0', '2', '2021-03-25 19:54:03', '2021-03-30 19:54:07', 'dddd');
INSERT INTO `sys_role` VALUES ('6', 'role6', '0', '0', '2021-03-14 19:53:42', '2021-03-15 18:27:55', 'role6');
INSERT INTO `sys_role` VALUES ('7', 'role01', '0', '2', '2021-03-15 19:04:17', '2021-03-15 19:04:17', 'role01');
INSERT INTO `sys_role` VALUES ('8', 'role02', '0', '2', '2021-03-15 19:04:42', '2021-03-15 19:04:42', 'role02');
INSERT INTO `sys_role` VALUES ('9', 'no7', '0', '0', '2021-03-18 20:40:18', '2021-03-18 20:40:18', 'no7');
