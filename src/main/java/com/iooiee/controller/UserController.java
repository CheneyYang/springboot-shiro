package com.iooiee.controller;

import com.iooiee.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/toMain")
    public String toMain(User user) {
        return "/main";
    }


    @RequestMapping("/toLogin")
    public String toLogin(User user) {
        return "/login";
    }



    @RequestMapping("/login")
    public String login(String name, String password, Model model) {
        /**
         * 使用Shiro编写认证操作
         */
        //1. 获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2. 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        //3. 执行登录方法
        try{
            subject.login(token);
            //登录成功，跳转到主页
            return "main";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            //登录失败: 用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "toLogin";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            //登录失败: 用户名不存在
            model.addAttribute("msg","密码错误");
            return "toLogin";
        }

    }

}
