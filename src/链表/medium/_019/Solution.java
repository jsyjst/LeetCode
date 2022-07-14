package 链表.medium._019;

import common.list.ListNode;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/15
 *     desc   : 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *              说明：给定的 n 保证是有效的。
 *              进阶：你能尝试使用一趟扫描实现吗？
 * </pre>
 */
public class Solution {
    /**
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode node = head;
        int k =1;
        //将结点和位置放到map中
        while (node!=null){
            map.put(k++,node);
            node = node.next;
        }
        k--;
        if(k==n){//如果删除的是第一个结点
            return head.next;
        }else if(n==1){//如果删除的是最后一个结点
            node = map.get(k-1);
            node.next = null;
        }else {//其他情况
            node = map.get(k-n);
            node.next = node.next.next;
        }
        return head;
    }

    /***
     * 通过虚拟头处理头节点被移除的情况，然后一次遍历找到倒数第n+1个节点进行移除倒数第n个节点的操作
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 使用虚拟头处理倒数第n个节点被移除的情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 由于要移除倒数第n个节点，所以要找到倒数第n+1个节点的位置
        ListNode p = findFromEnd(dummy, n + 1);
        p.next = p.next.next;
        return dummy.next;
    }

    /**
     * 返回倒数第K个节点
     * 设链表总共有n个节点，先让p1走k步，则剩下n-k;
     * 然后p2开始跟p1一起走，则p2走了n-k步，刚好到达n-k+1个节点，也就是倒数第k个节点
     */
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        // 先让p1走k步, 则剩下 n-k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // p1走到尾走了n-k步，因此p2也走了n-k步，刚好到达n-k+1个节点，也就是倒数第K个节点
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
