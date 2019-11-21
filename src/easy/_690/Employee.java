package easy._690;

import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/21
 *     desc   :
 * </pre>
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
