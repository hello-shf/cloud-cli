package com.shf.feign.fegin;

import com.shf.entity.user.SysUser;
import com.shf.feign.fallback.SysUserFallBack;
import com.shf.tool.utils.Rs;
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
@FeignClient(name="cloud-jdbc-user",fallbackFactory = SysUserFallBack.class)
public interface SysUserFegin{
    /**
     * 根据sysUser对象查询所有
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/sysUser/queryList",method = RequestMethod.POST)
    public List<SysUser> getAllData(SysUser sysUser);

    /**
     * 根据sysUser对象查询单条
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/sysUser/single",method = RequestMethod.POST)
    public Rs querySingle(SysUser sysUser);

    /**
     * 新增
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/sysUser/add",method = RequestMethod.POST)
    public boolean create(SysUser sysUser);

    /**
     * 更新
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/sysUser/updateById",method = RequestMethod.POST)
    public boolean update(SysUser sysUser);

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysUser/{id}",method = RequestMethod.GET)
    public SysUser getInfo(@PathVariable(value = "id") String id);

}
