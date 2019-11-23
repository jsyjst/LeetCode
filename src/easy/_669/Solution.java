package easy._669;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/23
 *     desc   :
 * </pre>
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return root;
        if(root.val<L) return trimBST(root.right,L,R);
        if(root.val>R) return trimBST(root.left,L,R);
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
