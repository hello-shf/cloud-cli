package com.shf.feign.fegin;

import com.shf.entity.user.SysRole;
import com.shf.feign.fallback.SysRoleFallBack;
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
@FeignClient(name="iot-cloud-metadata-user",fallback = SysRoleFallBack.class)
public interface SysRoleFegin{
    /**
     * 根据sysRole对象查询所有
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/sysRole/queryList",method = RequestMethod.POST)
    public List<SysRole> getAllData(SysRole sysRole);

    /**
     * 根据sysRole对象查询单条
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/sysRole/querySingle",method = RequestMethod.POST)
    public SysRole querySingle(SysRole sysRole);

    /**
     * 新增
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/sysRole/add",method = RequestMethod.POST)
    public boolean create(SysRole sysRole);

    /**
     * 更新
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/sysRole/updateById",method = RequestMethod.POST)
    public boolean update(SysRole sysRole);

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysRole/{id}",method = RequestMethod.GET)
    public SysRole getInfo(@PathVariable(value = "id") String id);

}
