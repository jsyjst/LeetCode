package easy._429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/17
 *     desc   : 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *     例如，给定一个 3叉树 :
 * </pre>
 */

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if(null == root) return res;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lineRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                lineRes.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    queue.offer(node.children.get(j));
                }
            }
            res.add(lineRes);
        }
        return res;
    }



    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

