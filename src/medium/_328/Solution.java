package medium._328;

import common.list.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/11
 *     desc   : 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 *     请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *     请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数
 * </pre>
 */
public class Solution {
    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     *
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     *
     * 说明:应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode odd = new ListNode(head.val);
        ListNode even = new ListNode(head.next.val);
        int count = 3;
        ListNode oddNode = odd;
        ListNode evenNode = even;
        ListNode node = head.next.next;
        while (node!=null){
            if(count%2!=0){
                oddNode.next = node;
                oddNode = oddNode.next;
            }else {
                evenNode.next = node;
                evenNode = evenNode.next;
            }
            node = node.next;
            count++;
        }
        evenNode.next = null;
        oddNode.next = even;
        return odd;
    }
}
