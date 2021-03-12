package com.youngmat.threas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhaoYanqi
 * @date 2021/3/12 0012
 */
public class AlternatePrintReentrantLock {

    public static void main(String[] args) {

        char[] num = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : num) {
                    System.out.print(c);
                    c2.signalAll();
                    c1.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : letters) {
                    System.out.print(c);
                    c1.signalAll();
                    c2.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

    }
}
