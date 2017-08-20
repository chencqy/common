package com.java.jianzhioffer.leftRotateString;

/**
 * Created by Richard Chen on 17-8-20
 * description: 42.左旋字符串：对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 *                 要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution {
    /**
     * 假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。
     * 假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果
     */
    public String LeftRotateString(String str,int n) {
        if(str == null || n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        if(n > 0 && n <= length ) {
            reverse(chars, 0, n - 1);
            reverse(chars, n, length - 1);
            reverse(chars, 0, length - 1);
        }
        return new String(chars);
    }
    private void reverse(char[] chars, int low, int high) {
        while (low < high) {
            for (int i = low; i < high; i++) {
                char temp = chars[high];
                chars[high] = chars[low];
                chars[low] = temp;
                low++;
                high--;
            }
        }
    }
}
