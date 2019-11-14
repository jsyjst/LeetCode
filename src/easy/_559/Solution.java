package easy._559;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/14
 *     desc   : 给定一个 N 叉树，找到其最大深度。
 *     最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * </pre>
 */
public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    //递归
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int res = 0;
        for (int i = 0; i < root.children.size(); i++) {
            res = Math.max(maxDepth(root.children.get(i)),res);
        }
        return res+1;
    }
    //层次遍历
    public int maxDepthBFS(Node root) {
        if(root == null) return 0;
        int res = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            res++;
            for (int i = 0; i <size ; i++) {
                Node cur  =queue.remove();
                if(cur!=null) queue.addAll(cur.children);
            }
        }
        return res;
    }
}
