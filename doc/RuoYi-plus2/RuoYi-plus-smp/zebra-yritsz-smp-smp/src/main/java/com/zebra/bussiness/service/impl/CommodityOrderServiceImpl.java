package com.zebra.bussiness.service.impl;

import java.util.List;

import com.zebra.bussiness.feign.client.BussinessFienClient;
import com.zebra.bussiness.feign.util.APIJson;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.mapper.CommodityOrderMapper;
import com.zebra.bussiness.domain.CommodityOrder;
import com.zebra.bussiness.service.ICommodityOrderService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 商品订单Service业务层处理
 *
 * @author zebra
 * @date 2020-08-18
 */
@Service
public class CommodityOrderServiceImpl implements ICommodityOrderService {
    @Autowired
    private CommodityOrderMapper commodityOrderMapper;
    @Autowired
    private BussinessFienClient bussinessFienClient;

    /**
     * 查询商品订单
     *
     * @param orderId 商品订单ID
     * @return 商品订单
     */
    @Override
    public CommodityOrder selectCommodityOrderById(String orderId) {
        return commodityOrderMapper.selectCommodityOrderById(orderId);
    }

    /**
     * 查询商品订单列表
     *
     * @param commodityOrder 商品订单
     * @return 商品订单
     */
    @Override
    public List<CommodityOrder> selectCommodityOrderList(CommodityOrder commodityOrder) {
        return commodityOrderMapper.selectCommodityOrderList(commodityOrder);
    }

    /**
     * 新增商品订单
     *
     * @param commodityOrder 商品订单
     * @return 结果
     */
    @Override
    public int insertCommodityOrder(CommodityOrder commodityOrder) {
        commodityOrder.setCreateTime(DateUtils.getNowDate());
        commodityOrder.setUpdateTime(DateUtils.getNowDate());
        commodityOrder.setUpdateBy(ShiroUtils.getLoginName());
        return commodityOrderMapper.insertCommodityOrder(commodityOrder);
    }

    /**
     * 修改商品订单
     *
     * @param commodityOrder 商品订单
     * @return 结果
     */
    @Override
    public AjaxResult updateCommodityOrder(CommodityOrder commodityOrder) {
        APIJson apiJson = bussinessFienClient.refundOrder(commodityOrder.getOrderId(), true);
        if (APIJson.success(apiJson.getCode())) {
            return AjaxResult.success();
        }
        return AjaxResult.error(apiJson.getMsg());
    }

    /**
     * 删除商品订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderByIds(String ids) {
        return commodityOrderMapper.deleteCommodityOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品订单信息
     *
     * @param orderId 商品订单ID
     * @return 结果
     */
    @Override
    public int deleteCommodityOrderById(String orderId) {
        return commodityOrderMapper.deleteCommodityOrderById(orderId);
    }
}
