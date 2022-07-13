package 链表.easy._876;

import common.list.ListNode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 0; i < 4; i++) {
            p.next = new ListNode(i + 2);
            p = p.next;
        }
        ListNode res = middleNode(head);
        System.out.println(res.val);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, low = head;
        while(fast != null && fast.next != null) {
            fast =  fast.next.next;
            low = low.next;
        }
        return low;
    }
}
