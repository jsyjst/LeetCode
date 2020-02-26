package 设计._146;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/31
 *     desc   : 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 *     它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *     获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *     写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
 *     当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * </pre>
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
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

    /**
     * LRUCache cache = new LRUCache( 2 缓存容量  )
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     */


//    private int capacity;
//    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (cache.containsKey(key)) {
//            int value = cache.get(key);
//            cache.remove(key);
//            cache.put(key,value);
//            return cache.get(key);
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)){
//            cache.remove(key);
//        }else if(cache.size() == capacity) {
//            Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
//            iterator.next();
//            iterator.remove();
//        }
//        cache.put(key, value);
//    }




    private LinkedHashMap<Integer,Integer> map;

    public LRUCache(int capacity) {

        map = new LinkedHashMap<>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry entry){
                return map.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}
