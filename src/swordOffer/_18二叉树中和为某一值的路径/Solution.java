package swordOffer._18二叉树中和为某一值的路径;

import common.tree.TreeNode;

import java.util.ArrayList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/19
 *     desc   :
 * </pre>
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    private ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return resList;
        res.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            resList.add(new ArrayList<>(res));
        FindPath(root.left,target);
        FindPath(root.right,target);
        res.remove(res.size()-1);
        return resList;
    }
}
