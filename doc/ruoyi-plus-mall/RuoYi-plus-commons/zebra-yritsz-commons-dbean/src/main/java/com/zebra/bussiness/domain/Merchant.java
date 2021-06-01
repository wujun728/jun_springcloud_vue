package com.zebra.bussiness.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * t_merchant表 Merchant
 *
 * @author zebra
 * @date 2020-03-03
 */
@Table(name="t_merchant")
@Getter
@Setter
@ToString
public class Merchant extends BussinessEntity
{
    private static final long serialVersionUID = 1L;

    /** 商户id */
     @Id
     @Column(name="merchant_id")
     private Long merchantId;

    /** 商户名称 */
     @Excel(name = "商户名称")
     @Column(name="merchant_name")
     private String merchantName;

    /** 商户地址 */
     @Excel(name = "商户地址")
     @Column(name="merchant_address")
     private String merchantAddress;

    /** 商户状态（1上线 2下线） */
     @Excel(name = "商户状态", readConverterExp = "1=上线,2=下线")
     @Column(name="merchant_status")
     private Integer merchantStatus;

    /** 商户图片 */
     @Excel(name = "商户图片")
     @Column(name="merchant_pic")
     private String merchantPic;

    /** 商户简介 */
     @Excel(name = "商户简介")
     @Column(name="merchant_brief")
     private String merchantBrief;

    /** 商户介绍 */
     @Excel(name = "商户介绍")
     @Column(name="merchant_introduce")
     private String merchantIntroduce;

    /** 部门ID */
     @Excel(name = "部门ID")
     @Column(name="dept_id")
     private Long deptId;
}
