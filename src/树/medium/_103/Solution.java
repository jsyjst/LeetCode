package 树.medium._103;

import common.tree.TreeNode;

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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean isForward = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                if(isForward) subList.add(cur.val);
                else subList.add(0,cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            isForward = !isForward;
            res.add(subList);
        }
        return res;
    }

}
