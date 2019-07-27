package easy._234;

import common.tree.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/23
 *     desc   : 请判断一个链表是否为回文链表。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 1->2
     * 输出: false
     *
     * 输入: 1->2->2->1
     * 输出: true
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int len =1;
        ListNode p = head.next;
        while (p!=null){
            len++;
            p= p.next;
        }
        p = head;
        ListNode pre = null;
        int index = 1;
        while (index <= len/2){
            ListNode nextNode = p.next;
            p.next = pre;
            pre = p;
            p = nextNode;
            index++;
        }
        if(len%2 != 0) p = p.next;
        while (p != null&&pre!= null){
            if(pre.val != p.val) return false;
            pre = pre.next;
            p = p.next;
        }
        return true;
    }
}
