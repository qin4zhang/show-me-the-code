package com.qin4zhang.demo;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * TODO
 *
 * @author zhangzhen
 * @date 2021/12/16 上午11:01
 **/
public class ClassLoggerTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("类名： " + className);
        return classfileBuffer;
    }
}
