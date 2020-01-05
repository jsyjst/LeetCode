package swordOffer._23二叉树的最小深度;

import common.tree.TreeNode;

import java.util.LinkedList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/05
 *     desc   : 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 * </pre>
 */
public class Solution {
    public int run(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                if(node.left == null && node.right == null) {
                    return res;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return res;

    }
}
