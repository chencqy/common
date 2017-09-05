package com.java.lintCode.linkedList.hasCycle;

/**
 * Created by Richard Chen on 17-9-5
 * description: 6.9 : 带环链表
 * 给定一个链表，判断它是否有环。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    /**
     * 思路：使用两个指针，初始时两个指针均指向链表头位置，然后一个指针每次走两步，一个指针每次走一步，
     * 如果在循环过程中遇到两个指针相等，则说明有循环返回true。如果出现一个指针无法继续往下走，则退出循环返回false。
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode low = head;
        ListNode high = head.next;
        while(high != null) {
            if(high.next == null) {
                return false;
            }
            if(low == high) {
                return true;
            }
            high = high.next.next;
            low = low.next;
        }
        return false;
    }
}
