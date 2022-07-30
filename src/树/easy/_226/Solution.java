package 树.easy._226;

import common.tree.TreeNode;

import java.util.LinkedList;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/21
 *     desc   : 翻转一棵二叉树。
 * </pre>
 */
public class Solution {
    /**
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */

    //先序遍历
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode rightNode = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightNode);
        return root;
    }

    // 使用遍历的方式
    public TreeNode invertTree1(TreeNode root) {
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        traversal(root.left);
        traversal(root.right);
    }

    //中序遍历
    public TreeNode invertTreeMid(TreeNode root) {
        if(root == null) return null;
        invertTreeMid(root.left);  //遍历最下面的左节点
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTreeMid(root.left);
        return root;
    }


}
