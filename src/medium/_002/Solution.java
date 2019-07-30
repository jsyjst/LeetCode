package medium._002;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/03/27
 *     desc   : 给出两个 非空 的链表用来表示两个非负的整数。
 *              其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *              如果，我们将这两个数相加起来则会返回一个新的链表来表示它们的和。
 *              您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *              示例：
 *                   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *                  输出：7 -> 0 -> 8
 *                 原因：342 + 465 = 807
 * </pre>
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        ListNode L = Solution.addTwoNumbers(l1,l2);
        while (L!=null){
            System.out.println(L.val);
            L = L.next;
        }

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val)%10);
        int carry =0;
        ListNode head;
        head = result;
        while (l1.next != null && l2.next != null) {
            if(l1.val + l2.val + carry>= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            result.next = new ListNode((l1.next.val + l2.next.val+ carry)%10);
            l1 = l1.next;l2 = l2.next;result = result.next;
        }
        if(l1.val + l2.val +carry >= 10) {
            carry = 1;
        } else {
            carry = 0;
        }
        while (l2.next != null) {
            result.next = new ListNode((l2.next.val+carry)%10);
            l2 = l2.next;
            if(l2.val+carry>=10){
                carry = 1;
            }else{
                carry = 0;
            }
            result = result.next;
        }
        while (l1.next != null) {
            result.next = new ListNode((l1.next.val+carry)%10);
            l1 = l1.next;
            if(l1.val+carry>=10){
                carry = 1;
            }else{
                carry = 0;
            }
            result = result.next;
        }
        if(l1.next==null&&l2.next==null&& carry==1) {
            result.next= new ListNode(1);
        }
        return head;
    }
}
