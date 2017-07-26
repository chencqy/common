package findKthToTail;

import java.util.List;

/**
 * Created by dell on 2017/7/26.
 * 13.输入一个链表，输出该链表中倒数第k个结点。
 * 代码的鲁棒性非常重要，要考虑到所有可能的情况。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthTOTail(ListNode head, int k){
        ListNode pre = head;
        ListNode last = head;
        if (head == null || k <= 0){//如果链表为空或者k小于等于0
            return null;
        }
        for (int i = 1; i < k; i++) {
            if (pre.next != null){
                pre = pre.next;
            }else {
                return null;
            }
        }
        while (pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
