package com.lvgu.industrynew.utils;

/**
 * 字符串工具类
 */
public class StringUtilss {

    /**
     * 字符串首字母转大写
     * @param str
     * @return
     */
    public static String initcap(String str) {
        if(str == null || "".equals(str)) {
            return str;
        }
        if(str.length()==1) {
            return str.toUpperCase();
        }else {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
    }
}
