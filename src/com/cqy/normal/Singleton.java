package com.cqy.normal;

/**
 * Created by Richard Chen on 2017/7/21.
 * 双重检查加锁，来自Head first 设计模式之单例模式
 */
public class Singleton {

    //使用volatile关键字确保多个线程能够正确处理uniqueInstance变量
    //懒汉式
    private volatile static Singleton uniqueInstance;
    //饿汉式：private static Singleton uniqueInstance = new Singleton();

    public Singleton(){}

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
