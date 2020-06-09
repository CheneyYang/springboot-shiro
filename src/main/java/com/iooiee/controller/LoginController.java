package com.iooiee.controller;

import com.iooiee.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * DateTime: 2020-05-15 14:29
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(User user) {
//        //添加用户认证信息
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
//                user.getUserName(),
//                user.getPassword()
//        );
//        try {
//            //进行验证，这里可以捕获异常，然后返回对应信息
//            subject.login(usernamePasswordToken);
//
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            return "账号或密码错误！";
//        } catch (AuthorizationException e) {
//            e.printStackTrace();
//            return "没有权限";
//        }
        return "login success";
    }
    //注解验角色和权限

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
