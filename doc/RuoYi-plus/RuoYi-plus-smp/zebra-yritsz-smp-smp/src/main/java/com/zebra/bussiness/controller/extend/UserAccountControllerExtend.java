package com.zebra.bussiness.controller.extend;

import com.zebra.bussiness.domain.UserAccount;
import com.zebra.bussiness.domain.page.UserAccountPage;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserAccountControllerExtend extends BaseServiceImplExtend {

    protected List<UserAccountPage> getUserAccountPage(List<UserAccount> list) {
        List<UserAccountPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getUserAccountPage(source));
        });
        return pages;
    }
    protected UserAccountPage getUserAccountPage(UserAccount source) {
        UserAccountPage page = new UserAccountPage();
        BeanUtils.copyProperties(source, page);
        page.setUserName(super.getUserName(page.getUserId()));
        return page;

    }
}
