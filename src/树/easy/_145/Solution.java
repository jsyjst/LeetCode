package 树.easy._145;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
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
    // 1. 回溯算法
    List<Integer> res = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }

    // 2. 动态规划
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        res.addAll(postorderTraversal2(root.left));
        res.addAll(postorderTraversal2(root.right));
        res.add(root.val);
        return res;
    }

    //栈
    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}
