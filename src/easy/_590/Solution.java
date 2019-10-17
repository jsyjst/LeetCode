package easy._590;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/17
 *     desc   : 给定一个 N 叉树，返回其节点值的后序遍历。
 * </pre>
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root,List<Integer> res){
        if(root == null) return;
        for(Node node:root.children){
            helper(node,res);
        }
        res.add(root.val);
    }

    //栈
    public List<Integer> postorderStack(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(0,node.val);
            for(Node n:node.children){
                stack.push(n);
            }
        }
        return res;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
