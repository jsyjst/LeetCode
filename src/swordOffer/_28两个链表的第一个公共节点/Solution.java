package swordOffer._28两个链表的第一个公共节点;

import common.list.ListNode;

import java.util.HashSet;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/15
 *     desc   : 输入两个链表，找出它们的第一个公共结点。
 * </pre>
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = pHead1;
        while(p != null){
            set.add(p);
            p = p.next;
        }
        p = pHead2;
        while(p != null) {
            if(set.contains(p)) return p;
            p = p.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNodeBetter(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
