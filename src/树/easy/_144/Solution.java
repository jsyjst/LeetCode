package 树.easy._144;

import common.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/***
 * 144.二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class Solution {

    // 1. 回溯算法，通过遍历一次解决问题
    List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }
    // 前序遍历
    public void traversal(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }

    // 动态规划算法：
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
        res.add(root.val);
        res.addAll(preorderTraversal2(root.left));
        res.addAll(preorderTraversal2(root.right));
        return res;
    }

    // 迭代算法：
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
