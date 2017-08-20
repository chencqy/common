package com.java.lintCode.strStr;

/**
 * Created by Richard Chen on 17-8-20
 * description: 3.字符串查找
 *                问题描述：对于一个给定的 source 字符串和一个target字符串，
 *                你应该在source字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 */
public class Solution {
    /**
     * O(n∗m)时间复杂度：暴力匹配
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int n = source.length();
        int m = target.length();
        if (m == 0) {
            return 0;
        }
        int i, j;
        for (i = 0; i <= n - m; i++) {
            for (j = 0; j < m; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
