package easy._496;

import java.util.HashMap;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/04
 *     desc   : 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *     找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *     nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * </pre>
 */
public class Solution {
    /**
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0) return new int[0];
        int[] res = new int[nums1.length];
        boolean isSame;
        for (int i = 0; i < nums1.length; i++) {
            isSame = false;
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j]!=nums1[i]&&!isSame) continue;
                isSame = true;
                if(nums2[j]>nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
            res[i]=res[i]==0?-1:res[i];
        }
        return res;
    }

    //HashMap+Stack
    public int[] nextGreaterElementBetter(int[] nums1, int[] nums2) {
        //key为num,value为num下一个更大的数
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        //遍历原数组
        for(int num:nums2){
            while (!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
