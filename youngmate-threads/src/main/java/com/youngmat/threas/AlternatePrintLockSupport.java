package com.youngmat.threas;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ZhaoYanqi
 * @date 2021/3/12 0012
 */
public class AlternatePrintLockSupport {
    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] num = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();
        t1 = new Thread(() -> {
            for (char c : num) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        }, "t1");

        t2 = new Thread(() -> {
            for (char c : letters) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
