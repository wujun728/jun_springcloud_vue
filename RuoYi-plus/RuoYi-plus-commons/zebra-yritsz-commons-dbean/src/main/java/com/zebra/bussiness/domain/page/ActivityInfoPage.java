package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.ActivityInfo;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivityInfoPage extends ActivityInfo {
    private static final long serialVersionUID = 1L;
    @Excel(name = "类别名称")
    private String categoryName;
}
