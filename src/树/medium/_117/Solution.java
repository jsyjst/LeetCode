package 树.medium._117;

import common.tree.Node;

import java.util.LinkedList;

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
        if(root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for(int i = 0; i < size; i++){
                Node cur = queue.remove();
                if(pre != null) pre.next = cur;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                pre = cur;
            }
        }
        return root;
    }

}
