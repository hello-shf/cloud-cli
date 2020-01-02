package com.shf.sso.server.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 描述：添加CustomWebResponseExceptionTranslator，登录发生异常时指定exceptionTranslator
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
@JsonSerialize(using = PrexCustomOauthExceptionSerializer.class)
public class SocialServiceException extends OAuth2Exception {

    public SocialServiceException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "social_exception";
    }

    @Override
    public int getHttpErrorCode() {
        return 423;
    }
}
