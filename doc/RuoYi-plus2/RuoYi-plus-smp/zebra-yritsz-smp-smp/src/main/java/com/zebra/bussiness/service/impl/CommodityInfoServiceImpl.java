package com.zebra.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.mapper.CommodityInfoMapper;
import com.zebra.bussiness.service.ICommodityInfoService;
import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.core.text.Convert;
import com.zebra.common.utils.DateUtils;
import com.zebra.framework.util.ShiroUtils;

/**
 * 产品信息Service业务层处理
 *
 * @author zebra
 * @date 2020-06-05
 */
@Service
public class CommodityInfoServiceImpl implements ICommodityInfoService {
    @Autowired
    private CommodityInfoMapper commodityInfoMapper;

    /**
     * 查询产品信息
     *
     * @param commodityId 产品信息ID
     * @return 产品信息
     */
    @Override
    public CommodityInfo selectCommodityInfoById(String commodityId) {
        return commodityInfoMapper.selectCommodityInfoById(commodityId);
    }

    /**
     * 查询产品信息列表
     *
     * @param commodityInfo 产品信息
     * @return 产品信息
     */
    @Override
    @AuthMerchantAnnotaion
    public List<CommodityInfo> selectCommodityInfoList(CommodityInfo commodityInfo) {
        return commodityInfoMapper.selectCommodityInfoList(commodityInfo);
    }

    /**
     * 新增产品信息
     *
     * @param commodityInfo 产品信息
     * @return 结果
     */
    @Override
    public int insertCommodityInfo(CommodityInfo commodityInfo) {
        commodityInfo.setCreateTime(DateUtils.getNowDate());
        commodityInfo.setUpdateTime(DateUtils.getNowDate());
        commodityInfo.setUpdateBy(ShiroUtils.getLoginName());
        commodityInfo.setDataVerFlag(1l);
        return commodityInfoMapper.insertCommodityInfo(commodityInfo);
    }

    /**
     * 修改产品信息
     *
     * @param commodityInfo 产品信息
     * @return 结果
     */
    @Override
    public int updateCommodityInfo(CommodityInfo commodityInfo) {
        commodityInfo.setUpdateTime(DateUtils.getNowDate());
        commodityInfo.setUpdateBy(ShiroUtils.getLoginName());
        return commodityInfoMapper.updateCommodityInfo(commodityInfo);
    }

    /**
     * 删除产品信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityInfoByIds(String ids) {
        return commodityInfoMapper.deleteCommodityInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     *
     * @param commodityId 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteCommodityInfoById(String commodityId) {
        return commodityInfoMapper.deleteCommodityInfoById(commodityId);
    }
}
