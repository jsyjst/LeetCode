package medium._114;

import common.TreeNode;

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
    TreeNode cur = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(cur != null){
            cur.left = null;
            cur.right = root;
        }
        cur = root;
        TreeNode copyRight = root.right;
        flatten(root.left);
        flatten(copyRight);
    }
}
