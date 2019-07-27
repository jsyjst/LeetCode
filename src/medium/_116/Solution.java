package medium._116;

import common.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/19
 *     desc   : 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *              struct Node {
 *                      int val;
 *                      Node *left;
 *                      Node *right;
 *                      Node *next;
 *                      }
 *              填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *              初始状态下，所有 next 指针都被设置为 NULL。
 * </pre>
 */
public class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node cur = queue.remove();
                if(cur.right != null){
                    queue.add(cur.right);
                    queue.add(cur.left);
                }
                cur.next = pre;
                pre = cur;
            }
        }
        return root;
    }
}
