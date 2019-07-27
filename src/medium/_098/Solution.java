package medium._098;

import common.tree.TreeNode;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/10
 *     desc   : 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *              假设一个二叉搜索树具有如下特征：
 *              节点的左子树只包含小于当前节点的数。
 *              节点的右子树只包含大于当前节点的数。
 *              所有左子树和右子树自身必须也是二叉搜索树。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     */
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);
    }

    //中序遍历，迭代
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre!= null&&pre.val >= cur.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}
