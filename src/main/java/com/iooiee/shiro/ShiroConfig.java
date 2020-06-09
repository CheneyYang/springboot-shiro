package com.iooiee.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * DateTime: 2020-06-07
 */
@Configuration
public class ShiroConfig {
    /**
     * 1,创建ShrioFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager SecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(SecurityManager);

        /**
         * 添加Shiro内置过滤器：可以实现权限相关的拦截器
         * 常用的过滤器：
         *  anon:无需认证（登录）可以访问
         *  authc: 必须认证才可以访问
         *  user:  如果使用remberMe的功能可以直接访问
         *  perms: 该资源必须得到资源权限才可以访问
         *  role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/index","anon");
        filterMap.put("/user/*","authc");

        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/login");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 2,创建DefaultWebSecurityManager
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /**
     * 3,创建Realm对象
     */
    @Bean("userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

}
