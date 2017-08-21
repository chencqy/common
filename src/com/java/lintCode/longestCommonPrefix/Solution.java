package com.java.lintCode.longestCommonPrefix;


/**
 * Created by Richard Chen on 17-8-21
 * description:1.6:最长公共前缀：给k个字符串，求出他们的最长公共前缀(LCP)
 *                 在 "ABCD" "ABEF" 和 "ACEF" 中,  LCP 为 "A"
                   在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"ABCD","ABEF","ACEF"}));
    }

    /**
     * 分治法
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
