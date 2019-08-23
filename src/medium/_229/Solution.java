package medium._229;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/23
 *     desc   : 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *     说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3,2,3]
     * 输出: [3]
     *
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     */

    //多数投票
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int candidateA = nums[0];  //候选人A
        int candidateB = nums[0];  //候选人B
        int countA = 0;
        int countB = 0;
        //选出两个候选人
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == candidateA){
                countA++; //投A
            }else if(nums[i] == candidateB){
                countB++; //投B
            }else {//A,B都不投
                if(countA == 0){ //更换候选人，票数置为0
                    candidateA = nums[i];
                    countA = 1;
                }else if(countB == 0){ //更换候选人，票数置为0
                    candidateB = nums[i];
                    countB = 1;
                }else {
                    countA--;
                    countB--;
                }
            }
        }
        countA = 0;
        countB = 0;
        for(int num: nums){
            if(num == candidateA){
                countA++;
            }else if(num == candidateB){
                countB++;
            }
        }
        if(countA>nums.length/3) res.add(candidateA);
        if(countB>nums.length/3) res.add(candidateB);
        return res;
    }
}
