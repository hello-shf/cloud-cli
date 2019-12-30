package com.shf.user.service;

import com.shf.user.entity.user.TUser;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/1 15:49
 * @Version V1.0
 **/
public interface UserService {
    TUser findOneByName(String username);
}
