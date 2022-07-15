package 链表.easy._234;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/23
 *     desc   : 请判断一个链表是否为回文链表。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 1->2
     * 输出: false
     *
     * 输入: 1->2->2->1
     * 输出: true
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int len =1;
        ListNode p = head.next;
        while (p!=null){
            len++;
            p= p.next;
        }
        p = head;
        ListNode pre = null;
        int index = 1;
        while (index <= len/2){
            ListNode nextNode = p.next;
            p.next = pre;
            pre = p;
            p = nextNode;
            index++;
        }
        if(len%2 != 0) p = p.next;
        while (p != null&&pre!= null){
            if(pre.val != p.val) return false;
            pre = pre.next;
            p = p.next;
        }
        return true;
    }

    // 翻转后面的链表
    public boolean isPalindrome2(ListNode head) {
        if (head.next == null) return true;
        // 找到中点
        ListNode firstReversalNode = getFirstReversalNode(head);
        // 翻转链表
        ListNode reversalNode = reversal(firstReversalNode.next);
        ListNode p1 = head;
        ListNode p2 = reversalNode;
        while(p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表
        firstReversalNode.next = reversal(reversalNode);
        return true;
    }

    // 找到翻转的链表
    private ListNode getFirstReversalNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reversal(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}
