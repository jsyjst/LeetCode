package easy._700;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/26
 *     desc   :
 * </pre>
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val<val) return searchBST(root.right,val);
        if(root.val>val) return searchBST(root.left,val);
        return root;
    }

    //迭代
    public TreeNode searchBSTBetter(TreeNode root, int val) {
        while (root!=null){
            if(root.val == val) {
                return root;
            }else if(root.val <val){
                root = root.right;
            }else {
                root  = root.left;
            }
        }
        return null;
    }
}
