package com.qin4zhang.demo.know.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author zhangzhen
 * @date 2021/11/29 下午4:17
 **/
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 指定生成的代理类的父类
        enhancer.setSuperclass(clazz);
        // 设置Callback对象
        enhancer.setCallback(this);
        // 通过ASM字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置处理");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置处理");
        return result;
    }
}
