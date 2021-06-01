package com.zebra.bussiness.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * t_commodity_info表 CommodityInfo
 *
 * @author zebra
 * @date 2020-03-25
 */
@Table(name="t_commodity_info")
@Getter
@Setter
@ToString
public class CommodityInfo extends BussinessEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品id */
     @Id
     @Column(name="commodity_id")
     private String commodityId;

    /** 产品名称 */
     @Excel(name = "产品名称")
     @Column(name="commodity_name")
     private String commodityName;

     /** 产品状态（1上架 2下架） */
      @Excel(name = "产品状态", readConverterExp = "1=上架,2=下架")
      @Column(name="commodity_status")
      private String commodityStatus;

     /** 商品价格 */
      @Excel(name = "商品价格")
      @Column(name="commodity_moeny")
      private Double commodityMoeny;

    /** 产品库存 */
     @Excel(name = "产品库存")
     @Column(name="commodity_count")
     private Integer commodityCount;

    /** 产品图片 */
     @Excel(name = "产品图片")
     @Column(name="commodity_img")
     private String commodityImg;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_datetime")
     private Date createDatetime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_datetime")
     private Date updateDatetime;

    /** 商户id */
     @Excel(name = "商户id")
     @Column(name="mechant_id")
     private Long mechantId;

    /** 数据版本 */
     @Excel(name = "数据版本")
     @Column(name="data_ver_flag")
     private Long dataVerFlag;
}
