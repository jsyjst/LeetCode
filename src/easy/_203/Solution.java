package easy._203;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/13
 *     desc   : 删除链表中等于给定值 val 的所有节点。
 */
public class Solution {
    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode headNew = new ListNode(0);
        headNew.next = head;
        ListNode cur = head;
        ListNode pre = headNew;
        while (cur !=null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return headNew.next;
    }
}
