package com.zebra.bussiness.mapper;

import java.util.List;

import com.zebra.bussiness.domain.CityInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * 城市信息Mapper接口
 * 
 * @author zebra
 * @date 2020-06-05
 */
public interface CityInfoMapper  extends Mapper<CityInfo> {
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
     * 删除城市信息
     * 
     * @param cityCode 城市信息ID
     * @return 结果
     */
    public int deleteCityInfoById(String cityCode);

    /**
     * 批量删除城市信息
     * 
     * @param cityCodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteCityInfoByIds(String[] cityCodes);
}
