package medium._082;

import common.ListNode;

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
        ListNode p = new ListNode(-1);
        p.next = head;
        boolean isHead = false;
        while (p.next!=null){
            
        }
    }
}
