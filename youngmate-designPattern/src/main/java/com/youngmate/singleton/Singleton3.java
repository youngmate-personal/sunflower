package com.youngmate.singleton;

/**
 * 枚举单例
 * 
 * 枚举类没有构造方法，所以不能被序列化
 * 
 * @author ZhaoYanqi
 * @date 2021/1/10
 */
public enum Singleton3 {
    /** instance */
    INSTANCE;

    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.INSTANCE;
        Singleton3 s2 = Singleton3.INSTANCE;
        System.out.println(s1 == s2);

    }
}
