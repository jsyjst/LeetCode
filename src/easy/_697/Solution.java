package easy._697;

import java.util.Collections;
import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/25
 *     desc   :
 * </pre>
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length<=1) return nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int degree = 0;
        //记录每个数的出现的次数
        for(int num:nums){
            int value = map.getOrDefault(num,0)+1;
            map.put(num,value);
            degree = Math.max(degree,value);
        }
        if(degree == 1) return 1;
        int res = Integer.MAX_VALUE;
        int count ;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!= degree) continue;
            count = degree-1;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]==nums[i]) count--;
                if(count ==0) {
                    res =Math.min(res,j-i+1);
                    break;
                }
            }
            if(res == degree) return res;
        }
        return res;
    }

    //优化时间复杂度，用空间换时间
    public int findShortestSubArrayBetter(int[] nums) {
        if(nums.length<=1) return nums.length;
        HashMap<Integer,Integer> count = new HashMap<>();
        //记录数量每个数的最左边和最右边的位置
        HashMap<Integer,Integer> left = new HashMap<>(),right = new HashMap<>();
        //记录每个数的出现的次数
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //记录左边的位置
            if(left.get(num)== null) left.put(num,i);
            //更新右边的位置
            right.put(num,i);
            //记录次数
            int value =count.getOrDefault(num,0)+1;
            count.put(num,value);
        }
        //遍历
        int degree= Collections.max(count.values());
        if(degree == 1) return 1;
        int res = Integer.MAX_VALUE;
        for(int num:nums){
            if(count.get(num) == degree){
                res = Math.min(res,right.get(num)-left.get(num)+1);
                if(res == degree) return res;
            }
        }
        return res;

    }
}
