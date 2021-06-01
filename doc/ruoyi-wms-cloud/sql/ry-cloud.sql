/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.34 : Database - ry-cloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ry-cloud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `ry-cloud`;

/*Table structure for table `gen_table` */

DROP TABLE IF EXISTS `gen_table`;

CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表';

/*Data for the table `gen_table` */

insert  into `gen_table`(`table_id`,`table_name`,`table_comment`,`sub_table_name`,`sub_table_fk_name`,`class_name`,`tpl_category`,`package_name`,`module_name`,`business_name`,`function_name`,`function_author`,`gen_type`,`gen_path`,`options`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (31,'wms_sale_order','销售订单表',NULL,NULL,'SaleOrder','crud','com.wms.oms','oms','order','销售订单','zzm','0','/',NULL,'admin','2021-05-16 06:08:40','',NULL,NULL),(32,'wms_sale_order_item','销售订单明细表',NULL,NULL,'SaleOrderItem','crud','com.wms.oms','oms','item','销售订单明细','zzm','0','/',NULL,'admin','2021-05-16 06:34:32','',NULL,NULL),(34,'wms_inventory','库存信息表',NULL,NULL,'Inventory','crud','com.wms.oms','oms','inventory','库存信息','zzm','0','/',NULL,'admin','2021-05-16 06:41:05','',NULL,NULL),(36,'wms_inventory_log','库存操作日志表',NULL,NULL,'InventoryLog','crud','com.wms.oms','oms','log','库存操作日志','zzm','0','/',NULL,'admin','2021-05-16 06:52:17','',NULL,NULL),(37,'wms_purchase_order','采购订单表',NULL,NULL,'PurchaseOrder','crud','com.wms.oms','oms','order','采购订单','zzm','0','/',NULL,'admin','2021-05-18 16:55:39','',NULL,NULL);

/*Table structure for table `gen_table_column` */

DROP TABLE IF EXISTS `gen_table_column`;

CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=470 DEFAULT CHARSET=utf8 COMMENT='代码生成业务表字段';

/*Data for the table `gen_table_column` */

insert  into `gen_table_column`(`column_id`,`table_id`,`column_name`,`column_comment`,`column_type`,`java_type`,`java_field`,`is_pk`,`is_increment`,`is_required`,`is_insert`,`is_edit`,`is_list`,`is_query`,`query_type`,`html_type`,`dict_type`,`sort`,`create_by`,`create_time`,`update_by`,`update_time`) values (373,'31','id','ID','bigint(20)','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-16 06:08:40','',NULL),(374,'31','sn','销售单编号','varchar(64)','String','sn','0','0','1','1','1','1','1','EQ','input','',2,'admin','2021-05-16 06:08:40','',NULL),(375,'31','customer_id','客户id','int(11)','Long','customerId','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-16 06:08:40','',NULL),(376,'31','worker_id','销售人id','int(11)','Long','workerId','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2021-05-16 06:08:40','',NULL),(377,'31','bill_date','单据日期','datetime','Date','billDate','0','0',NULL,'1','1','1','1','EQ','datetime','',5,'admin','2021-05-16 06:08:40','',NULL),(378,'31','address','客户地址','varchar(500)','String','address','0','0',NULL,'1','1','1','1','EQ','textarea','',6,'admin','2021-05-16 06:08:40','',NULL),(379,'31','inventory_type','1-销售出库','varchar(8)','String','inventoryType','0','0',NULL,'1','1','1','1','EQ','select','',7,'admin','2021-05-16 06:08:40','',NULL),(380,'31','discount_rate','优惠率','decimal(20,6)','BigDecimal','discountRate','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2021-05-16 06:08:40','',NULL),(381,'31','discount_amount','优惠金额','decimal(20,6)','BigDecimal','discountAmount','0','0',NULL,'1','1','1','1','EQ','input','',9,'admin','2021-05-16 06:08:40','',NULL),(382,'31','total_amount','合计金额','decimal(20,6)','BigDecimal','totalAmount','0','0',NULL,'1','1','1','1','EQ','input','',10,'admin','2021-05-16 06:08:40','',NULL),(383,'31','del_flag','删除标志（0代表存在 1代表删除）','bit(1)','String','delFlag','0','0',NULL,'1',NULL,NULL,NULL,'EQ',NULL,'',11,'admin','2021-05-16 06:08:40','',NULL),(384,'31','tenant_id','租户ID','bigint(20)','Long','tenantId','0','0',NULL,'1','1','1','1','EQ','input','',12,'admin','2021-05-16 06:08:40','',NULL),(385,'31','create_by','创建者','varchar(64)','String','createBy','0','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',13,'admin','2021-05-16 06:08:40','',NULL),(386,'31','create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',14,'admin','2021-05-16 06:08:40','',NULL),(387,'31','update_by','更新者','varchar(64)','String','updateBy','0','0',NULL,'1','1',NULL,NULL,'EQ','input','',15,'admin','2021-05-16 06:08:40','',NULL),(388,'31','update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',16,'admin','2021-05-16 06:08:40','',NULL),(389,'31','remark','备注','varchar(500)','String','remark','0','0',NULL,'1','1','1',NULL,'EQ','textarea','',17,'admin','2021-05-16 06:08:40','',NULL),(390,'32','id','ID','bigint(20)','Long','id','1','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-16 06:34:32','',NULL),(391,'32','sale_order_id','销售订单主表id','int(11)','Long','saleOrderId','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-16 06:34:32','',NULL),(392,'32','product_id','商品id','int(11)','Long','productId','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-16 06:34:32','',NULL),(393,'32','warehouse_id','仓库id','int(11)','Long','warehouseId','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2021-05-16 06:34:32','',NULL),(394,'32','price','销售单价','decimal(20,6)','BigDecimal','price','0','0',NULL,'1','1','1','1','EQ','input','',5,'admin','2021-05-16 06:34:32','',NULL),(395,'32','qty','销售数量','decimal(20,6)','BigDecimal','qty','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2021-05-16 06:34:32','',NULL),(396,'32','discount_rate','优惠率','decimal(20,6)','BigDecimal','discountRate','0','0',NULL,'1','1','1','1','EQ','input','',7,'admin','2021-05-16 06:34:32','',NULL),(397,'32','discount_amount','优惠金额','decimal(20,6)','BigDecimal','discountAmount','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2021-05-16 06:34:32','',NULL),(398,'32','amount','金额','decimal(20,6)','BigDecimal','amount','0','0',NULL,'1','1','1','1','EQ','input','',9,'admin','2021-05-16 06:34:32','',NULL),(399,'32','memo','备注','varchar(500)','String','memo','0','0',NULL,'1','1','1','1','EQ','textarea','',10,'admin','2021-05-16 06:34:32','',NULL),(400,'32','del_flag','删除标志（0代表存在 1代表删除）','bit(1)','String','delFlag','0','0',NULL,'1',NULL,NULL,NULL,'EQ',NULL,'',11,'admin','2021-05-16 06:34:32','',NULL),(401,'32','tenant_id','租户ID','bigint(20)','Long','tenantId','0','0',NULL,'1','1','1','1','EQ','input','',12,'admin','2021-05-16 06:34:32','',NULL),(402,'32','create_by','创建者','varchar(64)','String','createBy','0','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',13,'admin','2021-05-16 06:34:32','',NULL),(403,'32','create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',14,'admin','2021-05-16 06:34:32','',NULL),(404,'32','update_by','更新者','varchar(64)','String','updateBy','0','0',NULL,'1','1',NULL,NULL,'EQ','input','',15,'admin','2021-05-16 06:34:32','',NULL),(405,'32','update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',16,'admin','2021-05-16 06:34:32','',NULL),(406,'32','remark','备注','varchar(500)','String','remark','0','0',NULL,'1','1','1',NULL,'EQ','textarea','',17,'admin','2021-05-16 06:34:32','',NULL),(417,'34','id','ID','bigint(20)','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-16 06:41:05','',NULL),(418,'34','sku_id','skuId','int(11)','Long','skuId','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2021-05-16 06:41:05','',NULL),(419,'34','warehouse_id','仓库id','int(11)','Long','warehouseId','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-16 06:41:05','',NULL),(420,'34','qty','库存数量','decimal(20,6)','BigDecimal','qty','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2021-05-16 06:41:05','',NULL),(421,'34','del_flag','删除标志（0代表存在 1代表删除）','bit(1)','String','delFlag','0','0',NULL,'1',NULL,NULL,NULL,'EQ',NULL,'',5,'admin','2021-05-16 06:41:05','',NULL),(422,'34','tenant_id','租户ID','bigint(20)','Long','tenantId','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2021-05-16 06:41:05','',NULL),(423,'34','create_by','创建者','varchar(64)','String','createBy','0','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',7,'admin','2021-05-16 06:41:05','',NULL),(424,'34','create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',8,'admin','2021-05-16 06:41:05','',NULL),(425,'34','update_by','更新者','varchar(64)','String','updateBy','0','0',NULL,'1','1',NULL,NULL,'EQ','input','',9,'admin','2021-05-16 06:41:05','',NULL),(426,'34','update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',10,'admin','2021-05-16 06:41:05','',NULL),(427,'34','remark','备注','varchar(500)','String','remark','0','0',NULL,'1','1','1',NULL,'EQ','textarea','',11,'admin','2021-05-16 06:41:05','',NULL),(441,'36','id','ID','bigint(20)','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-16 06:52:17','',NULL),(442,'36','sn','单号','varchar(64)','String','sn','0','0','1','1','1','1','1','EQ','input','',2,'admin','2021-05-16 06:52:17','',NULL),(443,'36','warehouse_id','仓库id','int(11)','Long','warehouseId','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-16 06:52:17','',NULL),(444,'36','inventory_type','库存变动类型(0-采购入库,1-销售出库,2-调拨入库,3-调拨出库,4-盘盈入库,5-盘亏出库)','varchar(8)','String','inventoryType','0','0',NULL,'1','1','1','1','EQ','select','',4,'admin','2021-05-16 06:52:17','',NULL),(445,'36','sku_id','商品skuId','int(11)','Long','skuId','0','0',NULL,'1','1','1','1','EQ','input','',5,'admin','2021-05-16 06:52:17','',NULL),(446,'36','qty','库存数量','decimal(20,6)','BigDecimal','qty','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2021-05-16 06:52:17','',NULL),(447,'36','del_flag','删除标志（0代表存在 1代表删除）','bit(1)','String','delFlag','0','0',NULL,'1',NULL,NULL,NULL,'EQ',NULL,'',7,'admin','2021-05-16 06:52:17','',NULL),(448,'36','tenant_id','租户ID','bigint(20)','Long','tenantId','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2021-05-16 06:52:17','',NULL),(449,'36','create_by','创建者','varchar(64)','String','createBy','0','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',9,'admin','2021-05-16 06:52:17','',NULL),(450,'36','create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',10,'admin','2021-05-16 06:52:17','',NULL),(451,'36','update_by','更新者','varchar(64)','String','updateBy','0','0',NULL,'1','1',NULL,NULL,'EQ','input','',11,'admin','2021-05-16 06:52:17','',NULL),(452,'36','update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',12,'admin','2021-05-16 06:52:17','',NULL),(453,'36','remark','备注','varchar(500)','String','remark','0','0',NULL,'1','1','1',NULL,'EQ','textarea','',13,'admin','2021-05-16 06:52:17','',NULL),(454,'37','id','ID','bigint(20)','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2021-05-18 16:55:39','',NULL),(455,'37','sn','采购订单编号','varchar(64)','String','sn','0','0','1','1','1','1','1','EQ','input','',2,'admin','2021-05-18 16:55:39','',NULL),(456,'37','supplier_id','供应商id','int(11)','Long','supplierId','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2021-05-18 16:55:39','',NULL),(457,'37','buy_date','购货日期','datetime','Date','buyDate','0','0',NULL,'1','1','1','1','EQ','datetime','',4,'admin','2021-05-18 16:55:39','',NULL),(458,'37','bill_date','单据日期','datetime','Date','billDate','0','0',NULL,'1','1','1','1','EQ','datetime','',5,'admin','2021-05-18 16:55:39','',NULL),(459,'37','inventory_type','0-采购入库,6-采购退货','varchar(8)','String','inventoryType','0','0',NULL,'1','1','1','1','EQ','select','',6,'admin','2021-05-18 16:55:39','',NULL),(460,'37','discount_rate','优惠率','decimal(20,6)','BigDecimal','discountRate','0','0',NULL,'1','1','1','1','EQ','input','',7,'admin','2021-05-18 16:55:39','',NULL),(461,'37','discount_amount','优惠金额','decimal(20,6)','BigDecimal','discountAmount','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2021-05-18 16:55:40','',NULL),(462,'37','total_amount','合计金额','decimal(20,6)','BigDecimal','totalAmount','0','0',NULL,'1','1','1','1','EQ','input','',9,'admin','2021-05-18 16:55:40','',NULL),(463,'37','del_flag','删除标志（0代表存在 1代表删除）','bit(1)','String','delFlag','0','0',NULL,'1',NULL,NULL,NULL,'EQ',NULL,'',10,'admin','2021-05-18 16:55:40','',NULL),(464,'37','tenant_id','租户ID','bigint(20)','Long','tenantId','0','0',NULL,'1','1','1','1','EQ','input','',11,'admin','2021-05-18 16:55:40','',NULL),(465,'37','create_by','创建者','varchar(64)','String','createBy','0','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',12,'admin','2021-05-18 16:55:40','',NULL),(466,'37','create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',13,'admin','2021-05-18 16:55:40','',NULL),(467,'37','update_by','更新者','varchar(64)','String','updateBy','0','0',NULL,'1','1',NULL,NULL,'EQ','input','',14,'admin','2021-05-18 16:55:40','',NULL),(468,'37','update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',15,'admin','2021-05-18 16:55:40','',NULL),(469,'37','remark','备注','varchar(500)','String','remark','0','0',NULL,'1','1','1',NULL,'EQ','textarea','',16,'admin','2021-05-18 16:55:40','',NULL);

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`cron_expression`,`time_zone_id`) values ('WmsScheduler','TASK_CLASS_NAME1','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('WmsScheduler','TASK_CLASS_NAME2','DEFAULT','0/15 * * * * ?','Asia/Shanghai'),('WmsScheduler','TASK_CLASS_NAME3','DEFAULT','0/20 * * * * ?','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`sched_name`,`job_name`,`job_group`,`description`,`job_class_name`,`is_durable`,`is_nonconcurrent`,`is_update_data`,`requests_recovery`,`job_data`) values ('WmsScheduler','TASK_CLASS_NAME1','DEFAULT',NULL,'com.wms.job.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.wms.job.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.wms.common.core.web.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0yR�xpt\0\0pppt\01t\00/10 * * * * ?t\0ryTask.ryNoParamst\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（无参）t\03t\01x\0'),('WmsScheduler','TASK_CLASS_NAME2','DEFAULT',NULL,'com.wms.job.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.wms.job.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.wms.common.core.web.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0yR�xpt\0\0pppt\01t\00/15 * * * * ?t\0ryTask.ryParams(\'ry\')t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（有参）t\03t\01x\0'),('WmsScheduler','TASK_CLASS_NAME3','DEFAULT',NULL,'com.wms.job.util.QuartzDisallowConcurrentExecution','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.wms.job.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.wms.common.core.web.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0yR�xpt\0\0pppt\01t\00/20 * * * * ?t\08ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（多参）t\03t\01x\0');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`sched_name`,`lock_name`) values ('WmsScheduler','STATE_ACCESS'),('WmsScheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`sched_name`,`instance_name`,`last_checkin_time`,`checkin_interval`) values ('WmsScheduler','DESKTOP-0K3S1BC1620976072911',1620976574688,15000);

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`sched_name`,`trigger_name`,`trigger_group`,`job_name`,`job_group`,`description`,`next_fire_time`,`prev_fire_time`,`priority`,`trigger_state`,`trigger_type`,`start_time`,`end_time`,`calendar_name`,`misfire_instr`,`job_data`) values ('WmsScheduler','TASK_CLASS_NAME1','DEFAULT','TASK_CLASS_NAME1','DEFAULT',NULL,1620976080000,-1,5,'PAUSED','CRON',1620976074000,0,NULL,2,''),('WmsScheduler','TASK_CLASS_NAME2','DEFAULT','TASK_CLASS_NAME2','DEFAULT',NULL,1620976080000,-1,5,'PAUSED','CRON',1620976074000,0,NULL,2,''),('WmsScheduler','TASK_CLASS_NAME3','DEFAULT','TASK_CLASS_NAME3','DEFAULT',NULL,1620976080000,-1,5,'PAUSED','CRON',1620976075000,0,NULL,2,'');

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`config_id`,`config_name`,`config_key`,`config_value`,`config_type`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2021-04-26 11:57:08','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2021-04-26 11:57:09','',NULL,'初始化密码 123456'),(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2021-04-26 11:57:09','',NULL,'深色主题theme-dark，浅色主题theme-light');

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`parent_id`,`ancestors`,`dept_name`,`order_num`,`leader`,`phone`,`email`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`tenant_id`) values (100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:34','',NULL,NULL),(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:34','',NULL,NULL),(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:34','',NULL,NULL),(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:34','',NULL,NULL),(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:34','',NULL,NULL),(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:35','',NULL,NULL),(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:35','',NULL,NULL),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:35','',NULL,NULL),(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:35','',NULL,NULL),(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2021-04-26 11:56:35','',NULL,NULL),(110,0,'0','迅腾公司',1,NULL,NULL,NULL,'0','0','13326778348','2021-05-07 05:59:07','13326778348','2021-05-07 06:09:24',10),(111,110,'0,110','行政部',1,NULL,NULL,NULL,'0','0','13326778348','2021-05-07 06:09:35','',NULL,10),(112,111,'0,110,111','保安部',3,NULL,NULL,NULL,'0','0','13326778348','2021-05-07 06:09:52','',NULL,10),(113,110,'0,110','财务部',1,NULL,NULL,NULL,'0','0','13326778348','2021-05-07 06:10:03','',NULL,10);

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`dict_code`,`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,1,'男','0','sys_user_sex','','','Y','0','admin','2021-04-26 11:57:04','',NULL,'性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2021-04-26 11:57:04','',NULL,'性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2021-04-26 11:57:04','',NULL,'性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2021-04-26 11:57:04','',NULL,'显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2021-04-26 11:57:04','',NULL,'隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2021-04-26 11:57:04','',NULL,'正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2021-04-26 11:57:04','',NULL,'停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2021-04-26 11:57:05','',NULL,'正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2021-04-26 11:57:05','',NULL,'停用状态'),(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2021-04-26 11:57:05','',NULL,'默认分组'),(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2021-04-26 11:57:05','',NULL,'系统分组'),(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2021-04-26 11:57:05','',NULL,'系统默认是'),(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2021-04-26 11:57:05','',NULL,'系统默认否'),(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2021-04-26 11:57:05','',NULL,'通知'),(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2021-04-26 11:57:05','',NULL,'公告'),(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2021-04-26 11:57:05','',NULL,'正常状态'),(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2021-04-26 11:57:05','',NULL,'关闭状态'),(18,1,'新增','1','sys_oper_type','','info','N','0','admin','2021-04-26 11:57:05','',NULL,'新增操作'),(19,2,'修改','2','sys_oper_type','','info','N','0','admin','2021-04-26 11:57:05','',NULL,'修改操作'),(20,3,'删除','3','sys_oper_type','','danger','N','0','admin','2021-04-26 11:57:05','',NULL,'删除操作'),(21,4,'授权','4','sys_oper_type','','primary','N','0','admin','2021-04-26 11:57:05','',NULL,'授权操作'),(22,5,'导出','5','sys_oper_type','','warning','N','0','admin','2021-04-26 11:57:05','',NULL,'导出操作'),(23,6,'导入','6','sys_oper_type','','warning','N','0','admin','2021-04-26 11:57:05','',NULL,'导入操作'),(24,7,'强退','7','sys_oper_type','','danger','N','0','admin','2021-04-26 11:57:06','',NULL,'强退操作'),(25,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2021-04-26 11:57:06','',NULL,'生成操作'),(26,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2021-04-26 11:57:06','',NULL,'清空操作'),(27,1,'成功','0','sys_common_status','','primary','N','0','admin','2021-04-26 11:57:06','',NULL,'正常状态'),(28,2,'失败','1','sys_common_status','','danger','N','0','admin','2021-04-26 11:57:06','',NULL,'停用状态'),(29,0,'停用','0','account_status',NULL,NULL,'N','0','xiaohong','2021-05-07 06:48:28','',NULL,NULL),(30,1,'启用','1','account_status',NULL,NULL,'N','0','xiaohong','2021-05-07 06:48:57','',NULL,NULL),(31,1,'布类','1','supplier_type',NULL,NULL,'N','0','admin','2021-05-10 08:11:23','',NULL,NULL),(32,2,'金属','2','supplier_type',NULL,NULL,'N','0','admin','2021-05-10 08:11:37','',NULL,NULL),(33,3,'配件','3','supplier_type',NULL,NULL,'N','0','admin','2021-05-10 08:11:49','',NULL,NULL),(34,4,'塑料','4','supplier_type',NULL,NULL,'N','0','admin','2021-05-10 08:11:58','',NULL,NULL),(35,1,'零售','1','customer_type',NULL,NULL,'N','0','admin','2021-05-10 08:13:03','',NULL,NULL),(36,2,'散户','2','customer_type',NULL,NULL,'N','0','admin','2021-05-10 08:13:40','',NULL,NULL),(37,3,'代理商','3','customer_type',NULL,NULL,'N','0','admin','2021-05-10 08:13:59','',NULL,NULL),(38,1,'块','1','unit',NULL,NULL,'N','0','admin','2021-05-10 08:15:59','',NULL,NULL),(39,2,'kg','2','unit',NULL,NULL,'N','0','admin','2021-05-10 08:16:07','',NULL,NULL),(40,3,'件','3','unit',NULL,NULL,'N','0','admin','2021-05-10 08:16:17','',NULL,NULL),(41,4,'张','4','unit',NULL,NULL,'N','0','admin','2021-05-10 08:16:27','',NULL,NULL),(42,5,'根','5','unit',NULL,NULL,'N','0','admin','2021-05-10 08:16:37','',NULL,NULL),(43,6,'箱','6','unit',NULL,NULL,'N','0','admin','2021-05-10 08:16:49','',NULL,NULL),(44,1,'卡其','1','color',NULL,NULL,'N','0','admin','2021-05-10 08:19:58','',NULL,NULL),(45,2,'咖啡','2','color',NULL,NULL,'N','0','admin','2021-05-10 08:20:08','',NULL,NULL),(46,3,'宝石蓝','3','color',NULL,NULL,'N','0','admin','2021-05-10 08:20:23','',NULL,NULL),(47,4,'宝蓝','4','color',NULL,NULL,'N','0','admin','2021-05-10 08:20:32','',NULL,NULL),(48,5,'浅棕色','5','color',NULL,NULL,'N','0','admin','2021-05-10 08:20:50','',NULL,NULL),(49,6,'白色','6','color',NULL,NULL,'N','0','admin','2021-05-10 08:21:09','',NULL,NULL),(50,7,'粉色','7','color',NULL,NULL,'N','0','admin','2021-05-10 08:21:19','',NULL,NULL),(51,8,'黑色','8','color',NULL,NULL,'N','0','admin','2021-05-10 08:21:28','',NULL,NULL),(52,9,'红色','9','color',NULL,NULL,'N','0','admin','2021-05-10 08:21:43','',NULL,NULL),(53,10,'蓝色','10','color',NULL,NULL,'N','0','admin','2021-05-10 08:21:55','',NULL,NULL),(54,1,'普通会员','1','customer_level',NULL,NULL,'N','0','admin','2021-05-11 04:25:23','',NULL,NULL),(55,2,'VIP会员','2','customer_level',NULL,NULL,'N','0','admin','2021-05-11 04:25:33','',NULL,NULL);

/*Table structure for table `sys_dict_type` */

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

/*Data for the table `sys_dict_type` */

insert  into `sys_dict_type`(`dict_id`,`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'用户性别','sys_user_sex','0','admin','2021-04-26 11:57:01','',NULL,'用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2021-04-26 11:57:01','',NULL,'菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2021-04-26 11:57:01','',NULL,'系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2021-04-26 11:57:01','',NULL,'任务状态列表'),(5,'任务分组','sys_job_group','0','admin','2021-04-26 11:57:02','',NULL,'任务分组列表'),(6,'系统是否','sys_yes_no','0','admin','2021-04-26 11:57:02','',NULL,'系统是否列表'),(7,'通知类型','sys_notice_type','0','admin','2021-04-26 11:57:02','',NULL,'通知类型列表'),(8,'通知状态','sys_notice_status','0','admin','2021-04-26 11:57:02','',NULL,'通知状态列表'),(9,'操作类型','sys_oper_type','0','admin','2021-04-26 11:57:02','',NULL,'操作类型列表'),(10,'系统状态','sys_common_status','0','admin','2021-04-26 11:57:02','',NULL,'登录状态列表'),(11,'账户状态','account_status','0','xiaohong','2021-05-07 06:47:57','',NULL,NULL),(12,'供应商类别','supplier_type','0','admin','2021-05-10 08:10:46','',NULL,NULL),(13,'客户类别','customer_type','0','admin','2021-05-10 08:12:46','',NULL,NULL),(14,'计量单位','unit','0','admin','2021-05-10 08:15:43','',NULL,NULL),(15,'颜色','color','0','admin','2021-05-10 08:19:39','',NULL,NULL),(16,'客户等级','customer_level','0','admin','2021-05-11 04:24:51','',NULL,NULL);

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

/*Data for the table `sys_job` */

insert  into `sys_job`(`job_id`,`job_name`,`job_group`,`invoke_target`,`cron_expression`,`misfire_policy`,`concurrent`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2021-04-26 11:57:13','',NULL,''),(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2021-04-26 11:57:13','',NULL,''),(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2021-04-26 11:57:13','',NULL,'');

/*Table structure for table `sys_job_log` */

DROP TABLE IF EXISTS `sys_job_log`;

CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

/*Data for the table `sys_job_log` */

/*Table structure for table `sys_logininfor` */

DROP TABLE IF EXISTS `sys_logininfor`;

CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示信息',
  `access_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

/*Data for the table `sys_logininfor` */

insert  into `sys_logininfor`(`info_id`,`user_name`,`ipaddr`,`status`,`msg`,`access_time`) values (100,'admin','192.168.1.105','0','登录成功','2021-04-26 14:46:01'),(101,'admin','192.168.1.105','0','登录成功','2021-04-28 17:59:53'),(102,'admin','192.168.1.105','0','登录成功','2021-04-28 18:19:31'),(103,'admin','192.168.1.105','0','登录成功','2021-04-30 15:08:33'),(104,'admin','192.168.1.105','0','退出成功','2021-04-30 15:56:38'),(105,'admin','192.168.1.105','0','登录成功','2021-04-30 15:56:42'),(106,'admin','192.168.1.105','0','退出成功','2021-04-30 15:56:43'),(107,'admin','192.168.1.105','0','登录成功','2021-04-30 15:57:05'),(108,'admin','192.168.1.105','0','登录成功','2021-04-30 16:37:48'),(109,'admin','192.168.1.105','0','退出成功','2021-04-30 16:37:48'),(110,'admin','192.168.1.105','0','登录成功','2021-04-30 16:39:33'),(111,'admin','192.168.1.105','0','退出成功','2021-04-30 16:48:30'),(112,'admin','192.168.1.105','0','登录成功','2021-04-30 16:49:23'),(113,'admin','192.168.1.105','0','退出成功','2021-04-30 16:49:24'),(114,'admin','192.168.1.105','0','登录成功','2021-04-30 16:52:57'),(115,'admin','192.168.0.104','0','登录成功','2021-05-01 07:35:11'),(116,'admin','172.19.0.6','0','登录成功','2021-05-02 18:55:57'),(117,'admin','172.19.0.6','0','登录成功','2021-05-02 18:56:12'),(118,'admin','169.254.228.150','0','登录成功','2021-05-03 08:10:25'),(119,'admin','169.254.228.150','0','登录成功','2021-05-04 05:26:03'),(120,'admin','169.254.228.150','0','退出成功','2021-05-04 05:31:58'),(121,'admin','169.254.228.150','0','登录成功','2021-05-04 05:32:02'),(122,'admin','169.254.228.150','0','登录成功','2021-05-04 08:04:56'),(123,'admin','172.19.0.8','0','登录成功','2021-05-06 05:44:48'),(124,'admin','172.19.0.8','0','登录成功','2021-05-06 05:45:53'),(125,'admin','172.19.0.8','0','登录成功','2021-05-06 05:46:04'),(126,'admin','172.19.0.8','0','登录成功','2021-05-06 05:46:53'),(127,'admin','172.19.0.8','0','登录成功','2021-05-06 05:47:41'),(128,'admin','172.19.0.8','0','登录成功','2021-05-06 05:48:05'),(129,'admin','172.19.0.8','0','登录成功','2021-05-06 05:49:33'),(130,'admin','169.254.228.150','0','登录成功','2021-05-06 08:29:12'),(131,'admin','172.18.0.11','0','登录成功','2021-05-06 15:07:33'),(132,'admin','192.168.1.105','0','退出成功','2021-05-06 15:56:37'),(133,'王明','192.168.1.105','0','登录成功','2021-05-06 15:57:38'),(134,'王明','192.168.1.105','0','退出成功','2021-05-06 16:10:01'),(135,'13326778347','192.168.1.105','0','登录成功','2021-05-06 16:10:18'),(136,'13326778347','192.168.1.105','0','退出成功','2021-05-06 16:10:32'),(137,'admin','192.168.1.105','0','登录成功','2021-05-06 16:10:36'),(138,'admin','192.168.1.105','0','退出成功','2021-05-06 16:35:33'),(139,'13326778347','192.168.1.105','0','登录成功','2021-05-06 16:35:52'),(140,'13326778347','192.168.1.105','0','退出成功','2021-05-06 16:36:28'),(141,'admin','192.168.1.105','0','登录成功','2021-05-06 16:36:33'),(142,'admin','192.168.1.105','0','退出成功','2021-05-06 16:37:40'),(143,'13326778347','192.168.1.105','0','登录成功','2021-05-06 16:37:56'),(144,'13326778347','192.168.1.105','0','退出成功','2021-05-06 16:42:14'),(145,'13326778346','192.168.1.105','0','登录成功','2021-05-06 16:42:31'),(146,'13326778346','192.168.1.105','0','退出成功','2021-05-06 17:07:24'),(147,'13326778348','192.168.1.105','0','登录成功','2021-05-06 17:07:40'),(148,'13326778348','192.168.1.105','0','退出成功','2021-05-06 17:13:06'),(149,'admin','192.168.1.105','0','登录成功','2021-05-06 17:13:12'),(150,'admin','169.254.228.150','0','登录成功','2021-05-06 19:30:54'),(151,'admin','169.254.228.150','0','退出成功','2021-05-06 19:31:52'),(152,'13326778346','169.254.228.150','0','登录成功','2021-05-06 19:32:25'),(153,'13326778346','169.254.228.150','0','退出成功','2021-05-06 19:32:39'),(154,'13326778348','169.254.228.150','0','登录成功','2021-05-06 19:32:52'),(155,'13326778348','169.254.228.150','0','退出成功','2021-05-06 19:33:46'),(156,'admin','169.254.228.150','0','登录成功','2021-05-06 19:33:51'),(157,'admin','169.254.228.150','0','退出成功','2021-05-06 19:34:52'),(158,'13326778348','169.254.228.150','0','登录成功','2021-05-06 19:34:58'),(159,'13326778348','169.254.228.150','0','退出成功','2021-05-06 19:35:17'),(160,'13326778348','169.254.228.150','0','登录成功','2021-05-06 19:36:30'),(161,'13326778348','169.254.228.150','0','退出成功','2021-05-06 19:37:23'),(162,'13326778348','169.254.228.150','0','登录成功','2021-05-06 19:37:53'),(163,'13326778348','169.254.228.150','0','退出成功','2021-05-06 19:39:39'),(164,'13326778348','169.254.228.150','0','登录成功','2021-05-06 19:39:53'),(165,'13326778348','169.254.228.150','0','退出成功','2021-05-06 19:41:56'),(166,'admin','169.254.228.150','0','登录成功','2021-05-06 19:42:01'),(167,'admin','169.254.228.150','0','退出成功','2021-05-06 19:44:46'),(168,'13326778348','169.254.228.150','0','登录成功','2021-05-06 19:45:04'),(169,'13326778348','169.254.228.150','0','退出成功','2021-05-06 19:49:16'),(170,'13326778346','169.254.228.150','0','登录成功','2021-05-06 20:01:28'),(171,'13326778346','169.254.228.150','0','退出成功','2021-05-06 20:03:51'),(172,'admin','169.254.228.150','0','登录成功','2021-05-06 20:03:56'),(173,'admin','169.254.228.150','0','退出成功','2021-05-06 20:04:38'),(174,'13326778346','169.254.228.150','0','登录成功','2021-05-06 20:04:48'),(175,'admin','169.254.228.150','0','登录成功','2021-05-07 05:58:16'),(176,'admin','169.254.228.150','0','退出成功','2021-05-07 05:58:34'),(177,'13326778348','169.254.228.150','0','登录成功','2021-05-07 05:58:47'),(178,'13326778348','169.254.228.150','0','退出成功','2021-05-07 06:07:55'),(179,'admin','169.254.228.150','0','登录成功','2021-05-07 06:08:00'),(180,'admin','169.254.228.150','0','退出成功','2021-05-07 06:08:00'),(181,'13326778348','169.254.228.150','0','登录成功','2021-05-07 06:08:28'),(182,'13326778348','169.254.228.150','0','退出成功','2021-05-07 06:44:42'),(183,'xiaohong','169.254.228.150','0','登录成功','2021-05-07 06:44:51'),(184,'xiaohong','169.254.228.150','0','退出成功','2021-05-07 06:46:01'),(185,'admin','169.254.228.150','0','登录成功','2021-05-07 06:46:08'),(186,'admin','169.254.228.150','0','退出成功','2021-05-07 06:46:38'),(187,'xiaohong','169.254.228.150','0','登录成功','2021-05-07 06:47:04'),(188,'xiaohong','169.254.228.150','0','退出成功','2021-05-07 06:49:00'),(189,'admin','169.254.228.150','0','登录成功','2021-05-07 06:49:05'),(190,'admin','169.254.228.150','0','登录成功','2021-05-07 06:57:49'),(191,'admin','169.254.228.150','0','退出成功','2021-05-07 06:57:58'),(192,'xiaohong','169.254.228.150','0','登录成功','2021-05-07 06:58:07'),(193,'admin','192.168.1.105','0','登录成功','2021-05-08 10:26:41'),(194,'admin','192.168.1.105','0','退出成功','2021-05-08 11:51:34'),(195,'admin','192.168.1.105','0','登录成功','2021-05-08 11:52:20'),(196,'admin','192.168.1.105','0','登录成功','2021-05-08 16:37:21'),(197,'admin','192.168.1.105','0','退出成功','2021-05-08 17:33:51'),(198,'admin','192.168.1.105','0','登录成功','2021-05-08 18:00:19'),(199,'admin','169.254.228.150','0','登录成功','2021-05-09 00:15:34'),(200,'admin','169.254.228.150','0','退出成功','2021-05-09 00:42:46'),(201,'admin','169.254.228.150','0','登录成功','2021-05-09 00:43:04'),(202,'admin','169.254.228.150','0','退出成功','2021-05-09 00:43:29'),(203,'13326778346','169.254.228.150','0','登录成功','2021-05-09 00:43:41'),(204,'admin','169.254.228.150','0','登录成功','2021-05-10 06:22:54'),(205,'admin','169.254.228.150','0','登录成功','2021-05-10 06:23:27'),(206,'admin','169.254.228.150','0','登录成功','2021-05-10 20:51:48'),(207,'admin','169.254.228.150','0','登录成功','2021-05-11 05:09:32'),(208,'admin','192.168.1.105','0','登录成功','2021-05-13 10:34:18'),(209,'admin','192.168.1.105','0','登录成功','2021-05-14 14:53:15'),(210,'admin','169.254.228.150','0','登录成功','2021-05-14 20:22:49'),(211,'admin','169.254.228.150','0','登录成功','2021-05-16 05:24:00'),(212,'admin','169.254.228.150','0','登录成功','2021-05-16 06:24:08'),(213,'admin','169.254.228.150','0','登录成功','2021-05-16 15:58:14'),(214,'admin','169.254.228.150','0','登录成功','2021-05-17 05:01:13'),(215,'admin','192.168.1.105','0','登录成功','2021-05-17 09:31:16'),(216,'admin','192.168.1.105','0','登录成功','2021-05-18 10:25:20'),(217,'admin','192.168.1.105','0','登录成功','2021-05-19 09:39:46'),(218,'admin','192.168.1.105','0','登录成功','2021-05-20 09:18:40'),(219,'admin','192.168.1.105','0','登录成功','2021-05-20 14:06:09'),(220,'admin','192.168.1.105','0','登录成功','2021-05-21 11:40:47');

/*Table structure for table `sys_menu` */

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
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1133 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`parent_id`,`order_num`,`path`,`component`,`is_frame`,`is_cache`,`menu_type`,`visible`,`status`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统管理',0,10,'system',NULL,1,0,'M','0','0','','system','admin','2021-04-26 11:56:41','admin','2021-05-08 10:54:54','系统管理目录'),(2,'系统监控',0,11,'monitor',NULL,1,0,'M','0','0','','monitor','admin','2021-04-26 11:56:41','admin','2021-05-08 10:55:02','系统监控目录'),(3,'系统工具',0,12,'tool',NULL,1,0,'M','0','0','','tool','admin','2021-04-26 11:56:41','admin','2021-05-08 10:55:08','系统工具目录'),(100,'用户管理',1,1,'user','system/user/index',1,0,'C','0','0','system:user:list','user','admin','2021-04-26 11:56:41','',NULL,'用户管理菜单'),(101,'角色管理',1,2,'role','system/role/index',1,0,'C','0','0','system:role:list','peoples','admin','2021-04-26 11:56:41','',NULL,'角色管理菜单'),(102,'菜单管理',1,3,'menu','system/menu/index',1,0,'C','0','0','system:menu:list','tree-table','admin','2021-04-26 11:56:41','',NULL,'菜单管理菜单'),(103,'部门管理',1,4,'dept','system/dept/index',1,0,'C','0','0','system:dept:list','tree','admin','2021-04-26 11:56:42','',NULL,'部门管理菜单'),(104,'岗位管理',1,5,'post','system/post/index',1,0,'C','0','0','system:post:list','post','admin','2021-04-26 11:56:42','',NULL,'岗位管理菜单'),(105,'字典管理',1,6,'dict','system/dict/index',1,0,'C','0','0','system:dict:list','dict','admin','2021-04-26 11:56:42','',NULL,'字典管理菜单'),(106,'参数设置',1,7,'config','system/config/index',1,0,'C','0','0','system:config:list','edit','admin','2021-04-26 11:56:42','',NULL,'参数设置菜单'),(107,'通知公告',1,9,'notice','system/notice/index',1,0,'C','0','0','system:notice:list','message','admin','2021-04-26 11:56:42','',NULL,'通知公告菜单'),(108,'日志管理',1,10,'log','',1,0,'M','0','0','','log','admin','2021-04-26 11:56:42','',NULL,'日志管理菜单'),(109,'在线用户',2,1,'online','monitor/online/index',1,0,'C','0','0','monitor:online:list','online','admin','2021-04-26 11:56:42','',NULL,'在线用户菜单'),(110,'定时任务',2,2,'job','monitor/job/index',1,0,'C','0','0','monitor:job:list','job','admin','2021-04-26 11:56:42','',NULL,'定时任务菜单'),(111,'Sentinel控制台',2,3,'http://localhost:8718','',1,0,'C','0','0','monitor:sentinel:list','sentinel','admin','2021-04-26 11:56:42','',NULL,'流量控制菜单'),(112,'Nacos控制台',2,4,'http://localhost:8848/nacos','',1,0,'C','0','0','monitor:nacos:list','nacos','admin','2021-04-26 11:56:42','',NULL,'服务治理菜单'),(113,'Admin控制台',2,5,'http://localhost:9100/login','',1,0,'C','0','0','monitor:server:list','server','admin','2021-04-26 11:56:42','',NULL,'服务监控菜单'),(114,'表单构建',3,1,'build','tool/build/index',1,0,'C','0','0','tool:build:list','build','admin','2021-04-26 11:56:42','',NULL,'表单构建菜单'),(115,'代码生成',3,2,'gen','tool/gen/index',1,0,'C','0','0','tool:gen:list','code','admin','2021-04-26 11:56:42','',NULL,'代码生成菜单'),(116,'系统接口',3,3,'http://localhost:8080/swagger-ui.html','',1,0,'C','0','0','tool:swagger:list','swagger','admin','2021-04-26 11:56:42','',NULL,'系统接口菜单'),(500,'操作日志',108,1,'operlog','system/operlog/index',1,0,'C','0','0','system:operlog:list','form','admin','2021-04-26 11:56:42','',NULL,'操作日志菜单'),(501,'登录日志',108,2,'logininfor','system/logininfor/index',1,0,'C','0','0','system:logininfor:list','logininfor','admin','2021-04-26 11:56:42','',NULL,'登录日志菜单'),(1001,'用户查询',100,1,'','',1,0,'F','0','0','system:user:query','#','admin','2021-04-26 11:56:42','',NULL,''),(1002,'用户新增',100,2,'','',1,0,'F','0','0','system:user:add','#','admin','2021-04-26 11:56:42','',NULL,''),(1003,'用户修改',100,3,'','',1,0,'F','0','0','system:user:edit','#','admin','2021-04-26 11:56:42','',NULL,''),(1004,'用户删除',100,4,'','',1,0,'F','0','0','system:user:remove','#','admin','2021-04-26 11:56:42','',NULL,''),(1005,'用户导出',100,5,'','',1,0,'F','0','0','system:user:export','#','admin','2021-04-26 11:56:43','',NULL,''),(1006,'用户导入',100,6,'','',1,0,'F','0','0','system:user:import','#','admin','2021-04-26 11:56:43','',NULL,''),(1007,'重置密码',100,7,'','',1,0,'F','0','0','system:user:resetPwd','#','admin','2021-04-26 11:56:43','',NULL,''),(1008,'角色查询',101,1,'','',1,0,'F','0','0','system:role:query','#','admin','2021-04-26 11:56:43','',NULL,''),(1009,'角色新增',101,2,'','',1,0,'F','0','0','system:role:add','#','admin','2021-04-26 11:56:43','',NULL,''),(1010,'角色修改',101,3,'','',1,0,'F','0','0','system:role:edit','#','admin','2021-04-26 11:56:43','',NULL,''),(1011,'角色删除',101,4,'','',1,0,'F','0','0','system:role:remove','#','admin','2021-04-26 11:56:43','',NULL,''),(1012,'角色导出',101,5,'','',1,0,'F','0','0','system:role:export','#','admin','2021-04-26 11:56:43','',NULL,''),(1013,'菜单查询',102,1,'','',1,0,'F','0','0','system:menu:query','#','admin','2021-04-26 11:56:43','',NULL,''),(1014,'菜单新增',102,2,'','',1,0,'F','0','0','system:menu:add','#','admin','2021-04-26 11:56:43','',NULL,''),(1015,'菜单修改',102,3,'','',1,0,'F','0','0','system:menu:edit','#','admin','2021-04-26 11:56:43','',NULL,''),(1016,'菜单删除',102,4,'','',1,0,'F','0','0','system:menu:remove','#','admin','2021-04-26 11:56:43','',NULL,''),(1017,'部门查询',103,1,'','',1,0,'F','0','0','system:dept:query','#','admin','2021-04-26 11:56:43','',NULL,''),(1018,'部门新增',103,2,'','',1,0,'F','0','0','system:dept:add','#','admin','2021-04-26 11:56:43','',NULL,''),(1019,'部门修改',103,3,'','',1,0,'F','0','0','system:dept:edit','#','admin','2021-04-26 11:56:43','',NULL,''),(1020,'部门删除',103,4,'','',1,0,'F','0','0','system:dept:remove','#','admin','2021-04-26 11:56:43','',NULL,''),(1021,'岗位查询',104,1,'','',1,0,'F','0','0','system:post:query','#','admin','2021-04-26 11:56:43','',NULL,''),(1022,'岗位新增',104,2,'','',1,0,'F','0','0','system:post:add','#','admin','2021-04-26 11:56:43','',NULL,''),(1023,'岗位修改',104,3,'','',1,0,'F','0','0','system:post:edit','#','admin','2021-04-26 11:56:43','',NULL,''),(1024,'岗位删除',104,4,'','',1,0,'F','0','0','system:post:remove','#','admin','2021-04-26 11:56:43','',NULL,''),(1025,'岗位导出',104,5,'','',1,0,'F','0','0','system:post:export','#','admin','2021-04-26 11:56:43','',NULL,''),(1026,'字典查询',105,1,'#','',1,0,'F','0','0','system:dict:query','#','admin','2021-04-26 11:56:43','',NULL,''),(1027,'字典新增',105,2,'#','',1,0,'F','0','0','system:dict:add','#','admin','2021-04-26 11:56:43','',NULL,''),(1028,'字典修改',105,3,'#','',1,0,'F','0','0','system:dict:edit','#','admin','2021-04-26 11:56:43','',NULL,''),(1029,'字典删除',105,4,'#','',1,0,'F','0','0','system:dict:remove','#','admin','2021-04-26 11:56:43','',NULL,''),(1030,'字典导出',105,5,'#','',1,0,'F','0','0','system:dict:export','#','admin','2021-04-26 11:56:43','',NULL,''),(1031,'参数查询',106,1,'#','',1,0,'F','0','0','system:config:query','#','admin','2021-04-26 11:56:43','',NULL,''),(1032,'参数新增',106,2,'#','',1,0,'F','0','0','system:config:add','#','admin','2021-04-26 11:56:43','',NULL,''),(1033,'参数修改',106,3,'#','',1,0,'F','0','0','system:config:edit','#','admin','2021-04-26 11:56:43','',NULL,''),(1034,'参数删除',106,4,'#','',1,0,'F','0','0','system:config:remove','#','admin','2021-04-26 11:56:44','',NULL,''),(1035,'参数导出',106,5,'#','',1,0,'F','0','0','system:config:export','#','admin','2021-04-26 11:56:44','',NULL,''),(1041,'公告查询',107,1,'#','',1,0,'F','0','0','system:notice:query','#','admin','2021-04-26 11:56:44','',NULL,''),(1042,'公告新增',107,2,'#','',1,0,'F','0','0','system:notice:add','#','admin','2021-04-26 11:56:44','',NULL,''),(1043,'公告修改',107,3,'#','',1,0,'F','0','0','system:notice:edit','#','admin','2021-04-26 11:56:44','',NULL,''),(1044,'公告删除',107,4,'#','',1,0,'F','0','0','system:notice:remove','#','admin','2021-04-26 11:56:44','',NULL,''),(1045,'操作查询',500,1,'#','',1,0,'F','0','0','system:operlog:query','#','admin','2021-04-26 11:56:44','',NULL,''),(1046,'操作删除',500,2,'#','',1,0,'F','0','0','system:operlog:remove','#','admin','2021-04-26 11:56:44','',NULL,''),(1047,'日志导出',500,4,'#','',1,0,'F','0','0','system:operlog:export','#','admin','2021-04-26 11:56:44','',NULL,''),(1048,'登录查询',501,1,'#','',1,0,'F','0','0','system:logininfor:query','#','admin','2021-04-26 11:56:44','',NULL,''),(1049,'登录删除',501,2,'#','',1,0,'F','0','0','system:logininfor:remove','#','admin','2021-04-26 11:56:44','',NULL,''),(1050,'日志导出',501,3,'#','',1,0,'F','0','0','system:logininfor:export','#','admin','2021-04-26 11:56:44','',NULL,''),(1051,'在线查询',109,1,'#','',1,0,'F','0','0','monitor:online:query','#','admin','2021-04-26 11:56:44','',NULL,''),(1052,'批量强退',109,2,'#','',1,0,'F','0','0','monitor:online:batchLogout','#','admin','2021-04-26 11:56:44','',NULL,''),(1053,'单条强退',109,3,'#','',1,0,'F','0','0','monitor:online:forceLogout','#','admin','2021-04-26 11:56:44','',NULL,''),(1054,'任务查询',110,1,'#','',1,0,'F','0','0','monitor:job:query','#','admin','2021-04-26 11:56:44','',NULL,''),(1055,'任务新增',110,2,'#','',1,0,'F','0','0','monitor:job:add','#','admin','2021-04-26 11:56:44','',NULL,''),(1056,'任务修改',110,3,'#','',1,0,'F','0','0','monitor:job:edit','#','admin','2021-04-26 11:56:44','',NULL,''),(1057,'任务删除',110,4,'#','',1,0,'F','0','0','monitor:job:remove','#','admin','2021-04-26 11:56:44','',NULL,''),(1058,'状态修改',110,5,'#','',1,0,'F','0','0','monitor:job:changeStatus','#','admin','2021-04-26 11:56:44','',NULL,''),(1059,'任务导出',110,7,'#','',1,0,'F','0','0','monitor:job:export','#','admin','2021-04-26 11:56:44','',NULL,''),(1060,'生成查询',115,1,'#','',1,0,'F','0','0','tool:gen:query','#','admin','2021-04-26 11:56:44','',NULL,''),(1061,'生成修改',115,2,'#','',1,0,'F','0','0','tool:gen:edit','#','admin','2021-04-26 11:56:44','',NULL,''),(1062,'生成删除',115,3,'#','',1,0,'F','0','0','tool:gen:remove','#','admin','2021-04-26 11:56:44','',NULL,''),(1063,'导入代码',115,2,'#','',1,0,'F','0','0','tool:gen:import','#','admin','2021-04-26 11:56:44','',NULL,''),(1064,'预览代码',115,4,'#','',1,0,'F','0','0','tool:gen:preview','#','admin','2021-04-26 11:56:44','',NULL,''),(1065,'生成代码',115,5,'#','',1,0,'F','0','0','tool:gen:code','#','admin','2021-04-26 11:56:44','',NULL,''),(1066,'基础资料',0,9,'info',NULL,1,0,'M','0','0',NULL,'form','admin','2021-05-08 10:56:45','',NULL,''),(1067,'客户管理',1066,1,'customer','oms/customer/index',1,0,'C','0','0','oms:customer:list','#','admin','2021-05-08 11:01:50','',NULL,'客户管理菜单'),(1068,'客户信息查询',1067,1,'#','',1,0,'F','0','0','oms:customer:query','#','admin','2021-05-08 11:01:50','',NULL,''),(1069,'客户信息新增',1067,2,'#','',1,0,'F','0','0','oms:customer:add','#','admin','2021-05-08 11:01:50','',NULL,''),(1070,'客户信息修改',1067,3,'#','',1,0,'F','0','0','oms:customer:edit','#','admin','2021-05-08 11:01:50','',NULL,''),(1071,'客户信息删除',1067,4,'#','',1,0,'F','0','0','oms:customer:remove','#','admin','2021-05-08 11:01:50','',NULL,''),(1077,'供应商管理',1066,3,'supplier','oms/supplier/index',1,0,'C','0','0','oms:supplier:list','#','admin','2021-05-10 06:57:11','admin','2021-05-10 06:57:40','供应商信息菜单'),(1078,'供应商信息查询',1077,1,'#','',1,0,'F','0','0','oms:supplier:query','#','admin','2021-05-10 06:57:11','',NULL,''),(1079,'供应商信息新增',1077,2,'#','',1,0,'F','0','0','oms:supplier:add','#','admin','2021-05-10 06:57:11','',NULL,''),(1080,'供应商信息修改',1077,3,'#','',1,0,'F','0','0','oms:supplier:edit','#','admin','2021-05-10 06:57:11','',NULL,''),(1081,'供应商信息删除',1077,4,'#','',1,0,'F','0','0','oms:supplier:remove','#','admin','2021-05-10 06:57:11','',NULL,''),(1082,'仓库信息',1066,3,'warehouse','oms/warehouse/index',1,0,'C','0','0','oms:warehouse:list','#','admin','2021-05-14 15:18:12','',NULL,'仓库信息菜单'),(1083,'仓库信息查询',1082,1,'#','',1,0,'F','0','0','oms:warehouse:query','#','admin','2021-05-14 15:18:12','',NULL,''),(1084,'仓库信息新增',1082,2,'#','',1,0,'F','0','0','oms:warehouse:add','#','admin','2021-05-14 15:18:12','',NULL,''),(1085,'仓库信息修改',1082,3,'#','',1,0,'F','0','0','oms:warehouse:edit','#','admin','2021-05-14 15:18:12','',NULL,''),(1086,'仓库信息删除',1082,4,'#','',1,0,'F','0','0','oms:warehouse:remove','#','admin','2021-05-14 15:18:12','',NULL,''),(1087,'仓库信息导出',1082,5,'#','',1,0,'F','0','0','oms:warehouse:export','#','admin','2021-05-14 15:18:12','',NULL,''),(1088,'商品管理',0,8,'product',NULL,1,0,'M','0','0',NULL,'table','admin','2021-05-14 15:18:57','',NULL,''),(1089,'商品分类',1088,1,'category','oms/category/index',1,0,'C','0','0','oms:category:list','#','admin','2021-05-14 15:33:40','',NULL,'商品分类信息菜单'),(1090,'商品分类信息查询',1089,1,'#','',1,0,'F','0','0','oms:category:query','#','admin','2021-05-14 15:33:40','',NULL,''),(1091,'商品分类信息新增',1089,2,'#','',1,0,'F','0','0','oms:category:add','#','admin','2021-05-14 15:33:40','',NULL,''),(1092,'商品分类信息修改',1089,3,'#','',1,0,'F','0','0','oms:category:edit','#','admin','2021-05-14 15:33:40','',NULL,''),(1093,'商品分类信息删除',1089,4,'#','',1,0,'F','0','0','oms:category:remove','#','admin','2021-05-14 15:33:40','',NULL,''),(1094,'商品分类信息导出',1089,5,'#','',1,0,'F','0','0','oms:category:export','#','admin','2021-05-14 15:33:40','',NULL,''),(1095,'商品规格',1088,2,'spec','oms/spec/index',1,0,'C','0','0','oms:spec:list','#','admin','2021-05-14 20:43:17','',NULL,'商品规格菜单'),(1096,'商品规格查询',1095,1,'#','',1,0,'F','0','0','oms:spec:query','#','admin','2021-05-14 20:43:17','',NULL,''),(1097,'商品规格新增',1095,2,'#','',1,0,'F','0','0','oms:spec:add','#','admin','2021-05-14 20:43:17','',NULL,''),(1098,'商品规格修改',1095,3,'#','',1,0,'F','0','0','oms:spec:edit','#','admin','2021-05-14 20:43:17','',NULL,''),(1099,'商品规格删除',1095,4,'#','',1,0,'F','0','0','oms:spec:remove','#','admin','2021-05-14 20:43:17','',NULL,''),(1100,'商品管理',1088,3,'product','oms/product/index',1,0,'C','0','0','oms:product:list','#','admin','2021-05-15 06:18:51','',NULL,'商品信息菜单'),(1101,'商品信息查询',1100,1,'#','',1,0,'F','0','0','oms:product:query','#','admin','2021-05-15 06:18:51','',NULL,''),(1102,'商品信息新增',1100,2,'#','',1,0,'F','0','0','oms:product:add','#','admin','2021-05-15 06:18:51','',NULL,''),(1103,'商品信息修改',1100,3,'#','',1,0,'F','0','0','oms:product:edit','#','admin','2021-05-15 06:18:51','',NULL,''),(1104,'商品信息删除',1100,4,'#','',1,0,'F','0','0','oms:product:remove','#','admin','2021-05-15 06:18:51','',NULL,''),(1105,'商品信息导出',1100,5,'#','',1,0,'F','0','0','oms:product:export','#','admin','2021-05-15 06:18:51','',NULL,''),(1106,'采购管理',0,5,'purchase',NULL,1,0,'M','0','0',NULL,'client','admin','2021-05-16 05:42:23','',NULL,''),(1107,'采购订单',1106,1,'purchase','oms/purchaseOrder/index',1,0,'C','0','0','oms:purchase:list','#','admin','2021-05-16 05:46:42','admin','2021-05-16 06:20:53','采购订单菜单'),(1108,'采购订单查询',1107,1,'#','',1,0,'F','0','0','oms:purchase:query','#','admin','2021-05-16 05:46:42','',NULL,''),(1109,'采购订单新增',1107,2,'#','',1,0,'F','0','0','oms:purchase:add','#','admin','2021-05-16 05:46:42','',NULL,''),(1110,'采购订单修改',1107,3,'#','',1,0,'F','0','0','oms:purchase:edit','#','admin','2021-05-16 05:46:42','',NULL,''),(1111,'采购订单删除',1107,4,'#','',1,0,'F','0','0','oms:purchase:remove','#','admin','2021-05-16 05:46:42','',NULL,''),(1112,'采购订单导出',1107,5,'#','',1,0,'F','0','0','oms:purchase:export','#','admin','2021-05-16 05:46:42','',NULL,''),(1113,'销售管理',0,6,'sale',NULL,1,0,'M','0','0',NULL,'list','admin','2021-05-16 06:14:37','',NULL,''),(1114,'销售订单',1113,1,'order','oms/saleOrder/index',1,0,'C','0','0','oms:saleOrder:list','#','admin','2021-05-16 06:16:35','',NULL,'销售订单菜单'),(1115,'销售订单查询',1114,1,'#','',1,0,'F','0','0','oms:saleOrder:query','#','admin','2021-05-16 06:16:35','',NULL,''),(1116,'销售订单新增',1114,2,'#','',1,0,'F','0','0','oms:saleOrder:add','#','admin','2021-05-16 06:16:35','',NULL,''),(1117,'销售订单修改',1114,3,'#','',1,0,'F','0','0','oms:saleOrder:edit','#','admin','2021-05-16 06:16:35','',NULL,''),(1118,'销售订单删除',1114,4,'#','',1,0,'F','0','0','oms:saleOrder:remove','#','admin','2021-05-16 06:16:35','',NULL,''),(1120,'库存管理',0,7,'inventory',NULL,1,0,'M','0','0',NULL,'input','admin','2021-05-16 06:46:29','',NULL,''),(1121,'库存信息',1120,1,'inventory','oms/inventory/index',1,0,'C','0','0','oms:inventory:list','#','admin','2021-05-16 06:48:08','',NULL,'库存信息菜单'),(1122,'库存信息查询',1121,1,'#','',1,0,'F','0','0','oms:inventory:query','#','admin','2021-05-16 06:48:08','',NULL,''),(1123,'库存信息新增',1121,2,'#','',1,0,'F','0','0','oms:inventory:add','#','admin','2021-05-16 06:48:08','',NULL,''),(1124,'库存信息修改',1121,3,'#','',1,0,'F','0','0','oms:inventory:edit','#','admin','2021-05-16 06:48:08','',NULL,''),(1125,'库存信息删除',1121,4,'#','',1,0,'F','0','0','oms:inventory:remove','#','admin','2021-05-16 06:48:08','',NULL,''),(1126,'库存信息导出',1121,5,'#','',1,0,'F','0','0','oms:inventory:export','#','admin','2021-05-16 06:48:08','',NULL,''),(1127,'库存日志',1120,2,'inventoryLog','oms/inventoryLog/index',1,0,'C','0','0','oms:inventoryLog:list','#','admin','2021-05-16 06:58:00','',NULL,'库存操作日志菜单'),(1128,'库存操作日志查询',1127,1,'#','',1,0,'F','0','0','oms:inventoryLog:query','#','admin','2021-05-16 06:58:00','',NULL,''),(1129,'库存操作日志新增',1127,2,'#','',1,0,'F','0','0','oms:inventoryLog:add','#','admin','2021-05-16 06:58:00','',NULL,''),(1130,'库存操作日志修改',1127,3,'#','',1,0,'F','0','0','oms:inventoryLog:edit','#','admin','2021-05-16 06:58:00','',NULL,''),(1131,'库存操作日志删除',1127,4,'#','',1,0,'F','0','0','oms:inventoryLog:remove','#','admin','2021-05-16 06:58:00','',NULL,''),(1132,'库存操作日志导出',1127,5,'#','',1,0,'F','0','0','oms:log:export','#','admin','2021-05-16 06:58:00','',NULL,'');

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`notice_id`,`notice_title`,`notice_type`,`notice_content`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`,`tenant_id`) values (1,'温馨提醒：2018-07-01 若依新版本发布啦','2','新版本内容','0','admin','2021-04-26 11:57:17','',NULL,'管理员',NULL),(2,'维护通知：2018-07-01 若依系统凌晨维护','1','维护内容','0','admin','2021-04-26 11:57:17','',NULL,'管理员',NULL),(3,'眐hg','1',NULL,'0','xiaohong','2021-05-07 08:11:57','',NULL,NULL,10);

/*Table structure for table `sys_oper_log` */

DROP TABLE IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

/*Data for the table `sys_oper_log` */

insert  into `sys_oper_log`(`oper_id`,`title`,`business_type`,`method`,`request_method`,`operator_type`,`oper_name`,`dept_name`,`oper_url`,`oper_ip`,`oper_location`,`oper_param`,`json_result`,`status`,`error_msg`,`oper_time`,`tenant_id`) values (1,'用户管理',1,'com.ruoyi.system.controller.SysUserController.add()','POST',1,'admin',NULL,'/user','127.0.0.1','','{\"phonenumber\":\"15112121422\",\"admin\":false,\"password\":\"$2a$10$pCXkI0nObjcZzI1OuC5LiObP0Onevr5CJVDEYbAEFRSev9o0newWu\",\"postIds\":[4],\"nickName\":\"libai\",\"sex\":\"0\",\"deptId\":100,\"params\":{},\"userName\":\"李小白\",\"userId\":3,\"createBy\":\"admin\",\"roleIds\":[2],\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-04-30 17:02:22',NULL),(2,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','null',1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'tableNames\' not found. Available parameters are [arg1, arg0, param1, param2]','2021-05-04 05:26:36',NULL),(3,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','null',1,'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'tableNames\' not found. Available parameters are [arg1, arg0, param1, param2]','2021-05-04 05:26:40',NULL),(4,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:32:51',NULL),(5,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/1','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:46:24',NULL),(6,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:46:31',NULL),(7,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/2','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:51:15',NULL),(8,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:51:20',NULL),(9,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/3','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:57:06',NULL),(10,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 05:58:24',NULL),(11,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/4','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 06:04:51',NULL),(12,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 06:04:56',NULL),(13,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/4','127.0.0.1','',NULL,'{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}',0,NULL,'2021-05-04 06:07:11',NULL),(14,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/4','127.0.0.1','',NULL,'{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}',0,NULL,'2021-05-04 06:07:21',NULL),(15,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/5','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 06:08:50',NULL),(16,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 06:08:56',NULL),(17,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/6','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 07:34:21',NULL),(18,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 07:34:25',NULL),(19,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/7','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 07:40:22',NULL),(20,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-04 07:40:27',NULL),(21,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_address','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-06 05:49:55',NULL),(22,'用户管理',2,'com.wms.system.controller.SysUserController.edit()','PUT',1,'admin',NULL,'/user','127.0.0.1','','{\"roles\":[{\"flag\":false,\"roleId\":2,\"admin\":false,\"dataScope\":\"2\",\"params\":{},\"roleSort\":\"2\",\"deptCheckStrictly\":false,\"menuCheckStrictly\":false,\"roleKey\":\"common\",\"roleName\":\"普通角色\",\"status\":\"0\"}],\"phonenumber\":\"13326778346\",\"admin\":false,\"delFlag\":\"0\",\"password\":\"\",\"updateBy\":\"admin\",\"postIds\":[],\"loginIp\":\"\",\"email\":\"\",\"nickName\":\"陈品\",\"sex\":\"0\",\"avatar\":\"\",\"dept\":{\"deptId\":7,\"params\":{},\"children\":[]},\"params\":{},\"userName\":\"13326778346\",\"userId\":8,\"createBy\":\"13326778346\",\"roleIds\":[2],\"createTime\":1620290509000,\"tenantId\":10,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-06 19:31:47',NULL),(23,'用户管理',2,'com.wms.system.controller.SysUserController.edit()','PUT',1,'admin',NULL,'/user','127.0.0.1','','{\"roles\":[{\"flag\":false,\"roleId\":2,\"admin\":false,\"dataScope\":\"2\",\"params\":{},\"roleSort\":\"2\",\"deptCheckStrictly\":false,\"menuCheckStrictly\":false,\"roleKey\":\"common\",\"roleName\":\"普通角色\",\"status\":\"0\"}],\"phonenumber\":\"13326778346\",\"admin\":false,\"delFlag\":\"0\",\"password\":\"\",\"updateBy\":\"admin\",\"postIds\":[],\"loginIp\":\"\",\"email\":\"\",\"nickName\":\"陈品\",\"sex\":\"0\",\"avatar\":\"\",\"params\":{},\"userName\":\"13326778346\",\"userId\":8,\"createBy\":\"13326778346\",\"roleIds\":[2],\"createTime\":1620290509000,\"tenantId\":10,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-06 19:34:19',NULL),(24,'用户管理',2,'com.wms.system.controller.SysUserController.edit()','PUT',1,'admin',NULL,'/user','127.0.0.1','','{\"roles\":[{\"flag\":false,\"roleId\":2,\"admin\":false,\"dataScope\":\"2\",\"params\":{},\"roleSort\":\"2\",\"deptCheckStrictly\":false,\"menuCheckStrictly\":false,\"roleKey\":\"common\",\"roleName\":\"普通角色\",\"status\":\"0\"}],\"phonenumber\":\"13326778346\",\"admin\":false,\"delFlag\":\"0\",\"password\":\"\",\"updateBy\":\"admin\",\"postIds\":[],\"loginIp\":\"\",\"email\":\"\",\"nickName\":\"陈品\",\"sex\":\"0\",\"avatar\":\"\",\"params\":{},\"userName\":\"13326778346\",\"userId\":8,\"createBy\":\"13326778346\",\"roleIds\":[2],\"createTime\":1620290509000,\"tenantId\":10,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-06 19:34:25',NULL),(25,'用户管理',2,'com.wms.system.controller.SysUserController.edit()','PUT',1,'admin',NULL,'/user','127.0.0.1','','{\"roles\":[{\"flag\":false,\"roleId\":1,\"admin\":true,\"dataScope\":\"1\",\"params\":{},\"roleSort\":\"1\",\"deptCheckStrictly\":false,\"menuCheckStrictly\":false,\"roleKey\":\"admin\",\"roleName\":\"超级管理员\",\"status\":\"0\"}],\"phonenumber\":\"13326778348\",\"admin\":false,\"delFlag\":\"0\",\"password\":\"\",\"updateBy\":\"admin\",\"postIds\":[],\"loginIp\":\"\",\"email\":\"\",\"nickName\":\"右在\",\"sex\":\"0\",\"avatar\":\"\",\"params\":{},\"userName\":\"13326778348\",\"userId\":11,\"createBy\":\"13326778348\",\"roleIds\":[2],\"createTime\":1620292024000,\"tenantId\":10,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-06 19:34:31',NULL),(26,'角色管理',2,'com.wms.system.controller.SysRoleController.edit()','PUT',1,'admin',NULL,'/role','127.0.0.1','','{\"flag\":false,\"roleId\":2,\"admin\":false,\"remark\":\"普通角色\",\"dataScope\":\"2\",\"delFlag\":\"0\",\"params\":{},\"roleSort\":\"2\",\"deptCheckStrictly\":true,\"createTime\":1619409400000,\"updateBy\":\"admin\",\"menuCheckStrictly\":true,\"roleKey\":\"common\",\"roleName\":\"普通角色\",\"menuIds\":[1,100,1001,1002,1003,1004,1005,1006,1007,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,107,1041,1042,1043,1044],\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-06 20:04:26',NULL),(27,'部门管理',1,'com.wms.system.controller.SysDeptController.add()','POST',1,'13326778346',NULL,'/dept','127.0.0.1','','{\"deptName\":\"行政部\",\"leader\":\"李大地\",\"orderNum\":\"1\",\"params\":{},\"createBy\":\"13326778346\",\"children\":[],\"phone\":\"17112121522\",\"status\":\"0\"}','null',1,'','2021-05-06 20:09:16',NULL),(28,'部门管理',1,'com.wms.system.controller.SysDeptController.add()','POST',1,'13326778348',NULL,'/dept','127.0.0.1','','{\"deptName\":\"行政部\",\"orderNum\":\"1\",\"params\":{},\"createBy\":\"13326778348\",\"children\":[],\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 05:59:08',NULL),(29,'部门管理',2,'com.wms.system.controller.SysDeptController.edit()','PUT',1,'13326778348',NULL,'/dept','127.0.0.1','','{\"deptName\":\"迅腾公司\",\"deptId\":110,\"orderNum\":\"1\",\"delFlag\":\"0\",\"params\":{},\"parentId\":0,\"createBy\":\"13326778348\",\"children\":[],\"createTime\":1620338347000,\"updateBy\":\"13326778348\",\"ancestors\":\"0\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:09:24',NULL),(30,'部门管理',1,'com.wms.system.controller.SysDeptController.add()','POST',1,'13326778348',NULL,'/dept','127.0.0.1','','{\"deptName\":\"行政部\",\"orderNum\":\"1\",\"params\":{},\"parentId\":110,\"createBy\":\"13326778348\",\"children\":[],\"ancestors\":\"0,110\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:09:35',NULL),(31,'部门管理',1,'com.wms.system.controller.SysDeptController.add()','POST',1,'13326778348',NULL,'/dept','127.0.0.1','','{\"deptName\":\"保安部\",\"orderNum\":\"3\",\"params\":{},\"parentId\":111,\"createBy\":\"13326778348\",\"children\":[],\"ancestors\":\"0,110,111\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:09:52',NULL),(32,'部门管理',1,'com.wms.system.controller.SysDeptController.add()','POST',1,'13326778348',NULL,'/dept','127.0.0.1','','{\"deptName\":\"财务部\",\"orderNum\":\"1\",\"params\":{},\"parentId\":110,\"createBy\":\"13326778348\",\"children\":[],\"ancestors\":\"0,110\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:10:03',NULL),(33,'岗位管理',1,'com.wms.system.controller.SysPostController.add()','POST',1,'13326778348',NULL,'/post','127.0.0.1','','{\"postSort\":\"1\",\"flag\":false,\"postId\":5,\"params\":{},\"createBy\":\"13326778348\",\"postName\":\"助理\",\"postCode\":\"009\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:40:08',NULL),(34,'用户管理',1,'com.wms.system.controller.SysUserController.add()','POST',1,'13326778348',NULL,'/user','127.0.0.1','','{\"phonenumber\":\"13560359775\",\"admin\":false,\"password\":\"$2a$10$1sFuWSNNB4hG9RqFSGLQQebWXthDHqyZF0DcHH9Co7ECegU.CI2em\",\"postIds\":[5],\"nickName\":\"小红\",\"sex\":\"1\",\"deptId\":111,\"params\":{},\"userName\":\"xiaohong\",\"userId\":12,\"createBy\":\"13326778348\",\"roleIds\":[2],\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:41:03',NULL),(35,'用户管理',2,'com.wms.system.controller.SysUserController.resetPwd()','PUT',1,'13326778348',NULL,'/user/resetPwd','127.0.0.1','','{\"admin\":false,\"password\":\"$2a$10$5B63aQKinP.IEzae26cRN.M0EDeS1tU.WwSimTSp6VNZh5bq5sN8G\",\"updateBy\":\"13326778348\",\"params\":{},\"userId\":12}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:44:35',NULL),(36,'字典类型',1,'com.wms.system.controller.SysDictTypeController.add()','POST',1,'xiaohong',NULL,'/dict/type','127.0.0.1','','{\"createBy\":\"xiaohong\",\"dictName\":\"账户状态\",\"params\":{},\"dictType\":\"account_status\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:47:57',NULL),(37,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'xiaohong',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"0\",\"dictSort\":0,\"params\":{},\"dictType\":\"account_status\",\"dictLabel\":\"停用\",\"createBy\":\"xiaohong\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:48:28',NULL),(38,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'xiaohong',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"1\",\"dictSort\":1,\"params\":{},\"dictType\":\"account_status\",\"dictLabel\":\"启用\",\"createBy\":\"xiaohong\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 06:48:57',NULL),(39,'通知公告',1,'com.wms.system.controller.SysNoticeController.add()','POST',1,'xiaohong',NULL,'/notice','127.0.0.1','','{\"noticeType\":\"1\",\"params\":{},\"noticeTitle\":\"眐hg\",\"createBy\":\"xiaohong\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-07 08:11:58',NULL),(40,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_customer','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:27:06',NULL),(41,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/11','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:47:50',NULL),(42,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_customer','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:47:55',NULL),(43,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/12','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:53:51',NULL),(44,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_customer','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:53:55',NULL),(45,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"system\",\"orderNum\":\"10\",\"menuName\":\"系统管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"system\",\"children\":[],\"createTime\":1619409401000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:54:54',NULL),(46,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"monitor\",\"orderNum\":\"11\",\"menuName\":\"系统监控\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"monitor\",\"children\":[],\"createTime\":1619409401000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:55:02',NULL),(47,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"12\",\"menuName\":\"系统工具\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"tool\",\"children\":[],\"createTime\":1619409401000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":3,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:55:08',NULL),(48,'菜单管理',1,'com.wms.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"9\",\"menuName\":\"基础资料\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"info\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 10:56:45',NULL),(49,'菜单管理',1,'com.wms.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"1\",\"orderNum\":\"6\",\"menuName\":\"客户信息编辑\",\"params\":{},\"parentId\":1067,\"isCache\":\"0\",\"path\":\"/oms/customer/edit\",\"component\":\"/oms/customer/edit\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 11:44:33',NULL),(50,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"1\",\"icon\":\"#\",\"orderNum\":\"6\",\"menuName\":\"客户信息编辑\",\"params\":{},\"parentId\":1067,\"isCache\":\"0\",\"path\":\"customerEdit\",\"component\":\"/oms/customer/edit\",\"children\":[],\"createTime\":1620445473000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1073,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 11:45:26',NULL),(51,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"1\",\"icon\":\"#\",\"orderNum\":\"6\",\"menuName\":\"客户信息编辑\",\"params\":{},\"parentId\":1067,\"isCache\":\"0\",\"path\":\"customerEdit\",\"component\":\"oms/customer/edit\",\"children\":[],\"createTime\":1620445473000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1073,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 11:45:34',NULL),(52,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"1\",\"icon\":\"#\",\"orderNum\":\"6\",\"menuName\":\"客户信息编辑\",\"params\":{},\"parentId\":1067,\"isCache\":\"0\",\"path\":\"customerEdit\",\"component\":\"oms/customer/edit\",\"children\":[],\"createTime\":1620445473000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1073,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 11:53:22',NULL),(53,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1073','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 15:49:03',NULL),(54,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1072','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 15:49:10',NULL),(55,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_customer_contacts','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-08 18:00:41',NULL),(56,'角色管理',2,'com.wms.system.controller.SysRoleController.edit()','PUT',1,'admin',NULL,'/role','127.0.0.1','','{\"flag\":false,\"roleId\":2,\"admin\":false,\"remark\":\"普通角色\",\"dataScope\":\"2\",\"delFlag\":\"0\",\"params\":{},\"roleSort\":\"2\",\"deptCheckStrictly\":true,\"createTime\":1619409400000,\"updateBy\":\"admin\",\"menuCheckStrictly\":true,\"roleKey\":\"common\",\"roleName\":\"普通角色\",\"menuIds\":[1,1066,1067,1068,1069,1070,1071,100,1001,1002,1003,1004,1005,1006,1007,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,107,1041,1042,1043,1044],\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-09 00:43:20',NULL),(57,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_worker','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 06:25:25',NULL),(58,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_supplier,wms_supplier_contacts','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 06:46:31',NULL),(59,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/17','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 06:51:46',NULL),(60,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/16','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 06:51:49',NULL),(61,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_supplier,wms_supplier_contacts','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 06:51:59',NULL),(62,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"3\",\"menuName\":\"供应商管理\",\"params\":{},\"parentId\":1066,\"isCache\":\"0\",\"path\":\"supplier\",\"component\":\"oms/supplier/index\",\"children\":[],\"createTime\":1620601031000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1077,\"menuType\":\"C\",\"perms\":\"oms:supplier:list\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 06:57:41',NULL),(63,'字典类型',1,'com.wms.system.controller.SysDictTypeController.add()','POST',1,'admin',NULL,'/dict/type','127.0.0.1','','{\"createBy\":\"admin\",\"dictName\":\"供应商类别\",\"params\":{},\"dictType\":\"supplier_type\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:10:46',NULL),(64,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"1\",\"dictSort\":1,\"params\":{},\"dictType\":\"supplier_type\",\"dictLabel\":\"布类\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:11:23',NULL),(65,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"2\",\"dictSort\":2,\"params\":{},\"dictType\":\"supplier_type\",\"dictLabel\":\"金属\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:11:37',NULL),(66,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"3\",\"dictSort\":3,\"params\":{},\"dictType\":\"supplier_type\",\"dictLabel\":\"配件\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:11:49',NULL),(67,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"4\",\"dictSort\":4,\"params\":{},\"dictType\":\"supplier_type\",\"dictLabel\":\"塑料\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:11:58',NULL),(68,'字典类型',1,'com.wms.system.controller.SysDictTypeController.add()','POST',1,'admin',NULL,'/dict/type','127.0.0.1','','{\"createBy\":\"admin\",\"dictName\":\"客户类别\",\"params\":{},\"dictType\":\"customer_type\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:12:46',NULL),(69,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"1\",\"dictSort\":1,\"params\":{},\"dictType\":\"customer_type\",\"dictLabel\":\"零售\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:13:03',NULL),(70,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"2\",\"dictSort\":2,\"params\":{},\"dictType\":\"customer_type\",\"dictLabel\":\"散户\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:13:41',NULL),(71,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"3\",\"dictSort\":3,\"params\":{},\"dictType\":\"customer_type\",\"dictLabel\":\"代理商\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:13:59',NULL),(72,'字典类型',1,'com.wms.system.controller.SysDictTypeController.add()','POST',1,'admin',NULL,'/dict/type','127.0.0.1','','{\"createBy\":\"admin\",\"dictName\":\"计量单位\",\"params\":{},\"dictType\":\"unit\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:15:43',NULL),(73,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"1\",\"dictSort\":1,\"params\":{},\"dictType\":\"unit\",\"dictLabel\":\"块\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:15:59',NULL),(74,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"2\",\"dictSort\":2,\"params\":{},\"dictType\":\"unit\",\"dictLabel\":\"kg\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:16:07',NULL),(75,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"3\",\"dictSort\":3,\"params\":{},\"dictType\":\"unit\",\"dictLabel\":\"件\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:16:17',NULL),(76,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"4\",\"dictSort\":4,\"params\":{},\"dictType\":\"unit\",\"dictLabel\":\"张\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:16:27',NULL),(77,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"5\",\"dictSort\":5,\"params\":{},\"dictType\":\"unit\",\"dictLabel\":\"根\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:16:37',NULL),(78,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"6\",\"dictSort\":6,\"params\":{},\"dictType\":\"unit\",\"dictLabel\":\"箱\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:16:50',NULL),(79,'字典类型',1,'com.wms.system.controller.SysDictTypeController.add()','POST',1,'admin',NULL,'/dict/type','127.0.0.1','','{\"createBy\":\"admin\",\"dictName\":\"颜色\",\"params\":{},\"dictType\":\"color\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:19:39',NULL),(80,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"1\",\"dictSort\":1,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"卡其\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:19:58',NULL),(81,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"2\",\"dictSort\":2,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"咖啡\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:20:09',NULL),(82,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"3\",\"dictSort\":3,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"宝石蓝\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:20:23',NULL),(83,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"4\",\"dictSort\":4,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"宝蓝\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:20:32',NULL),(84,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"5\",\"dictSort\":5,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"浅棕色\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:20:50',NULL),(85,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"6\",\"dictSort\":6,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"白色\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:21:09',NULL),(86,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"7\",\"dictSort\":7,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"粉色\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:21:19',NULL),(87,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"8\",\"dictSort\":8,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"黑色\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:21:28',NULL),(88,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"9\",\"dictSort\":9,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"红色\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:21:43',NULL),(89,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"10\",\"dictSort\":10,\"params\":{},\"dictType\":\"color\",\"dictLabel\":\"蓝色\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-10 08:21:55',NULL),(90,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1072','127.0.0.1','',NULL,'{\"msg\":\"存在子菜单,不允许删除\",\"code\":500}',0,NULL,'2021-05-11 04:10:38',NULL),(91,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1073','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:10:44',NULL),(92,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1074','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:10:47',NULL),(93,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1075','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:10:49',NULL),(94,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1076','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:10:51',NULL),(95,'菜单管理',3,'com.wms.system.controller.SysMenuController.remove()','DELETE',1,'admin',NULL,'/menu/1072','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:10:54',NULL),(96,'字典类型',1,'com.wms.system.controller.SysDictTypeController.add()','POST',1,'admin',NULL,'/dict/type','127.0.0.1','','{\"createBy\":\"admin\",\"dictName\":\"客户等级\",\"params\":{},\"dictType\":\"customer_level\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:24:51',NULL),(97,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"1\",\"dictSort\":1,\"params\":{},\"dictType\":\"customer_level\",\"dictLabel\":\"普通会员\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:25:23',NULL),(98,'字典数据',1,'com.wms.system.controller.SysDictDataController.add()','POST',1,'admin',NULL,'/dict/data','127.0.0.1','','{\"dictValue\":\"2\",\"dictSort\":2,\"params\":{},\"dictType\":\"customer_level\",\"dictLabel\":\"VIP会员\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-11 04:25:33',NULL),(99,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/15','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 15:17:11',NULL),(100,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_warehouse','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 15:17:28',NULL),(101,'菜单管理',1,'com.wms.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"table\",\"orderNum\":\"8\",\"menuName\":\"商品管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"product\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 15:18:57',NULL),(102,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product_category','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 15:27:00',NULL),(103,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/21','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 15:27:46',NULL),(104,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product_category','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 15:28:02',NULL),(105,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/8','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 20:37:44',NULL),(106,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/9,10,13,14,18,19,20,22','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 20:37:48',NULL),(107,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product_spec','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-14 20:37:59',NULL),(108,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/23','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-15 05:50:36',NULL),(109,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product_sku','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-15 05:50:52',NULL),(110,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_product','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-15 06:17:47',NULL),(111,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/24','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:24:10',NULL),(112,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/25','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:24:11',NULL),(113,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_purchase_order','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:24:22',NULL),(114,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/26','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:25:42',NULL),(115,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_purchase_order','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:25:48',NULL),(116,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/27','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:33:46',NULL),(117,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_purchase_order','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:33:51',NULL),(118,'菜单管理',1,'com.wms.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"client\",\"orderNum\":\"5\",\"menuName\":\"采购管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"purchase\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:42:24',NULL),(119,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_purchase_order_item','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 05:55:10',NULL),(120,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/28','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:03:48',NULL),(121,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/29','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:03:53',NULL),(122,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_purchase_order_item','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:04:03',NULL),(123,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/30','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:08:31',NULL),(124,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_sale_order','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:08:40',NULL),(125,'菜单管理',1,'com.wms.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"6\",\"menuName\":\"销售管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"sale\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:14:38',NULL),(126,'菜单管理',2,'com.wms.system.controller.SysMenuController.edit()','PUT',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"采购订单\",\"params\":{},\"parentId\":1106,\"isCache\":\"0\",\"path\":\"purchase\",\"component\":\"oms/purchaseOrder/index\",\"children\":[],\"createTime\":1621115202000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1107,\"menuType\":\"C\",\"perms\":\"oms:purchase:list\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:20:53',NULL),(127,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_sale_order_item','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:34:33',NULL),(128,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_inventory','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:38:08',NULL),(129,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/33','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:38:15',NULL),(130,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_inventory','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:41:05',NULL),(131,'菜单管理',1,'com.wms.system.controller.SysMenuController.add()','POST',1,'admin',NULL,'/menu','127.0.0.1','','{\"visible\":\"0\",\"icon\":\"input\",\"orderNum\":\"7\",\"menuName\":\"库存管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"inventory\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:46:29',NULL),(132,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_inventory_log','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:49:58',NULL),(133,'代码生成',3,'com.wms.gen.controller.GenController.remove()','DELETE',1,'admin',NULL,'/gen/35','127.0.0.1','',NULL,'{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:50:03',NULL),(134,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_inventory_log','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-16 06:52:17',NULL),(135,'代码生成',6,'com.wms.gen.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/gen/importTable','127.0.0.1','','wms_purchase_order','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2021-05-18 16:55:40',NULL);

/*Table structure for table `sys_post` */

DROP TABLE IF EXISTS `sys_post`;

CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

/*Data for the table `sys_post` */

insert  into `sys_post`(`post_id`,`post_code`,`post_name`,`post_sort`,`status`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`,`tenant_id`) values (1,'ceo','董事长',1,'0','admin','2021-04-26 11:56:38','',NULL,'',NULL),(2,'se','项目经理',2,'0','admin','2021-04-26 11:56:38','',NULL,'',NULL),(3,'hr','人力资源',3,'0','admin','2021-04-26 11:56:38','',NULL,'',NULL),(4,'user','普通员工',4,'0','admin','2021-04-26 11:56:38','',NULL,'',NULL),(5,'009','助理',1,'0','13326778348','2021-05-07 06:40:07','',NULL,NULL,10);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`data_scope`,`menu_check_strictly`,`dept_check_strictly`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'超级管理员','admin',1,'1',1,1,'0','0','admin','2021-04-26 11:56:40','',NULL,'超级管理员'),(2,'普通角色','common',2,'2',1,1,'0','0','admin','2021-04-26 11:56:40','admin','2021-05-09 00:43:19','普通角色');

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

/*Data for the table `sys_role_dept` */

insert  into `sys_role_dept`(`role_id`,`dept_id`) values (2,100),(2,101),(2,105);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (2,1),(2,100),(2,103),(2,104),(2,105),(2,107),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1041),(2,1042),(2,1043),(2,1044),(2,1066),(2,1067),(2,1068),(2,1069),(2,1070),(2,1071);

/*Table structure for table `sys_tenant` */

DROP TABLE IF EXISTS `sys_tenant`;

CREATE TABLE `sys_tenant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '租户ID',
  `name` varchar(255) DEFAULT NULL COMMENT '租户名称',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '姓名(昵称)',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号',
  `del_flag` bit(1) DEFAULT NULL COMMENT '删除标记',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='租户管理';

/*Data for the table `sys_tenant` */

insert  into `sys_tenant`(`id`,`name`,`nick_name`,`phone`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (6,'广东佛山卡哇科技','王明','13326778347','\0','13326778347','2021-05-06 16:33:38','',NULL,NULL),(7,'广东佛山雄霸科技','陈品','13326778346','\0','13326778346','2021-05-06 16:41:50','',NULL,NULL),(10,'广东广州信息科技','右在','13326778348','\0','13326778348','2021-05-06 17:07:04','',NULL,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`dept_id`,`user_name`,`nick_name`,`user_type`,`email`,`phonenumber`,`sex`,`avatar`,`password`,`status`,`del_flag`,`login_ip`,`login_date`,`tenant_id`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,103,'admin','若依','00','ry@163.com','15888888888','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2021-04-26 11:56:37',NULL,'admin','2021-04-26 11:56:37','',NULL,'管理员'),(2,105,'ry','若依','00','ry@qq.com','15666666666','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2021-04-26 11:56:37',NULL,'admin','2021-04-26 11:56:37','',NULL,'测试员'),(3,100,'李小白','libai','00','','15112121422','0','','$2a$10$pCXkI0nObjcZzI1OuC5LiObP0Onevr5CJVDEYbAEFRSev9o0newWu','0','0','',NULL,NULL,'admin','2021-04-30 17:02:22','',NULL,NULL),(7,NULL,'13326778347','王明','00','','13326778347','0','','$2a$10$yLz2/cd6qfZEiSIbSY/uveKeHjy3mDDoEvshNEbpdLnKCDrBhXqTm','0','0','',NULL,6,'13326778347','2021-05-06 16:33:37','',NULL,NULL),(8,NULL,'13326778346','陈品','00','','13326778346','0','','$2a$10$X9ZXVTd6e6wVNV1le5AReeGv79ImBaK.6GLsfyW.55L8mvjgcyN2m','0','0','',NULL,10,'13326778346','2021-05-06 16:41:49','admin','2021-05-06 19:34:25',NULL),(11,NULL,'13326778348','右在','00','','13326778348','0','','$2a$10$OHYwpHpdt5aC6VZlG8YWk.xlGhHEVxS1VrO8lNVuPV74JJAEPsqke','0','0','',NULL,10,'13326778348','2021-05-06 17:07:04','admin','2021-05-06 19:34:31',NULL),(12,NULL,'xiaohong','小红','00','','13560359775','1','','$2a$10$5B63aQKinP.IEzae26cRN.M0EDeS1tU.WwSimTSp6VNZh5bq5sN8G','0','0','',NULL,10,'13326778348','2021-05-07 06:41:03','13326778348','2021-05-07 06:44:34',NULL);

/*Table structure for table `sys_user_post` */

DROP TABLE IF EXISTS `sys_user_post`;

CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

/*Data for the table `sys_user_post` */

insert  into `sys_user_post`(`user_id`,`post_id`) values (1,1),(2,2),(3,4),(12,5);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,1),(2,2),(3,2),(7,2),(8,2),(11,2),(12,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
