package com.web.app.backend_netflix.security.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCode code;
    private final Object[] args;

    public BusinessException(final ErrorCode code, final Object... args) {
        super(getFormatterMessage(code, args));
        this.code = code;
        this.args = args;
    }

    private static String getFormatterMessage(ErrorCode code, Object... args) {

        if (args != null && args.length > 0) {
            return String.format(code.getDefaultMessage(),args);
        }
        return code.getDefaultMessage();
    }

}
