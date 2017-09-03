package com.java.lintCode.linkedList.deleteDuplicates;

/**
 * Created by Richard Chen on 17-9-3
 * description: 6.3 : 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 */


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode node = head;
        ListNode pHead = new ListNode(-1);
        pHead.next = node;
        while(head != null && head.next != null) {
            if(head.val != head.next.val) {
                node.next = head.next;
                node = node.next;
            }
            head = head.next;
        }
        node.next = null;
        return pHead.next;
    }
}
