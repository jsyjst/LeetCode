package medium._236;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/25
 *     desc   : 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 *     最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * </pre>
 */
public class Solution {
    /**
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     */
    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    //后序遍历
    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid > 1) res = root;
        return left + right + mid > 0 ? 1 : 0;
    }
}
