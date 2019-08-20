package medium._222;

import common.tree.TreeNode;

import java.util.LinkedList;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/20
 *     desc   : 给出一个完全二叉树，求出该树的节点个数。
 *     说明：完全二叉树的定义如下：
 *     在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 *     并且最下面一层的节点都集中在该层最左边的若干位置。
 *     若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     *     1
     *    / \
     *   2   3
     *  / \  /
     * 4  5 6
     *
     * 输出: 6
     */

    //层次遍历
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                res++;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right!= null) queue.offer(cur.right);
            }
        }
        return res;
    }



    //先序遍历,时间复杂度更优
    private int res;
    public int countNodesDfs(TreeNode root) {
        if(root == null) return 0;
        res = 0;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        res++;
        dfs(root.left);
        dfs(root.right);
    }
}
