package medium._148;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/01
 *     desc   : 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //快，慢指针找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null&&fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        //递归
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        //合并
        ListNode dummy = new ListNode(0);//辅助链表
        ListNode cur = dummy;
        while (left != null&& right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null?right:left;
        return dummy.next;
    }
}
