package easy._543;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/25
 *     desc   : 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * </pre>
 */
public class Solution {
    /**
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     *       返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *       注意：两结点之间的路径长度是以它们之间边的数目表示。
     */
    private int maxD;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxD;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        maxD = Math.max(left + right,maxD);
        return Math.max(left,right)+1;
    }
}
