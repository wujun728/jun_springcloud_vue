package com.zebra.bussiness.domain;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import com.zebra.common.core.domain.MyNextVersion;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * t_commodity_info表 CommodityInfo
 * 
 * @author zebra
 * @date 2020-06-11
 */
@Table(name="t_commodity_info")
@Getter
@Setter
@ToString
public class CommodityInfo extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 产品id */
     @Id
     private String commodityId;

    /** 产品名称 */
     @Excel(name = "产品名称")
     @Column(name="commodity_name")
     private String commodityName;

    /** 产品简介 */
     @Excel(name = "产品简介")
     @Column(name="commodity_brief")
     private String commodityBrief;

    /** 产品详情 */
     @Excel(name = "产品详情")
     @Column(name="commodity_introduce")
     private String commodityIntroduce;

    /** 商品费用 */
     @Excel(name = "商品费用")
     @Column(name="commodity_moeny")
     private Integer commodityMoeny;

    /** 商品类型（1单规格 2多规格） */
    @Excel(name = "商品类型", readConverterExp = "1=单规格,2=多规格")
    @Column(name="commodity_type")
    private Integer commodityType;

    /** 商品运费（0元免费） */
     @Excel(name = "商品运费", readConverterExp = "0=元免费")
     @Column(name="commodity_freight")
     private Integer commodityFreight;

    /** 产品图片 */
     @Excel(name = "产品图片")
     @Column(name="commodity_img")
     private String commodityImg;

    /** 商品属性（1允许退款-无需审核 2允许退款-需要审核 3不允许退款） */
     @Excel(name = "商品属性", readConverterExp = "1=允许退款-无需审核,2=允许退款-需要审核,3=不允许退款")
     @Column(name="commodity_attribute")
     private Integer commodityAttribute;

    /** 商品状态（1上架 2下架） */
     @Excel(name = "商品状态", readConverterExp = "1=上架,2=下架")
     @Column(name="commodity_status")
     private Integer commodityStatus;

    /** 商品类别 */
     @Excel(name = "商品类别")
     @Column(name="category_id")
     private String categoryId;

    /** 审核状态（1审核通过 2待审核 3审核拒绝） */
     @Excel(name = "审核状态", readConverterExp = "1=审核通过,2=待审核,3=审核拒绝")
     @Column(name="examine_status")
     private Integer examineStatus;

    /** 审核描述 */
     @Excel(name = "审核描述")
     @Column(name="examine_desc")
     private String examineDesc;

    /** 商品库存（无规格时以此为准） */
     @Excel(name = "商品库存", readConverterExp = "无=规格时以此为准")
     @Column(name="commodity_count")
     private Integer commodityCount;

    /** 排序 */
     @Excel(name = "排序")
     @Column(name="zebra_order")
     private Integer zebraOrder;

    /** 商户id */
     @Excel(name = "商户id")
     @Column(name="merchant_id")
     private String merchantId;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

    /** 操作人 */
     @Excel(name = "操作人")
     @Column(name="update_by")
     private String updateBy;

    /** 数据版本 */
    @Version(nextVersion = MyNextVersion.class)
    @Excel(name = "数据版本")
     @Column(name="data_ver_flag")
     private Long dataVerFlag;

}