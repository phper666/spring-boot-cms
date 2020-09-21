package com.github.phper666.schemaregistry.rest.exception.code;

/**
 * @author liyuzhao
 * @email 562405704@qq.com
 * @date 2020/9/17 10:29 下午
 * @software IntelliJ IDEA
 */
public enum EnumCode {
    // 数据操作错误定义
    SUCCESS(0, "成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    public final static Integer SUCCESS_CODE = 0;
    public final static Integer ERROR_CODE = 400;

    /** 错误码 */
    private Integer errCode;

    /** 错误描述 */
    private String errMsg;

    EnumCode(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
