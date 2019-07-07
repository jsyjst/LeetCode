package medium._144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/07
 *     desc   : 给定一个二叉树，返回它的 前序 遍历。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     */

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }

    private void preOrder(TreeNode T,List<Integer> res){
        if(T == null) return;
        res.add(T.val);
        preOrder(T.left,res);
        preOrder(T.right,res);
    }

    //栈遍历
    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null||!stack.isEmpty()){
            while (curr!=null){
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }

}
