package com.shf.sso.server.security.exception;

import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
public class PrexCustomOauthException extends OAuth2Exception {

    @Getter
    private String errorCode;

    public PrexCustomOauthException(String msg) {
        super(msg);
    }

    public PrexCustomOauthException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
