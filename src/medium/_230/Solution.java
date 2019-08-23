package medium._230;

import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/23
 *     desc   : 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *     说明：你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     */
    private int res; //保存结果
    private int count; //计数
    //中序遍历
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count--;
        if(count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
