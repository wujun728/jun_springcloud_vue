package com.zebra.bussiness.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * t_user_info表 UserInfo
 * 
 * @author zebra
 * @date 2021-01-22
 */
@Table(name="t_user_info")
@Getter
@Setter
@ToString
public class UserInfo extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 用户id */
     @Excel(name = "用户id")
     @Id
     private String userId;

    /** 手机号码 */
     @Excel(name = "手机号码")
     @Column(name="user_phone")
     private String userPhone;

    /** 用户昵称 */
     @Excel(name = "用户昵称")
     @Column(name="user_nickname")
     private String userNickname;

    /** 用户头像 */
     @Excel(name = "用户头像")
     @Column(name="user_photo")
     private String userPhoto;

    /** 用户性别（0男 1女 2未知） */
     @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
     @Column(name="user_sex")
     private Integer userSex;

    /** 用户生日 */
     @Excel(name = "用户生日", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="user_birthday")
     @JSONField(format = "yyyy-MM-dd")
     private Date userBirthday;

    /** 微信标识 */
     @Excel(name = "微信标识")
     @Column(name="user_openid")
     private String userOpenid;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

}
