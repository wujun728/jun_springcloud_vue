package com.zebra.bussiness.domain;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import java.util.Date;

/**
 * t_user_account表 UserAccount
 * 
 * @author zebra
 * @date 2021-01-25
 */
@Table(name="t_user_account")
@Getter
@Setter
@ToString
public class UserAccount extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 账户ID */
     @Excel(name = "账户ID")
     @Id
     private String accountId;

    /** 当前积分 */
     @Excel(name = "当前积分")
     @Column(name="account_integral")
     private Integer accountIntegral;

    /** 账户余额 */
     @Excel(name = "账户余额")
     @Column(name="account_balance")
     private Double accountBalance;

    /** 总积分 */
     @Excel(name = "总积分")
     @Column(name="account_integral_all")
     private Integer accountIntegralAll;

    /** 账户状态（1正常 2冻结） */
     @Excel(name = "账户状态", readConverterExp = "1=正常,2=冻结")
     @Column(name="account_status")
     private Integer accountStatus;

    /** 账户备注 */
     @Excel(name = "账户备注")
     @Column(name="account_remarks")
     private String accountRemarks;

    /** 用户id */
     @Excel(name = "用户id")
     @Column(name="user_id")
     private String userId;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

    /** 操作人 */
     @Excel(name = "操作人")
     @Column(name="update_by")
     private String updateBy;

}
