package com.qin4zhang.demo;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 */
public class Agent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("agent is working...");
        ClassLoggerTransformer loggerTransformer = new ClassLoggerTransformer();
        instrumentation.addTransformer(loggerTransformer);
    }

}
