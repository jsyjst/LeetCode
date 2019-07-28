package medium._136;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/28
 *     desc   : 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *     说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * </pre>
 */
public class Solution {
    /**
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     */
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int i = 0;
        for (;i < nums.length-1; i= i+2) {
            if(nums[i] != nums[i+1]) break;
        }
        return nums[i];
    }
    public int singleNumberHash(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num :nums){
            int count = map.get(num) == null?1:2;
            map.put(num,count);
        }
        for (int num :nums) {
            if(map.get(num) == 1) return num;
        }
        return 0;
    }

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数于0异或为任何数 0 ^ n => n
     * 相同的数异或为0: n ^ n => 0
     * a = [2,3,2,4,4]
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     */
    public int singleNumberBest(int[] nums) {
        if(nums.length == 1) return nums[0];
        int res =0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
