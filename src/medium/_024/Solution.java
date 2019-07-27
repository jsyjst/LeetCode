package medium._024;

import common.tree.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/16
 *     desc   :给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *             你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * </pre>
 */
public class Solution {
    /**
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        //如果该结点为空或者只有一个则直接返回
        if(head==null||head.next == null) return head;
        ListNode node =head;
        head = head.next;
        ListNode secondNode; //要交换的第二个结点
        ListNode lastNode = null; //记录上个结点
        while (node!=null){
            if(node.next == null) break; //如果要交换的最后一个结点为null,则跳出循环
            secondNode = node.next;  //交换的第二个结点
            node.next = secondNode.next; //第一个结点连接到第三个结点
            secondNode.next = node;  //第二个结点连接到第一个结点，实现交换
            //如果不是第一次遍历
            if(lastNode!=null){
                lastNode.next = secondNode;  //上一个交换后的结点连接到后一个交换后的结点
            }
            lastNode = node; //记录交换后的后一个结点
            node = node.next;
        }
        return head;
    }
}
