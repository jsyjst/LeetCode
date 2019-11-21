package easy._690;

import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/21
 *     desc   :
 * </pre>
 */
public class Solution {
    /**
     * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * 输出: 11
     * 解释:
     * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
     */
    private int res = 0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        DFS(map.get(id),map);
        return res;
    }
    private void DFS(Employee employee,HashMap<Integer,Employee> map){
        if(employee == null) return;
        res+=employee.importance;
        for(int id:employee.subordinates){
            DFS(map.get(id),map);
        }
    }

}
