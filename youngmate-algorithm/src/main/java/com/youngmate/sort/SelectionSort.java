package com.youngmate.sort;

import java.util.Arrays;

/**
 * 选择排序，时间复杂度:O(N²)；额外空间复杂度为O(1)；因为每次选择交换时可能会改变元素的顺序，所以选择排序时不稳定的
 * 
 * @author ZhaoYanqi
 * @date 2021/1/12 0012
 */
public class SelectionSort {

    /** 选择排序 */
    public static void selectionSort(int[] arr) {
        // 基本情况
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从第一个元素开始遍历，依次和后面的元素进行比较，记录最小元素的index,遍历完成后将后面最小元素与当前元素交换位置，
        // 当到达最后一个元素时不需要再进行比较
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 每次都和i后面的元素进行比较
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
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
        selectionSort(array);
        Arrays.sort(copyArray);
        if (!SortUtils.isEqual(array, copyArray)) {
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(copyArray));
        } else {
            System.out.println("Nice!");
        }
    }
}
