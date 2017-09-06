package com.java.lintCode.linkedList.copyRandomList;

/**
 * Created by Richard Chen on 17-9-6
 * description: 6.8 : 复制带随机指针的链表
 * 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。

 返回一个深拷贝的链表。
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode rHead = head;
        while(rHead != null) {
            RandomListNode cHead = new RandomListNode(rHead.label);
            RandomListNode next = rHead.next;
            cHead.random = null;
            rHead.next = cHead;
            cHead.next = next;
            rHead = next;
        }
        rHead = head;
        while(rHead != null) {
            if(rHead.random != null) {
                rHead.next.random = rHead.random.next;
            }
            rHead = rHead.next.next;
        }
        rHead = head;
        RandomListNode pHead = head.next;
        RandomListNode nHead = pHead;
        while(rHead != null) {
            RandomListNode next = rHead.next.next;
            if(nHead.next != null) {
                nHead.next = next.next;
                nHead = next.next;
            }
            rHead.next = next;
            rHead = next;
        }
        return pHead;
    }
}
