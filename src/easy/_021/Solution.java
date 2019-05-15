package easy._021;

import common.ListNode;

import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/15
 *     desc   : 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * </pre>
 */
public class Solution {
    /**
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (l1 != null && l2!=null){
            if(l1.val<l2.val){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            node.next = l1;
        }else if(l2!=null){
            node.next = l2;
        }
        return result.next;
    }
}
