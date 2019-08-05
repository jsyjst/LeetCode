package medium._173;

import common.tree.TreeNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/05
 *     desc   : 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *     调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * </pre>
 */
public class BSTIterator {
    /**
     * BSTIterator iterator = new BSTIterator(root);
     * iterator.next();    // 返回 3
     * iterator.next();    // 返回 7
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 9
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 15
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 20
     * iterator.hasNext(); // 返回 false
     * <p>
     * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
     * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
     */
    private LinkedList<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        firstSortTree(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll().val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void firstSortTree(TreeNode root){
        if(root == null) return;
        firstSortTree(root.left);
        queue.offer(root);
        firstSortTree(root.right);
    }

}
