package com.java.lintCode.linkedList.sortedListToBST;

/**
 * Created by Richard Chen on 17-9-7
 * description: 6.7 : 排序列表转换为二分查找树
 * 给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {
    /**
     * 设置两个指针slow和fast，我们令这两个指针一开始都指向链表的头结点--head，
     * 然后slow每次指向链表的下一位（就是它现在所指向的节点的next），
     * 而fast每次指向他的下一位的下一位（也就是每次向后移动两个节点），
     * 那当fast指向尾节点的时候，slow指向的刚好是中间节点。
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode slow = pHead;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        ListNode high = slow.next.next;
        slow.next = null;
        ListNode low = pHead.next;
        root.left = sortedListToBST(low);
        root.right = sortedListToBST(high);
        return root;
    }
}
