package com.java.jianzhioffer.reverseSentence;

/**
 * Created by Richard Chen on 17-8-20
 * description: 42.翻转单词顺序：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 *                 标点符号和普通字母一样处理。
 */
public class Solution {
    /**
     * 先翻转整个句子，然后，依次翻转每个单词。
       依据空格来确定单词的起始和终止位置
     */
    public String ReverseSentence(String str) {
        if (str == "" || str == null) {
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = 0;
        int nextBlank;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                nextBlank = i;
                reverse(chars, blank, nextBlank - 1);
                blank = nextBlank + 1;
            }
        }
        //因为最后一个单词后面没有空格了，所以得单独翻转最后一个单词
        reverse(chars, blank, chars.length - 1);
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
