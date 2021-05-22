package com.zebra.bussiness.cms.domain.page;

import com.zebra.bussiness.cms.domain.CmsArticle;
import com.zebra.bussiness.cms.domain.CmsComment;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CmsCommentPage extends CmsComment {
    @Excel(name = "所属商户")
    private String merchantName;
}
