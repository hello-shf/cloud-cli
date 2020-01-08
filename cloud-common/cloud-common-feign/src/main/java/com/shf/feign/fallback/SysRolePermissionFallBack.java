package com.shf.feign.fallback;

import com.shf.entity.user.SysRolePermission;
import com.shf.feign.fegin.SysRolePermissionFegin;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * 描述：回调操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Component
public class SysRolePermissionFallBack implements SysRolePermissionFegin {
    /**
     * 根据sysRolePermission对象查询所有
     * @param sysRolePermission
     * @return
     */
    @Override
    public List<SysRolePermission> getAllData(SysRolePermission sysRolePermission){
        return null;
    }

    /**
     * 根据sysRolePermission对象查询单条
     * @param sysRolePermission
     * @return
     */
    @Override
    public SysRolePermission querySingle(SysRolePermission sysRolePermission){
        return null;
    }

    /**
     * 新增
     * @param sysRolePermission
     * @return
     */
    @Override
    public boolean create(SysRolePermission sysRolePermission){
        return false;
    }

    /**
     * 更新
     * @param sysRolePermission
     * @return
     */
    @Override
    public boolean update(SysRolePermission sysRolePermission){
        return false;
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @Override
    public SysRolePermission getInfo(String id){
        return null;
    }

}
