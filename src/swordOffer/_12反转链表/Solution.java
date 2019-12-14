package swordOffer._12反转链表;

import common.list.ListNode;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/14
 *     desc   : 输入一个链表，反转链表后，输出新链表的表头。
 * </pre>
 */
public class Solution {

    //头插法
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = new ListNode(0);
        while(head != null){
            ListNode p = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = p;
        }
        return newHead.next;
    }

    //原地翻转
    public ListNode ReverseListOther(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
