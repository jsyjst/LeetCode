package easy._594;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/15
 *     desc   : 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *     现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,3,2,2,5,2,3,7]
     * 输出: 5
     * 原因: 最长的和谐数组是：[3,2,2,2,3].
     */

    //哈希表
    public int findLHS(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        int res = 0;
        for(int key:map.keySet()){
            if(map.containsKey(key+1)) res = Math.max(res, map.get(key)+map.get(key+1));
        }
        return res;
    }
}
