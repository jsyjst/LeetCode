package medium._086;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/27
 *     desc   : 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *              你应当保留两个分区中每个节点的初始相对位置。
 * </pre>
 */
public class Solution {
    /**
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode headNew = new ListNode(-1);
        headNew.next = head;//用来解决头节点为大于或等于x的情况
        ListNode p, p1, p2;
        p1 = headNew;
        p = head;
        if (p.val < x) { //如果大于等于x的节点不是头节点
            while (p.next != null && p.next.val < x) p = p.next; // 找到第一个大于或等于x的节点的前一个节点
            p1 = p;
        }
        while (p.next != null) {
            if (p.next.val < x) {
                p2 = p.next;
                p.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2;
            } else {
                p = p.next;
            }
        }
        return headNew.next;
    }
    /**
     * 优化，用两个链表来存储，一个链表放小于x的节点，另外一个链表放大于等于x的节点，最后连接
     */
    public ListNode partitionBetter(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode after = new ListNode(-1);
        ListNode before = new ListNode(-1);
        ListNode p1,p2;
        p1 = before;p2 = after;
        while (head!=null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = after.next;
        p2.next = null;
        return before.next;
    }
}
