package com.zebra.bussiness.cms.domain.page;

import com.zebra.bussiness.cms.domain.CmsMaterial;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CmsMaterialPage extends CmsMaterial {
    private String groupName;
    private String merchantName;
}
