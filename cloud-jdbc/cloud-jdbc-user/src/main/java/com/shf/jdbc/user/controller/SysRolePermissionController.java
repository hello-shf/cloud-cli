package com.shf.jdbc.user.controller;

import com.shf.entity.user.SysRolePermission;
import com.shf.jdbc.user.service.SysRolePermissionService;
import com.shf.tool.base.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@RestController
@RequestMapping("/sysRolePermission")
public class SysRolePermissionController extends BaseController<SysRolePermissionService, SysRolePermission> {

}
