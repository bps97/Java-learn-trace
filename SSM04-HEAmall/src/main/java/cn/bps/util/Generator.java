package cn.bps.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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

}
