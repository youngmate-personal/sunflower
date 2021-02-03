package com.youngmate.sort.util;

import java.util.Arrays;

/**
 * @author ZhaoYanqi
 * @date 2021/1/28 0028
 */
public class SortUtils {
    /**
     * 数组生成器
     *
     * @param maxSize
     *            数组的最大长度
     * @param maxValue
     *            数组中的最大值
     * @return 随机正数数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 初始化一个长度在maxSize范围内随机长度的数组（默认情况长度最小为1）
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        // 补充数组中的元素
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 复制数组
     * 
     * @param arr
     *            需要被复制的数组
     * @return 元素值相同的不同内存地址的新数组
     */
    public static int[] copyArray(int[] arr) {
        // 基础校验
        if (arr == null) {
            return null;
        }
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    /**
     * 比较两个数组（元素）是否相同
     * 
     * @param arr1
     *            数组1
     * @param arr2
     *            数组2
     * @return true、相同；false、相同
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        // 处理基本情况，一个数组为空，另一个数组不为空，两个数组必不同
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        // 两个数组都为空时视为相同数组
        if (arr1 == null && arr2 == null) {
            return true;
        }
        // 两个数组的长度不同时必然不同
        if (arr1.length != arr2.length) {
            return false;
        }
        // 基本情况排除后的情况：两个数组不为空且长度相同，比较数组中各个位置的元素是否相同
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
