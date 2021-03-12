package com.youngmat.threas;

/**
 * @author ZhaoYanqi
 * @date 2021/3/12 0012
 */
public class AlternatePrintSyncWaitNotify {

    public static void main(String[] args) {
        final Object o = new Object();

        char[] num = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();
        new Thread(() -> {
            synchronized (o) {
                for (char c : num) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();// 让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();// 必须，否则无法停止程序
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : letters) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();

    }
}
