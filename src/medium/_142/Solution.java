package medium._142;

import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/30
 *     desc   : 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *     说明：不允许修改给定的链表。
 * </pre>
 */
public class Solution {
    /**
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if(set.contains(cur)) return cur;
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
