package com.youngmate.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZhaoYanqi
 * @date 2021/1/10
 */
public class LeetCodeDemo {
    /**
     * 求两个数之和,每次输入只对应一个答案，数组中的元素只能使用一次
     * 
     * @param nums
     *            给定的数组
     * @param target
     *            目标值
     * @return 数组中两个相加为target的元素位置
     */
    public static int[] getSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 11, 2, 15 };
        int[] res = getSum(nums, 17);
        System.out.println(Arrays.toString(res));
    }

}
