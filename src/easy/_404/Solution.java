package easy._404;

import common.tree.TreeNode;

import java.util.LinkedList;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/08
 *     desc   : 计算给定二叉树的所有左叶子之和。
 * </pre>
 */
public class Solution {
    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     */

    //层次遍历，队列实现
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null) {
                    if(node.left.left == null&&node.left.right == null) sum += node.left.val;
                    queue.offer(node.left);
                }
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return sum;
    }

    //递归实现
    private int res = 0;
    public int sumOfLeftLeavesDfs(TreeNode root){
        helper(root,null);
        return res;
    }

    private void helper(TreeNode root,TreeNode pre){
        if(root == null) return;
        if(root.left == null&&root.right == null&&pre!=null&&pre.left == root){
            res+=root.val;
        }
        helper(root.left,root);
        helper(root.right,root);
    }
}
