package com.zebra.bussiness.controller.extend;

import java.util.ArrayList;
import java.util.List;

import com.zebra.bussiness.service.impl.extend.MerchaninfoServiceImplExtend;
import org.springframework.beans.BeanUtils;

import com.zebra.bussiness.domain.Merchaninfo;
import com.zebra.bussiness.domain.page.MerchantInfoPage;

public class MerchaninfoControllerExtend extends MerchaninfoServiceImplExtend {

	protected List<MerchantInfoPage> getMerchantInfoPage(List<Merchaninfo> list) {
		List<MerchantInfoPage> pages = new ArrayList<>(list.size());
		BeanUtils.copyProperties(list, pages);
		list.forEach(source -> {
			pages.add(this.getMerchantInfoPage(source));
		});
		return pages;
	}

	protected MerchantInfoPage getMerchantInfoPage(Merchaninfo source) {
		MerchantInfoPage page = new MerchantInfoPage();
		BeanUtils.copyProperties(source, page);
		page.setCityName(super.getCityName(page.getProvinceId(),page.getCityCode()));
		page.setDeptName(super.getDeptName(page.getDeptId()));
		return page;

	}
}
