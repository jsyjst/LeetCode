package easy._705;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/27
 *     desc   : 设计哈希集合
 * </pre>
 */
public class MyHashSet {
    private boolean[] set;
    public MyHashSet() {
        set = new boolean[1000000];
    }

    public void add(int key) {
        set[key]= true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}
