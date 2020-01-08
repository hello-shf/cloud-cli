package com.shf.feign.fallback;

import com.shf.entity.user.SysRole;
import com.shf.feign.fegin.SysRoleFegin;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * 描述：回调操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Component
public class SysRoleFallBack implements SysRoleFegin {
    /**
     * 根据sysRole对象查询所有
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> getAllData(SysRole sysRole){
        return null;
    }

    /**
     * 根据sysRole对象查询单条
     * @param sysRole
     * @return
     */
    @Override
    public SysRole querySingle(SysRole sysRole){
        return null;
    }

    /**
     * 新增
     * @param sysRole
     * @return
     */
    @Override
    public boolean create(SysRole sysRole){
        return false;
    }

    /**
     * 更新
     * @param sysRole
     * @return
     */
    @Override
    public boolean update(SysRole sysRole){
        return false;
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @Override
    public SysRole getInfo(String id){
        return null;
    }

}
