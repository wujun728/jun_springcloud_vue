package com.zebra.bussiness.cms.domain;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * cms_blacklist表 CmsBlacklist
 * 
 * @author zebra
 * @date 2020-06-30
 */
@Table(name="cms_blacklist")
@Getter
@Setter
@ToString
public class CmsBlacklist extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** ID */
     @Id
     private Integer blacklistId;

    /** 类型（1文章评论） */
     @Excel(name = "类型", readConverterExp = "1=文章评论")
     @Column(name="blacklist_type")
     private Integer blacklistType;

    /** 关联id */
     @Excel(name = "关联id")
     @Column(name="aubot_id")
     private String aubotId;

    /** 相关内容 */
     @Excel(name = "相关内容")
     @Column(name="aubot_info")
     private String aubotInfo;

    /** 用户id */
     @Excel(name = "用户id")
     @Column(name="user_id")
     private String userId;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

    /** 商户id */
     @Excel(name = "商户id")
     @Column(name="merchant_id")
     private String merchantId;

    /** 更新人 */
     @Column(name="update_by")
     private String updateBy;

    /** 其他信息 */
     @Excel(name = "其他信息")
     @Column(name="other_info")
     private String otherInfo;

}
