package com.iooiee.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * DateTime: 2020-05-15 14:43
 */
@ControllerAdvice
public class CustomException {

    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e){
        e.printStackTrace();
        System.out.println("没有通过权限认证");
        return "没有通过权限认证";
    }
}
