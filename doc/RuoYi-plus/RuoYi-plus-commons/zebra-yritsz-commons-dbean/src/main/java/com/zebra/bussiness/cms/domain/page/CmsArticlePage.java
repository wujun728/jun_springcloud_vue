package com.zebra.bussiness.cms.domain.page;

import com.zebra.bussiness.cms.domain.CmsArticle;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CmsArticlePage extends CmsArticle {
    private String content;
    private String materialUrl;
    private String categoryName;
    private String merchantName;
}
