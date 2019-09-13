package cn.bps.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderCode {
    public static String getOrderCode(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix = df.format(new Date()).toString();
        Random random = new Random();
        int suffix = random.nextInt(9000) + 1000;
        return prefix + suffix;
    }

}
