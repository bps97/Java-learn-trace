package cn.bps.common.lang.util;

import org.springframework.util.DigestUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtils {

    private static final char[] hexDigits = "0123456789joker".toCharArray();

    private EncryptUtils(){}

    public static String md5Encrypt(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    public static String sha1Encrypt(String str){
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("sha1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String base64Encrypt(String str){
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String base64Decrypt(String str){
        return new String(Base64.getDecoder().decode(str));
    }
}
