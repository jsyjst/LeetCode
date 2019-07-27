package easy._206;

import common.tree.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/05
 *     desc   :
 * </pre>
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!= null){
            ListNode nextNode = cur.next; //记录下一个节点
            cur.next = pre;   //指向上一个结点
            pre = cur;   //移动
            cur = nextNode;
        }
        return pre;
    }

    /**
     * 插入法
     * @param head
     * @return
     */
    public ListNode reverseListMine(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode headNew = new ListNode(-1);
        headNew.next = head;
        ListNode start = headNew.next;
        ListNode tail = start.next;
        while (tail!=null){
            start.next = tail.next;
            tail.next = headNew.next;
            headNew.next = tail;
            tail = start.next;
        }
        return headNew.next;
    }
}
