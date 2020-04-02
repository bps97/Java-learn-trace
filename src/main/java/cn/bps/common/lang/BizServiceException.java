package cn.bps.common.lang;

public class BizServiceException extends BizRuntimeException {

    public BizServiceException(String message,  String errorCode) {
        super(message, ResponseCode.BUSINESS_ERROR, errorCode);
    }
}
