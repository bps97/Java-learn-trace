package cn.bps.mms.handler;

import cn.bps.common.lang.api.Token;
import cn.bps.security.server.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@SuppressWarnings("ALL")
@Component
public class MyHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String tokenStr = request.getHeader("token");

        Token token = tokenService.parse(tokenStr);

        return Objects.isNull(token) == Boolean.FALSE;
    }






}
