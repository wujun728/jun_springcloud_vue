package com.zebra.api.commodity.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.api.commodity.service.CommodityService;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.enums.ResultEnum;
import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.mapper.CommodityInfoMapper;

/**
 * Title: 产品管理实现<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	@Override
	public Json editStock(String commodityId, boolean isRollback) {
		if (isRollback) {
			return Json.other(ResultEnum.COMMODITY_FAIL);
		}
		CommodityInfo commodityInfo = commodityInfoMapper.selectByPrimaryKey(commodityId);
		if (commodityInfo == null) {
			return Json.other(ResultEnum.PARAMNULL);
		}
		Integer count = commodityInfo.getCommodityCount();
		count--;
		commodityInfo.setCommodityCount(count);
		commodityInfo.setUpdateDatetime(new Date());
		int falg = commodityInfoMapper.updateByPrimaryKeySelective(commodityInfo);
		if (falg == 0) {
			return Json.other(ResultEnum.FLAG_FAIL);
		}
		return Json.success();
	}

}
