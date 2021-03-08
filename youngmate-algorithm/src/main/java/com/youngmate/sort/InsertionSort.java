package com.youngmate.sort;

import java.util.Arrays;

import com.youngmate.sort.util.SortUtils;

/**
 * @author ZhaoYanqi
 * @date 2021/2/3 0003
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // 基本情况
        if (arr == null || arr.length < 2) {
            return;
        }
        // 插入过程：默认第一个元素时有序的，从第二个元素开始遍历，和前面的元素依次进行比较，遇到小于前面元素则进行交换
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtils.generateRandomArray(30, 100);
        int[] copyArray = SortUtils.copyArray(array);
        insertionSort(array);
        Arrays.sort(copyArray);
        if (!SortUtils.isEqual(array, copyArray)) {
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(copyArray));
        } else {
            System.out.println("Nice!");
        }
    }

}
