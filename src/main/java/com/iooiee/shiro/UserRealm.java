package com.iooiee.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * DateTime: 2020-06-10
 */
public class UserRealm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(UserRealm.class);

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.warn("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.warn("执行认证逻辑");
        //假设数据库的用户名和密码
        String name = "admin";
        String password = "123456";
        //编写shiro 判断逻辑，判断用户名和密码
        // 1. 判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if(!token.getUsername().equals(name)){
            //用户名不存在
            return null; //Shiro 底层会抛出 UnknownAccountException
        }

        //2. 判断密码
        return new SimpleAuthenticationInfo("",password,"");

    }
}
