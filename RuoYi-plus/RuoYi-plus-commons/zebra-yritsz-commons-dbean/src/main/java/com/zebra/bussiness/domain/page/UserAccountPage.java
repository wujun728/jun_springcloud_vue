package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.UserAccount;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanshuangbin
 * @date 2021-01-25 10:28
 */
@Setter
@Getter
public class UserAccountPage extends UserAccount {
    @Excel(name = "用户信息")
    private String userName;
}
