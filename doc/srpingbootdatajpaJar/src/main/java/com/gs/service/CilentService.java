package com.gs.service;

import com.gs.entity.Oauth2Client;

import java.util.List;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 12:34
 */
public interface CilentService {
    List<Oauth2Client> findOauth2UsersByName(String name);
    void  saveClient(Oauth2Client oc) ;
}
