package easy._538;

import common.tree.TreeNode;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/12
 *     desc   : 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 *     使得每个节点的值是原来的节点值加上所有大于它的节点值之和
 * </pre>
 */
public class Solution {
    /**
     * 输入: 二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     */


    private int preNum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    //变形的中序遍历，从右->中->左的顺序遍历
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.right);
        root.val+=preNum;
        preNum = root.val;
        helper(root.left);
    }

    //非递归的方法,栈实现
    public TreeNode convertBSTByStack(TreeNode root) {
        if(root == null) return null;
        int preNum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += preNum;
            preNum = cur.val;
            cur = cur.left;
        }
        return root;
    }

}
