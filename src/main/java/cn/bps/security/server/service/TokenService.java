package cn.bps.security.server.service;

import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.security.Subject;
import cn.bps.mms.entity.Account;

public interface TokenService {

    String ACCESS_TOKEN_CACHE = "security_accessToken_";
    String USERNAME_ACCESS_TOKEN_CACHE = "security_username_accessToken_";

    Account getAccount(String value);

    Token getAccessTokenByUser(String username);

    Subject getSubjectByAccessToken(String accessToken);

    int getAccessTokenExpSeconds();

    Token parse(String value);

}
