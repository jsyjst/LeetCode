package 树.medium._114;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/17
 *     desc   : 给定一个二叉树，原地将它展开为链表。
 * </pre>
 */
public class Solution {
    /**
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = null;
        root.right = leftNode;
        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }
        p.right = rightNode;
    }
}
