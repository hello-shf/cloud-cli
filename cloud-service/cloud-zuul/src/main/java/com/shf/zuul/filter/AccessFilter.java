package com.shf.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/3 17:30
 * @Version V1.0
 **/
@Component
@Slf4j
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
//        log.info("请求的url----->{}", request.getRequestURL());
        log.info("请求的URI----->{}", request.getRequestURI());
        Map<String, String[]> requestMap = request.getParameterMap();
        System.out.println("参数：" + JSON.toJSONString(requestMap));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null != authentication){
            log.info("用户名：{}", authentication.getName());
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
