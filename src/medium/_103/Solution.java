package medium._103;

import common.TreeNode;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/12
 *     desc   : 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * </pre>
 */
public class Solution {
    /**
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     *    3
     *  /  \
     * 9   20
     *    / \
     *  15   7
     * 返回锯齿形层次遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.remove();
                if(level % 2 == 0){
                    res.add(node.val);
                }else {
                    res.add(0,node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add(res);
            level++;
        }
        return resList;
    }

}
