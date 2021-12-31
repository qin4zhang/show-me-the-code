package com.qin4zhang.demo.know.basic;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java正则匹配
 *
 * @author zhangzhen
 * @date 2021/12/22 下午5:40
 **/
public class Regex {
    private static final String REGEX = "(select|insert|delete|and)";

    public static void main(String[] args) throws SocketException {
        Pattern pattern = Pattern.compile(REGEX);
        System.out.println(pattern.matcher("select").matches());
        System.out.println(pattern.matcher("select123456").find());
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

}
