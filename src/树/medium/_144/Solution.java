package 树.medium._144;

import common.tree.TreeNode;

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
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            //从右往左压入栈
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);

        }
        return res;
    }

}
