package medium._341;

import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/18
 *     desc   :
 * </pre>
 */
public interface NestedInteger {


    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
