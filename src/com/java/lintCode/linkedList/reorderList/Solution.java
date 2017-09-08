package com.java.lintCode.linkedList.reorderList;

/**
 * Created by Richard Chen on 17-9-8
 * description: 6.10 : 重排链表
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,

 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…

 必须在不改变节点值的情况下进行原地操作。
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
     * 分三步走，第一步，将链表一分为二，用到快慢指针；
     *           第二步，反转第二部分，反转链表是很重要的根基；
     *           第三步，将两链表接起来。
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while(preCurrent.next != null){
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        p1 = head;
        p2 = preMiddle.next;
        while(p1 != preMiddle){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}
