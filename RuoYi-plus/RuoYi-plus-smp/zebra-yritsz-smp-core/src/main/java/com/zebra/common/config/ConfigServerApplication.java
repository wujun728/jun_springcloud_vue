package com.zebra.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Configuration
@Slf4j
public class ConfigServerApplication {
    /**
     * 名称
     */
    private static String name;
    /**
     * 版本
     */
    private static String version;
    /**
     * 版权年份
     */
    private static String copyrightYear;

    /**
     * 实例演示开关
     */
    private static String demoEnabled;

    /**
     * 获取头像上传路径
     */
    private static String avatarPath;

    /**
     * 获取上传路径
     */
    private static String uploadPath;

    /**
     * 获取ip地址开关
     */
    private static String addressEnabled;

    /**
     * 文件路径
     */
    private static String profile;

    /**
     * 获取下载路径
     */
    private static String downloadPath;

    /**
     * 限制操作ip
     */
    private static String ips;

    /**
     * 刷新配置中心地址
     */
    private static String refresh;
    /**
     * 高德地图key
     */
    private static String gd_map_key;

    /**
     * api服务url地址
     */
    private static String api_url;
    /**
     * 图片文件限制
     */
    private static String uploadImageFileExts;
    /**
     * 图片文件大小限制
     */
    private static String uploadImageFileMaxSize;

    @Value("${zebra.name}")
    private void setName(String name) {
        ConfigServerApplication.name = name;
    }

    @Value("${zebra.version}")
    private void setVersion(String version) {
        ConfigServerApplication.version = version;
    }

    @Value("${zebra.copyrightYear}")
    private void setCopyrightYear(String copyrightYear) {
        ConfigServerApplication.copyrightYear = copyrightYear;
    }

    @Value("${zebra.demoEnabled}")
    private void setDemoEnabled(String demoEnabled) {
        ConfigServerApplication.demoEnabled = demoEnabled;
    }

    @Value("${zebra.avatarPath}")
    private void setAvatarPath(String avatarPath) {
        ConfigServerApplication.avatarPath = avatarPath;
    }

    @Value("${zebra.uploadPath}")
    private void setUploadPath(String uploadPath) {
        ConfigServerApplication.uploadPath = uploadPath;
    }

    @Value("${zebra.addressEnabled}")
    private void setAddressEnabled(String addressEnabled) {
        ConfigServerApplication.addressEnabled = addressEnabled;
    }

    @Value("${zebra.profile}")
    private void setProfile(String profile) {
        ConfigServerApplication.profile = profile;
    }

    @Value("${zebra.downloadPath}")
    private void setDownloadPath(String downloadPath) {
        ConfigServerApplication.downloadPath = downloadPath;
    }

    @Value("${zebra.ips}")
    private void setIps(String ips) {
        ConfigServerApplication.ips = ips;
    }


    @Value("${zebra.config.refresh}")
    private void setRefresh(String refresh) {
        ConfigServerApplication.refresh = refresh;
    }

    @Value("${zebra.gd_map_key}")
    private void setGd_map_key(String gd_map_key) {
        ConfigServerApplication.gd_map_key = gd_map_key;
    }

    @Value("${zebra.api_url}")
    private void setApi_url(String api_url) {
        ConfigServerApplication.api_url = api_url;
    }

    @Value("${zebra.uploadImageFileExts}")
    private void setUploadImageFileExts(String uploadImageFileExts) {
        ConfigServerApplication.uploadImageFileExts = uploadImageFileExts;
    }

    @Value("${zebra.uploadImageFileMaxSize}")
    private void setUploadImageFileMaxSize(String uploadImageFileMaxSize) {
        ConfigServerApplication.uploadImageFileMaxSize = uploadImageFileMaxSize;
    }

    public static String getName() {
        return name;
    }

    public static String getVersion() {
        return version;
    }

    public static String getCopyrightYear() {
        return copyrightYear;
    }

    public static String getDemoEnabled() {
        return demoEnabled;
    }

    public static String getAvatarPath() {
        return avatarPath;
    }

    public static String getUploadPath() {
        return uploadPath;
    }

    public static String getAddressEnabled() {
        return addressEnabled;
    }

    public static String getProfile() {
        return profile;
    }

    public static String getDownloadPath() {
        return downloadPath;
    }

    public static String getIps() {
        return ips;
    }

    public static String getRefresh() {
        return refresh;
    }

    public static String getGd_map_key() {
        return gd_map_key;
    }

    public static String getApi_url() {
        return api_url;
    }

    public static String getUploadImageFileExts() {
        return uploadImageFileExts;
    }

    public static String getUploadImageFileMaxSize() {
        return uploadImageFileMaxSize;
    }
}
