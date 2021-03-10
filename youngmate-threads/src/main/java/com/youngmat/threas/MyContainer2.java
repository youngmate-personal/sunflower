package com.youngmat.threas;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhaoYanqi
 * @date 2021/3/10 0010
 */
public class MyContainer2<T> {
    private final LinkedList<T> list = new LinkedList<T>();
    private int count = 0;

    private final Lock lock = new ReentrantLock();

    /** Condition 本质为等待队列 */
    private final Condition producer = lock.newCondition();
    private final Condition consumer = lock.newCondition();

    public void put(T t) {
        lock.lock();
        try {
            // 当容器满后生产者要停止生产
            int max = 10;
            while (list.size() == max) {
                producer.await();
            }
            list.add(t);
            ++count;
            // 生产完成后通知所有消费者线程进行消费
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        lock.lock();
        try {
            while (list.size() == 0) {
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public int getCount() {
        return this.count;
    }
}
