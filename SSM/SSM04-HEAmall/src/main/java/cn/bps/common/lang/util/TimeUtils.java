package cn.bps.common.lang.util;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private final static String DATE_FORMAT_STR = "yyyy-MM-dd hh:mm:ss";

    private static DateTimeFormatter formatter;

    static {
        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_STR);
    }

    private TimeUtils(){}

    public static String now(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    public static LocalDateTime parseTime(String time){
        return LocalDateTime.parse(time, formatter);
    }

    public static long tomorrowUnixTime(){
        LocalDateTime now = LocalDateTime.now();
        return plus1Day(now).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static LocalDateTime plus1Day(LocalDateTime time){
        return time.plusHours(24L);
    }

}
