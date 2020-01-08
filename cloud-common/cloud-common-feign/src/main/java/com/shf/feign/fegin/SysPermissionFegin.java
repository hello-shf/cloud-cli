package com.shf.feign.fegin;

import com.shf.entity.user.SysPermission;
import com.shf.feign.fallback.SysPermissionFallBack;
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
@FeignClient(name="iot-cloud-metadata-user",fallback = SysPermissionFallBack.class)
public interface SysPermissionFegin{
    /**
     * 根据sysPermission对象查询所有
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/sysPermission/queryList",method = RequestMethod.POST)
    public List<SysPermission> getAllData(SysPermission sysPermission);

    /**
     * 根据sysPermission对象查询单条
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/sysPermission/querySingle",method = RequestMethod.POST)
    public SysPermission querySingle(SysPermission sysPermission);

    /**
     * 新增
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/sysPermission/add",method = RequestMethod.POST)
    public boolean create(SysPermission sysPermission);

    /**
     * 更新
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/sysPermission/updateById",method = RequestMethod.POST)
    public boolean update(SysPermission sysPermission);

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysPermission/{id}",method = RequestMethod.GET)
    public SysPermission getInfo(@PathVariable(value = "id") String id);

}
