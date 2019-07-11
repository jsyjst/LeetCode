package easy._637;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/11
 *     desc   : 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出: [3, 14.5, 11]
     * 解释:
     * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
     * 注意：
     * 节点值的范围在32位有符号整数范围内
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if(root== null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int nodeLen = queue.size();
            double sum = 0;
            for (int i = 0; i < nodeLen; i++) {
                TreeNode T = queue.remove();
                sum += T.val;
                if(T.left != null) queue.add(T.left);
                if(T.right!= null) queue.add(T.right);
            }
            res.add(sum/nodeLen);
        }
        return res;
    }

}
