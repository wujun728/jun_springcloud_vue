package com.zebra.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zebra.bussiness.domain.Merchant;
import com.zebra.bussiness.domain.page.MerchantPage;
import com.zebra.bussiness.mapper.MerchantMapper;
import com.zebra.bussiness.service.IMerchantService;
import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.core.text.Convert;
import com.zebra.system.domain.SysDept;
import com.zebra.system.mapper.SysDeptMapper;

/**
 * 商户信息Service业务层处理
 *
 * @author zebra
 * @date 2020-03-03
 */
@Service
public class MerchantServiceImpl implements IMerchantService {
	@Autowired
	private MerchantMapper merchantMapper;
	@Autowired
	private SysDeptMapper deptMapper;

	/**
	 * 查询商户信息
	 *
	 * @param merchantId
	 *            商户信息ID
	 * @return 商户信息
	 */
	@Override
	public Merchant selectMerchantById(Long merchantId) {
		return merchantMapper.selectMerchantById(merchantId);
	}

	/**
	 * 查询商户信息列表
	 *
	 * @param merchant
	 *            商户信息
	 * @return 商户信息
	 */
	@Override
	@AuthMerchantAnnotaion(fieldAlias = "MECHANT_ID")
	public List<MerchantPage> selectMerchantList(Merchant merchant) {
		List<Merchant> list = merchantMapper.selectMerchantList(merchant);
		List<MerchantPage> pages = new Page<MerchantPage>();
		BeanUtils.copyProperties(list, pages);
		changeModel(list, pages);
		return pages;
	}

	private void changeModel(List<Merchant> list, List<MerchantPage> pages) {
		list.forEach(d -> {
			MerchantPage page = new MerchantPage();
			BeanUtils.copyProperties(d, page);
			SysDept sysDept = deptMapper.selectDeptById(d.getDeptId());
			if (sysDept != null) {
				page.setDeptName(sysDept.getDeptName());
			}
			pages.add(page);
		});

	}

	/**
	 * 新增商户信息
	 *
	 * @param merchant
	 *            商户信息
	 * @return 结果
	 */
	@Override
	public int insertMerchant(Merchant merchant) {
		return merchantMapper.insertMerchant(merchant);
	}

	/**
	 * 修改商户信息
	 *
	 * @param merchant
	 *            商户信息
	 * @return 结果
	 */
	@Override
	public int updateMerchant(Merchant merchant) {
		return merchantMapper.updateMerchant(merchant);
	}

	/**
	 * 删除商户信息对象
	 *
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMerchantByIds(String ids) {
		return merchantMapper.deleteMerchantByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除商户信息信息
	 *
	 * @param merchantId
	 *            商户信息ID
	 * @return 结果
	 */
	@Override
	public int deleteMerchantById(Long merchantId) {
		return merchantMapper.deleteMerchantById(merchantId);
	}

	@Override
	public List<Merchant> getAll(List<Object> list) {
		List<Merchant> bMerchants = new ArrayList<Merchant>();
		PageHelper.orderBy(" merchant_status, merchant_id desc");
		if (list == null || list.size() == 0) {
			bMerchants = merchantMapper.selectAll();

		} else {
			Merchant bMerchant = new Merchant();
			bMerchant.setMerchantIds(list);
			bMerchants = merchantMapper.selectMerchantList(bMerchant);
		}
		return bMerchants;
	}
}
