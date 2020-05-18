package cn.bps.heam.service.impl;

import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.security.Subject;
import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.common.lang.util.TimeUtils;
import cn.bps.heam.service.AccountService;
import cn.bps.security.server.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenServiceImpl implements TokenService{

    private static final String SEPARATOR = "-";

    @Resource
    private AccountService accountService;

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
    public Token getAccessTokenByUser(String username) {
        String id = accountService.getAccountByUsername(username).getId();
        long expireTime = TimeUtils.tomorrowUnixTime();

        String signature = generateSignature(id, expireTime);
        String value = generateTokenValue(id, expireTime, signature);

        Token token = new Token();
        token.setExpireTime(expireTime);
        token.setUserId(id);
        token.setSignature(signature);
        token.setValue(value);

        return token;
    }

    public static Token parse(String value) {
        // 未写
        return null;
    }

    private String generateTokenValue(String id, long expireTime, String signature) {
        return EncryptUtils.md5Encrypt(id + SEPARATOR + expireTime + SEPARATOR + signature);
    }

    private String generateSignature(String id, long expireTime) {
        return EncryptUtils.sha1Encrypt(id + expireTime);
    }


    @Override
    public Subject getSubjectByAccessToken(String accessToken) {
        return null;
    }


    /**
     * 获取token剩余生命
     * @return
     */
    @Override
    public int getAccessTokenExpSeconds() {
        return 0;
    }
}
