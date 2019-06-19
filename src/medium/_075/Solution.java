package medium._075;

import java.sql.Array;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/19
 *     desc   : 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *              此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *              注意: 不能使用代码库中的排序函数来解决这道题。
 *
 *              进阶：
 *              一个直观的解决方案是使用计数排序的两趟扫描算法。
 *              首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 *              你能想出一个仅使用常数空间的一趟扫描算法吗？
 * </pre>
 */
public class Solution {
    /**
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {
        if(nums.length < 1) return;
        int red = 0;
        int white = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                red++;
            }else if(nums[i] == 1){
                white++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(red-->0){
                nums[i] = 0;
            }else if(white-->0){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 一趟遍历，遇到0与前面交换，遇到2与后面交换，遇到1什么也不干
     */
    public void sortColorsBetter(int[] nums) {
        if(nums.length <=1) return;
        int left = 0;
        int right = nums.length-1;
        for (int i = left; i <= right; i++) {
            if(nums[i] == 0){
                swap(nums,i,left++);
            }
            if(nums[i] == 2){
                swap(nums,i--,right--);
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
