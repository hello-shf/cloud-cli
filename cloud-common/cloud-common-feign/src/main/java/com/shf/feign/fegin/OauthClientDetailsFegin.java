package com.shf.feign.fegin;

import com.shf.entity.user.OauthClientDetails;
import com.shf.feign.fallback.OauthClientDetailsFallBack;
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
@FeignClient(name="shf-cloud-metadata-user",fallback = OauthClientDetailsFallBack.class)
public interface OauthClientDetailsFegin{
    /**
     * 根据oauthClientDetails对象查询所有
     * @param oauthClientDetails
     * @return
     */
    @RequestMapping(value = "/oauthClientDetails/queryList",method = RequestMethod.POST)
    public List<OauthClientDetails> getAllData(OauthClientDetails oauthClientDetails);

    /**
     * 根据oauthClientDetails对象查询单条
     * @param oauthClientDetails
     * @return
     */
    @RequestMapping(value = "/oauthClientDetails/querySingle",method = RequestMethod.POST)
    public OauthClientDetails querySingle(OauthClientDetails oauthClientDetails);

    /**
     * 新增
     * @param oauthClientDetails
     * @return
     */
    @RequestMapping(value = "/oauthClientDetails/add",method = RequestMethod.POST)
    public boolean create(OauthClientDetails oauthClientDetails);

    /**
     * 更新
     * @param oauthClientDetails
     * @return
     */
    @RequestMapping(value = "/oauthClientDetails/updateById",method = RequestMethod.POST)
    public boolean update(OauthClientDetails oauthClientDetails);

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/oauthClientDetails/{id}",method = RequestMethod.GET)
    public OauthClientDetails getInfo(@PathVariable(value = "id") String id);

}
