package com.youngmate.algorithm;

import java.util.LinkedList;

/**
 * @author ZhaoYanqi
 * @date 2021/1/9
 */
public class LinkedListDemo {

    /**
     * 窗口最大值问题(双端队列)
     *
     * @param arr
     *            目标数组
     * @param w
     *            窗口长度
     * @return 窗口划过数组过程中的最大值
     */
    public static int[] getWindowMaxArr(int[] arr, int w) {
        // 处理无结果的情况
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        // 创建一个双端队列，存放数组元素的位置，顺序头（大->小）尾
        LinkedList<Integer> qMax = new LinkedList<Integer>();

        int[] result = new int[arr.length - w + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // 模拟窗口移动，将窗口中出现的值放在比它大的数后面，队列为空时可直接放入
            while (!qMax.isEmpty() && arr[qMax.getLast()] <= arr[i]) {
                qMax.removeLast();
            }
            qMax.addLast(i);

            // 当窗口未形成w之前不获取窗口中的最大值，窗口滑动时若队列中对应的最大值滑出窗口则弹出队列
            if (qMax.getFirst() == i - w) {
                qMax.removeFirst();
            }

            // 当窗口形成则开始向结果数组中放入最大值
            if (i >= w - 1) {
                result[index++] = arr[qMax.getFirst()];
            }

        }
        return result;
    }

    /**
     * 窗口最大值问题(双端队列)
     *
     * @param arr
     *            目标数组
     * @param w
     *            窗口长度
     * @return 窗口划过数组过程中的最大值
     */
    public static int[] getWindowMinArr(int[] arr, int w) {
        // 处理无结果的情况
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        // 创建一个双端队列，存放数组元素的位置，顺序头（小->大）尾
        LinkedList<Integer> qMin = new LinkedList<Integer>();

        int[] result = new int[arr.length - w + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // 模拟窗口移动，将窗口中出现的值放在比它小的数后面，队列为空时可直接放入
            while (!qMin.isEmpty() && arr[qMin.getLast()] >= arr[i]) {
                qMin.removeLast();
            }
            qMin.addLast(i);

            // 当窗口未形成w之前不获取窗口中的最小值，窗口滑动时若队列中对应的最小值滑出窗口则弹出队列
            if (qMin.getFirst() == i - w) {
                qMin.removeFirst();
            }

            // 当窗口形成则开始收集答案
            if (i >= w - 1) {
                result[index++] = arr[qMin.getFirst()];
            }

        }
        return result;
    }

}
