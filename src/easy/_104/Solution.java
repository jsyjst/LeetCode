package easy._104;

import common.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/12
 *     desc   : 给定一个二叉树，找出其最大深度。
 *     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *     说明: 叶子节点是指没有子节点的节点。
 * </pre>
 */
public class Solution {
    /**
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1+Math.max(leftDepth,rightDepth);
    }

    //时间复杂度较复杂
    public int maxDepthLevel(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return level;
    }



}
