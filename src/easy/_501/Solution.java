package easy._501;

import common.tree.TreeNode;

import javax.naming.LinkLoopException;
import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/08
 *     desc   : 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *     假定 BST 有如下定义：
 *     结点左子树中所含结点的值小于等于当前结点的值
 *     结点右子树中所含结点的值大于等于当前结点的值
 *     左子树和右子树都是二叉搜索树
 *
 * </pre>
 */
public class Solution {
    /**
     * 给定 BST [1,null,2,2],
     *    1
     *     \
     *      2
     *     /
     *    2
     * 返回[2].
     * 提示：如果众数超过1个，不需考虑输出顺序
     */
    //层次遍历+HashMap
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root.val,1);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null){
                    queue.offer(node.left);
                    map.put(node.left.val,map.getOrDefault(node.left.val,0)+1);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    map.put(node.right.val,map.getOrDefault(node.right.val,0)+1);
                }
            }
        }
        List<Integer> resList = new ArrayList<>(map.keySet());
        resList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        int size = 1;
        int temp = map.get(resList.get(0));
        for (int i = 1; i < resList.size(); i++) {
            if(map.get(resList.get(i))< temp) break;
            size++;
        }
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    //中序遍历：二叉搜索树的中序遍历是有序的
    private int preVal =0;//记录上一个数
    private int curCount = 0;//记录当前数的次数
    private int maxCount = 0;//记录最大次数
    private ArrayList<Integer> resList = new ArrayList<>();
    public int[] findModeBetter(TreeNode root) {
        if(root == null) return new int[0];
        helper(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        //中序遍历
        if(preVal == root.val) {
            curCount++;
        }else {
            preVal = root.val;
            curCount = 1;
        }
        if(curCount == maxCount){
            resList.add(root.val);
        }else if(curCount>maxCount){
            resList.clear();
            resList.add(root.val);
            maxCount = curCount;
        }
        helper(root.right);
    }
}
