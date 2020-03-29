package com.bai.ding.common.exception;

/**
 * @author BaiDing
 * @date 2020/3/27 21:26
 */
public class FdfsException extends RuntimeException {

    public FdfsException(){
        super();
    }

    public FdfsException(String message, Throwable cause){
        super(message,cause);
    }

    public FdfsException(String message){
        super(message);
    }

    public FdfsException(Throwable cause){
        super(cause);
    }
}
