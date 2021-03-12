package com.youngmat.threas;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author ZhaoYanqi
 * @date 2021/3/12 0012
 */
public class AlternateBlockingQueue {
    static ArrayBlockingQueue b1 = new ArrayBlockingQueue(1);
    static ArrayBlockingQueue b2 = new ArrayBlockingQueue(1);

    public static void main(String[] args) {
        char[] num = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : num) {
                System.out.print(c);
                try {
                    b1.put("ok");
                    b2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : letters) {
                try {
                    b1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(c);
                try {
                    b2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

    }
}
