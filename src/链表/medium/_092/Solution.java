package 链表.medium._092;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/05
 *     desc   : 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *              说明:
 *              1 ≤ m ≤ n ≤ 链表长度。
 * </pre>
 */
public class Solution {
    public static void main(String [] args){
        ListNode head = new ListNode(1);
        ListNode p1 = head;
        for (int i = 2; i <= 5; i++) {
            ListNode p = new ListNode(i);
            p1.next = p;
            p1 = p1.next;
        }

        System.out.println(reverseBetween(head,2,4));
        for (int i = 0; i < 5; i++) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    /**
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        /**
         * 每次遍历插入到头节点
         * 1->2->3->4->5
         * 1->3->2->4->5
         * 1->3->4->2->5
         */
        if(left == right) return head;
        // 因为链表头会被翻转，需要用到虚节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 1;
        // 先找到开始翻转的链表头的前一个节点
        while(i < left) {
            pre = pre.next;
            i++;
        }
        ListNode cur = pre.next;
        while(i < right) {
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
            i++;
        }
        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode pre = null;
        ListNode cur = head;
        int i = 1;
        // 先找到当前要翻转链表的起始点
        while(i < left) {
            pre = cur;
            cur = cur.next;
            i++;
        }
        ListNode firstNode = pre;
        // 找到最后面的节点
        ListNode secondNode = cur;
        while(i <= right) {
            secondNode = secondNode.next;
            i++;
        }
        pre = secondNode;
        // 进行翻转链表
        i = left;
        while(i <= right) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
            i++;
        }
        // 如果不是翻转第一个节点，则返回head
        if (firstNode != null) {
            firstNode.next = pre;
            return head;
        }
        return pre;
    }
}
