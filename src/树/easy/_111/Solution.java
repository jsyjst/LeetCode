package 树.easy._111;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/15
 *     desc   :给定一个二叉树，找出其最小深度。
 *     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *     说明: 叶子节点是指没有子节点的节点。
 * </pre>
 */
public class Solution {
    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最小深度  2.
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
