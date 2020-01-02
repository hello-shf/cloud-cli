package com.shf.sso.server.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
@JsonSerialize(using = PrexCustomOauthExceptionSerializer.class)
public class InvalidException extends OAuth2Exception {

    public InvalidException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_exception";
    }

    @Override
    public int getHttpErrorCode() {
        return 422;
    }
}
