package easy._706;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/27
 *     desc   :  设计哈希映射
 * </pre>
 */
public class MyHashMap {
    private ArrayList<int[]> mapList = new ArrayList<>();
    public MyHashMap() {
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        remove(key);
        int[] map = new int[2];
        map[0] = key;
        map[1] = value;
        mapList.add(map);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(int[] map:mapList){
            if(map[0] == key)
                return map[1];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(int[] map:mapList){
            if(key == map[0]){
                mapList.remove(map);
                break;
            }
        }
    }
}
