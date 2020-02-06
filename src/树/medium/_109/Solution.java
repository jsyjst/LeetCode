package 树.medium._109;

import common.list.ListNode;
import common.tree.TreeNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/14
 *     desc   : 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * </pre>
 */
public class Solution {
    /**
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return help(head,null);
    }
    private TreeNode help(ListNode head,ListNode tail){
        if(head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            slow= slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = help(head,slow);
        root.right = help(slow.next,tail);
        return root;
    }
}
