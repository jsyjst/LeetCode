package easy._671;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/23
 *     desc   :
 * </pre>
 */
public class Solution {
    private int min ;
    private int res = Integer.MAX_VALUE;
    private boolean hasMin2 = false;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        min = root.val;
        helper(root);
        return hasMin2?res:-1;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        if(min!=root.val) {
            hasMin2 = true;
            res = Math.min(res,root.val);
        }
        helper(root.left);
        helper(root.right);
    }
}
