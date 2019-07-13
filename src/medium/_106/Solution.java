package medium._106;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/13
 *     desc   : 根据一棵树的中序遍历与后序遍历构造二叉树。
 *     注意: 你可以假设树中没有重复的元素。
 * </pre>
 */
public class Solution {
    /**
     *中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private int[] postorder;
    private int[] inorder;
    private int post_index;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return help(0,inorder.length);
    }

    private TreeNode help(int left,int right){
        if(left == right) return null;
        int root_val = postorder[post_index];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);

        post_index--;
        root.right = help(index + 1,right);
        root.left = help(left,index);


        return root;
    }
}
