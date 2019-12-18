package swordOffer._17二叉树的层次遍历;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/18
 *     desc   : 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * </pre>
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resList = new ArrayList<>();
        if(root == null) return resList;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                resList.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return resList;
    }
}
