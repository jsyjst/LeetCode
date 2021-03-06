package medium._430;

import javax.print.attribute.standard.NumberUp;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/18
 *     desc   : 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
 *     这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *     扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     *  1---2---3---4---5---6--NULL
     *          |
     *          7---8---9---10--NULL
     *              |
     *              11--12--NULL
     *
     * 输出:
     * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
     */

    //借助栈
    public Node flatten(Node head) {
        if(head == null) return head;
        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        //对于没有子节点的不需要做处理
        while (true){
             if(cur.child!= null){
                 //将有子结点的next压入栈
                 if(cur.next!=null) stack.push(cur.next);
                 //扁平化
                 cur.next = cur.child;
                 cur.child.prev = cur;
                 cur.child = null;
             }else {
                 //有可能是下一个结点或是栈弹出的next结点
                if(cur.next!=null){
                    cur = cur.next;
                }else if(!stack.isEmpty()){
                    Node node = stack.pop();
                    cur.next = node;
                    node.prev = cur;
                    cur = cur.next;
                }else {
                    return head;
                }
             }
        }
    }



    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
