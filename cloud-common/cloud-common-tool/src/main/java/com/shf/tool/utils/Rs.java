package com.shf.tool.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 描述：统一 restFul 接口返回值
 *
 * @Author shf
 * @Date 2019/4/16 15:03
 * @Version V1.0
 **/
@Api(value = "Rs", tags = "Rs", description = "相应模板")
public class Rs {
    private static final String DEFALUT_OK_CODE = "-200";
    private static final String DEFALUT_ERROR_CODE = "-400";
    private static final String DEFALUT_OK_MSG = "SUCCESS";
    private static final String DEFALUT_ERROR_MSG = "FAILED";
    @ApiModelProperty(value = "响应码 -200：成功 -400：失败", name = "code")
    private String code;
    @ApiModelProperty(value = "响应信息", name = "msg")
    private String msg;
    @ApiModelProperty(value = "响应数据", name = "data")
    private Object data;
    public Rs() {
        this.code = DEFALUT_OK_CODE;
        this.msg = DEFALUT_OK_MSG;
    }
    public Rs(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public static Rs ok(){
        return new Rs();
    }
    public static Rs error(){
        return new Rs(DEFALUT_ERROR_CODE, DEFALUT_ERROR_MSG);
    }
    public static Rs ok(String msg){
        return new Rs(DEFALUT_OK_CODE, msg);
    }
    public static Rs error(String msg){
        return new Rs(DEFALUT_ERROR_CODE, msg);
    }
    public static Rs error(String code, String msg){
        return new Rs(code, msg);
    }
    public static Rs ok(String code, String msg){
        return new Rs(code, msg);
    }

    public String getCode() {
        return code;
    }

    public Rs setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Rs setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Rs setData(Object data) {
        this.data = data;
        return this;
    }
}

