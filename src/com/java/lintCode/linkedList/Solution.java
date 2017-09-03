package com.java.lintCode.linkedList;

/**
 * Created by Richard Chen on 17-9-3
 * description: 6.1 : 删除链表中倒数第n个节点
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
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
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode pre = head;
        ListNode last = head;
        if (head == null || n <= 0){
            return null;
        }
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        if(pre == null) {
            head = head.next;
            return head;
        }
        while(pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        last.next = last.next.next;

        return head;
    }
}
