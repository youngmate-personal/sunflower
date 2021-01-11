package com.youngmate.singleton;

/**
 * lazy loading（懒汉式加载） 注意多线程高并发时带来的安全问题
 * 
 * @author ZhaoYanqi
 * @date 2021/1/10
 */
public class Singleton2 {
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return Singleton2Holder.INSTANCE;
    }

    /** 静态内部类，（加载机制？） */
    private static class Singleton2Holder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
}
