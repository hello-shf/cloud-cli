package com.shf.sso.user.service.impl;

import com.shf.sso.dao.UserDao;
import com.shf.sso.user.service.UserService;
import com.shf.sso.user.entity.user.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/1 15:49
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public TUser findOneByName(String username) {
        return userDao.findOneByName(username);
    }
}
