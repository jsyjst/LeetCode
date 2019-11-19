package easy._653;

import common.tree.TreeNode;

import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/19
 *     desc   : 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * </pre>
 */
public class Solution {
    private HashSet<Integer> set = new HashSet<>();
    private boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        BFS(root,k);
        return res;
    }

    private void BFS(TreeNode root,int k){
        if(root == null) return;
        if(set.contains(root.val)) {
            res = true;
            return;
        }
        set.add(k-root.val);
        BFS(root.left,k);
        BFS(root.right,k);
    }
}
