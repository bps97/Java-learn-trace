package cn.bps.heam;

import cn.bps.common.lang.domain.Success;
import cn.bps.common.lang.util.Generator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import org.junit.Test;
import org.springframework.util.DigestUtils;

public class MethodTest {

    @Test
    public void md5Test(){
        String str = "abc1998";
        String md5Password = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(md5Password);
        System.out.println(DigestUtils.md5DigestAsHex("abc1998".getBytes()).equals(md5Password));
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
        Success success = new Success.Builder(Generator.getActionName()).code("403").failure().info("该账户已存在").build();
        PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
        System.out.println(JSON.toJSONString(success));
    }

    @Test
    public void temporaryTest(){
    }
}
