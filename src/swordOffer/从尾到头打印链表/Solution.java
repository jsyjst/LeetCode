package swordOffer.从尾到头打印链表;

import common.list.ListNode;

import java.util.ArrayList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/10
 *     desc   : 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * </pre>
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resList = new ArrayList<>();
        while (listNode!=null){
            resList.add(0,listNode.val);
            listNode = listNode.next;
        }
        return resList;
    }
}
