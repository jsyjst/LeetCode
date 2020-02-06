package 树.medium._106;

import common.tree.TreeNode;

import java.util.HashMap;

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
    private int[] post;
    private HashMap<Integer,Integer> map = new HashMap<>();
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        postIndex = post.length - 1;
        for(int i = 0; i <  inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(0,inorder.length - 1);
    }

    public TreeNode helper(int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(post[postIndex--]);
        int index = map.get(root.val);
        root.right = helper(index + 1,end);
        root.left = helper(start,index - 1);
        return root;
    }
}
