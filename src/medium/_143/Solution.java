package medium._143;

import common.list.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/30
 *     desc   : 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *     将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * </pre>
 */
public class Solution {
    /**
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * <p>
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            map.put(len++, cur);
            cur = cur.next;
        }
        cur = head;
        for (int j = len - 1; j >= len / 2; j--) {
            ListNode last = map.get(j);
            if(cur == last) {
                cur.next = null;
                return;
            }
            if (last == cur.next) {
                last.next = null;
            } else {
                last.next = cur.next;
            }
            cur.next = last;
            cur = last.next;
        }
    }

    //队列
    public void reorderListByQueue(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null){
            queue.offer(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()){
            if(cur == null){
                cur = queue.pollFirst();
            }else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if(cur !=null) cur.next = null;
    }
}
