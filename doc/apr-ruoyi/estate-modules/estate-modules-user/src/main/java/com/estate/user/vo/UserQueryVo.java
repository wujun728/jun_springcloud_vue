package com.estate.user.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserQueryVo {

    private Integer pageNum;
    private Integer pageSize;
    private String userName;
    private String phonenumber;
    private String status;

    // 日期区间
    private Map<String, Object> params = new HashMap<>();

}
