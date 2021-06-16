package com.zebra.bussiness.cms.domain;

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
 * cms_article_template表 CmsArticleTemplate
 * 
 * @author zebra
 * @date 2020-07-28
 */
@Table(name="cms_article_template")
@Getter
@Setter
@ToString
public class CmsArticleTemplate extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 模板id */
     @Id
     private Long templeId;

    /** 模板名称 */
     @Excel(name = "模板名称")
     @Column(name="temple_name")
     private String templeName;

    /** 模板内容 */
     @Excel(name = "模板内容")
     @Column(name="temple_content")
     private String templeContent;

    /** 审核状态（0待审批 2未通过 1通过） */
     @Excel(name = "审核状态", readConverterExp = "0=待审批,2=未通过,1=通过")
     @Column(name="audit_state")
     private Integer auditState;

    /** 审核意见 */
     @Excel(name = "审核意见")
     @Column(name="audit_reason")
     private String auditReason;

    /** 审核时间 */
     @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="audit_time")
     private Date auditTime;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

    /** 商户id */
     @Column(name="merchant_id")
     private String merchantId;

    /** 更新人 */
     @Excel(name = "更新人")
     @Column(name="update_by")
     private String updateBy;

    /** 删除标志（1删除 0正常） */
     @Column(name="del_flag")
     private Integer delFlag;

}
