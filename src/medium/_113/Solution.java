package medium._113;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/16
 *     desc   : 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *     说明: 叶子节点是指没有子节点的节点。
 * </pre>
 */
public class Solution {
    /**
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) return resList;
        helper(resList,new ArrayList<>(),root,sum);
        return resList;
    }

    private void helper(List<List<Integer>> resList,List<Integer> res,TreeNode root,int sum){
        if(root == null) return;
        res.add(root.val);
        if(root.left == null && root.right == null&& sum - root.val == 0) resList.add(new ArrayList<>(res));
        helper(resList, res, root.left, sum-root.val);
        helper(resList,res,root.right,sum - root.val);
        res.remove(res.size() - 1);
    }
}

