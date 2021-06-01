package com.gs.service.impl;

import com.gs.dao.ClientDao;
import com.gs.entity.Oauth2Client;
import com.gs.exception.MyException;
import com.gs.service.CilentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 12:35
 */
@Service
public class CilentServiceImpl implements CilentService {
    @Autowired
    private ClientDao clientDao;


    public Oauth2Client findOauth2UsersByName(String name) {
        return clientDao.findOauth2UsersByName(name);
    }

    @Override
    public void saveClient(Oauth2Client oc){

            clientDao.saveClient(oc);
         //  System.out.println(6/0);

    }
}
