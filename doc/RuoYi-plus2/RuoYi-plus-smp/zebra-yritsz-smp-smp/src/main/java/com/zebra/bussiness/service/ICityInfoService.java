package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.CityInfo;
import java.util.List;

/**
 * 城市信息Service接口
 * 
 * @author zebra
 * @date 2020-06-05
 */
public interface ICityInfoService {
    /**
     * 查询城市信息
     * 
     * @param cityCode 城市信息ID
     * @return 城市信息
     */
    public CityInfo selectCityInfoById(String cityCode);

    /**
     * 查询城市信息列表
     * 
     * @param cityInfo 城市信息
     * @return 城市信息集合
     */
    public List<CityInfo> selectCityInfoList(CityInfo cityInfo);

    /**
     * 新增城市信息
     * 
     * @param cityInfo 城市信息
     * @return 结果
     */
    public int insertCityInfo(CityInfo cityInfo);

    /**
     * 修改城市信息
     * 
     * @param cityInfo 城市信息
     * @return 结果
     */
    public int updateCityInfo(CityInfo cityInfo);

    /**
     * 批量删除城市信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCityInfoByIds(String ids);

    /**
     * 删除城市信息信息
     * 
     * @param cityCode 城市信息ID
     * @return 结果
     */
    public int deleteCityInfoById(String cityCode);
}
