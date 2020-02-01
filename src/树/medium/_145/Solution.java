package 树.medium._145;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/17
 *     desc   : 给定一个二叉树，返回它的 后序 遍历。
 * </pre>
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res,root);
        return res;
    }
    private void helper(List<Integer> res,TreeNode root){
        if(root == null) return;
        helper(res,root.left);
        helper(res,root.right);
        res.add(root.val);
    }

    //栈
    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(0,node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        return res;
    }
}
