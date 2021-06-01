package com.zebra.bussiness.service.impl.extend;

import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.bussiness.domain.CityInfo;
import com.zebra.bussiness.domain.ProvinceInfo;
import com.zebra.bussiness.mapper.CityInfoMapper;
import com.zebra.bussiness.mapper.ProvinceInfoMapper;
import com.zebra.common.utils.StringUtils;
import com.zebra.system.domain.SysDept;
import com.zebra.system.mapper.SysDeptMapper;

public class MerchaninfoServiceImplExtend extends BaseServiceImplExtend {
	@Autowired
	private SysDeptMapper sysDeptMapper;
	@Autowired
	private ProvinceInfoMapper provinceInfoMapper;
	@Autowired
	private CityInfoMapper cityInfoMapper;

	protected String getCityName(String provinceId, String cityCode) {
		ProvinceInfo provinceInfo = provinceInfoMapper.selectByPrimaryKey(provinceId);
		if (provinceInfo == null)
			return null;
		CityInfo cityInfo = cityInfoMapper.selectByPrimaryKey(cityCode);
		if (cityInfo == null)
			return provinceInfo.getProvinceName();
		return StringUtils.format("{}.{}", provinceInfo.getProvinceName(), cityInfo.getCityName());
	}

	protected String getDeptName(Long deptId) {
		SysDept sysDept = sysDeptMapper.selectDeptById(deptId);
		if (sysDept == null)
			return null;
		return sysDept.getDeptName();
	}
}
