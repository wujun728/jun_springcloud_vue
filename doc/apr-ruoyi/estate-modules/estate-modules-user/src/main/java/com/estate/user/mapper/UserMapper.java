package com.estate.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.estate.api.system.domain.User;

public interface UserMapper extends BaseMapper<User> {

    User selectUserByUserName(String username);

}
