package com.zebra.bussiness.mapper;

import java.util.List;

import com.zebra.bussiness.domain.Merchaninfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * 商户信息Mapper接口
 * 
 * @author zebra
 * @date 2020-05-13
 */
public interface MerchaninfoMapper extends Mapper<Merchaninfo> {
	/**
	 * 查询商户信息
	 * 
	 * @param merchantId
	 *            商户信息ID
	 * @return 商户信息
	 */
	public Merchaninfo selectMerchaninfoById(String merchantId);

	/**
	 * 查询商户信息列表
	 * 
	 * @param merchaninfo
	 *            商户信息
	 * @return 商户信息集合
	 */
	public List<Merchaninfo> selectMerchaninfoList(Merchaninfo merchaninfo);

	/**
	 * 新增商户信息
	 * 
	 * @param merchaninfo
	 *            商户信息
	 * @return 结果
	 */
	public int insertMerchaninfo(Merchaninfo merchaninfo);

	/**
	 * 修改商户信息
	 * 
	 * @param merchaninfo
	 *            商户信息
	 * @return 结果
	 */
	public int updateMerchaninfo(Merchaninfo merchaninfo);

	/**
	 * 删除商户信息
	 * 
	 * @param merchantId
	 *            商户信息ID
	 * @return 结果
	 */
	public int deleteMerchaninfoById(String merchantId);

	/**
	 * 批量删除商户信息
	 * 
	 * @param merchantIds
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteMerchaninfoByIds(String[] merchantIds);

	// *************************************************不能删除的sql************************************************
	/**
	 * 查询商户部门权限
	 * 
	 * @param merchaninfo
	 * @return
	 */

	public List<Merchaninfo> selectMerchantByauto(Merchaninfo merchaninfo);
}
