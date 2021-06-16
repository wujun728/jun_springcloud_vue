package com.estate.common.core.constant;

/**
 * 缓存的key 常量
 *
 * @author ruoyi
 */
public class CacheConstants {
    /**
     * 令牌自定义标识
     */
    public static final String HEADER = "Authorization";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌密钥
     */
    public static final String SECRET = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 过期时间（分钟）
     */
    public static final Integer EXPIRE_TIME = 30;

    /**
     * Redis缓存 key 前缀
     */
    public final static String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * token中存UUID的Map key
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID字段
     */
    public static final String DETAILS_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    public static final String DETAILS_USERNAME = "username";
}
