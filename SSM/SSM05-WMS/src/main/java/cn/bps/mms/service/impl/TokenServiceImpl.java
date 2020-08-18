package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.security.Subject;
import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.common.lang.util.TimeUtils;
import cn.bps.mms.model.pojo.Account;
import cn.bps.mms.service.AccountService;
import cn.bps.security.server.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String SEPARATOR = "-";

    @Resource
    private AccountService accountService;

    private int accessTokenExpSeconds;

    public TokenServiceImpl() {}

    public void init() {
        this.accessTokenExpSeconds = 1800;
    }

    @Override
    public Account getAccount(String value){
        if(Objects.nonNull(value)){
            value = EncryptUtils.base64Decrypt(value);
            String[] val = value.split(SEPARATOR);
            if( val.length == 3) {
                Token token = new Token();
                String accountId = val[0];
                return accountService.getById(accountId);
            }
        }
        return null;
    }

    public void addAccessToken(String username, String accessToken) {
        // 没卵用
    }

    public void removeToken(String accessToken) {
        // 说实话我也不知道怎么清除token，本身服务端也没存储token，除非记录黑名单
    }

    @Override
    public Token getAccessTokenByUser(String username) {
        String id = accountService.getByUsername(username).getId();
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

    @Override
    public Token parse(String tokenValue) {
        if(Objects.nonNull(tokenValue)){
            tokenValue = EncryptUtils.base64Decrypt(tokenValue);
            String[] val = tokenValue.split(SEPARATOR);
            if( val.length == 3){
                Token token = new Token();
                token.setUserId(val[0]);
                token.setExpireTime(Long.parseLong(val[1]));
                token.setSignature(val[2]);
                token.setValue(tokenValue);

                /*生成的数字签名*/
                String generatedSignature = generateSignature(token.getUserId(),token.getExpireTime());
                if(Objects.equals(generatedSignature,token.getSignature())){
                    if(token.getExpireTime() > (new Date().getTime())){
                        return token;
                    }
                    throw new LocalBizServiceException(CustomizeExceptionCode.TOKEN_EXPIRED);
                }
            }
        }
        // token过期
        // return null
        throw new LocalBizServiceException(CustomizeExceptionCode.TOKEN_IS_INVALID);
    }

    @Override
    public boolean validToken(String tokenValue) {

        Token token = this.parse(tokenValue);

        return Objects.isNull(token) == Boolean.FALSE;
    }

    private String generateTokenValue(String id, long expireTime, String signature) {
        return EncryptUtils.base64Encrypt(id + SEPARATOR + expireTime + SEPARATOR + signature);
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
