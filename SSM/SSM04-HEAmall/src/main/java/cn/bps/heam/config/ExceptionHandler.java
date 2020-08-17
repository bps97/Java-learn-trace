package cn.bps.heam.config;


import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.domain.Ret;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(LocalBizServiceException.class)
    public Ret handleException(LocalBizServiceException bizException) {
        return Ret.error().message(bizException.getCustomizeExceptionCode().getName());
    }

}
