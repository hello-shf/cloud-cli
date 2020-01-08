package com.shf.feign.fallback;

import com.shf.entity.user.SysUser;
import com.shf.feign.fegin.SysUserFegin;
import com.shf.tool.utils.Rs;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * 描述：回调操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Slf4j
@Component
public class SysUserFallBack implements FallbackFactory<SysUserFegin> {
    @Override
    public SysUserFegin create(Throwable throwable){
        return new SysUserFegin() {
            @Override
            public List<SysUser> getAllData(SysUser sysUser) {
                return null;
            }

            @Override
            public Rs querySingle(SysUser sysUser) {
                log.info(throwable.getMessage());
                return null;
            }

            @Override
            public boolean create(SysUser sysUser) {
                return false;
            }

            @Override
            public boolean update(SysUser sysUser) {
                return false;
            }

            @Override
            public SysUser getInfo(String id) {
                return null;
            }
        };
    }
}
