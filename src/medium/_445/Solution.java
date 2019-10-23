package medium._445;

import common.list.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/23
 *     desc   : 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 *     它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *     你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * </pre>
 */
public class Solution {
    /**
     * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出: 7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        l1 = reversal(l1);//进行翻转
        l2 = reversal(l2);//进行翻转
        int carry = 0;
        while (l1!=null||l2!=null){
            int num1 = l1 != null?l1.val:0;
            int num2 = l2 != null?l2.val:0;
            int num = (num1+num2+carry)%10;
            carry = (num1+num2+carry)/10;
            res.next = new ListNode(num);
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
            res = res.next;
        }
        res.next = carry == 1?new ListNode(1):null;
        return reversal(head.next);
    }

    private ListNode reversal(ListNode node){
        ListNode res = null;
        ListNode pre = null;
        while (node != null){
            ListNode next = node.next;
            if(next == null) res = node;
            node.next = pre;
            pre = node;
            node = next;
        }
        return res;
    }

    //栈
    public ListNode addTwoNumbersBetter(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        //将l1压入栈
        while (l1!=null){
            s1.push(l1);
            l1 = l1.next;
        }
        //将l2压入栈
        while (l2!=null){
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode pre = null;
        int carry = 0;
        while (!s1.isEmpty()||!s2.isEmpty()){
            int num1 = s1.isEmpty()?0:s1.pop().val;
            int num2 = s2.isEmpty()?0:s2.pop().val;
            ListNode  cur= new ListNode((num1+num2+carry)%10);
            carry = (num1+num2+carry)/10;
            cur.next = pre;
            pre = cur;
        }
        if(carry == 1){
            ListNode cur = new ListNode(1);
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
