package cn.bps.common.lang;

/**
 * 继承自RuntimeException，该异常是会导致自动中断的异常
 */
public class LocalBizServiceException extends BizServiceException {
    public LocalBizServiceException(CustomizeExceptionCode errorCode, String...args) {
        super(Messages.getMessages(errorCode, args), errorCode.getName());
    }
}
