package com.java.jianzhioffer.firstNotRepeatingChar;

import java.util.HashMap;

/**
 * Created by Richard Chen on 17-8-16
 * description: 35.在一个字符串(全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        /**
         * 先在hash表中统计各字母出现次数，第二次扫描直接访问hash表获得次数
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int length = str.length();
        if (length == 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
