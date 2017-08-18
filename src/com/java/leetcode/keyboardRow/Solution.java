package com.java.leetcode.keyboardRow;

import java.util.*;

/**
 * Created by Richard Chen on 17-8-18
 * description:5.Given a List of words, return the words that can be typed using letters of alphabet
 *               on only one row's of American keyboard like the image below.
 */
public class Solution {
    /**
     * 给出一个单词列表，返回可以使用字母字母键入的单词，只能在美国键盘的一行
     * 将对应的行的字母存入map中，i=1则为第一行以此类推
     * 取出单词的第一个字母并判断处于哪一行，与之后的字母作比较如果i不相同则次单词不满足要求
     */
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> result = new LinkedList<>();
        for (String w : words) {
            if (w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for (char c: w.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                result.add(w);
            }
        }
        return result.toArray(new String[0]);
    }
}
