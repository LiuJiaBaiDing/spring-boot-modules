package com.bai.ding.common.constant;

/**
 * @author BaiDing
 * @date 2020/3/10 16:15
 */
public class BackendModulesConstant {

    public static String getBaiDingMessage() {
        return CommonConstant.getStringConstant("bai.ding.message", "");
    }

    public static String getBaiDingJwtSubject() {
        return CommonConstant.getStringConstant("bai.ding.jwt.subject", "");
    }

    public static String getBaiDingJwtSecretkey() {
        return CommonConstant.getStringConstant("bai.ding.jwt.secretkey", "");
    }

    public static Long getBaiDingJwtExpire() {
        return Long.parseLong(CommonConstant.getStringConstant("bai.ding.jwt.expire", ""))*24*60*60*1000;
    }

    public static String getFastdfsUploadUrl() {
        return CommonConstant.getStringConstant("fastdfs.upload.url", "");
    }
}
