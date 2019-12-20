package swordOffer._19复杂链表的复制;

import java.util.HashMap;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/20
 *     desc   : 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *     返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * </pre>
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        //新旧节点的映射
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        //新节点
        RandomListNode newHead = new RandomListNode(pHead.label);
        map.put(pHead, newHead);
        //移动节点
        RandomListNode oldNode = pHead.next;
        RandomListNode newNode = newHead;
        //next节点复制
        while (oldNode != null) {
            newNode.next = new RandomListNode(oldNode.label);
            newNode = newNode.next;
            map.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        //random节点复制
        oldNode = pHead;
        newNode = newHead;
        while (oldNode != null) {
            newNode.random = map.get(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }

    public RandomListNode CloneBetter(RandomListNode pHead) {
        if (pHead == null) return null;
        //新旧节点的映射
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        //新节点
        RandomListNode newHead = new RandomListNode(pHead.label);
        map.put(pHead, newHead);
        //移动节点
        RandomListNode oldNode = pHead;
        RandomListNode newNode = newHead;

        while (oldNode != null) {
            //next节点复制
            if(oldNode.next != null){
                if(!map.containsKey(oldNode.next)) {
                    map.put(oldNode.next, new RandomListNode(oldNode.next.label));
                }
                newNode.next = map.get(oldNode.next);
            }
            //random节点复制
            if(oldNode.random!=null){
                if(!map.containsKey(oldNode.random)){
                    map.put(oldNode.random,new RandomListNode(oldNode.random.label));
                }
                newNode.random = map.get(oldNode.random);
            }
            //移动
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        return newHead;
    }
}


