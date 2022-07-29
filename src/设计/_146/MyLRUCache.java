package 设计._146;

import java.util.HashMap;

public class MyLRUCache {
    // 双向链表,用来插入和删除
    private DoubleLinkedList cache;
    // HashMap，用来查询
    private HashMap<Integer, DoubleNode> map;
    private int capacity;

    public static void main(String[] args) {
        MyLRUCache cache = new MyLRUCache(2);
        cache.put(1, 1);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public MyLRUCache(int capacity) {
        cache = new DoubleLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    // 升级为最近使用的节点
    public DoubleNode makeRecentNode(int key) {
        DoubleNode node = map.get(key);
        cache.removeNode(node);
        cache.addNode(node);
        return node;
    }

    // 删除最老的节点
    public DoubleNode removeOldestNode() {
        DoubleNode node = cache.removeOldestNode();
        map.remove(node.key);
        return node;
    }

    public DoubleNode removeKey(int key) {
        DoubleNode node = map.get(key);
        cache.removeNode(node);
        map.remove(key);
        return node;
    }

    // 升级为最近使用的节点
    public DoubleNode addRecentNode(int key, int value) {
        DoubleNode node = new DoubleNode(key, value);
        cache.addNode(node);
        map.put(key, node);
        return node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleNode node = makeRecentNode(key);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeKey(key);
            addRecentNode(key, value);
            return;
        }
        if (cache.getSize() == capacity) {
            removeOldestNode();
        }
        addRecentNode(key, value);
    }

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
    }

    // 双向链表
    public class DoubleNode{
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
