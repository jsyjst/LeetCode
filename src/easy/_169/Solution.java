package easy._169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/04
 *     desc   : 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *     你可以假设数组是非空的，并且给定的数组总是存在众数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3,2,3]
     * 输出: 3
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n<=2) return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
                if(map.get(num)> n/2) return num;
            }else {
                map.put(num,1);
            }
        }
        return nums[0];
    }

    public int majorityElementBetter(int[] nums) {
        int n = nums.length;
        if(n<=2) return nums[0];
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                count = 1;
            }else {
                count++;
                if(count>n/2) return nums[i];
            }
        }
        return nums[0];
    }
}
