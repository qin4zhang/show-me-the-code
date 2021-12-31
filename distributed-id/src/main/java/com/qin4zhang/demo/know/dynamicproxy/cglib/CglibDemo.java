package com.qin4zhang.demo.know.dynamicproxy.cglib;

/**
 * TODO
 *
 * @author zhangzhen
 * @date 2021/11/29 下午4:22
 **/
public class CglibDemo {

    public String say() {
        System.out.println("Hello World");
        return "Hello World";
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        CglibDemo demo = (CglibDemo) proxy.getProxy(CglibDemo.class);
        demo.say();
    }

}
