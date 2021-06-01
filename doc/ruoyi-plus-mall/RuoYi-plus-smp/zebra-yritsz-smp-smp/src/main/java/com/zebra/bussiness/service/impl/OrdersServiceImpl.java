package com.zebra.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.Merchant;
import com.zebra.bussiness.domain.Orders;
import com.zebra.bussiness.domain.page.OrdersPage;
import com.zebra.bussiness.mapper.CommodityInfoMapper;
import com.zebra.bussiness.mapper.MerchantMapper;
import com.zebra.bussiness.mapper.OrdersMapper;
import com.zebra.bussiness.service.IOrdersService;
import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.core.text.Convert;

/**
 * 订单信息Service业务层处理
 *
 * @author zebra
 * @date 2020-03-03
 */
@Service
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private MerchantMapper merchantMapper;
	@Autowired
	private CommodityInfoMapper commodityInfoMapper;

	/**
	 * 查询订单信息
	 *
	 * @param orderId
	 *            订单信息ID
	 * @return 订单信息
	 */
	@Override
	public Orders selectOrdersById(String orderId) {
		return ordersMapper.selectOrdersById(orderId);
	}

	/**
	 * 查询订单信息列表
	 *
	 * @param orders
	 *            订单信息
	 * @return 订单信息
	 */
	@Override
	@AuthMerchantAnnotaion(fieldAlias = "MECHANT_ID")
	public List<OrdersPage> selectOrdersList(Orders orders) {
		List<Orders> list = ordersMapper.selectOrdersList(orders);
		List<OrdersPage> pages = new Page<OrdersPage>();
		BeanUtils.copyProperties(list, pages);
		changeModel(list, pages);
		return pages;
	}

	private void changeModel(List<Orders> list, List<OrdersPage> pages) {
		list.forEach(o -> {
			OrdersPage ordersPage = new OrdersPage();
			BeanUtils.copyProperties(o, ordersPage);
			Merchant merchant = merchantMapper.selectByPrimaryKey(o.getMechantId());
			if (merchant != null) {
				ordersPage.setMerchantName(merchant.getMerchantName());
			}
			CommodityInfo commodityInfo = commodityInfoMapper.selectByPrimaryKey(o.getCommodityId());
			if (commodityInfo != null) {
				ordersPage.setCommodityName(commodityInfo.getCommodityName());
			}
			pages.add(ordersPage);
		});

	}

	/**
	 * 新增订单信息
	 *
	 * @param orders
	 *            订单信息
	 * @return 结果
	 */
	@Override
	public int insertOrders(Orders orders) {
		return ordersMapper.insertOrders(orders);
	}

	/**
	 * 修改订单信息
	 *
	 * @param orders
	 *            订单信息
	 * @return 结果
	 */
	@Override
	public int updateOrders(Orders orders) {
		return ordersMapper.updateOrders(orders);
	}

	/**
	 * 删除订单信息对象
	 *
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteOrdersByIds(String ids) {
		return ordersMapper.deleteOrdersByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除订单信息信息
	 *
	 * @param orderId
	 *            订单信息ID
	 * @return 结果
	 */
	@Override
	public int deleteOrdersById(String orderId) {
		return ordersMapper.deleteOrdersById(orderId);
	}
}
