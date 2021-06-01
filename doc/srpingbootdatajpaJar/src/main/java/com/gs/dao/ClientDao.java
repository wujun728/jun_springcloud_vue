package com.gs.dao;

import com.gs.entity.Oauth2Client;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 11:30
 */
public interface ClientDao {

    Oauth2Client  findOauth2UsersByName(String name);
    void saveClient(Oauth2Client oc);



}
