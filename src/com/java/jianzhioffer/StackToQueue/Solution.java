package com.java.jianzhioffer.StackToQueue;

import java.util.Stack;

/**
 * Created by Richard Chen on 2017/5/15.
 * 7：用两个栈实现队列
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (stack1.empty() && stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
