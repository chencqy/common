package randomListNodeClone;

/**
 * Created by Chen on 17-8-7
 * 24.输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCur != null) {
            RandomListNode node = new RandomListNode(pHead.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        //复制原链表的random
        // pCur.random是原来链表的结点的random，其next是复制过后的random
        // pCur.next.random是复制pCur的结点的random
        while (pCur != null) {
            if (pCur.random != null) {
                pCur.next.random = pCur.random.next;
            }
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        //把链表拆分为两个链表，返回复制后的链表
        while (pCur != null) {
            pCur.next = pCur.next.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }
}
