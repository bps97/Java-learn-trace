package cn.bps.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String generatorRandomCode(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix = df.format(new Date()).toString();
        Random random = new Random();
        int suffix = random.nextInt(9000) + 1000;
        return prefix + suffix;
    }

    public static String matchSuffix(String text){
        String reStr = "(\\.[0-9,a-z,A-Z]*)$";
        Pattern pattern = Pattern.compile(reStr);
        Matcher matcher = pattern.matcher(text);

        String suffix = "";

        if(matcher.find()){
            suffix = matcher.group(0);
        }
        return suffix;
    }

}
