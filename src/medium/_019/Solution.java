package medium._019;

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
}
