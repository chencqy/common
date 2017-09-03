package com.java.lintCode.greedyAlgorithm.DeleteDigits;

import java.util.Stack;

/**
 * Created by Richard Chen on 17-9-3
 * description: 5.5 : 删除数字
 * 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。

 找到删除 k 个数字之后的最小正整数。

 N <= 240, k <= N
 */
public class Solution {
    public String DeleteDigits(String A, int k) {
        int len = A.length();
        if(k==len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<A.length()){
            while(k>0 && !stack.isEmpty() && stack.peek()>A.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(A.charAt(i));
            i++;
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
