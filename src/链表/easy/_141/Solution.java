package 链表.easy._141;

import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/30
 *     desc   : 给定一个链表，判断链表中是否有环。
 *     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * </pre>
 */
public class Solution {
    /**
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null){
            if(set.contains(cur)) return true;
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }
    //快慢指针法
    public boolean hasCycleBest(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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
