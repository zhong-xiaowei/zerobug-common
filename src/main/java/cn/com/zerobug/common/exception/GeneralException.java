package cn.com.zerobug.common.exception;

import cn.com.zerobug.common.exception.enums.IErrorCode;

/**
 * @author zhongxiaowei
 * @date 2022/2/25
 */
public class GeneralException extends RuntimeException {

    /**
     * @See {@link IErrorCode}
     */
    private IErrorCode errorCode;

    public GeneralException() {
    }

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(Throwable cause) {
        super(cause);
    }

    public GeneralException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
