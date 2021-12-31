package com.qin4zhang.demo.know.dynamicproxy.jdk;

/**
 * 启动类
 *
 * @author zhangzhen
 * @date 2021/11/29 下午2:43
 **/
public class Demo {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        DemoInvokerHandler handler = new DemoInvokerHandler(subject);
        Subject proxy = (Subject) handler.getProxy();
        System.out.println(proxy.say());
    }
}
