package com.zebra.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.bussiness.domain.ProvinceInfo;
import com.zebra.bussiness.mapper.ProvinceInfoMapper;
import com.zebra.bussiness.service.IProvinceInfoService;
import com.zebra.common.core.text.Convert;


/**
 * 省份信息Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-05
 */
@Service
public class ProvinceInfoServiceImpl implements IProvinceInfoService {
    @Autowired
    private ProvinceInfoMapper provinceInfoMapper;

    /**
     * 查询省份信息
     * 
     * @param provinceId 省份信息ID
     * @return 省份信息
     */
    @Override
    public ProvinceInfo selectProvinceInfoById(String provinceId)
    {
        return provinceInfoMapper.selectProvinceInfoById(provinceId);
    }

    /**
     * 查询省份信息列表
     * 
     * @param provinceInfo 省份信息
     * @return 省份信息
     */
    @Override
    public List<ProvinceInfo> selectProvinceInfoList(ProvinceInfo provinceInfo)
    {
        return provinceInfoMapper.selectProvinceInfoList(provinceInfo);
    }

    /**
     * 新增省份信息
     * 
     * @param provinceInfo 省份信息
     * @return 结果
     */
    @Override
    public int insertProvinceInfo(ProvinceInfo provinceInfo)
    {
        return provinceInfoMapper.insertProvinceInfo(provinceInfo);
    }

    /**
     * 修改省份信息
     * 
     * @param provinceInfo 省份信息
     * @return 结果
     */
    @Override
    public int updateProvinceInfo(ProvinceInfo provinceInfo)
    {
        return provinceInfoMapper.updateProvinceInfo(provinceInfo);
    }

    /**
     * 删除省份信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProvinceInfoByIds(String ids)
    {
        return provinceInfoMapper.deleteProvinceInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除省份信息信息
     * 
     * @param provinceId 省份信息ID
     * @return 结果
     */
    @Override
    public int deleteProvinceInfoById(String provinceId)
    {
        return provinceInfoMapper.deleteProvinceInfoById(provinceId);
    }
}
