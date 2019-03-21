package com.zgz.group.config.handler;

import org.springframework.security.core.AuthenticationException;

public class TokenIsExpiredException extends AuthenticationException {

    public TokenIsExpiredException(String message) {
        super(message);
    }

}
