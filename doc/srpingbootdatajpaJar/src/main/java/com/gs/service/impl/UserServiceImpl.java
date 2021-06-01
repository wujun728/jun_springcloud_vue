package com.gs.service.impl;

import com.gs.dao.UserDao;
import com.gs.entity.Oauth2User;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 10:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Oauth2User findOauth2UsersByName(String username) {
        return userDao.findOauth2UsersByName(username);
    }

    @Override
    public void saveUser(Oauth2User u ) {
        userDao.save(u);
    }
}
