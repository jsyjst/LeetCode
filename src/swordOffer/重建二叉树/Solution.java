package swordOffer.重建二叉树;

import common.tree.TreeNode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/10
 *     desc   : 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *     例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * </pre>
 */
public class Solution {
    private int[] pre,in;
    private int preIndex;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        this.pre = pre;
        this.in = in;
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return helper(0,pre.length);

    }

    private TreeNode helper(int left,int right){
        if(left == right) return null;
        int val = pre[preIndex++];
        TreeNode root = new TreeNode(val);

        int index = map.get(val);
        root.left = helper(left,index);
        root.right = helper(index+1,right);
        return root;
    }
}
