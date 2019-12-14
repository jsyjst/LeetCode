package swordOffer._13合并两个排序的链表;

import common.list.ListNode;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/14
 *     desc   : 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * </pre>
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 != null) p.next = list1;
        if(list2 != null) p.next = list2;
        return head.next;
    }
}
