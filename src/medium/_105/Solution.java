package medium._105;

import common.tree.TreeNode;

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
    private int[] pre;
    private HashMap<Integer,Integer> map = new HashMap<>();
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(0,inorder.length-1);
    }

    public TreeNode helper(int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int index = map.get(root.val);
        root.left = helper(start, index - 1);
        root.right = helper(index + 1 , end);
        return root;
    }
}
