package com.zebra.bussiness.domain;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import java.util.Date;

/**
 * t_merchant_info表 Merchaninfo
 * 
 * @author zebra
 * @date 2020-05-13
 */
@Table(name = "t_merchant_info")
@Getter
@Setter
@ToString
public class Merchaninfo extends BussinessEntity {
	private static final long serialVersionUID = 1L;

	/** 商户id */
	@Id
	private String merchantId;

	/** 商户名称 */
	@Excel(name = "商户名称")
	@Column(name = "merchant_name")
	private String merchantName;

	/** 商户地址 */
	@Excel(name = "商户地址")
	@Column(name = "merchant_address")
	private String merchantAddress;

	/** 商户图片 */
	@Excel(name = "商户图片")
	@Column(name = "merchant_img")
	private String merchantImg;

	/** 商户简介 */
	@Excel(name = "商户简介")
	@Column(name = "merchant_brief")
	private String merchantBrief;

	/** 商户介绍 */
	@Excel(name = "商户介绍")
	@Column(name = "merchant_introduce")
	private String merchantIntroduce;

	/** 信用代码 */
	@Excel(name = "信用代码")
	@Column(name = "merchant_credit_code")
	private String merchantCreditCode;

	/** 商户营业执照 */
	@Excel(name = "商户营业执照")
	@Column(name = "merchant_license_img")
	private String merchantLicenseImg;

	/** 商户状态（1上线 2下线） */
	@Excel(name = "商户状态", readConverterExp = "1=上线,2=下线")
	@Column(name = "merchant_status")
	private Integer merchantStatus;

	/** 审核状态（1正常 2违规） */
	@Excel(name = "审核状态", readConverterExp = "1=正常,2=违规")
	@Column(name = "examine_status")
	private Integer examineStatus;

	/** 审核描述 */
	@Excel(name = "审核描述")
	@Column(name = "examine_desc")
	private String examineDesc;

	/** 商户属性（1官方 2品牌 3个人） */
	@Excel(name = "商户属性", readConverterExp = "1=官方,2=品牌,3=个人")
	@Column(name = "merchant_attribute")
	private Integer merchantAttribute;

	/** 商品权益（1需要审核 2不需要审核） */
	@Excel(name = "商品权益", readConverterExp = "1=需要审核,2=不需要审核")
	@Column(name = "commodity_equity")
	private Integer commodityEquity;

	/** 省份编码 */
	@Excel(name = "省份编码")
	@Column(name = "province_id")
	private String provinceId;

	/** 城市编码 */
	@Excel(name = "城市编码")
	@Column(name = "city_code")
	private String cityCode;

	/** 部门ID */
	@Excel(name = "部门ID")
	@Column(name = "dept_id")
	private Long deptId;

	/** 创建时间 */
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	@Column(name = "create_time")
	private Date createTime;

	/** 更新时间 */
	@Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
	@Column(name = "update_time")
	private Date updateTime;

	/** 操作人 */
	@Excel(name = "操作人")
	@Column(name = "update_by")
	private String updateBy;

}
