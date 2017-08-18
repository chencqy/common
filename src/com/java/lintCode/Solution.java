package com.java.lintCode;

/**
 * Created by Richard Chen on 17-8-18
 * description: 1.两个字符串是变位词
 * 写出一个函数 anagram(s, t) 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串。
 */
public class Solution {
    public boolean anagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if(count[(int) t.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
