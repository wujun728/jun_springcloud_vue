package com.zebra.bussiness.controller.extend;

import java.util.ArrayList;
import java.util.List;

import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import com.zebra.bussiness.domain.CityInfo;
import com.zebra.bussiness.domain.page.CityInfoPage;

public class CityInfoControllerExtend extends BaseServiceImplExtend {

	protected List<CityInfoPage> getCityInfoPage(List<CityInfo> list) {
		List<CityInfoPage> pages = new ArrayList<>(list.size());
		BeanUtils.copyProperties(list, pages);
		list.forEach(source -> {
			pages.add(this.getCityInfoPage(source));
		});
		return pages;
	}

	protected CityInfoPage getCityInfoPage(CityInfo source) {
		CityInfoPage page = new CityInfoPage();
		BeanUtils.copyProperties(source, page);
		page.setProvinceName(super.getProvinceName(page.getProvinceId()));
		return page;

	}
}
