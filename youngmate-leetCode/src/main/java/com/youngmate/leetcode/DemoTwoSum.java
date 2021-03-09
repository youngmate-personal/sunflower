package com.youngmate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoYanqi
 * @date 2021/3/9 0009
 */
public class DemoTwoSum {

    /**
     * 求两个数之和,每次输入只对应一个答案，数组中的元素只能使用一次
     *
     * @param nums
     *            给定的数组
     * @param target
     *            目标值
     * @return 数组中两个相加为target的元素位置
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
