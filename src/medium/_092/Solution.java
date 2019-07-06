package medium._092;

import common.ListNode;

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
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode headNew = new ListNode(-1);
        headNew.next = head;
        ListNode pre = headNew;
        //找到m的前一个结点，pre指向1
        for (int i = 0; i < m-1; i++)  pre = pre.next;
        ListNode start = pre.next;//指向2
        ListNode tail = start.next;//指向3
        for (int i = 0; i < n-m; i++) {
            start.next = tail.next;
            tail.next = pre.next;
            pre.next = tail;
            tail = start.next;
        }
        return headNew.next;
    }
}
