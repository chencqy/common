package com.java.lintCode.greedyAlgorithm.largestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Richard Chen on 17-9-2
 * description: 5.4 : 最大数
 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。
 */
public class Solution {
    /**
     * 修改排序规则即可
     */
    public String largestNumber(int[] nums) {
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        if(str[len - 1].equals("0")) {
            return "0";
        }
        for (int i = len - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
