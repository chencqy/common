package com.java.lintCode.linkedList.rotateRight;

/**
 * Created by Richard Chen on 17-9-6
 * description: 6.6 :  旋转链表
 * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        if(k == 0) {
            return head;
        }

        ListNode node = head;
        ListNode pHead = head;
        for(int i = 0; i < k; i++) {
            if(node.next != null) {
                node = node.next;
            } else if(node.next == null) {
                node = head;
            }
        }

        while(node.next != null) {
            node = node.next;
            pHead = pHead.next;
        }

        ListNode newHead = head;
        if(pHead.next != null) {
            newHead = pHead.next;
        }
        node.next = head;
        pHead.next = null;
        return newHead;
    }
}
