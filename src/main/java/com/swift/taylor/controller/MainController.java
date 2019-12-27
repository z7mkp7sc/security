package com.swift.taylor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:52
 * @version: v1
 * @modified By:
 */
@Controller
public class MainController {

    //重定向到首页
    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    //直接上首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //登录页
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //登录失败页
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute( "loginError"  , true);
        return "login";
    }

    @GetMapping("/401")
    public String accessDenied() {
        return "401";
    }

    //需要认证
    @GetMapping("/user/common")
    public String common() {
        return "user/common";
    }

    //需要认证
    @GetMapping("/user/admin")
    public String admin() {
        return "user/admin";
    }


}
