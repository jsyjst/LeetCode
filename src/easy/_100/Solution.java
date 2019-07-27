package easy._100;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/26
 *     desc   : 给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * </pre>
 */
public class Solution {

    /**
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *         [1,2,3],   [1,2,3]
     * 输出: true
     *
     * 输入:      1          1
     *           /           \
     *          2             2
     *         [1,2],     [1,null,2]
     * 输出: false
     *
     * 输入:       1         1
     *           / \       / \
     *          2   1     1   2
     *         [1,2,1],   [1,1,2]
     * 输出: false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p!=null && q!=null && p.val==q.val  ){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}
