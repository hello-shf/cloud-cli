package com.shf.sso.server.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/12/27 17:58
 * @Version V1.0
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
