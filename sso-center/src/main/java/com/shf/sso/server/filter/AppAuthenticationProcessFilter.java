package com.shf.sso.server.filter;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/24 16:42
 * @Version V1.0
 **/
public class AppAuthenticationProcessFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_KEY = "Authorization";

    private TokenStore tokenStore;

    public AppAuthenticationProcessFilter(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        Authentication authentication = attemptAuthentication(request);
        if (Objects.nonNull(authentication)) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    /**
     * 验证权限
     *
     * @param request
     * @return
     * @throws AuthenticationException
     */
    private Authentication attemptAuthentication(HttpServletRequest request)
            throws AuthenticationException {
        String token = extractToken(request);
        if (!StrUtil.isBlank(token)) {
            return tokenStore.readAuthentication(token);
        }
        return null;
    }

    /**
     * 先从请求头中获取token，没获取到就从请求体中获取
     *
     * @param request
     * @return
     */
    protected String extractToken(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders(AUTHORIZATION_KEY);
        while (headers.hasMoreElements()) {
            String value = parseAuthorizationValue(headers.nextElement());
            if (!StrUtil.isBlank(value)) {
                return value;
            }
        }
        // 如果没有从请求头中拿到token，就从请求体中获取
        return obtainRequestToken(request);
    }

    /**
     * 从请求体中获取token
     *
     * @param request
     * @return
     */
    private String obtainRequestToken(HttpServletRequest request) {
        String authorizationValue = request.getParameter(AUTHORIZATION_KEY);
        return parseAuthorizationValue(authorizationValue);
    }

    /**
     * 解析AuthorizationValue
     *
     * @param authorizationValue
     * @return
     */
    private String parseAuthorizationValue(String authorizationValue) {
        if (Objects.isNull(authorizationValue)) {
            return null;
        }
        if ((authorizationValue
                .toLowerCase()
                .startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
            String authHeaderValue =
                    authorizationValue.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
            int commaIndex = authHeaderValue.indexOf(',');
            if (commaIndex > 0) {
                authHeaderValue = authHeaderValue.substring(0, commaIndex);
            }
            return authHeaderValue;
        }
        return null;
    }
}