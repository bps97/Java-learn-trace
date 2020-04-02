package cn.bps.common.lang.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 工具生成器
 */
public class Generator {

    private Generator(){} /*工具类屏蔽构造函数*/

    public static String  getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-","").substring(0,24);
    }

    public static String now(){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(now);
    }

    public static String getActionName(){
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String className = stackTraceElement.getFileName();
        return className.substring(0,className.lastIndexOf(".")) + "@" + stackTraceElement.getMethodName();
    }
}
