/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : estate

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2021-03-19 10:45:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1066 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', 'system', null, '1', '0', 'M', '0', '0', '', 'system', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', 'monitor', null, '1', '0', 'M', '0', '0', '', 'monitor', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '3', 'tool', null, '1', '0', 'M', '0', '0', '', 'tool', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('4', '若依官网', '0', '4', 'http://ruoyi.vip', null, '0', '0', 'M', '0', '0', '', 'guide', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '1', '0', 'C', '0', '0', 'system:user:list', 'user', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '1', '0', 'C', '0', '0', 'system:role:list', 'peoples', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '1', '0', 'C', '0', '0', 'system:menu:list', 'tree-table', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '1', '0', 'C', '0', '0', 'system:dept:list', 'tree', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '1', '0', 'C', '0', '0', 'system:post:list', 'post', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '1', '0', 'C', '0', '0', 'system:dict:list', 'dict', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', 'config', 'system/config/index', '1', '0', 'C', '0', '0', 'system:config:list', 'edit', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', 'notice', 'system/notice/index', '1', '0', 'C', '0', '0', 'system:notice:list', 'message', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', 'log', '', '1', '0', 'M', '0', '0', '', 'log', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', 'online', 'monitor/online/index', '1', '0', 'C', '0', '0', 'monitor:online:list', 'online', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', 'job', 'monitor/job/index', '1', '0', 'C', '0', '0', 'monitor:job:list', 'job', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', 'druid', 'monitor/druid/index', '1', '0', 'C', '0', '0', 'monitor:druid:list', 'druid', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('112', '服务监控', '2', '4', 'server', 'monitor/server/index', '1', '0', 'C', '0', '0', 'monitor:server:list', 'server', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('113', '缓存监控', '2', '5', 'cache', 'monitor/cache/index', '1', '0', 'C', '0', '0', 'monitor:cache:list', 'redis', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('114', '表单构建', '3', '1', 'build', 'tool/build/index', '1', '0', 'C', '0', '0', 'tool:build:list', 'build', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('115', '代码生成', '3', '2', 'gen', 'tool/gen/index', '1', '0', 'C', '0', '0', 'tool:gen:list', 'code', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('116', '系统接口', '3', '3', 'swagger', 'tool/swagger/index', '1', '0', 'C', '0', '0', 'tool:swagger:list', 'swagger', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', 'operlog', 'monitor/operlog/index', '1', '0', 'C', '0', '0', 'monitor:operlog:list', 'form', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '1', '0', 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1001', '用户查询', '100', '1', '', '', '1', '0', 'F', '0', '0', 'system:user:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1002', '用户新增', '100', '2', '', '', '1', '0', 'F', '0', '0', 'system:user:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1003', '用户修改', '100', '3', '', '', '1', '0', 'F', '0', '0', 'system:user:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1004', '用户删除', '100', '4', '', '', '1', '0', 'F', '0', '0', 'system:user:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1005', '用户导出', '100', '5', '', '', '1', '0', 'F', '0', '0', 'system:user:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1006', '用户导入', '100', '6', '', '', '1', '0', 'F', '0', '0', 'system:user:import', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1007', '重置密码', '100', '7', '', '', '1', '0', 'F', '0', '0', 'system:user:resetPwd', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1008', '角色查询', '101', '1', '', '', '1', '0', 'F', '0', '0', 'system:role:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1009', '角色新增', '101', '2', '', '', '1', '0', 'F', '0', '0', 'system:role:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1010', '角色修改', '101', '3', '', '', '1', '0', 'F', '0', '0', 'system:role:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1011', '角色删除', '101', '4', '', '', '1', '0', 'F', '0', '0', 'system:role:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1012', '角色导出', '101', '5', '', '', '1', '0', 'F', '0', '0', 'system:role:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1013', '菜单查询', '102', '1', '', '', '1', '0', 'F', '0', '0', 'system:menu:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1014', '菜单新增', '102', '2', '', '', '1', '0', 'F', '0', '0', 'system:menu:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1015', '菜单修改', '102', '3', '', '', '1', '0', 'F', '0', '0', 'system:menu:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1016', '菜单删除', '102', '4', '', '', '1', '0', 'F', '0', '0', 'system:menu:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1017', '部门查询', '103', '1', '', '', '1', '0', 'F', '0', '0', 'system:dept:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1018', '部门新增', '103', '2', '', '', '1', '0', 'F', '0', '0', 'system:dept:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1019', '部门修改', '103', '3', '', '', '1', '0', 'F', '0', '0', 'system:dept:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1020', '部门删除', '103', '4', '', '', '1', '0', 'F', '0', '0', 'system:dept:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1021', '岗位查询', '104', '1', '', '', '1', '0', 'F', '0', '0', 'system:post:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1022', '岗位新增', '104', '2', '', '', '1', '0', 'F', '0', '0', 'system:post:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1023', '岗位修改', '104', '3', '', '', '1', '0', 'F', '0', '0', 'system:post:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1024', '岗位删除', '104', '4', '', '', '1', '0', 'F', '0', '0', 'system:post:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1025', '岗位导出', '104', '5', '', '', '1', '0', 'F', '0', '0', 'system:post:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1026', '字典查询', '105', '1', '#', '', '1', '0', 'F', '0', '0', 'system:dict:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1027', '字典新增', '105', '2', '#', '', '1', '0', 'F', '0', '0', 'system:dict:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1028', '字典修改', '105', '3', '#', '', '1', '0', 'F', '0', '0', 'system:dict:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1029', '字典删除', '105', '4', '#', '', '1', '0', 'F', '0', '0', 'system:dict:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1030', '字典导出', '105', '5', '#', '', '1', '0', 'F', '0', '0', 'system:dict:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1031', '参数查询', '106', '1', '#', '', '1', '0', 'F', '0', '0', 'system:config:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1032', '参数新增', '106', '2', '#', '', '1', '0', 'F', '0', '0', 'system:config:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1033', '参数修改', '106', '3', '#', '', '1', '0', 'F', '0', '0', 'system:config:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1034', '参数删除', '106', '4', '#', '', '1', '0', 'F', '0', '0', 'system:config:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1035', '参数导出', '106', '5', '#', '', '1', '0', 'F', '0', '0', 'system:config:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1036', '公告查询', '107', '1', '#', '', '1', '0', 'F', '0', '0', 'system:notice:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1037', '公告新增', '107', '2', '#', '', '1', '0', 'F', '0', '0', 'system:notice:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1038', '公告修改', '107', '3', '#', '', '1', '0', 'F', '0', '0', 'system:notice:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1039', '公告删除', '107', '4', '#', '', '1', '0', 'F', '0', '0', 'system:notice:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1040', '操作查询', '500', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:operlog:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1041', '操作删除', '500', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:operlog:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', '1', '0', 'F', '0', '0', 'monitor:operlog:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1046', '在线查询', '109', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:online:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1047', '批量强退', '109', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:online:batchLogout', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1048', '单条强退', '109', '3', '#', '', '1', '0', 'F', '0', '0', 'monitor:online:forceLogout', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1049', '任务查询', '110', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1050', '任务新增', '110', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:add', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1051', '任务修改', '110', '3', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1052', '任务删除', '110', '4', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1053', '状态修改', '110', '5', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:changeStatus', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1054', '任务导出', '110', '7', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:export', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1055', '生成查询', '115', '1', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:query', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1056', '生成修改', '115', '2', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:edit', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1057', '生成删除', '115', '3', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:remove', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1058', '导入代码', '115', '2', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:import', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1059', '预览代码', '115', '4', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:preview', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1060', '生成代码', '115', '5', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:code', '#', '2021-02-26 10:41:22', null);
INSERT INTO `sys_menu` VALUES ('1061', '报表', '0', '5', 'system', null, '1', '0', 'M', '0', '0', null, 'chart', '2021-03-18 17:18:12', '2021-03-18 17:18:12');
INSERT INTO `sys_menu` VALUES ('1062', '邮箱', '0', '6', 'system', null, '1', '0', 'M', '0', '0', null, 'checkbox', '2021-03-18 19:43:19', '2021-03-18 19:43:19');
INSERT INTO `sys_menu` VALUES ('1063', '颜色', '1061', '1', 'system', 'system/color/index', '1', '0', 'C', '0', '0', 'system:color:list', 'color', '2021-03-18 19:52:31', '2021-03-18 19:52:31');
INSERT INTO `sys_menu` VALUES ('1064', '颜色查询', '1063', '1', '', null, '1', '0', 'F', '0', '0', 'system:color:query', '#', '2021-03-18 19:54:36', '2021-03-18 19:54:36');
INSERT INTO `sys_menu` VALUES ('1065', '颜色修改', '1063', '2', '', null, '1', '0', 'F', '0', '0', 'system:color:update', '#', '2021-03-18 19:56:37', '2021-03-18 20:00:23');
