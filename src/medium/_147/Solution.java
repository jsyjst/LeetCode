package medium._147;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/31
 *     desc   : 对链表进行插入排序。
 *     插入排序算法：
 *     插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     重复直到所有输入数据插入完为止。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode p;
        while (cur != null) {
            if (cur.val < pre.val) {
                p = dummy;
                while (p.next!=null&&p.next.val < cur.val) {
                    p = p.next;
                }
                pre.next =cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }

        }
        return dummy.next;

    }
}
