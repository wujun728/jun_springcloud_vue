package com.zebra.bussiness.cms.mapper;

import com.zebra.bussiness.cms.domain.CmsBlacklist;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 黑名单Mapper接口
 * 
 * @author zebra
 * @date 2020-06-30
 */
public interface CmsBlacklistMapper  extends Mapper<CmsBlacklist> {
    /**
     * 查询黑名单
     * 
     * @param blacklistId 黑名单ID
     * @return 黑名单
     */
    public CmsBlacklist selectCmsBlacklistById(Integer blacklistId);

    /**
     * 查询黑名单列表
     * 
     * @param cmsBlacklist 黑名单
     * @return 黑名单集合
     */
    public List<CmsBlacklist> selectCmsBlacklistList(CmsBlacklist cmsBlacklist);

    /**
     * 新增黑名单
     * 
     * @param cmsBlacklist 黑名单
     * @return 结果
     */
    public int insertCmsBlacklist(CmsBlacklist cmsBlacklist);

    /**
     * 修改黑名单
     * 
     * @param cmsBlacklist 黑名单
     * @return 结果
     */
    public int updateCmsBlacklist(CmsBlacklist cmsBlacklist);

    /**
     * 删除黑名单
     * 
     * @param blacklistId 黑名单ID
     * @return 结果
     */
    public int deleteCmsBlacklistById(Integer blacklistId);

    /**
     * 批量删除黑名单
     * 
     * @param blacklistIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsBlacklistByIds(String[] blacklistIds);
}
