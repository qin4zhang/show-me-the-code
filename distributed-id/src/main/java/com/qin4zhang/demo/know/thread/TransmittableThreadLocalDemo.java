package com.qin4zhang.demo.know.thread;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 在线程池中，线程间的数据传递方案
 * <p>
 * 线程池中的线程不需要新建，此时JDk的InheritableThreadLocal方式无法使用。
 * <p>
 * 对于线程池，应该是将任务提交给线程池的时候，进行线程间数据的传递。
 * <p>
 * ThreadLocal的需求场景即TransmittableThreadLocal的潜在需求场景，如果你的业务需要『在使用线程池等会池化复用线程的执行组件情况下传递ThreadLocal值』则是TransmittableThreadLocal目标场景。
 * <p>
 * 1. 分布式跟踪系统
 * <p>
 * 2. 日志收集记录系统上下文
 * <p>
 * 3. 应用容器或上层框架跨应用代码给下层SDK传递信息
 * <p>
 * https://github.com/alibaba/transmittable-thread-local
 *
 * @author zhangzhen
 * @date 2021/12/20 上午10:23
 **/
public class TransmittableThreadLocalDemo {

    private static final ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("main thread.");
        System.out.println(threadLocal.get());
        Thread thread = new Thread(() -> {
            System.out.println(threadLocal.get());
        });
        thread.start();
    }
}
