package easy._107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/11
 *     desc   : 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * </pre>
 */
public class Solution {
    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int levelLen = queue.size();  //记录这一层节点的总个数
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.remove();
                res.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add(0,res);
        }
        return resList;
    }
}
