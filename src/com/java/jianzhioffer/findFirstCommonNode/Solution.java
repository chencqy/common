package com.java.jianzhioffer.findFirstCommonNode;

/**
 * Created by Richard Chen on 17-8-17
 * description: 37.两个链表的第一个公共结点
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
     （因为2个链表用公共的尾部）
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        if (len1 >= len2) {
            int current = len1 - len2;
            while (current > 0) {
                pHead1 = pHead1.next;
                current--;
            }
        }else if (len2 > len1) {
            int current = len2 -len1;
            while (current > 0) {
                pHead2 = pHead2.next;
                current--;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
    public static int getLength(ListNode pHead) {
        int length = 0;
        while (pHead != null) {
            length++;
            pHead = pHead.next;
        }
        return length;
    }
}

