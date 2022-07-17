package cn.com.zerobug.common.base.api;

import cn.com.zerobug.common.exception.enums.BaseErrorCode;
import cn.com.zerobug.common.exception.enums.IErrorCode;

import java.io.Serializable;
import java.util.Optional;

/**
 * API 统一返回
 *
 * @author zhongxiaowei
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int    code;
    private String msg;
    private T      data;

    public ApiResult() {
    }

    public ApiResult(IErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(BaseErrorCode.FAILED);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static <T> ApiResult<T> ok() {
        return result(null, BaseErrorCode.SUCCESS.getCode(), BaseErrorCode.SUCCESS.getMsg());
    }

    public static <T> ApiResult<T> ok(T data) {
        return result(data, BaseErrorCode.SUCCESS.getCode(), BaseErrorCode.SUCCESS.getMsg());
    }

    public static <T> ApiResult<T> ok(T data, String msg) {
        return result(data, BaseErrorCode.SUCCESS.getCode(), msg);
    }

    public static <T> ApiResult<T> failed() {
        return result(null, BaseErrorCode.FAILED.getCode(), BaseErrorCode.FAILED.getMsg());
    }

    public static <T> ApiResult<T> failed(T data) {
        return result(data, BaseErrorCode.FAILED.getCode(), BaseErrorCode.FAILED.getMsg());
    }

    public static <T> ApiResult<T> failed(T data, String msg) {
        return result(data, BaseErrorCode.FAILED.getCode(), msg);
    }

    public static <T> ApiResult<T> of(T data) {
        IErrorCode resultCode = BaseErrorCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            resultCode = BaseErrorCode.FAILED;
        }
        return result(data, resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> ApiResult<T> of(IErrorCode errorCode) {
        return result(null, errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> ApiResult<T> of(IErrorCode errorCode, T data) {
        return result(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> ApiResult<T> result(T data, int code, String msg) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
