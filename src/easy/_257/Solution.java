package easy._257;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/28
 *     desc   : 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *     说明: 叶子节点是指没有子节点的节点。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */

    //注String值不可变，故为值传递。而StringBuilder为引用传递，故在这里使用String而不是StringBuilder
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        helper(res,"",root);
        return res;
    }
    private void helper(List<String> res,String resString,TreeNode root){
        if(root == null) return;
        resString+=String.valueOf(root.val);
        if(root.left == null&&root.right == null){
            res.add(resString);
            return;
        }
        resString+=("->");
        helper(res,resString,root.left);
        helper(res,resString,root.right);
    }
}
