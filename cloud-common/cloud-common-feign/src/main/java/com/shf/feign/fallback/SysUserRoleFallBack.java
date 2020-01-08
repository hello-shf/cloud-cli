package com.shf.feign.fallback;

import com.shf.entity.user.SysUserRole;
import com.shf.feign.fegin.SysUserRoleFegin;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * 描述：回调操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Component
public class SysUserRoleFallBack implements SysUserRoleFegin {
    /**
     * 根据sysUserRole对象查询所有
     * @param sysUserRole
     * @return
     */
    @Override
    public List<SysUserRole> getAllData(SysUserRole sysUserRole){
        return null;
    }

    /**
     * 根据sysUserRole对象查询单条
     * @param sysUserRole
     * @return
     */
    @Override
    public SysUserRole querySingle(SysUserRole sysUserRole){
        return null;
    }

    /**
     * 新增
     * @param sysUserRole
     * @return
     */
    @Override
    public boolean create(SysUserRole sysUserRole){
        return false;
    }

    /**
     * 更新
     * @param sysUserRole
     * @return
     */
    @Override
    public boolean update(SysUserRole sysUserRole){
        return false;
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @Override
    public SysUserRole getInfo(String id){
        return null;
    }

}
