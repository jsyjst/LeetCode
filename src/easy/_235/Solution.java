package easy._235;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/24
 *     desc   : 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 *     最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *     例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * </pre>
 */
public class Solution {
    /**
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * <p>
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     * <p>
     * 注：所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     */
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left,p,q);
        }else if(pVal>parentVal&&qVal>parentVal){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
    //递归
    public TreeNode lowestCommonAncestorBest(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node!=null){
            int parentVal = node.val;
            if (pVal < parentVal && qVal < parentVal){
                node = node.left;
            }else if(pVal>parentVal&&qVal>parentVal){
                node = node.right;
            }else {
                return node;
            }
        }
        return null;
    }
}
