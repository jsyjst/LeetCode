package swordOffer._11链表中倒数第k个结点;

import common.list.ListNode;

import java.util.HashMap;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/14
 *     desc   : 输入一个链表，输出该链表中倒数第k个结点。
 * </pre>
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null) return null;
        HashMap<Integer,ListNode> map = new HashMap<>();
        int index = 0;
        while(head != null){
            map.put(++index,head);
            head = head.next;
        }
        return map.get(index-k+1);
    }

    //快慢指针法
    public ListNode FindKthToTailBetter(ListNode head, int k) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(fast != null){
            if(count >= k) slow = slow.next;
            fast = fast.next;
            count++;
        }
        return count >= k ? slow : null;
    }
}
