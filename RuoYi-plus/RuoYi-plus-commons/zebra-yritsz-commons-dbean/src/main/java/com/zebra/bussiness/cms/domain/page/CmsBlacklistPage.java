package com.zebra.bussiness.cms.domain.page;

import com.zebra.bussiness.cms.domain.CmsBlacklist;
import com.zebra.bussiness.cms.domain.CmsComment;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CmsBlacklistPage extends CmsBlacklist {
    @Excel(name = "所属商户")
    private String merchantName;
}
