package medium._117;

import common.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/19
 *     desc   : 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *     初始状态下，所有 next 指针都被设置为 NULL。
 * </pre>
 */
public class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if(cur.right !=null) queue.offer(cur.right);
                if(cur.left != null)  queue.offer(cur.left);
                cur.next = pre;
                pre = cur;
            }
        }
        return root;
    }

}
