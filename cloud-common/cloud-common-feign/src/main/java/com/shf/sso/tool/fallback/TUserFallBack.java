package com.shf.sso.tool.fallback;

import com.shf.sso.tool.feign.TUserFeign;
import com.shf.sso.user.entity.user.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 描述：用户表回调操作
 * @author: lihaohan
 * @date: 2019-04-18 17:45:52
 * @version: V1.0
 */
@Component
@Slf4j
public class TUserFallBack implements TUserFeign {
    @Override
    public TUser findOneByName(String username) {
        log.error("fallback---请求失败了");
        return null;
    }
}
