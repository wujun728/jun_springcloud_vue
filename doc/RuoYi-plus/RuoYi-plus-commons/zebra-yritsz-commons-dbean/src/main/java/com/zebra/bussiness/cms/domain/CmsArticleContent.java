package com.zebra.bussiness.cms.domain;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;

/**
 * cms_article_content表 CmsArticleContent
 * 
 * @author zebra
 * @date 2020-06-26
 */
@Table(name="cms_article_content")
@Getter
@Setter
@ToString
public class CmsArticleContent extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** $column.columnComment */
     @Id
     private String id;

    /** $column.columnComment */
     @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
     @Column(name="content")
     private String content;

    /** $column.columnComment */
     @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
     @Column(name="content_markdown_source")
     private String contentMarkdownSource;

}
