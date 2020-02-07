package 树.easy._110;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/15
 *     desc   : 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *     本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * </pre>
 */
public class Solution {
    /**
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftNum = helper(root.left);
        if(leftNum == -1) return -1;
        int rightNum = helper(root.right);
        if(rightNum == -1) return -1;
        if(Math.abs(leftNum - rightNum) <= 1)
            return Math.max(leftNum,rightNum) + 1;
        else return -1;
    }
}
