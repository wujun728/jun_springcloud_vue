package com.wms.oms.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 客户信息对象 wms_customer
 *
 * @author zzm
 * @date 2021-05-08
 */
@Data
@TableName("wms_customer")
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 客户编号 */
    private String sn;

    /** 客户名称 */
    @NotEmpty(message = "客户名称不能为空！")
    private String customerName;

    /** 客户类别 */
    @NotEmpty(message = "请选择客户类别！")
    private String customerType;

    /** 客户等级 */
    @NotEmpty(message = "请选择客户等级！")
    private String customerLevel;

    /** 余额日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date balanceDate;

    /** 期初应收 */
    @NotNull(message = "期初应收不能为空！")
    private BigDecimal firstGet;

    /** 期初预收 */
    @NotNull(message = "期初预收不能为空！")
    private BigDecimal firstPreGet;

    /** 纳税人识别号 */
    private String taxIdentity;

    /** 开户银行 */
    private String bankInfo;

    /** 银行账号 */
    private String bankNum;

    /** 销售人员id */
    @NotNull(message = "请选择销售人员！")
    private Long sellerId;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;


    @TableField(exist = false)
    @Valid
    private List<CustomerContacts> customerContactsList;




}