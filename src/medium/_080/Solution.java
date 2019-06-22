package medium._080;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/22
 *     desc   :给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * </pre>
 */
public class Solution {
    /**
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int k=1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            if(count > 2) continue;
            nums[k++] = nums[i];
        }
        return k;
    }

    /**
     * 优化代码,使用foreach取数的特点
     */
    public int removeDuplicatesBetter(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n != nums[i-2])
                nums[i++] = n;
        return i;
    }

}
