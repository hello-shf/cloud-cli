package com.shf.feign.fegin;

import com.shf.entity.user.SysUserRole;
import com.shf.feign.fallback.SysUserRoleFallBack;
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
@FeignClient(name="iot-cloud-metadata-user",fallback = SysUserRoleFallBack.class)
public interface SysUserRoleFegin{
    /**
     * 根据sysUserRole对象查询所有
     * @param sysUserRole
     * @return
     */
    @RequestMapping(value = "/sysUserRole/queryList",method = RequestMethod.POST)
    public List<SysUserRole> getAllData(SysUserRole sysUserRole);

    /**
     * 根据sysUserRole对象查询单条
     * @param sysUserRole
     * @return
     */
    @RequestMapping(value = "/sysUserRole/querySingle",method = RequestMethod.POST)
    public SysUserRole querySingle(SysUserRole sysUserRole);

    /**
     * 新增
     * @param sysUserRole
     * @return
     */
    @RequestMapping(value = "/sysUserRole/add",method = RequestMethod.POST)
    public boolean create(SysUserRole sysUserRole);

    /**
     * 更新
     * @param sysUserRole
     * @return
     */
    @RequestMapping(value = "/sysUserRole/updateById",method = RequestMethod.POST)
    public boolean update(SysUserRole sysUserRole);

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysUserRole/{id}",method = RequestMethod.GET)
    public SysUserRole getInfo(@PathVariable(value = "id") String id);

}
