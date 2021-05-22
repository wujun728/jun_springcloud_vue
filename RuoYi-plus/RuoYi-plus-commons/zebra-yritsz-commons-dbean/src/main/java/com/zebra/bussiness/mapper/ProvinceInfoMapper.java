package com.zebra.bussiness.mapper;

import java.util.List;

import com.zebra.bussiness.domain.ProvinceInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * 省份信息Mapper接口
 * 
 * @author zebra
 * @date 2020-06-05
 */
public interface ProvinceInfoMapper  extends Mapper<ProvinceInfo> {
    /**
     * 查询省份信息
     * 
     * @param provinceId 省份信息ID
     * @return 省份信息
     */
    public ProvinceInfo selectProvinceInfoById(String provinceId);

    /**
     * 查询省份信息列表
     * 
     * @param provinceInfo 省份信息
     * @return 省份信息集合
     */
    public List<ProvinceInfo> selectProvinceInfoList(ProvinceInfo provinceInfo);

    /**
     * 新增省份信息
     * 
     * @param provinceInfo 省份信息
     * @return 结果
     */
    public int insertProvinceInfo(ProvinceInfo provinceInfo);

    /**
     * 修改省份信息
     * 
     * @param provinceInfo 省份信息
     * @return 结果
     */
    public int updateProvinceInfo(ProvinceInfo provinceInfo);

    /**
     * 删除省份信息
     * 
     * @param provinceId 省份信息ID
     * @return 结果
     */
    public int deleteProvinceInfoById(String provinceId);

    /**
     * 批量删除省份信息
     * 
     * @param provinceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProvinceInfoByIds(String[] provinceIds);
}
