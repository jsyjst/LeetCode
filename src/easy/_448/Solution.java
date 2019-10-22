package easy._448;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/22
 *     desc   : 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *     找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *     您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) res.add(i+1);
        }
        return res;
    }
}
