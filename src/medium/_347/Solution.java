package medium._347;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/17
 *     desc   : 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * </pre>
 */
public class Solution {
    /**
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num,(map.get(num))+1);
        }

        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        queue.addAll(map.keySet());

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;


    }
}
