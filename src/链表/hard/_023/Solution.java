package 链表.hard._023;

import common.list.ListNode;

import java.util.PriorityQueue;

/**
 *
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode pre = new ListNode(-1);
        // 优先级队列，默认为小顶堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        // 将每个链表到头节点放入到优先级队列中
        for(ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        ListNode p = pre;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return pre.next;
    }
}
