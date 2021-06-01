package com.gs.dao;

import com.gs.entity.Oauth2User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 10:13
 */
@Repository
public interface UserDao extends JpaRepository<Oauth2User,Long>{

    @Query("select t from Oauth2User t where username=:username")
    Oauth2User findOauth2UsersByName(@Param("username") String username);



}
