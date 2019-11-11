package easy._532;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/11
 *     desc   : 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 *     这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * <p>
     * 输入:[1, 2, 3, 4, 5], k = 1
     * 输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     */
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (k == 0 && map.get(num) > 1) {
                res++;
            } else if (k!=0&&map.containsKey(num + k)) {
                res++;
            }
        }
        return res;
    }
}
