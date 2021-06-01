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
 * cms_material表 CmsMaterial
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Table(name="cms_material")
@Getter
@Setter
@ToString
public class CmsMaterial extends BussinessEntity {
    private static final long serialVersionUID = 1L;

    /** 素材id */
    @Id
    private String materialId;

    /** 分组id */
    @Excel(name = "分组id")
    @Column(name="group_id")
    private String groupId;

    /** 素材名称 */
    @Excel(name = "素材名称")
    @Column(name="material_name")
    private String materialName;

    /** 素材类型（1图片 2视频 3文本） */
    @Excel(name = "素材类型", readConverterExp = "1=图片,2=视频,3=文本")
    @Column(name="material_type")
    private Integer materialType;

    /** 素材描述 */
    @Excel(name = "素材描述")
    @Column(name="material_description")
    private String materialDescription;

    /** 保存路径 */
    @Excel(name = "保存路径")
    @Column(name="save_path")
    private String savePath;

    /** 缩略图 */
    @Excel(name = "缩略图")
    @Column(name="material_thumbnail")
    private String materialThumbnail;

    /** 审核状态（0待审批 2未通过 1通过） */
    @Excel(name = "审核状态", readConverterExp = "0=待审批,2=未通过,1=通过")
    @Column(name="audit_state")
    private Integer auditState;

    /** 审核意见 */
    @Excel(name = "审核意见")
    @Column(name="audit_reason")
    private String auditReason;

    /** 可用状态（0停用 1启用） */
    @Excel(name = "可用状态", readConverterExp = "0=停用,1=启用")
    @Column(name="use_state")
    private String useState;

    /** 商户id */
    @Excel(name = "商户id")
    @Column(name="merchant_id")
    private String merchantId;

    /** 操作人 */
    @Excel(name = "操作人")
    @Column(name="update_by")
    private String updateBy;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @Column(name="create_time")
    private Date createTime;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    @Column(name="update_time")
    private Date updateTime;

}
