package com.ruoyi.activiti.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 请假对象 act_leave
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BizLeave implements Serializable
{
    //
    private static final long serialVersionUID = 7171474850069379927L;

    /** 主键 */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long              id;

    /** 标题 */
    @Excel(name = "标题")
    private String            title;

    /** 描述 */
    @Excel(name = "描述")
    private String            description;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date              startDate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date              endDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date              createTime;

    /** 时长 */
    @Excel(name = "时长")
    private Double            duration;

    /** 请假类型 */
    @Excel(name = "请假类型")
    private Integer           type;

    /** 删除标记 */
    private Boolean           delFlag;

    @Transient
    private String            procDefId;

    @Transient
    private String            procName;
}
