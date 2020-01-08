package com.shf.jdbc.user.controller;

import com.shf.entity.user.SysUser;
import com.shf.jdbc.user.service.SysUserService;
import com.shf.tool.base.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController<SysUserService, SysUser> {

}
