package com.zebra.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.bussiness.domain.Merchaninfo;
import com.zebra.bussiness.mapper.MerchaninfoMapper;
import com.zebra.bussiness.service.IMerchaninfoService;
import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.core.text.Convert;
import com.zebra.common.utils.DateUtils;
import com.zebra.framework.util.ShiroUtils;

/**
 * 商户信息Service业务层处理
 * 
 * @author zebra
 * @date 2020-05-13
 */
@Service
public class MerchaninfoServiceImpl implements IMerchaninfoService {
    @Autowired
    private MerchaninfoMapper merchaninfoMapper;

    /**
     * 查询商户信息
     * 
     * @param merchantId 商户信息ID
     * @return 商户信息
     */
    @Override
    public Merchaninfo selectMerchaninfoById(String merchantId)
    {
        return merchaninfoMapper.selectMerchaninfoById(merchantId);
    }

    /**
     * 查询商户信息列表
     * 
     * @param merchaninfo 商户信息
     * @return 商户信息
     */
    @Override
	@AuthMerchantAnnotaion
    public List<Merchaninfo> selectMerchaninfoList(Merchaninfo merchaninfo)
    {
        return merchaninfoMapper.selectMerchaninfoList(merchaninfo);
    }

    /**
     * 新增商户信息
     * 
     * @param merchaninfo 商户信息
     * @return 结果
     */
    @Override
    public int insertMerchaninfo(Merchaninfo merchaninfo)
    {
        merchaninfo.setCreateTime(DateUtils.getNowDate());
        merchaninfo.setUpdateTime(DateUtils.getNowDate());
        merchaninfo.setUpdateBy(ShiroUtils.getLoginName());
        return merchaninfoMapper.insertMerchaninfo(merchaninfo);
    }

    /**
     * 修改商户信息
     * 
     * @param merchaninfo 商户信息
     * @return 结果
     */
    @Override
    public int updateMerchaninfo(Merchaninfo merchaninfo)
    {
        merchaninfo.setUpdateTime(DateUtils.getNowDate());
        merchaninfo.setUpdateBy(ShiroUtils.getLoginName());
        return merchaninfoMapper.updateMerchaninfo(merchaninfo);
    }

    /**
     * 删除商户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMerchaninfoByIds(String ids)
    {
        return merchaninfoMapper.deleteMerchaninfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商户信息信息
     * 
     * @param merchantId 商户信息ID
     * @return 结果
     */
    @Override
    public int deleteMerchaninfoById(String merchantId)
    {
        return merchaninfoMapper.deleteMerchaninfoById(merchantId);
    }
}
