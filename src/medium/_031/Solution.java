package medium._031;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/23
 *     desc   : 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *              如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *              必须原地修改，只允许使用额外常数空间。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int nums[] = {1,2,5,3,2,1};
        Arrays.sort(nums,3,nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
    /**
     *以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    public void nextPermutation(int[] nums) {
        int target; //记录更换的位序
        int i = nums.length-1;
        while (i>0){
            if(nums[i]>nums[i-1]){
                //找到刚好比目标值大的下标
                target = i-1;
                i++;
                while (i<nums.length&&nums[target]<nums[i]){//从该下标向右移动，找到刚好比目标值大的下标
                    i++;
                }
                swap(nums,target,i-1);
                Arrays.sort(nums,target+1,nums.length);//从小到大排列交换后的数字
                return;
            }else {//从后面向左移动
                i--;
            }
        }
        Arrays.sort(nums);
    }

    /**
     * 交换
     * @param nums 数组
     * @param i 需要交换的靠近左边的数
     * @param j 需要交换的靠近右边的数
     */
    public static void swap(int[] nums,int i,int j){
        int k = nums[j];
        nums[j] = nums[i];
        nums[i] = k;
    }

}
