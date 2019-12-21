package swordOffer._20二叉搜索树与双向链表;

import common.tree.TreeNode;

import java.util.Stack;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/21
 *     desc   : 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * </pre>
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        //栈
        Stack<TreeNode> stack = new Stack<>();
        //记录当前节点
        TreeNode cur = pRootOfTree;
        //记录上一个节点
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            //中序遍历
            if (pre == null) {
                pRootOfTree = cur;
                pre = cur;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return pRootOfTree;
    }
}