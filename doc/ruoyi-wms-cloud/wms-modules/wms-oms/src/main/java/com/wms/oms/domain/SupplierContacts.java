package com.wms.oms.domain;

import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 供应商联系人信息对象 wms_supplier_contacts
 *
 * @author zzm
 * @date 2021-05-10
 */
@Data
@TableName("wms_supplier_contacts")
public class SupplierContacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 联系人姓名 */
    private String name;

    /** 联系人手机 */
    private String phone;

    /** 坐机 */
    private String tel;

    /** 邮箱/QQ/微信 */
    private String email;

    /** 地址 */
    private String address;

    /** 是否默认 */
    private Boolean isDefault;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 客户ID */
    private Long supplierId;

    /** 租户ID */
    private Long tenantId;

}