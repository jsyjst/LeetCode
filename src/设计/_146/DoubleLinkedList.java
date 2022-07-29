package 设计._146;

import java.util.HashMap;

public class DoubleLinkedList {
    //虚拟头尾节点
    private final DoubleNode head;
    private final DoubleNode tail;
    // 个数
    int size;

    DoubleLinkedList() {
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    // 插入元素，插入时插入到链表头
    public DoubleNode addNode(DoubleNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        size++;
        return node;
    }

    // 删除元素，该元素一定存在该链表
    public DoubleNode removeNode(DoubleNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        return node;
    }

    public DoubleNode getRecentNode() {
        return head.next;
    }

    // 删除最老的节点
    public DoubleNode removeOldestNode() {
        DoubleNode node = tail.pre;
        if (node != null) {
            return removeNode(node);
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    // 双向链表
    public static class DoubleNode{
        DoubleNode pre;
        DoubleNode next;
        int key;
        int value;
        DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
