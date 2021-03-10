package com.youngmate.binarysearch;

/**
 * @author ZhaoYanqi
 * @date 2021/3/9 0009
 */
public class DemoBinarySearch {

    public static int binarySearch(int[] sortedArr, int target) {
        // base case
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = sortedArr.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 6, 13, 16, 25, 32, 35, 39, 55, 61, 67, 70 };
        int search = binarySearch(arr, 25);
        System.out.println(search);
    }
}
