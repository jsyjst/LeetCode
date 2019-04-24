package one;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/03/27
 *     desc   : 给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。
 *              您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。
 *              例：
 *                 给定nums = [2,7,11,15]，target = 9，
 *                 因为nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
 *                返回[ 0，1 ]。
 *
 * </pre>
 */
public class one {
    public static void main(String[] args){
        int[] nums = {0,3,6,9,7,8};
        int[] index ;
        index=Solution.twoSum(nums,14);
        System.out.println(""+index[0]+""+index[1]);
    }
}
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i ;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}