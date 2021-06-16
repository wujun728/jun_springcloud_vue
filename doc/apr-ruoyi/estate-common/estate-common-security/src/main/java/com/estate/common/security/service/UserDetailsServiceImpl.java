//package com.estate.common.security.service;
//
//import com.estate.api.system.domain.User;
//import com.estate.common.core.enums.UserStatus;
//import com.estate.common.core.exception.BaseException;
//import com.estate.common.core.utils.StringUtils;
//import com.estate.common.security.model.LoginUser;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * 用户验证处理
// *
// * @author ruoyi
// */
//@Service
//@Slf4j
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private ISysUserService userService;
//
//    @Autowired
//    private SysPermissionService permissionService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.selectUserByUserName(username);
//        if (StringUtils.isNull(user)) {
//            log.info("登录用户：{} 不存在.", username);
//            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
//        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
//            log.info("登录用户：{} 已被删除.", username);
//            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
//        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
//            log.info("登录用户：{} 已被停用.", username);
//            throw new BaseException("对不起，您的账号：" + username + " 已停用");
//        }
//
//        return createLoginUser(user);
//    }
//
//    public UserDetails createLoginUser(User user) {
//        return new LoginUser(user, permissionService.getMenuPermission(user));
//    }
//}
