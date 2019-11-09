package easy._506;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/09
 *     desc   : 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
 *     前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *     (注：分数越高的选手，排名越靠前。)
 * </pre>
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        String[] res = new String[nums.length];
        HashMap<Integer,String> map = new HashMap<>();
        Arrays.sort(nums);
        if(len>=3) {
            map.put(nums[len-1],"Gold Medal");
            map.put(nums[len-2],"Silver Medal");
            map.put(nums[len-3],"Bronze Medal");
        }else if(len == 2){
            map.put(nums[1],"Gold Medal");
            map.put(nums[0],"Silver Medal");
        }else {
            map.put(nums[0],"Gold Medal");
        }
        for (int i = len-4; i >=0 ; i--) {
            map.put(nums[i],String.valueOf(len-i));
        }

        for (int i = 0; i < len; i++) {
            res[i]=map.get(temp[i]);
        }
        return res;
    }
}
