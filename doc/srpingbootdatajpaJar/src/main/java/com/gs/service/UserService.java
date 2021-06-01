package com.gs.service;

import com.gs.entity.Oauth2User;
import com.gs.exception.MyException;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 10:18
 */
public interface UserService {

    Oauth2User findOauth2UsersByName(String username);
    void  saveUser(Oauth2User u) throws Exception;



}
