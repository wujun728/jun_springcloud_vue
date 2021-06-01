package com.wms.oms.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wms.system.api.domain.SysUser;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 销售订单对象 wms_sale_order
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
@TableName("wms_sale_order")
public class SaleOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 销售单编号 */
    private String sn;

    /** 客户id */
    private Long customerId;

    /** 销售人id */
    private Long workerId;

    /** 单据日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date billDate;

    /** 客户地址 */
    private String address;

    /** 1-销售出库 */
    private String inventoryType;

    /** 确认出库 */
    private String inventoryStatus;

    /** 优惠率 */
    private BigDecimal discountRate;

    /** 优惠金额 */
    private BigDecimal discountAmount;

    /** 合计金额 */
    private BigDecimal totalAmount;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

    /** 关联销售用户 */
    @TableField(exist = false)
    private SysUser sysUser;

    /** 关联客户 */
    @TableField(exist = false)
    private Customer customer;

    /** 销售明细 */
    @TableField(exist = false)
    private List<SaleOrderItem> saleOrderItemList;

}