package medium._138;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/29
 *     desc   : 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *     要求返回这个链表的深拷贝。
 * </pre>
 */
public class Solution {
    /**
     * 输入：
     * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
     *
     * 解释：
     * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
     * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
     */
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    // 使用hash存储原结点和克隆结点的映射关系，通过映射关系处理克隆结点的random指针
    public Node copyRandomList(Node head) {
        if(head == null)  return head;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while (cur!=null){
            Node clone = new Node(cur.val,null,null);
            map.put(cur,clone);
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
