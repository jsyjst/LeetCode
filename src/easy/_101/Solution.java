package easy._101;

import common.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/30
 *     desc   : 给定一个二叉树，检查它是否是镜像对称的。
 *
 * </pre>
 */
public class Solution {
    /**
     * 二叉树 [1,2,2,3,4,4,3] 是对称的。
     *      1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * [1,2,2,null,3,null,3]则不是镜像对称的:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     *
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode left,TreeNode right){
        if(left == null&&right ==null) return true;
        if(left == null||right == null) return false;
        return (left.val == right.val)&&isMirror(left.left,right.right)&&isMirror(left.right,right.left);
    }

}
