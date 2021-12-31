package com.qin4zhang.demo.know.dynamicproxy.jdk;

/**
 * 接口实现类
 *
 * @author zhangzhen
 * @date 2021/11/29 下午2:36
 **/
public class RealSubject implements Subject {
    /**
     * say something
     *
     * @return
     */
    @Override
    public String say() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World";
    }
}
