package cn.bps.common.lang;

public class LocalBizServiceException extends BizServiceException {
    public LocalBizServiceException(CustomizeExceptionCode errorCode, String...args) {
        super(Messages.getMessages(errorCode, args), errorCode.getName());
    }
}
