package easy._783;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/06
 *     desc   :
 * </pre>
 */
public class Solution {
    private int res = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(pre != null){
            res = Math.min(res,root.val-pre.val);
        }
        pre = root;
        helper(root.right);
    }
}
