package com.java.lintCode.linkedList.partition;

/**
 * Created by Richard Chen on 17-9-4
 * description: 6.4 : 链表划分
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。

 你应该保留两部分内链表节点原有的相对顺序。
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
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode p1 = node1;
        ListNode p2 = node2;
        while(head != null) {
            if(head.val < x) {
                p1 = p1.next = head;
            } else {
                p2 = p2.next = head;
            }
            head = head.next;
        }
        p1.next = node2.next;
        p2.next = null;
        return node1.next;
    }
}
