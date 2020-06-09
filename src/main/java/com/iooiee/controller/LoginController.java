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


    //注解验角色和权限

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
