package 排序算法.选择;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/25
 *     desc   :
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[] nums = new int[]{5,6,2,3,8,9,1,0,4};
        selectSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }

    private static void selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int targetIndex = i;
            //找到最小的值
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[targetIndex]) targetIndex = j;
            }
            //然后进行交换
            if(targetIndex != i){
                nums[i] += nums[targetIndex];
                nums[targetIndex] = nums[i] - nums[targetIndex];
                nums[i] -= nums[targetIndex];
            }
        }
    }
}
