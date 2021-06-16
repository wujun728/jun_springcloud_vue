package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.CommodityOrderRefund;
import java.util.List;

/**
 * 退款订单Service接口
 * 
 * @author zebra
 * @date 2021-01-09
 */
public interface ICommodityOrderRefundService {
    /**
     * 查询退款订单
     * 
     * @param refundId 退款订单ID
     * @return 退款订单
     */
    public CommodityOrderRefund selectCommodityOrderRefundById(String refundId);

    /**
     * 查询退款订单列表
     * 
     * @param commodityOrderRefund 退款订单
     * @return 退款订单集合
     */
    public List<CommodityOrderRefund> selectCommodityOrderRefundList(CommodityOrderRefund commodityOrderRefund);

    /**
     * 新增退款订单
     * 
     * @param commodityOrderRefund 退款订单
     * @return 结果
     */
    public int insertCommodityOrderRefund(CommodityOrderRefund commodityOrderRefund);

    /**
     * 修改退款订单
     * 
     * @param commodityOrderRefund 退款订单
     * @return 结果
     */
    public int updateCommodityOrderRefund(CommodityOrderRefund commodityOrderRefund);

    /**
     * 批量删除退款订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityOrderRefundByIds(String ids);

    /**
     * 删除退款订单信息
     * 
     * @param refundId 退款订单ID
     * @return 结果
     */
    public int deleteCommodityOrderRefundById(String refundId);
}
