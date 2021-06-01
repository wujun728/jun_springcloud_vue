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
 * cms_article表 CmsArticle
 * 
 * @author zebra
 * @date 2020-06-25
 */
@Table(name="cms_article")
@Getter
@Setter
@ToString
public class CmsArticle extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 文章ID */
     @Id
     private String articleId;

    /** 作者 */
     @Excel(name = "作者")
     @Column(name="article_author")
     private String articleAuthor;

    /** 文章标题 */
     @Excel(name = "文章标题")
     @Column(name="article_title")
     private String articleTitle;

    /** 文章状态（1草稿 2待审核 3已发布 4审核失败） */
     @Excel(name = "文章状态", readConverterExp = "1=草稿,2=待审核,3=已发布,4=审核失败")
     @Column(name="article_status")
     private Integer articleStatus;

    /** 关键词 */
     @Column(name="article_keywords")
     private String articleKeywords;

    /** 摘要 */
     @Column(name="article_description")
     private String articleDescription;

    /** 封面 素材id */
     @Excel(name = "封面 素材id")
     @Column(name="material_id")
     private String materialId;

    /** 频道栏目ID */
     @Excel(name = "频道栏目ID")
     @Column(name="category_id")
     private String categoryId;

    /** 转载标志（1转载 0原创） */
     @Excel(name = "转载标志", readConverterExp = "1=转载,0=原创")
     @Column(name="copy_flag")
     private Integer copyFlag;

    /** 原始链接 */
     @Column(name="article_link")
     private String articleLink;

    /** 静态化后url */
     @Column(name="static_url")
     private String staticUrl;

    /** 标签 */
     @Excel(name = "标签")
     @Column(name="article_tags")
     private String articleTags;

    /** 热点标志（1热点 0普通） */
     @Excel(name = "热点标志", readConverterExp = "1=热点,0=普通")
     @Column(name="hot_flag")
     private Integer hotFlag;

    /** 是否开启评论(1开启 0关闭） */
     @Excel(name = "是否开启评论(1开启 0关闭）")
     @Column(name="comment_flag")
     private Integer commentFlag;

    /** 置顶标志(1置顶 0普通） */
     @Excel(name = "置顶标志(1置顶 0普通）")
     @Column(name="top_flag")
     private Integer topFlag;

    /** 生成静态页面的模板(cms_template表中的name) */
     @Column(name="template_name")
     private String templateName;

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
     @Column(name="del_flag")
     private Integer delFlag;

}
