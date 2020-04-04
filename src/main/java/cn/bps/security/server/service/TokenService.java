package cn.bps.security.server.service;

import cn.bps.common.lang.security.Subject;

public interface TokenService {

    String ACCESS_TOKEN_CACHE = "security_accessToken_";
    String USERNAME_ACCESS_TOKEN_CACHE = "security_username_accessToken_";

    void addSubject (String accessToken, Subject subject);

    void addAccessToken(String username, String accessToken);

    void removeToken(String accessToken);

    String getAccessTokenByUser(String username);

    Subject getSubjectByAccessToken(String accessToken);

    int getAccessTokenExpSeconds();

}
