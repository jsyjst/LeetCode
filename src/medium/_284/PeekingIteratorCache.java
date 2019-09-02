package medium._284;


import java.util.Iterator;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/02
 *     desc   :
 * </pre>
 */
public class PeekingIteratorCache implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer cache;
    public PeekingIteratorCache(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(cache == null){
            cache = iterator.next();
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(cache == null) return iterator.next();
        Integer temp = cache;
        cache = null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext()||cache!=null;
    }
}
