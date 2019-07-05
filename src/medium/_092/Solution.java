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
        int i = n-m;
        while (m>0) {
            m--;
            if(m == 1) pre = head;
            head = head.next;
        }
        ListNode p3 = pre.next;
        while (i-- > 0) {
            ListNode nextNode = head.next;
            nextNode.next = head;
            head = nextNode;
        }
        pre.next = 
        return headNew.next;
    }
}
