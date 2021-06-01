package com.zebra.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.Merchant;
import com.zebra.bussiness.domain.page.CommodityInfoPage;
import com.zebra.bussiness.mapper.CommodityInfoMapper;
import com.zebra.bussiness.mapper.MerchantMapper;
import com.zebra.bussiness.service.ICommodityInfoService;
import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.core.text.Convert;

/**
 * 产品信息Service业务层处理
 *
 * @author zebra
 * @date 2020-03-25
 */
@Service
public class CommodityInfoServiceImpl implements ICommodityInfoService {
	@Autowired
	private CommodityInfoMapper commodityInfoMapper;
	@Autowired
	private MerchantMapper merchantMapper;

	/**
	 * 查询产品信息
	 *
	 * @param commodityId
	 *            产品信息ID
	 * @return 产品信息
	 */
	@Override
	public CommodityInfo selectCommodityInfoById(String commodityId) {
		return commodityInfoMapper.selectCommodityInfoById(commodityId);
	}

	/**
	 * 查询产品信息列表
	 *
	 * @param commodityInfo
	 *            产品信息
	 * @return 产品信息
	 */
	@Override
	@AuthMerchantAnnotaion(fieldAlias = "MECHANT_ID")
	public List<CommodityInfoPage> selectCommodityInfoList(CommodityInfo commodityInfo) {
		List<CommodityInfo> list = commodityInfoMapper.selectCommodityInfoList(commodityInfo);
		List<CommodityInfoPage> pages = new Page<CommodityInfoPage>();
		BeanUtils.copyProperties(list, pages);
		changeModel(list, pages);
		return pages;
	}

	private void changeModel(List<CommodityInfo> list, List<CommodityInfoPage> pages) {
		list.forEach(o -> {
			CommodityInfoPage commodityInfoPage = new CommodityInfoPage();
			BeanUtils.copyProperties(o, commodityInfoPage);
			Merchant merchant = merchantMapper.selectByPrimaryKey(o.getMechantId());
			if (merchant != null) {
				commodityInfoPage.setMerchantName(merchant.getMerchantName());
			}
			pages.add(commodityInfoPage);
		});

	}

	/**
	 * 新增产品信息
	 *
	 * @param commodityInfo
	 *            产品信息
	 * @return 结果
	 */
	@Override
	public int insertCommodityInfo(CommodityInfo commodityInfo) {
		return commodityInfoMapper.insertCommodityInfo(commodityInfo);
	}

	/**
	 * 修改产品信息
	 *
	 * @param commodityInfo
	 *            产品信息
	 * @return 结果
	 */
	@Override
	public int updateCommodityInfo(CommodityInfo commodityInfo) {
		return commodityInfoMapper.updateCommodityInfo(commodityInfo);
	}

	/**
	 * 删除产品信息对象
	 *
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteCommodityInfoByIds(String ids) {
		return commodityInfoMapper.deleteCommodityInfoByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除产品信息信息
	 *
	 * @param commodityId
	 *            产品信息ID
	 * @return 结果
	 */
	@Override
	public int deleteCommodityInfoById(String commodityId) {
		return commodityInfoMapper.deleteCommodityInfoById(commodityId);
	}
}
