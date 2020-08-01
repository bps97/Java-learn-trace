package cn.bps.common.lang;

import java.util.Arrays;

/**
 * 继承自RuntimeException，该异常是会导致自动中断的异常
 */
public class LocalBizServiceException extends BizServiceException {
    private CustomizeExceptionCode customizeExceptionCode;
    private String message;

    public LocalBizServiceException(CustomizeExceptionCode errorCode, String...args) {
        super(Messages.getMessages(errorCode, args), errorCode.getName());
        this.customizeExceptionCode = errorCode;
        if(args.length>0){
            this.message = Arrays.toString(args);
        }
    }

    public CustomizeExceptionCode getCustomizeExceptionCode() {
        return customizeExceptionCode;
    }
}
