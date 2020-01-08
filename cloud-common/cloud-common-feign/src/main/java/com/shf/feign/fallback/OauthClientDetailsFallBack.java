package com.shf.feign.fallback;

import com.shf.entity.user.OauthClientDetails;
import com.shf.feign.fegin.OauthClientDetailsFegin;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 描述：回调操作
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@Component
public class OauthClientDetailsFallBack implements OauthClientDetailsFegin {
    /**
     * 根据oauthClientDetails对象查询所有
     * @param oauthClientDetails
     * @return
     */
    @Override
    public List<OauthClientDetails> getAllData(OauthClientDetails oauthClientDetails){
        return null;
    }

    /**
     * 根据oauthClientDetails对象查询单条
     * @param oauthClientDetails
     * @return
     */
    @Override
    public OauthClientDetails querySingle(OauthClientDetails oauthClientDetails){
        return null;
    }

    /**
     * 新增
     * @param oauthClientDetails
     * @return
     */
    @Override
    public boolean create(OauthClientDetails oauthClientDetails){
        return false;
    }

    /**
     * 更新
     * @param oauthClientDetails
     * @return
     */
    @Override
    public boolean update(OauthClientDetails oauthClientDetails){
        return false;
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @Override
    public OauthClientDetails getInfo(String id){
        return null;
    }

}
