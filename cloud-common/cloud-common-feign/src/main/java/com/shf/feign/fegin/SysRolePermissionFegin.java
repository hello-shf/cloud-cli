package com.shf.feign.fegin;

import com.shf.entity.user.SysRolePermission;
import com.shf.feign.fallback.SysRolePermissionFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 描述：fegin操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@FeignClient(name="iot-cloud-metadata-user",fallback = SysRolePermissionFallBack.class)
public interface SysRolePermissionFegin{
    /**
     * 根据sysRolePermission对象查询所有
     * @param sysRolePermission
     * @return
     */
    @RequestMapping(value = "/sysRolePermission/queryList",method = RequestMethod.POST)
    public List<SysRolePermission> getAllData(SysRolePermission sysRolePermission);

    /**
     * 根据sysRolePermission对象查询单条
     * @param sysRolePermission
     * @return
     */
    @RequestMapping(value = "/sysRolePermission/querySingle",method = RequestMethod.POST)
    public SysRolePermission querySingle(SysRolePermission sysRolePermission);

    /**
     * 新增
     * @param sysRolePermission
     * @return
     */
    @RequestMapping(value = "/sysRolePermission/add",method = RequestMethod.POST)
    public boolean create(SysRolePermission sysRolePermission);

    /**
     * 更新
     * @param sysRolePermission
     * @return
     */
    @RequestMapping(value = "/sysRolePermission/updateById",method = RequestMethod.POST)
    public boolean update(SysRolePermission sysRolePermission);

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysRolePermission/{id}",method = RequestMethod.GET)
    public SysRolePermission getInfo(@PathVariable(value = "id") String id);

}
