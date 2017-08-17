package com.java.jianzhioffer.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by dell on 2017/8/9.
 * 26.输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 */


public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }

    void fun(HashSet<String> re, char[] str, int k) {
        if (k == str.length) {
            re.add(new String(str));
            return;
        }
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            swap(str, i, k);
        }
    }

    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
