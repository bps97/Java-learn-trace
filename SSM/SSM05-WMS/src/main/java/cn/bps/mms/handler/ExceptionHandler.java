package cn.bps.mms.handler;

import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.domain.Ret;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(LocalBizServiceException.class)
    public Ret<String> handleCustomException(LocalBizServiceException bizException) {

        String message  = bizException.getMessage();

        return StringUtils.isEmpty(message)
                ? Ret.error().message(bizException.getCustomizeExceptionCode().getInfo())
                : Ret.error().message(message);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class)
    public Ret<String> handleSQLException(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException jdbcException){

        return Ret.error();

    }

}
