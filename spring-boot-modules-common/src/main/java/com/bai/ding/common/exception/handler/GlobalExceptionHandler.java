package com.bai.ding.common.exception.handler;

import com.bai.ding.common.Result;
import com.bai.ding.common.exception.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author BaiDing
 * @date 2020/3/22 21:04
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理JWT自定义异常
     */
    @ExceptionHandler(JwtException.class)
    public Result handleJwtException(JwtException e) {
        logger.error("Token验证异常信息:{}", e.getMessage(), e);
        return new Result.Builder().error().setCode(e.getCode()).setMessage(e.getMessage()).build();
    }

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleOtherException(Exception e) {
        // 打印异常信息
        logger.error("服务器发生未知错误:{}", e.getMessage(), e);
        return new Result.Builder().error().setMessage("系统繁忙，请稍后重试").build();
    }

    @ExceptionHandler(Throwable.class)
    public Result handleThrowable(Throwable throwable) {
        // 打印异常信息
        logger.error("服务器发生严重错误: {}", throwable.getMessage(), throwable);
        return new Result.Builder().error().setCode(20006).setMessage("系统出问题了，请联系管理员哦").build();
    }
}
