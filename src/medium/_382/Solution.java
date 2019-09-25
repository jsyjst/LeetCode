package medium._382;

import common.list.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/25
 *     desc   : 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *     进阶: 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * </pre>
 */
public class Solution {
    /**
     * // 初始化一个单链表 [1,2,3].
     * ListNode head = new ListNode(1);
     * head.next = new ListNode(2);
     * head.next.next = new ListNode(3);
     * Solution solution = new Solution(head);
     * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
     * solution.getRandom();
     */
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */

    private List<ListNode> nodeList;
    public Solution(ListNode head) {
        nodeList = new ArrayList<>();
        ListNode p = head;
        while (p!=null){
            nodeList.add(p);
            p = p.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return nodeList.get(new Random().nextInt(nodeList.size())).val;
    }
}
