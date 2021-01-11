package com.youngmate.singleton;

/**
 * 单例模式1 饿汉式 类加载到内存后就实例化一个单例，JVM保证线程安全 简单实用，推荐实用 缺点：不管用到与否，类装载时就完成实例化
 *
 * @author ZhaoYanqi
 * @date 2021/1/10
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();;

    /** 单例需要将构造方法私有化 */
    private Singleton1() {
    }

    /** 开放公有方法获取本对象 */
    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton1 s1 = getInstance();
        Singleton1 s2 = getInstance();
        System.out.println(s1 == s2);
    }
}
