package com.wms.oms.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotNull;

/**
 * 采购订单对象 wms_purchase_order
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
@TableName("wms_purchase_order")
public class PurchaseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 采购订单编号 */
    private String sn;

    /** 供应商id */
    @NotNull(message = "供应商不能为空！")
    private Long supplierId;

    /** 购货日期 */
    @NotNull(message = "购货日期不能为空！")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;

    /** 单据日期 */
    @NotNull(message = "单据日期不能为空！")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date billDate;

    /** 出入库类型 */
    private String inventoryType;

    /** 出入库状态 */
    private String inventoryStatus;

    /** 优惠率 */
    @NotNull(message = "优惠率不能为空！")
    private BigDecimal discountRate;

    /** 优惠金额 */
    @NotNull(message = "优惠金额不能为空！")
    private BigDecimal discountAmount;

    /** 合计金额 */
    @NotNull(message = "合计金额不能为空！")
    private BigDecimal totalAmount;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

    /** 供应商 */
    @TableField(exist = false)
    private Supplier supplier;

    /** 采购订单详情 */
    @TableField(exist = false)
    private List<PurchaseOrderItem> purchaseOrderItemList;

}