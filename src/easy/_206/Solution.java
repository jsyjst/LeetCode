package easy._206;

import common.ListNode;

import java.util.List;

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
}
