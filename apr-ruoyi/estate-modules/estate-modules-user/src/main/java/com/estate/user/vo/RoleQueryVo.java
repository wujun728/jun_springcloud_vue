package com.estate.user.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RoleQueryVo {

    private Integer pageNum;
    private Integer pageSize;
    private String roleName;
    private String roleKey;
    private String status;

    // 日期区间
    private Map<String, Object> params = new HashMap<>();
}
