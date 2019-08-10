package medium._199;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/10
 *     desc   : 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     */

    //层次遍历，队列，记录最右边的节点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>(); //队列
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if(i == len-1) res.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
