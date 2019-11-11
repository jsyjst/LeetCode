package easy._530;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/11
 *     desc   : 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * </pre>
 */
public class Solution {
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return res;
    }
    //中序遍历
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(pre!=null){
            res = Math.min(root.val-pre.val,res);
        }
        pre = root;
        helper(root.right);
    }
}
