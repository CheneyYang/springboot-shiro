package com.iooiee.controller;

import com.iooiee.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * DateTime: 2020-06-10
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("add")
    @ResponseBody
    public String add(){
        return "用户添加成功";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(){
        return "用户更新成功";
    }

    @RequestMapping("/login")
    public String login(User user) {
        return "/login";
    }

}
