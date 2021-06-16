package com.zebra.api.commodity.service;

import com.zebra.api.commons.bean.Json;

/**
 * Title: 产品管理<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
public interface CommodityService {
	/**
	 * 修改库存
	 *
	 * @param commodityId
	 *            商品id
	 * @param isRollback
	 *            是否需要回滚 否：正常业务 是：直接响应失败
	 * @return
	 */
	public Json editStock(String commodityId, boolean isRollback);
}
