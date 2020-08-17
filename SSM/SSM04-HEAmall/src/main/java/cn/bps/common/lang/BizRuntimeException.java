package cn.bps.common.lang;

public class BizRuntimeException extends RuntimeException {

    private final ResponseCode code;
    private final String errorCode;
    private String requestId;

    public BizRuntimeException(String message, ResponseCode code, String errorCode) {
        super(message);
        this.code = code;
        this.errorCode = errorCode;
    }

    public BizRuntimeException(String message, Throwable cause, ResponseCode code, String errorCode) {
        super(message, cause);
        this.code = code;
        this.errorCode = errorCode;
    }

    public ResponseCode getCode() {
        return code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
