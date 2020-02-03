package 树.medium._095;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/03
 *     desc   :
 * </pre>
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        //左子树为null的情况
        if(start > end) {
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> subLeft = helper(start,i - 1);
            List<TreeNode> subRight = helper(i+1,end);
            for(TreeNode left : subLeft){
                for(TreeNode right : subRight){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
