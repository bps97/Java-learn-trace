package cn.bps.heam;

import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.heam.dict.Column;
import cn.bps.common.lang.api.Filter;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.util.Objects;

public class MethodTest {

    @Test
    public void md5Test(){
        String str = "abc1998";
        String md5Password = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(md5Password);
        System.out.println(DigestUtils.md5DigestAsHex("abc1998".getBytes()).equals(md5Password));
    }

    @Test
    public void sha1Test(){
        String str = "abc1998";
        String sha1Password = EncryptUtils.sha1Encrypt(str);
        System.out.println(sha1Password);
//        System.out.println(DigestUtils.md5DigestAsHex("abc1998".getBytes()).equals(sha1Password));
    }

    @Test
    public void getMethodName(){
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        String className = stackTraceElement.getFileName();
        String name = className.substring(0,className.lastIndexOf(".")) + "@" + stackTraceElement.getMethodName();
        System.out.println(name);
    }

    @Test
    public void getSuccessResp() {
//        Ret success = new Ret.Builder(Generator.getActionName()).code("403").failure().info("该账户已存在").build();
//        PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
//        System.out.println(JSON.toJSONString(success));
    }

    @Test
    public void  outputFilter(){
        Filter filter = Filter.condition();
        filter.add(new Filter.Property("category","冰箱"));
        filter.add(new Filter.Property("制冷方式", "风冷"));
        filter.addEndWith("压缩机", "变频");
        filter.addEndWith("箱门结构","对开门");
        System.out.println(JSON.toJSONString(filter));
        System.out.println(Objects.equals("category", Column.category.name()));
    }

    @Test
    public void temporaryTest(){

    }
}
