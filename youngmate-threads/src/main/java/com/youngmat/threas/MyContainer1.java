package com.youngmat.threas;

import java.util.LinkedList;

/**
 * 写一个固定量同步容器，拥有put和get方法，以及getCount方法， 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll方法实现
 * 
 * @author ZhaoYanqi
 * @date 2021/3/10 0010
 */
public class MyContainer1<T> {
    final private LinkedList<T> list = new LinkedList<T>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        // 思考，while可以被if取代吗？
        while (list.size() == MAX) {
            try {
                // 当容器满了就等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 添加元素
        list.add(t);
        ++count;
        // 添加完成，通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        while (list.size() == 0) {
            try {
                // 当容器为空时，停止消费
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 可消费，取出容器中的第一个元素
        T t = list.removeFirst();
        count--;
        // 消费完成，通知生产者线程进行生产
        this.notifyAll();
        return t;
    }

    public int getCount() {
        return this.count;
    }

}
