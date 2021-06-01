package com.wms.oms.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 供应商信息对象 wms_supplier
 *
 * @author zzm
 * @date 2021-05-10
 */
@Data
@TableName("wms_supplier")
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 供应商编号 */
    private String sn;

    /** 供应商名称 */
    @NotEmpty(message = "供应商名称不能为空！")
    private String supplierName;

    /** 供应商类别 */
    @NotEmpty(message = "供应商类别不能为空！")
    private String supplierType;

    /** 余额日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date balanceDate;

    /** 期初应付 */
    @NotNull(message = "期初应付不能为空！")
    private BigDecimal firstPay;

    /** 期初预付款 */
    @NotNull(message = "期初预付款不能为空！")
    private BigDecimal firstPrePay;

    /** 纳税人识别号 */
    private String taxIdentity;

    /** 增值税税率 */
    private BigDecimal taxRate;

    /** 开户银行 */
    private String bankInfo;

    /** 银行账号 */
    private String bankNum;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

    /**  关联供应商联系人表 */
    @TableField(exist = false)
    private List<SupplierContacts> supplierContactsList;

}