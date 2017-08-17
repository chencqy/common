package com.java.jianzhioffer.printMinNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Richard Chen on 17-8-14
 * description: 33.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *                 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        /**
          * 解题思路：
          * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
          * 排序规则如下：
          * 若ab > ba 则 a > b，
          * 若ab < ba 则 a < b，
          * 若ab = ba 则 a = b；
          * 解释说明：
          * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
         */
        if (numbers.length == 0 || numbers == null) {
            return "";
        }
        int length = numbers.length;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
