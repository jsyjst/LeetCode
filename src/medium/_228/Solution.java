package medium._228;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/23
 *     desc   : 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [0,1,2,4,5,7]
     * 输出: ["0->2","4->5","7"]
     * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间
     *
     * 输入: [0,2,3,4,6,8,9]
     * 输出: ["0","2->4","6","8->9"]
     * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if(i==nums.length||nums[i]-nums[i-1]!=1){
                if(nums[i-1] == start) {
                    res.add(String.valueOf(start));
                }else {
                    res.add(start+"->"+nums[i-1]);
                }
                if(i!=nums.length) start = nums[i];
            }
        }
        return res;
    }

}
