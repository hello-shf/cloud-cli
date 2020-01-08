package com.shf.feign.fallback;

import com.shf.entity.user.SysPermission;
import com.shf.feign.fegin.SysPermissionFegin;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 描述：回调操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Component
public class SysPermissionFallBack implements SysPermissionFegin {
    /**
     * 根据sysPermission对象查询所有
     * @param sysPermission
     * @return
     */
    @Override
    public List<SysPermission> getAllData(SysPermission sysPermission){
        return null;
    }

    /**
     * 根据sysPermission对象查询单条
     * @param sysPermission
     * @return
     */
    @Override
    public SysPermission querySingle(SysPermission sysPermission){
        return null;
    }

    /**
     * 新增
     * @param sysPermission
     * @return
     */
    @Override
    public boolean create(SysPermission sysPermission){
        return false;
    }

    /**
     * 更新
     * @param sysPermission
     * @return
     */
    @Override
    public boolean update(SysPermission sysPermission){
        return false;
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @Override
    public SysPermission getInfo(String id){
        return null;
    }

}
