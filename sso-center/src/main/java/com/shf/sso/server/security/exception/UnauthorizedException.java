package com.shf.sso.server.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 描述：添加CustomWebResponseExceptionTranslator，登录发生异常时指定exceptionTranslator
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
@JsonSerialize(using = PrexCustomOauthExceptionSerializer.class)
public class UnauthorizedException extends OAuth2Exception {

    public UnauthorizedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unauthorized";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

}
