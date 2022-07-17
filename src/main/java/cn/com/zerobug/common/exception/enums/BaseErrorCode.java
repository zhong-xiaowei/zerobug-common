package cn.com.zerobug.common.exception.enums;

/**
 * @author zhongxiaowei
 */
public enum BaseErrorCode implements IErrorCode {

    //=======================基础异常==========================

    /**
     * 成功
     */
    SUCCESS(0, "执行成功"),
    /**
     * 失败
     */
    FAILED(-1, "操作失败"),
    /**
     * 坏的请求
     */
    BAD_REQUEST(400, "请求方式或参数不正确"),
    /**
     * 未登录
     */
    UNAUTHORIZED(401, "认证失败"),
    /**
     * 权限不足
     */
    FORBIDDEN(403, "权限不足"),
    /**
     * 请求资源未找到
     */
    NOT_FOUND(404, "请求资源未找到"),
    /**
     * 请求方法不正确
     */
    METHOD_NOT_ALLOWED(405, "请求方法不正确"),
    /**
     * 操作频繁
     */
    OPERATING_FREQUENCY(444, "操作频繁,请稍后重试"),

    /**
     * 服务器内部异常
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部异常");

    /**
     * 错误代码
     */
    private final int    code;
    /**
     * 错误信息
     */
    private final String msg;

    BaseErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
