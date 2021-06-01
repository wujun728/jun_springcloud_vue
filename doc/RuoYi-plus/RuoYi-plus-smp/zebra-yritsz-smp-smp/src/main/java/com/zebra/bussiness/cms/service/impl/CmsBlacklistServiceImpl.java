package com.zebra.bussiness.cms.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsBlacklistMapper;
import com.zebra.bussiness.cms.domain.CmsBlacklist;
import com.zebra.bussiness.cms.service.ICmsBlacklistService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 黑名单Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-30
 */
@Service
public class CmsBlacklistServiceImpl implements ICmsBlacklistService {
    @Autowired
    private CmsBlacklistMapper cmsBlacklistMapper;

    /**
     * 查询黑名单
     * 
     * @param blacklistId 黑名单ID
     * @return 黑名单
     */
    @Override
    public CmsBlacklist selectCmsBlacklistById(Integer blacklistId)
    {
        return cmsBlacklistMapper.selectCmsBlacklistById(blacklistId);
    }

    /**
     * 查询黑名单列表
     * 
     * @param cmsBlacklist 黑名单
     * @return 黑名单
     */
    @Override
    public List<CmsBlacklist> selectCmsBlacklistList(CmsBlacklist cmsBlacklist)
    {
        return cmsBlacklistMapper.selectCmsBlacklistList(cmsBlacklist);
    }

    /**
     * 新增黑名单
     * 
     * @param cmsBlacklist 黑名单
     * @return 结果
     */
    @Override
    public int insertCmsBlacklist(CmsBlacklist cmsBlacklist)
    {
        cmsBlacklist.setCreateTime(DateUtils.getNowDate());
        cmsBlacklist.setUpdateTime(DateUtils.getNowDate());
        cmsBlacklist.setUpdateBy(ShiroUtils.getLoginName());
        return cmsBlacklistMapper.insertCmsBlacklist(cmsBlacklist);
    }

    /**
     * 修改黑名单
     * 
     * @param cmsBlacklist 黑名单
     * @return 结果
     */
    @Override
    public int updateCmsBlacklist(CmsBlacklist cmsBlacklist)
    {
        cmsBlacklist.setUpdateTime(DateUtils.getNowDate());
        cmsBlacklist.setUpdateBy(ShiroUtils.getLoginName());
        return cmsBlacklistMapper.updateCmsBlacklist(cmsBlacklist);
    }

    /**
     * 删除黑名单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsBlacklistByIds(String ids)
    {
        return cmsBlacklistMapper.deleteCmsBlacklistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除黑名单信息
     * 
     * @param blacklistId 黑名单ID
     * @return 结果
     */
    @Override
    public int deleteCmsBlacklistById(Integer blacklistId)
    {
        return cmsBlacklistMapper.deleteCmsBlacklistById(blacklistId);
    }
}
