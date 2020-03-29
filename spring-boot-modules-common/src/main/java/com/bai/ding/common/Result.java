package com.bai.ding.common;

import com.bai.ding.common.constant.BackendEnumConstant;

/**
 * @author BaiDing
 * @date 2020/3/22 0:53
 */
public class Result {

    private Boolean success;
    private Integer code;
    private String message;
    private Object data;

    private Result() {}

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class Builder{
        private Result instance;

        private Builder(Result result){
            this.instance = result;
        }
        public Builder(){
            this(new Result());
        }

        public Builder ok(){
            this.instance.setSuccess(BackendEnumConstant.ResultCodeEnum.SUCCESS.getSuccess());
            this.instance.setCode(BackendEnumConstant.ResultCodeEnum.SUCCESS.getCode());
            this.instance.setMessage(BackendEnumConstant.ResultCodeEnum.SUCCESS.getMessage());
            return this;
        }

        public Builder error(){
            this.instance.setSuccess(BackendEnumConstant.ResultCodeEnum.UNKNOW_ERROR.getSuccess());
            this.instance.setCode(BackendEnumConstant.ResultCodeEnum.UNKNOW_ERROR.getCode());
            this.instance.setMessage(BackendEnumConstant.ResultCodeEnum.UNKNOW_ERROR.getMessage());
            return this;
        }

        public Builder setSuccess(Boolean success){
            this.instance.success = success;
            return this;
        }

        public Builder setCode(Integer code){
            this.instance.code = code;
            return this;
        }

        public Builder setMessage(String message){
            this.instance.message = message;
            return this;
        }

        public Builder setData(Object data){
            this.instance.data = data;
            return this;
        }

        public Result build(){
            return this.instance;
        }


    }

}
