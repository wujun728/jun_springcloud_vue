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
 * cms_comment表 CmsComment
 * 
 * @author zebra
 * @date 2020-06-30
 */
@Table(name="cms_comment")
@Getter
@Setter
@ToString
public class CmsComment extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** ID */
     @Id
     @Excel(name = "评论id")
     private Long commentId;

    /** 父ID */
    @Excel(name = "父级id")
    @Column(name="comment_pid")
     private Long commentPid;

    /** 目标ID(例如文章id) */
     @Excel(name = "目标ID(例如文章id)")
     @Column(name="comment_tid")
     private String commentTid;

    /** 评论类型（1系统 2文章） */
     @Excel(name = "评论类型", readConverterExp = "1=系统,2=文章")
     @Column(name="comment_type")
     private Integer commentType;

    /** 评论内容 */
     @Excel(name = "评论内容")
     @Column(name="comment_content")
     private String commentContent;

    /** 平台回复 */
     @Excel(name = "平台回复")
     @Column(name="comment_reply")
     private String commentReply;

    /** 反对数 */
     @Excel(name = "反对数")
     @Column(name="num_opposition")
     private Integer numOpposition;

    /** 点赞数 */
     @Excel(name = "点赞数")
     @Column(name="num_like")
     private Integer numLike;

    /** 用户id */
     @Excel(name = "用户id")
     @Column(name="user_id")
     private String userId;

    /** 用户名称 */
     @Excel(name = "用户名称")
     @Column(name="user_name")
     private String userName;

    /** 用户头像 */
     @Excel(name = "用户头像")
     private String userAvatar;

    /** 联系方式 */
     @Excel(name = "联系方式")
     @Column(name="user_contact")
     private String userContact;

    /** 用户IP */
     @Excel(name = "用户IP")
     @Column(name="user_ip")
     private String userIp;

    /** 状态（1正常 2黑名单） */
     @Excel(name = "状态", readConverterExp = "1=正常,2=黑名单")
     @Column(name="user_status")
     private Integer userStatus;

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

    /** 删除标志（1删除 0正常） */
     private Integer delFlag;

    /** 置顶标志(1置顶 0普通） */
    @Excel(name = "置顶标志", readConverterExp = "1=置顶,0=普通")
     private Integer topFlag;

}
