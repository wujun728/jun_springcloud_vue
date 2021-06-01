/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.34 : Database - ry-wms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ry-wms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `ry-wms`;

/*Table structure for table `wms_account` */

DROP TABLE IF EXISTS `wms_account`;

CREATE TABLE `wms_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '账户编号',
  `account_name` varchar(30) NOT NULL COMMENT '账户名称',
  `current_balance` decimal(10,6) DEFAULT NULL COMMENT '当前余额',
  `first_get` decimal(10,6) DEFAULT NULL COMMENT '期初余额',
  `account_type` varchar(30) NOT NULL COMMENT '账户类型',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户信息表';

/*Data for the table `wms_account` */

/*Table structure for table `wms_address` */

DROP TABLE IF EXISTS `wms_address`;

CREATE TABLE `wms_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(64) NOT NULL COMMENT '地址简称',
  `phone` varchar(30) NOT NULL COMMENT '联系电话',
  `contacts` varchar(30) NOT NULL COMMENT '联系人',
  `postal_code` varchar(30) DEFAULT NULL COMMENT '邮政编码',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
  `province` varchar(30) NOT NULL COMMENT '省',
  `city` varchar(30) NOT NULL COMMENT '市',
  `area` varchar(30) NOT NULL COMMENT '区',
  `address_detail` varchar(500) NOT NULL COMMENT '详细地址',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发货地址信息表';

/*Data for the table `wms_address` */

/*Table structure for table `wms_check_inventory` */

DROP TABLE IF EXISTS `wms_check_inventory`;

CREATE TABLE `wms_check_inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sn` varchar(64) DEFAULT NULL COMMENT '盘点单号',
  `status` varchar(8) DEFAULT NULL COMMENT '状态:0-待提交,1-待审批,2-已批准',
  `worker_id` int(11) DEFAULT NULL COMMENT '盘点人id',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
  `file_path` varchar(500) DEFAULT NULL COMMENT '上传盘点文件路径',
  `approval_time` datetime DEFAULT NULL COMMENT '审批时间',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘点表';

/*Data for the table `wms_check_inventory` */

/*Table structure for table `wms_check_inventory_item` */

DROP TABLE IF EXISTS `wms_check_inventory_item`;

CREATE TABLE `wms_check_inventory_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `check_inventory_id` int(11) DEFAULT NULL COMMENT '盘点单id',
  `sku_id` int(11) DEFAULT NULL COMMENT '商品sku',
  `inventory_type` varchar(8) DEFAULT NULL COMMENT '库存变动类型(4-盘盈入库,5-盘亏出库)',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `qty` decimal(20,6) DEFAULT NULL COMMENT '盘点库存数量',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘点明细表';

/*Data for the table `wms_check_inventory_item` */

/*Table structure for table `wms_customer` */

DROP TABLE IF EXISTS `wms_customer`;

CREATE TABLE `wms_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '客户编号',
  `customer_name` varchar(30) NOT NULL COMMENT '客户名称',
  `customer_type` varchar(8) DEFAULT NULL COMMENT '客户类别',
  `customer_level` varchar(8) DEFAULT NULL COMMENT '客户等级',
  `balance_date` datetime DEFAULT NULL COMMENT '余额日期',
  `first_get` decimal(10,6) DEFAULT NULL COMMENT '期初应收',
  `first_pre_get` decimal(10,6) DEFAULT NULL COMMENT '期初预收',
  `tax_identity` varchar(64) DEFAULT NULL COMMENT '纳税人识别号',
  `bank_info` varchar(256) DEFAULT NULL COMMENT '开户银行',
  `bank_num` varchar(256) DEFAULT NULL COMMENT '银行账号',
  `seller_id` int(11) DEFAULT NULL COMMENT '销售人员id',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='客户信息表';

/*Data for the table `wms_customer` */

insert  into `wms_customer`(`id`,`sn`,`customer_name`,`customer_type`,`customer_level`,`balance_date`,`first_get`,`first_pre_get`,`tax_identity`,`bank_info`,`bank_num`,`seller_id`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (2,'CT1620492327167','广东牛牛公司','2','2','2021-01-01 00:00:00','4545.440000','4545.440000','34234','中国银行','2323323',2,'\0',10,'','2021-05-09 00:45:27','admin','2021-05-11 05:52:36',NULL),(3,'CT1620492327168','广东牛牛公司','2','2','2021-01-01 00:00:00','4545.440000','4545.440000','34234','中国银行','2323323',1,'',10,'','2021-05-09 00:45:27','','2021-05-09 00:55:02',NULL),(4,'CT1620492327169','广东牛牛公司','2','2','2021-01-01 00:00:00','4545.440000','4545.440000','34234','中国银行','2323323',1,'',10,'','2021-05-09 00:45:27','','2021-05-09 00:55:02',NULL),(5,'CT1620651791627','rrrr','1','1','2021-05-10 00:00:00','3233.000000','2233.000000','rrere','erre','rererr',2,'\0',NULL,'admin','2021-05-10 21:03:12','admin','2021-05-11 04:27:30',NULL),(6,'CT1620683290204','xfd','1','1','2021-05-11 00:00:00','33.000000','23.000000','ewew','ewe','wewe',7,'\0',NULL,'admin','2021-05-11 05:48:10','admin','2021-05-11 05:48:24',NULL);

/*Table structure for table `wms_customer_contacts` */

DROP TABLE IF EXISTS `wms_customer_contacts`;

CREATE TABLE `wms_customer_contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(64) NOT NULL COMMENT '联系人姓名',
  `phone` varchar(30) NOT NULL COMMENT '联系人手机',
  `tel` varchar(64) DEFAULT NULL COMMENT '坐机',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱/QQ/微信',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='客户联系人信息表';

/*Data for the table `wms_customer_contacts` */

insert  into `wms_customer_contacts`(`id`,`name`,`phone`,`tel`,`email`,`address`,`is_default`,`del_flag`,`customer_id`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`) values (5,'关胜6','44444','4444','555','ewrwe','','\0',2,10,'','2021-05-09 00:45:27','','2021-05-11 05:52:36'),(6,'关胜','12222','2323','223','ewrwe','','\0',2,10,'','2021-05-09 00:45:27','','2021-05-11 05:52:36'),(7,'牛大力','12222','2323','223','ewrwe','\0','\0',2,10,'','2021-05-09 00:55:02','','2021-05-11 05:52:36'),(8,'erer','4333','','','','\0','\0',5,NULL,'admin','2021-05-10 21:03:12','','2021-05-11 04:27:30'),(9,'rerer','43434','','','','\0','\0',5,NULL,'admin','2021-05-10 21:03:12','','2021-05-11 04:27:30'),(10,'dfsfs','233','233','23','32','','\0',6,NULL,'admin','2021-05-11 05:48:10','','2021-05-11 05:48:24'),(11,'23r','r23','23r','2','3r','\0','\0',6,NULL,'admin','2021-05-11 05:48:10','','2021-05-11 05:48:24');

/*Table structure for table `wms_inventory` */

DROP TABLE IF EXISTS `wms_inventory`;

CREATE TABLE `wms_inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sku_id` int(11) DEFAULT NULL COMMENT 'skuId',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `qty` decimal(20,6) DEFAULT NULL COMMENT '库存数量',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存信息表';

/*Data for the table `wms_inventory` */

/*Table structure for table `wms_inventory_log` */

DROP TABLE IF EXISTS `wms_inventory_log`;

CREATE TABLE `wms_inventory_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '单号',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `inventory_type` varchar(8) DEFAULT NULL COMMENT '库存变动类型(0-采购入库,1-销售出库,2-调拨入库,3-调拨出库,4-盘盈入库,5-盘亏出库)',
  `sku_id` int(11) DEFAULT NULL COMMENT '商品skuId',
  `qty` decimal(20,6) DEFAULT NULL COMMENT '库存数量',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存操作日志表';

/*Data for the table `wms_inventory_log` */

/*Table structure for table `wms_product` */

DROP TABLE IF EXISTS `wms_product`;

CREATE TABLE `wms_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '商品编号',
  `product_code` varchar(64) NOT NULL COMMENT '商品编码',
  `category_id` int(11) DEFAULT NULL COMMENT '商品类别id',
  `is_spec` bit(1) DEFAULT NULL COMMENT '是否多规格',
  `spec_list` varchar(2000) DEFAULT NULL COMMENT '规格参数',
  `product_name` varchar(30) NOT NULL COMMENT '商品名称',
  `images` text COMMENT '图片',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

/*Data for the table `wms_product` */

insert  into `wms_product`(`id`,`sn`,`product_code`,`category_id`,`is_spec`,`spec_list`,`product_name`,`images`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (2,'PT1621463010146','efefe',2,'','[{\"searchValue\":null,\"createBy\":\"\",\"createTime\":\"2021-05-15 04:55:54\",\"updateBy\":\"\",\"updateTime\":\"2021-05-15 05:33:22\",\"remark\":null,\"params\":{},\"id\":1,\"specName\":\"颜色\",\"specAttr\":[\"红色\",\"白色\",\"黑色\"],\"delFlag\":null,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-19 10:10:42\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":2,\"specName\":\"尺寸\",\"specAttr\":[\"大\",\"中\",\"小\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"}]','efefe',NULL,'',NULL,'admin','2021-05-20 06:23:30','admin','2021-05-20 14:42:30','efefe'),(3,'PT1621463139460','dsds',0,'','[{\"searchValue\":null,\"createBy\":\"\",\"createTime\":\"2021-05-15 04:55:54\",\"updateBy\":\"\",\"updateTime\":\"2021-05-15 05:33:22\",\"remark\":null,\"params\":{},\"id\":1,\"specName\":\"颜色\",\"specAttr\":[\"红色\",\"白色\",\"黑色\"],\"delFlag\":null,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-19 10:10:42\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":2,\"specName\":\"尺寸\",\"specAttr\":[\"大\",\"中\",\"小\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"}]','sdsd',NULL,'',NULL,'admin','2021-05-20 06:25:39','admin','2021-05-20 14:42:32','sdsd'),(4,'PT1621493040368','P9394999938',2,'','[{\"searchValue\":null,\"createBy\":\"\",\"createTime\":\"2021-05-15 04:55:54\",\"updateBy\":\"\",\"updateTime\":\"2021-05-15 05:33:22\",\"remark\":null,\"params\":{},\"id\":1,\"specName\":\"颜色\",\"specAttr\":[\"红色\",\"黑色\"],\"delFlag\":null,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-19 10:10:42\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":2,\"specName\":\"尺寸\",\"specAttr\":[\"大\",\"中\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-20 14:09:45\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":3,\"specName\":\"套餐\",\"specAttr\":[\"套餐一\",\"套餐二\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"}]','电饭锅',NULL,'\0',NULL,'admin','2021-05-20 14:44:00','',NULL,'dldklfdlddsfsfsfsfsfsf'),(5,'PT1621493580404','K9899939488',2,'','[{\"searchValue\":null,\"createBy\":\"\",\"createTime\":\"2021-05-15 04:55:54\",\"updateBy\":\"\",\"updateTime\":\"2021-05-15 05:33:22\",\"remark\":null,\"params\":{},\"id\":1,\"specName\":\"颜色\",\"specAttr\":[\"红色\",\"白色\",\"黑色\"],\"delFlag\":null,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-19 10:10:42\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":2,\"specName\":\"尺寸\",\"specAttr\":[\"大\",\"中\",\"小\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-20 14:09:45\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":3,\"specName\":\"套餐\",\"specAttr\":[\"套餐一\",\"套餐二\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"}]','手机',NULL,'\0',NULL,'admin','2021-05-20 14:53:00','',NULL,'llksjfjefjefjlef'),(6,'PT1621494527878','dfdfefef',1,'','[{\"searchValue\":null,\"createBy\":\"\",\"createTime\":\"2021-05-15 04:55:54\",\"updateBy\":\"\",\"updateTime\":\"2021-05-15 05:33:22\",\"remark\":null,\"params\":{},\"id\":1,\"specName\":\"颜色\",\"specAttr\":[\"红色\",\"白色\"],\"delFlag\":null,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-19 10:10:42\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":2,\"specName\":\"尺寸\",\"specAttr\":[\"大\",\"中\",\"小\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-20 14:09:45\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":3,\"specName\":\"套餐\",\"specAttr\":[\"套餐一\",\"套餐二\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"}]','wefwefwf',NULL,'\0',NULL,'admin','2021-05-20 15:08:48','',NULL,'wewfw'),(7,'PT1621589351074','PN65554542452523',1,'','[{\"searchValue\":null,\"createBy\":\"\",\"createTime\":\"2021-05-15 04:55:54\",\"updateBy\":\"\",\"updateTime\":\"2021-05-15 05:33:22\",\"remark\":null,\"params\":{},\"id\":1,\"specName\":\"颜色\",\"specAttr\":[\"红色\",\"白色\",\"灰色\"],\"delFlag\":null,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"},{\"searchValue\":null,\"createBy\":\"admin\",\"createTime\":\"2021-05-19 10:10:42\",\"updateBy\":\"\",\"updateTime\":null,\"remark\":null,\"params\":{},\"id\":2,\"specName\":\"尺寸\",\"specAttr\":[\"大\",\"小\"],\"delFlag\":false,\"tenantId\":null,\"inputVisible\":false,\"inputValue\":\"\"}]','电风扇',NULL,'\0',NULL,'admin','2021-05-21 17:29:11','admin','2021-05-21 17:31:04','jhfshkjfhskfhskhfksfksfhkshfkshfkshfkshfkehkfekf');

/*Table structure for table `wms_product_category` */

DROP TABLE IF EXISTS `wms_product_category`;

CREATE TABLE `wms_product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_name` varchar(64) NOT NULL COMMENT '分类名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类别id',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品分类信息表';

/*Data for the table `wms_product_category` */

insert  into `wms_product_category`(`id`,`category_name`,`parent_id`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'gfgdg',0,NULL,NULL,'','2021-05-14 16:04:22','',NULL,NULL),(2,'ddfdfd',1,NULL,NULL,'','2021-05-14 16:04:29','',NULL,NULL);

/*Table structure for table `wms_product_sku` */

DROP TABLE IF EXISTS `wms_product_sku`;

CREATE TABLE `wms_product_sku` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) DEFAULT NULL COMMENT '商品编号',
  `bar_code` varchar(64) DEFAULT NULL COMMENT '商品条码',
  `sku_name` varchar(500) DEFAULT NULL COMMENT '商品sku名称',
  `specifications` varchar(500) DEFAULT NULL COMMENT '规格',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `sale_price` decimal(10,6) DEFAULT NULL COMMENT '零售价',
  `trade_price` decimal(10,6) DEFAULT NULL COMMENT '批发价',
  `vip_price` decimal(10,6) DEFAULT NULL COMMENT '会员价',
  `discount1` decimal(10,6) DEFAULT NULL COMMENT '折扣一',
  `discount2` decimal(10,6) DEFAULT NULL COMMENT '折扣二',
  `purchase_price` decimal(10,6) DEFAULT NULL COMMENT '预计采购价',
  `images` text COMMENT '图片',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(11) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='商品sku信息表';

/*Data for the table `wms_product_sku` */

insert  into `wms_product_sku`(`id`,`sn`,`bar_code`,`sku_name`,`specifications`,`product_id`,`sale_price`,`trade_price`,`vip_price`,`discount1`,`discount2`,`purchase_price`,`images`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'ST1621463010158',NULL,NULL,'红色',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:23:30','',NULL,NULL),(2,'ST1621463010220',NULL,NULL,'白色',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:23:30','',NULL,NULL),(3,'ST1621463010231',NULL,NULL,'黑色',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:23:30','',NULL,NULL),(4,'ST1621463139476',NULL,NULL,'红色_大',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(5,'ST1621463139491',NULL,NULL,'红色_中',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(6,'ST1621463139507',NULL,NULL,'红色_小',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(7,'ST1621463139520',NULL,NULL,'白色_大',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(8,'ST1621463139532',NULL,NULL,'白色_中',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(9,'ST1621463139547',NULL,NULL,'白色_小',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(10,'ST1621463139558',NULL,NULL,'黑色_大',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(11,'ST1621463139568',NULL,NULL,'黑色_中',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(12,'ST1621463139577',NULL,NULL,'黑色_小',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin','2021-05-20 06:25:39','',NULL,NULL),(13,'ST1621493040393','33344',NULL,'红色_大',4,'4.000000','4.000000','4.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:44:00','',NULL,NULL),(14,'ST1621493040410','434343',NULL,'红色_中',4,'6.000000','6.000000','6.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:44:00','',NULL,NULL),(15,'ST1621493040420','43434',NULL,'黑色_大',4,'7.000000','7.000000','7.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:44:00','',NULL,NULL),(16,'ST1621493040429','343434',NULL,'黑色_中',4,'5.000000','5.000000','5.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:44:00','',NULL,NULL),(17,'ST1621493580415',NULL,NULL,'红色',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:53:00','',NULL,NULL),(18,'ST1621493580424',NULL,NULL,'白色',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:53:00','',NULL,NULL),(19,'ST1621493580431',NULL,NULL,'黑色',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 14:53:00','',NULL,NULL),(20,'ST1621494527887',NULL,NULL,'红色',6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 15:08:48','',NULL,NULL),(21,'ST1621494527898',NULL,NULL,'白色',6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-20 15:08:48','',NULL,NULL),(22,'ST1621589351094','3333',NULL,'红色_大',7,'3.000000','3.000000','3.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:11','admin','2021-05-21 17:31:04',NULL),(23,'ST1621589351111','4444',NULL,'红色_中',7,'4.000000','4.000000','4.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:11','admin','2021-05-21 17:31:04',NULL),(24,'ST1621589351119','555',NULL,'白色_大',7,'5.000000','5.000000','5.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:11','admin','2021-05-21 17:31:04',NULL),(25,'ST1621589351129','6666',NULL,'白色_中',7,'6.000000','6.000000','6.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:11','admin','2021-05-21 17:31:04',NULL),(26,'ST1621589361442','3333',NULL,'红色_大',7,'3.000000','3.000000','3.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:21','admin','2021-05-21 17:31:04','jhfshkjfhskfhskhfksfksfhkshfkshfkshfkshfkehkfekf'),(27,'ST1621589361452','4444',NULL,'红色_中',7,'4.000000','4.000000','4.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:21','admin','2021-05-21 17:31:04','jhfshkjfhskfhskhfksfksfhkshfkshfkshfkshfkehkfekf'),(28,'ST1621589361461','555',NULL,'白色_大',7,'5.000000','5.000000','5.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:21','admin','2021-05-21 17:31:04','jhfshkjfhskfhskhfksfksfhkshfkshfkshfkshfkehkfekf'),(29,'ST1621589361470','6666',NULL,'白色_中',7,'6.000000','6.000000','6.000000',NULL,NULL,NULL,NULL,'',NULL,'admin','2021-05-21 17:29:21','admin','2021-05-21 17:31:04','jhfshkjfhskfhskhfksfksfhkshfkshfkshfkshfkehkfekf'),(30,'ST1621589463834','3333',NULL,'红色_大',7,'3.000000','3.000000','3.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-21 17:31:04','',NULL,NULL),(31,'ST1621589463843','4444',NULL,'红色_小',7,'4.000000','4.000000','4.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-21 17:31:04','',NULL,NULL),(32,'ST1621589463850','5555',NULL,'白色_大',7,'5.000000','5.000000','5.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-21 17:31:04','',NULL,NULL),(33,'ST1621589463857','6666',NULL,'白色_小',7,'6.000000','6.000000','6.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-21 17:31:04','',NULL,NULL),(34,'ST1621589463864','7777',NULL,'灰色_大',7,'7.000000','7.000000','7.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-21 17:31:04','',NULL,NULL),(35,'ST1621589463872','8888',NULL,'灰色_小',7,'8.000000','8.000000','8.000000',NULL,NULL,NULL,NULL,'\0',NULL,'admin','2021-05-21 17:31:04','',NULL,NULL);

/*Table structure for table `wms_product_spec` */

DROP TABLE IF EXISTS `wms_product_spec`;

CREATE TABLE `wms_product_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `spec_name` varchar(30) NOT NULL COMMENT '规格名称',
  `spec_attr` varchar(1000) NOT NULL COMMENT '规格属性',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品规格表';

/*Data for the table `wms_product_spec` */

insert  into `wms_product_spec`(`id`,`spec_name`,`spec_attr`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'颜色','[\"红色\",\"白色\",\"黑色\"]',NULL,NULL,'','2021-05-15 04:55:54','','2021-05-15 05:33:22',NULL),(2,'尺寸','[\"大\",\"中\",\"小\"]','\0',NULL,'admin','2021-05-19 10:10:42','',NULL,NULL),(3,'套餐','[\"套餐一\",\"套餐二\"]','\0',NULL,'admin','2021-05-20 14:09:45','',NULL,NULL);

/*Table structure for table `wms_purchase_order` */

DROP TABLE IF EXISTS `wms_purchase_order`;

CREATE TABLE `wms_purchase_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '采购订单编号',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `buy_date` datetime DEFAULT NULL COMMENT '购货日期',
  `bill_date` datetime DEFAULT NULL COMMENT '单据日期',
  `inventory_type` varchar(8) DEFAULT NULL COMMENT '0-采购入库',
  `inventory_status` varchar(8) DEFAULT NULL COMMENT '0-未确认,1-确认入库,2-确认出库',
  `discount_rate` decimal(20,6) DEFAULT NULL COMMENT '优惠率',
  `discount_amount` decimal(20,6) DEFAULT NULL COMMENT '优惠金额',
  `total_amount` decimal(20,6) DEFAULT NULL COMMENT '合计金额',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单表';

/*Data for the table `wms_purchase_order` */

/*Table structure for table `wms_purchase_order_item` */

DROP TABLE IF EXISTS `wms_purchase_order_item`;

CREATE TABLE `wms_purchase_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `purchase_order_id` int(11) DEFAULT NULL COMMENT '订单主表id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'skuId',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `price` decimal(20,6) DEFAULT NULL COMMENT '购买单价',
  `qty` decimal(20,6) DEFAULT NULL COMMENT '购买数量',
  `discount_rate` decimal(20,6) DEFAULT NULL COMMENT '优惠率',
  `discount_amount` decimal(20,6) DEFAULT NULL COMMENT '优惠金额',
  `amount` decimal(20,6) DEFAULT NULL COMMENT '金额',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单明细表';

/*Data for the table `wms_purchase_order_item` */

/*Table structure for table `wms_sale_order` */

DROP TABLE IF EXISTS `wms_sale_order`;

CREATE TABLE `wms_sale_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '销售单编号',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `worker_id` int(11) DEFAULT NULL COMMENT '销售人id',
  `bill_date` datetime DEFAULT NULL COMMENT '单据日期',
  `address` varchar(500) DEFAULT NULL COMMENT '客户地址',
  `inventory_type` varchar(8) DEFAULT NULL COMMENT '1-销售出库',
  `inventory_status` varchar(8) DEFAULT NULL COMMENT '0-未确认,1-确认入库,2-确认出库',
  `discount_rate` decimal(20,6) DEFAULT NULL COMMENT '优惠率',
  `discount_amount` decimal(20,6) DEFAULT NULL COMMENT '优惠金额',
  `total_amount` decimal(20,6) DEFAULT NULL COMMENT '合计金额',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售订单表';

/*Data for the table `wms_sale_order` */

/*Table structure for table `wms_sale_order_item` */

DROP TABLE IF EXISTS `wms_sale_order_item`;

CREATE TABLE `wms_sale_order_item` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `sale_order_id` int(11) DEFAULT NULL COMMENT '销售订单主表id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `sku_id` int(11) DEFAULT NULL COMMENT 'skuId',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `price` decimal(20,6) DEFAULT NULL COMMENT '销售单价',
  `qty` decimal(20,6) DEFAULT NULL COMMENT '销售数量',
  `discount_rate` decimal(20,6) DEFAULT NULL COMMENT '优惠率',
  `discount_amount` decimal(20,6) DEFAULT NULL COMMENT '优惠金额',
  `amount` decimal(20,6) DEFAULT NULL COMMENT '金额',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售订单明细表';

/*Data for the table `wms_sale_order_item` */

/*Table structure for table `wms_supplier` */

DROP TABLE IF EXISTS `wms_supplier`;

CREATE TABLE `wms_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '供应商编号',
  `supplier_name` varchar(30) NOT NULL COMMENT '客户名称',
  `supplier_type` varchar(8) DEFAULT NULL COMMENT '客户类别',
  `balance_date` datetime DEFAULT NULL COMMENT '余额日期',
  `first_pay` decimal(10,6) DEFAULT NULL COMMENT '期初应付',
  `first_pre_pay` decimal(10,6) DEFAULT NULL COMMENT '期初预付款',
  `tax_identity` varchar(64) DEFAULT NULL COMMENT '纳税人识别号',
  `tax_rate` decimal(20,6) DEFAULT NULL COMMENT '增值税税率',
  `bank_info` varchar(256) DEFAULT NULL COMMENT '开户银行',
  `bank_num` varchar(256) DEFAULT NULL COMMENT '银行账号',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='供应商信息表';

/*Data for the table `wms_supplier` */

insert  into `wms_supplier`(`id`,`sn`,`supplier_name`,`supplier_type`,`balance_date`,`first_pay`,`first_pre_pay`,`tax_identity`,`tax_rate`,`bank_info`,`bank_num`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'ST1620692435561','sdssd','1',NULL,NULL,NULL,'',NULL,'','','\0',NULL,'admin','2021-05-11 08:20:36','',NULL,NULL),(3,'ST1620692715001','wefwef','1','2021-05-10 00:00:00','32.000000','23.000000','er','32.000000','eww','ewewe','\0',NULL,'admin','2021-05-11 08:25:15','',NULL,NULL),(4,'ST1620874616655','fghfhg','2','2021-05-12 00:00:00','56.000000','56.000000','56ytyy','56.000000','hght','tytydddccccddddd','\0',NULL,'admin','2021-05-13 10:56:57','admin','2021-05-13 11:10:50',NULL),(5,'ST1620875642455','','',NULL,NULL,NULL,'',NULL,'','','',NULL,'admin','2021-05-13 11:14:02','',NULL,NULL);

/*Table structure for table `wms_supplier_contacts` */

DROP TABLE IF EXISTS `wms_supplier_contacts`;

CREATE TABLE `wms_supplier_contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(64) NOT NULL COMMENT '联系人姓名',
  `phone` varchar(30) NOT NULL COMMENT '联系人手机',
  `tel` varchar(64) DEFAULT NULL COMMENT '坐机',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱/QQ/微信',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `supplier_id` int(11) DEFAULT NULL COMMENT '客户ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='供应商联系人信息表';

/*Data for the table `wms_supplier_contacts` */

insert  into `wms_supplier_contacts`(`id`,`name`,`phone`,`tel`,`email`,`address`,`is_default`,`del_flag`,`supplier_id`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'fewf','wefw','wefw','wef','wfw','\0','\0',3,NULL,'admin','2021-05-11 08:25:15','',NULL,NULL),(2,'hgfh','ghfgh','fgh','fgh','fgh','\0','\0',4,NULL,'admin','2021-05-13 10:56:57','admin','2021-05-13 11:10:50',NULL);

/*Table structure for table `wms_transfer_order` */

DROP TABLE IF EXISTS `wms_transfer_order`;

CREATE TABLE `wms_transfer_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sn` varchar(64) NOT NULL COMMENT '调拨单编号',
  `bill_date` datetime DEFAULT NULL COMMENT '单据日期',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调拨单';

/*Data for the table `wms_transfer_order` */

/*Table structure for table `wms_transfer_order_item` */

DROP TABLE IF EXISTS `wms_transfer_order_item`;

CREATE TABLE `wms_transfer_order_item` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `transfer_order_id` int(11) DEFAULT NULL COMMENT '调拨单id',
  `warehouse_in_id` int(11) DEFAULT NULL COMMENT '入库仓',
  `warehouse_out_id` int(11) DEFAULT NULL COMMENT '出库仓',
  `sku_id` int(11) DEFAULT NULL COMMENT '商品sku',
  `qty` decimal(20,6) DEFAULT NULL COMMENT '调拨数量',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调拨单明细';

/*Data for the table `wms_transfer_order_item` */

/*Table structure for table `wms_warehouse` */

DROP TABLE IF EXISTS `wms_warehouse`;

CREATE TABLE `wms_warehouse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '仓库编号',
  `warehouse_name` varchar(30) NOT NULL COMMENT '仓库名称',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='仓库信息表';

/*Data for the table `wms_warehouse` */

insert  into `wms_warehouse`(`id`,`sn`,`warehouse_name`,`del_flag`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'WT1621586431077','广州仓库','\0',NULL,'','2021-05-21 16:40:31','',NULL,NULL),(2,'WT1621586442085','佛山仓库','\0',NULL,'','2021-05-21 16:40:42','',NULL,NULL);

/*Table structure for table `wms_worker` */

DROP TABLE IF EXISTS `wms_worker`;

CREATE TABLE `wms_worker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(64) NOT NULL COMMENT '职员编号',
  `worker_name` varchar(30) NOT NULL COMMENT '职员名称',
  `phone` varchar(64) NOT NULL COMMENT '手机号',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职员信息表';

/*Data for the table `wms_worker` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
