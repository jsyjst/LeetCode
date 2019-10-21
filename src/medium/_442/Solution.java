package medium._442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/21
 *     desc   : 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *     找到所有出现两次的元素。
 *     你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [2,3]
     */
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        if(nums.length <=1) return res;
        for(int num:nums){
            if(set.contains(num)) res.add(num);
            else set.add(num);
        }
        return res;
    }

    //优化空间
    //将值变成索引
    public List<Integer> findDuplicatesBetter(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length <=1) return res;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num-1]>0){
                nums[num-1] *= -1;
            }else {
                res.add(num);
            }

        }
        return res;
    }
}
