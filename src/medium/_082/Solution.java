package medium._082;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/24
 *     desc   :给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode head1 = new ListNode(-1);
        ListNode p= head.next,p1= head,p2 = head1;
        if(p.val!=head.val) {
            p2.next = head;
            p2 = p2.next;
        }
        while (p.next!=null){
            if(p.val != p1.val&&p.val!=p.next.val){
                p1 = p;
                p2.next = p;
                p2 = p2.next;
            }else if(p.val == p.next.val){
                p1 = p;
            }
            p = p.next;
        }
        if(p.val!= p1.val){
            p2.next = p;
            p2 = p2.next;
        }
        p2.next = null;
        return head1.next;
    }

    /**
     * 优化
     *
     */
    public ListNode deleteDuplicatesBetter(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode headNew = new ListNode(-1);
        headNew.next = head;
        ListNode fast = headNew.next;
        ListNode slow = headNew;
        while (fast!=null){
            while (fast.next!=null&&fast.val == fast.next.val) fast = fast.next;
            if(slow.next == fast){
                slow = slow.next;
            }else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return headNew.next;
    }
}
