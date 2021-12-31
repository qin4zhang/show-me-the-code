package com.qin4zhang.demo.know.thread;

/**
 * 线程变量和有继承关系的线程变量
 *
 * @author zhangzhen
 * @date 2021/12/20 上午10:23
 **/
public class ThreadLocalDemo {

//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("main thread.");
        System.out.println(threadLocal.get());
        // 新建线程，这一步是关键，这里会将父线程的数据赋值给子线程，从而达到线程间数据的传递。
        Thread thread = new Thread(() -> {
            System.out.println(threadLocal.get());
        });
        thread.start();
    }
}
