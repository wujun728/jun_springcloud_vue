package com.wms.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * 租户管理对象 sys_tenant
 *
 * @author zzm
 * @date 2021-05-06
 */
@Data
public class SysTenant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租户ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 租户名称 */
    private String name;

    /** 删除标记 */
    private Boolean delFlag;


    /** 联系人 */
    private String nickName;

    /** 联系人手机 */
    private String phone;

    /** 登录密码 */
    @TableField(exist = false)
    private String password;

}