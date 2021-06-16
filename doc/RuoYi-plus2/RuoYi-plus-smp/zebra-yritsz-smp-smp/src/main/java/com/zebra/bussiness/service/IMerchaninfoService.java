package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.Merchaninfo;
import java.util.List;

/**
 * 商户信息Service接口
 * 
 * @author zebra
 * @date 2020-05-13
 */
public interface IMerchaninfoService {
    /**
     * 查询商户信息
     * 
     * @param merchantId 商户信息ID
     * @return 商户信息
     */
    public Merchaninfo selectMerchaninfoById(String merchantId);

    /**
     * 查询商户信息列表
     * 
     * @param merchaninfo 商户信息
     * @return 商户信息集合
     */
    public List<Merchaninfo> selectMerchaninfoList(Merchaninfo merchaninfo);

    /**
     * 新增商户信息
     * 
     * @param merchaninfo 商户信息
     * @return 结果
     */
    public int insertMerchaninfo(Merchaninfo merchaninfo);

    /**
     * 修改商户信息
     * 
     * @param merchaninfo 商户信息
     * @return 结果
     */
    public int updateMerchaninfo(Merchaninfo merchaninfo);

    /**
     * 批量删除商户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMerchaninfoByIds(String ids);

    /**
     * 删除商户信息信息
     * 
     * @param merchantId 商户信息ID
     * @return 结果
     */
    public int deleteMerchaninfoById(String merchantId);
}
