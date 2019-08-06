package easy._189;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/06
 *     desc   : 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *              说明:尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *              要求使用空间复杂度为 O(1) 的 原地 算法。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     */
    public void rotate(int[] nums, int k) {
       if(k == 0||nums.length<2) return;
       int len = nums.length-1;

        for (int i = 0; i < k; i++) {
            int temp = nums[len];
            for (int j = len; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
    //
    public void rotateReverse(int[] nums, int k) {
        if(k == 0||nums.length<2) return;
        int n = nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
