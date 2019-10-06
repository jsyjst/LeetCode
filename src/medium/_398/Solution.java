package medium._398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/06
 *     desc   : 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *     注意:数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * </pre>
 */
public class Solution {
    /**
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     *
     * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
     * solution.pick(3);
     *
     * // pick(1) 应该返回 0。因为只有nums[0]等于1。
     * solution.pick(1);
     */
//    private HashMap<Integer, List<Integer>> map;
//    public Solution(int[] nums) {
//        map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!map.containsKey(nums[i])){
//                List<Integer> valueList = new ArrayList<>();
//                valueList.add(i);
//                map.put(nums[i],valueList);
//            }else {
//                map.get(nums[i]).add(i);
//            }
//        }
//
//    }
//
//    public int pick(int target) {
//        List<Integer> res = map.get(target);
//        return res.get(new Random().nextInt(res.size()));
//    }

    //better
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int index = 0;
        int n = 0;
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]){
                n++;
                // 1/n的概率留下i
                if(random.nextInt(n)==0) index = i;
            }
        }
        return index;
    }


}
