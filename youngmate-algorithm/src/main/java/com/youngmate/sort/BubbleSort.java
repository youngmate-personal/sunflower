package com.youngmate.sort;

import java.util.Arrays;

/**
 * @author ZhaoYanqi
 * @date 2021/1/28 0028
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        // 基本情况
        if (arr == null || arr.length < 2) {
            return;
        }
        // 每一次遍历结束后数组中最大的元素就会被放在参与当前比较元素的最后位置
        for (int e = arr.length - 1; e > 0; e--) {
            // 每个元素两两比较，将较大的元素放在后面，
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = SortUtils.generateRandomArray(30, 100);
        int[] copyArray = SortUtils.copyArray(array);
        bubbleSort(array);
        Arrays.sort(copyArray);
        if (!SortUtils.isEqual(array, copyArray)) {
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(copyArray));
        } else {
            System.out.println("Nice!");
        }
    }
}
