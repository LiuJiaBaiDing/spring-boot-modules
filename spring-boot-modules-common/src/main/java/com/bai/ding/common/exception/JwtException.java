package com.bai.ding.common.exception;

import com.bai.ding.common.constant.BackendEnumConstant;

/**
 * @author BaiDing
 * @date 2020/3/22 20:59
 */
public class JwtException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public JwtException() {
    }

    public JwtException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public JwtException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public JwtException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public JwtException(BackendEnumConstant.ResultCodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }
}
