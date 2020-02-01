package 树.medium._094;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/07
 *     desc   : 给定一个二叉树，返回它的中序 遍历。
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
     * 输出: [1,3,2]
     */

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
       inorderTraversal(root,res);
        return res;
    }
    public void inorderTraversal(TreeNode root,List<Integer> res){
        if(root == null) return;
        inorderTraversal(root.left,res);
        res.add(root.val);
        inorderTraversal(root.right,res);
    }
    //栈遍历
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
