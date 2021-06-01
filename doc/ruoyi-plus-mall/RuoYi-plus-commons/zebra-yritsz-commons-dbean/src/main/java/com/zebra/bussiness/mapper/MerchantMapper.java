package com.zebra.bussiness.mapper;

import java.util.List;

import com.zebra.bussiness.domain.Merchant;

import tk.mybatis.mapper.common.Mapper;

/**
 * 商户信息Mapper接口
 *
 * @author zebra
 * @date 2020-03-03
 */
public interface MerchantMapper  extends Mapper<Merchant>
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
    public List<Merchant> selectMerchantList(Merchant merchant);

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
     * 删除商户信息
     *
     * @param merchantId 商户信息ID
     * @return 结果
     */
    public int deleteMerchantById(Long merchantId);

    /**
     * 批量删除商户信息
     *
     * @param merchantIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMerchantByIds(String[] merchantIds);
	/**
	 * 查询活动列表 根据权限
	 *
	 * @param activity
	 * @return
	 */
	public List<Merchant> selectMerchantListByauto(Merchant bMerchant);
}
