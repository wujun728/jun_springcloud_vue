package com.zebra.bussiness.service;

import java.util.List;

import com.zebra.bussiness.domain.Merchant;
import com.zebra.bussiness.domain.page.MerchantPage;

/**
 * 商户信息Service接口
 *
 * @author zebra
 * @date 2020-03-03
 */
public interface IMerchantService
{
    /**
     * 查询商户信息
     *
     * @param merchantId 商户信息ID
     * @return 商户信息
     */
    public Merchant selectMerchantById(Long merchantId);

    /**
     * 查询商户信息列表
     *
     * @param merchant 商户信息
     * @return 商户信息集合
     */
    public List<MerchantPage> selectMerchantList(Merchant merchant);

    /**
     * 新增商户信息
     *
     * @param merchant 商户信息
     * @return 结果
     */
    public int insertMerchant(Merchant merchant);

    /**
     * 修改商户信息
     *
     * @param merchant 商户信息
     * @return 结果
     */
    public int updateMerchant(Merchant merchant);

    /**
     * 批量删除商户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMerchantByIds(String ids);

    /**
     * 删除商户信息信息
     *
     * @param merchantId 商户信息ID
     * @return 结果
     */
    public int deleteMerchantById(Long merchantId);

    /**
	 * 查询商户列表
	 *
	 * @param objs
	 * @return
	 */
	public List<Merchant> getAll(List<Object> objs);
}
