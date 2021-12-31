package com.qin4zhang.demo.know.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK的动态代理
 *
 * @author zhangzhen
 * @date 2021/11/29 下午2:37
 **/
public class DemoInvokerHandler implements InvocationHandler {

    private Object target;

    public DemoInvokerHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long time = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long t = System.currentTimeMillis() - time;
        System.out.println(String.format("耗时： %s ms", t));
        return result;
    }

    public Object getProxy() {
        // 创建代理对象
        return Proxy.newProxyInstance(Thread.currentThread()
                        .getContextClassLoader(),
                target.getClass().getInterfaces(), this);

    }
}
