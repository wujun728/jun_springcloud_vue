package com.zebra.bussiness.service.impl.extend;

import com.zebra.bussiness.domain.*;
import com.zebra.bussiness.mapper.*;
import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.config.ConfigServerApplication;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.exception.BusinessException;
import com.zebra.common.utils.GenerateID;
import com.zebra.common.utils.RandomUtil;
import com.zebra.common.utils.StringUtils;
import com.zebra.common.utils.file.FileUploadUtils;
import com.zebra.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BaseServiceImplExtend extends BaseController {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private MerchaninfoMapper merchaninfoMapper;
    @Autowired
    private ProvinceInfoMapper provinceInfoMapper;
    @Autowired
    private CommodityInfoMapper commodityInfoMapper;
    @Autowired
    private ActivityInfoMapper activityInfoMapper;
    @Autowired
    private ISysConfigService sysConfigService;
    @Autowired
    private ConfigServerApplication configServerApplication;
    @Autowired
    private GenerateID generateID;

    @AuthMerchantAnnotaion
    protected List<Merchaninfo> getMerchantInfo(Merchaninfo merchaninfo) {
        merchaninfo.getParams().put("dataOther", " order by u.create_time desc ");
        return merchaninfoMapper.selectMerchaninfoList(merchaninfo);
    }

    protected void merchantAuth(ModelMap mmap) {
        mmap.addAttribute("mts", this.getMerchantInfo(new Merchaninfo()));
    }

    protected void getActivity(ModelMap mmap) {
        mmap.addAttribute("activity", activityInfoMapper.selectActivityInfoList(new ActivityInfo()));
    }

    protected String getMerchantName(String merchantId) {
        Merchaninfo merchaninfo = merchaninfoMapper.selectByPrimaryKey(merchantId);
        if (merchaninfo == null)
            return null;
        return merchaninfo.getMerchantName();
    }

    protected Merchaninfo getMerchantById(String merchantId) {
        Merchaninfo merchaninfo = merchaninfoMapper.selectByPrimaryKey(merchantId);
        if (merchaninfo == null)
            throw new BusinessException("商户信息不存在");

        if (merchaninfo.getExamineStatus() == 2)
            throw new BusinessException("该商户发生违规，请及时申诉恢复权限");
        return merchaninfo;
    }

    protected String getProvinceName(String provinceId) {
        ProvinceInfo provinceInfo = provinceInfoMapper.selectByPrimaryKey(provinceId);
        if (provinceInfo == null)
            return null;
        return provinceInfo.getProvinceName();
    }

    protected List<ProvinceInfo> getProvinceList() {
        Example example = new Example(ProvinceInfo.class);
        example.setOrderByClause(" province_id asc");
        return provinceInfoMapper.selectByExample(example);
    }

    protected String getFtileHttp() {
        return sysConfigService.selectConfigByKey("bussiness.file.http");
    }

    /**
     * 保存图片文件
     *
     * @param pic_file
     * @param fileName
     * @param path
     * @param isMast
     * @return
     */
    protected String saveFile(MultipartFile pic_file, String fileName, String path, Boolean isMast) {
        try {
            fileName += ".png";
            path += "/";
            if (pic_file != null && !pic_file.isEmpty()) {
                if (configServerApplication.getUploadImageFileExts().contains(pic_file.getName())) {
                    throw new BusinessException("图片格式不正确！");
                }
                if (Long.parseLong(configServerApplication.getUploadImageFileMaxSize()) < pic_file.getSize()) {
                    throw new BusinessException("图片超出大小限制！");
                }
                FileUploadUtils.savefile(configServerApplication.getUploadPath() + path, fileName, pic_file.getBytes());
                return StringUtils.format("/upload/{}{}?r={}", path, fileName, RandomUtil.generateRandomNumber(3));
            }
            if (isMast) {
                throw new BusinessException("请上传正确的图片！");
            }
            return null;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * 商品名称
     *
     * @param commodityId
     * @return
     */
    protected String getCommodityName(String commodityId) {
        CommodityInfo commodityInfo = this.getCommodityById(commodityId);
        if (commodityInfo != null)
            return commodityInfo.getCommodityName();
        return null;
    }

    protected CommodityInfo getCommodityById(String commodityId) {
        return commodityInfoMapper.selectByPrimaryKey(commodityId);

    }

    /**
     * 活动名称
     *
     * @param activityId
     * @return
     */
    protected String getActivityName(String activityId) {
        ActivityInfo activityInfo = activityInfoMapper.selectByPrimaryKey(activityId);
        if (activityInfo != null)
            return activityInfo.getActivityName();
        return null;
    }

    /**
     * 获取uuid
     *
     * @return
     */
    public String getUid() {
        return generateID.nextId();
    }


    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    protected String getUserName(String userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (userInfo != null)
            return StringUtils.format("{}[{}]", userInfo.getUserPhone(), userInfo.getUserNickname());
        return null;
    }
}
