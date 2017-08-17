package com.java.jianzhioffer.printStackToHead;

import java.util.ArrayList;

/**
 * Created by Richard Chen on 2017/5/10.
 * 5：从尾到头打印链表（递归实现）
 */

class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

public class Solution {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 使用栈实现
     */
//    public ArrayList<Integer> printStackFromTailToHead(ListNode listNode){
//        Stack<Integer> stack = new Stack<>();
//        while(listNode != null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        while (!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;
//    }
}
