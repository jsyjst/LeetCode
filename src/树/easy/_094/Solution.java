package 树.easy._094;

import common.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/***
 * 94.二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 */
public class Solution {

    // 1. 回溯算法，通过遍历一次解决问题
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }
    // 中序遍历
    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }

    // 动态规划算法：
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 中序遍历结果特点：第一个是左子树，接着是，最后是右子树
        res.addAll(inorderTraversal2(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal2(root.right));
        return res;
    }

    // 迭代算法：
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}
