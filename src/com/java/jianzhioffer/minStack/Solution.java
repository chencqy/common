package com.java.jianzhioffer.minStack;

import java.util.Stack;

/**
 * Created by dell on 2017/8/2.
 * 19.定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 * 利用一个辅助栈来存放最小值,push之前把辅助栈顶元素与入栈元素比较，小的入栈
 */
public class Solution {
    Stack data = new Stack();
    Stack min  = new Stack();
    public void push(int node) {
        data.push(node);
        if(min.empty() || node <= (int)min.peek()){
            min.push(node);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return (int)data.peek();
    }

    public int min() {
        return (int)min.peek();
    }
}
