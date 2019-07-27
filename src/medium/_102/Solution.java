package medium._102;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/11
 *     desc   : 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * </pre>
 */
public class Solution {
    /**
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            res.add(new ArrayList<>());
            int levelLen = queue.size();  //记录这一层节点的总个数
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.remove();
                res.get(level).add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            level++;
        }
        return res;
    }

}
