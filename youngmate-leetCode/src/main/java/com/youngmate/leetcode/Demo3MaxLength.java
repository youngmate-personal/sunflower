package com.youngmate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * @author ZhaoYanqi
 * @date 2021/3/10 0010
 */
public class Demo3MaxLength {
    public static int getMaxLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (int start = 0, end = 0; end < s.length(); end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(map.get(element) + 1, start);
            }
            maxLength = Math.max((end - start + 1), maxLength);
            map.put(element, end);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "google";
        int maxLength = getMaxLength(str);
        System.out.println(maxLength);
    }

}
