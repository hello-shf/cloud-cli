package com.shf.sso.server.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 描述：添加CustomWebResponseExceptionTranslator，登录发生异常时指定exceptionTranslator
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }
}
