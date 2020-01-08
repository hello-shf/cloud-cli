package com.shf.controller;

import com.shf.tool.utils.Rs;
import lombok.extern.slf4j.Slf4j;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/1 16:47
 * @Version V1.0
 **/
@RestController
@Slf4j
public class RoleController {
    @RequestMapping("/admin/get")
    public Rs adminGet(){
        log.info("admin有权限访问");
        return Rs.ok("admin有权限访问");
    }
    @RequestMapping("/vip/get")
    public Rs vipGet(){
        log.info("admin，vip有权限访问");
        return Rs.ok("admin，vip有权限访问");
    }
    @RequestMapping("/user/get")
    public Rs userGet(){
        log.info("admin，vip，user有权限访问");
        return Rs.ok("admin，vip，user有权限访问");
    }
}
