package easy._083;

import common.tree.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/24
 *     desc   : 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 1->1->2
     * 输出: 1->2
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode p=head.next,p1  = head;
        while (p.next!=null){
            if(p.val != p1.val){
                p1.next = p;
                p1 = p1.next;
            }
            p = p.next;
        }
        if(p.val != p1.val) {
            p1.next = p;
            p1.next.next = null;
        }else {
            p1.next = null;
        }
        return head;
    }
    //优化代码
    public ListNode deleteDuplicatesBetter(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode p=head;
        while (p.next!=null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }

}
