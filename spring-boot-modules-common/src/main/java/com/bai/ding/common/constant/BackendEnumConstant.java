package com.bai.ding.common.constant;

/**
 * @author BaiDing
 * @date 2020/3/22 0:41
 */
public class BackendEnumConstant {

    public static enum ResultCodeEnum {
        /**
         * 暂定三种响应状态
         */
        SUCCESS(true,2000,"成功"),
        UNKNOW_ERROR(false,20001,"未知错误"),
        PAEAM_ERROR(false,20002,"参数错误"),
        NULL_TOKEN(false,20003,"用户未登录"),
        EXPIRED_TOKEN(false,20004,"token已过期,请用户重新登录"),
        INVALID_TOKEN(false,20005,"无效的token,请用户重新登录"),
        UNKNOW_THROWABLE(false,20006,"系统出现严重错误"),
        ;

        /**
         * 响应是否成功
         */
        private Boolean success;
        /**
         * 响应状态码
         */
        private Integer code;
        /**
         * 响应信息
         */
        private String message;

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

        ResultCodeEnum(Boolean success, Integer code, String message) {
            this.success = success;
            this.code = code;
            this.message = message;
        }
    }
}
