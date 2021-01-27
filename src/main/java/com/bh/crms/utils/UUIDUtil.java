package com.bh.crms.utils;

import java.util.UUID;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 14:23
 */
public class UUIDUtil {
    /**
     * 带 -  的UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 不带 - 的UUID
     * @return
     *
     * toUpperCase(): 大写
     */
    public static String getContinuouslyUUID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
