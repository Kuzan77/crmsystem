package com.bh.crms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期和字符串相互转换的工具类
 */
public class DateUtil {
    /**
     * 方法的作用就是把日期转成一个字符串
     */
    public static String dateToString(Date d, String format) {
//        // 创建格式化对象
//        // SimpleDateFormat sdf = new SimpleDateFormat();
//        // 给定模式
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        //格式化
//        String time = sdf.format(d);
//        return time;
        // 代码改进
        return new SimpleDateFormat(format).format(d);
    }

    /**
     * 方法的作用就是把一个字符串解析成一个日期对象
     */
    public static Date stringToDate(String time, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(time);
    }
}
