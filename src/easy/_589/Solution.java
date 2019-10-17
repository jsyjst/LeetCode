package easy._589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/17
 *     desc   : 给定一个 N 叉树，返回其节点值的前序遍历。
 * </pre>
 */
public class Solution {

    //递归法
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root,List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        for(Node node:root.children){
            helper(node,res);
        }
    }



    //迭代法，栈辅助空间
    public List<Integer> preorderStack(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            //从右往左压入栈
            for (int i = node.children.size()-1; i >=0 ; i--) {
                stack.push(node.children.get(i));
            }
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
