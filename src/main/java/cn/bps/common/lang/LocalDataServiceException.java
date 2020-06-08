package cn.bps.common.lang;

public class LocalDataServiceException extends Exception {
    public LocalDataServiceException(CustomizeExceptionCode errorCode, String...args) {
        super(Messages.getMessages(errorCode, args));
    }
}
