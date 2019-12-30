package com.shf.user.service;

import com.shf.user.entity.SysUser;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/12/27 17:58
 * @Version V1.0
 **/
public interface UserService {

    SysUser getByUsername(String username);
}
