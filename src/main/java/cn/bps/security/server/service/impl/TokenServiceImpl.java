package cn.bps.security.server.service.impl;

import cn.bps.common.lang.security.Subject;
import cn.bps.security.server.service.TokenService;


public class TokenServiceImpl implements TokenService{

    private int accessTokenExpSeconds;

    public TokenServiceImpl() {}

    public void init() {
        this.accessTokenExpSeconds = 1800;
    }

    @Override
    public void addSubject(String accessToken, Subject subject) {

    }

    @Override
    public void addAccessToken(String username, String accessToken) {

    }

    @Override
    public void removeToken(String accessToken) {

    }

    @Override
    public String getAccessTokenByUser(String username) {
        return null;
    }

    @Override
    public Subject getSubjectByAccessToken(String accessToken) {
        return null;
    }

    @Override
    public int getAccessTokenExpSeconds() {
        return 0;
    }
}
