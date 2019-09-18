package medium._341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/18
 *     desc   : 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。列表中的项或者为一个整数，或者是另一个列表。
 * </pre>
 */
public class NestedIterator implements Iterator<Integer> {

    /**
     * 输入: [[1,1],2,[1,1]]
     * 输出: [1,1,2,1,1]
     * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
     *
     * 输入: [1,[4,[6]]]
     * 输出: [1,4,6]
     * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
     */
    private LinkedList<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        helper(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void helper(List<NestedInteger> nestedIntegerList){
        for (int i = 0; i < nestedIntegerList.size(); i++) {
            NestedInteger nestedInteger = nestedIntegerList.get(i);
            if(nestedInteger.isInteger()) {
                queue.offer(nestedInteger.getInteger());
            }else {
                helper(nestedInteger.getList());
            }
        }
    }
}
