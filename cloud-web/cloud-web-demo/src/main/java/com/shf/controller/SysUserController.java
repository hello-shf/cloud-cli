package com.shf.controller;

import com.shf.entity.user.SysUser;
import com.shf.feign.fegin.SysUserFegin;
import com.shf.tool.utils.Rs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Api(value = "SysUserController", tags = "SysUserController", description = "用户接口")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserFegin sysUserFegin;

    @RequestMapping("/single")
    @ApiOperation("单条查询")
    public Rs single(SysUser user){
        return sysUserFegin.querySingle(user);
    }
}
