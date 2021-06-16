package com.zebra.bussiness.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.mapper.CityInfoMapper;
import com.zebra.bussiness.domain.CityInfo;
import com.zebra.bussiness.service.ICityInfoService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 城市信息Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-05
 */
@Service
public class CityInfoServiceImpl implements ICityInfoService {
    @Autowired
    private CityInfoMapper cityInfoMapper;

    /**
     * 查询城市信息
     * 
     * @param cityCode 城市信息ID
     * @return 城市信息
     */
    @Override
    public CityInfo selectCityInfoById(String cityCode)
    {
        return cityInfoMapper.selectCityInfoById(cityCode);
    }

    /**
     * 查询城市信息列表
     * 
     * @param cityInfo 城市信息
     * @return 城市信息
     */
    @Override
    public List<CityInfo> selectCityInfoList(CityInfo cityInfo)
    {
        return cityInfoMapper.selectCityInfoList(cityInfo);
    }

    /**
     * 新增城市信息
     * 
     * @param cityInfo 城市信息
     * @return 结果
     */
    @Override
    public int insertCityInfo(CityInfo cityInfo)
    {
        cityInfo.setUpdateBy(ShiroUtils.getLoginName());
        cityInfo.setCreateTime(DateUtils.getNowDate());
        cityInfo.setUpdateTime(DateUtils.getNowDate());
        return cityInfoMapper.insertCityInfo(cityInfo);
    }

    /**
     * 修改城市信息
     * 
     * @param cityInfo 城市信息
     * @return 结果
     */
    @Override
    public int updateCityInfo(CityInfo cityInfo)
    {
        cityInfo.setUpdateBy(ShiroUtils.getLoginName());
        cityInfo.setUpdateTime(DateUtils.getNowDate());
        return cityInfoMapper.updateCityInfo(cityInfo);
    }

    /**
     * 删除城市信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCityInfoByIds(String ids)
    {
        return cityInfoMapper.deleteCityInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除城市信息信息
     * 
     * @param cityCode 城市信息ID
     * @return 结果
     */
    @Override
    public int deleteCityInfoById(String cityCode)
    {
        return cityInfoMapper.deleteCityInfoById(cityCode);
    }
}
