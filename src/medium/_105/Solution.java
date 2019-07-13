package medium._105;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/13
 *     desc   : 根据一棵树的前序遍历与中序遍历构造二叉树。
 *              注意:
 *              你可以假设树中没有重复的元素。
 * </pre>
 */
public class Solution {
    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private int[] preorder;
    private int[] inorder;
    private int pre_index = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return help(0,inorder.length);
    }

    private TreeNode help(int left,int right){
        if(left == right) return null;
        int root_val = preorder[pre_index];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);

        pre_index++;
        root.left = help(left,index);
        root.right = help(index + 1,right);

        return root;
    }
}
