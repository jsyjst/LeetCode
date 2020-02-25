package 排序算法.快排;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/25
 *     desc   :
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[] nums = new  int[]{2,6,3,5,10,2,1,6,8};
        quickSort(nums);
        for(int num : nums) System.out.println(num);
    }

    private static void quickSort(int[] nums){
        sort(nums,0,nums.length - 1);
    }

    private static void sort(int[] nums,int start,int end){
        if(start >= end) return;
        int target = nums[start];
        int left = start;
        int right = end;
        while (left < right){
            while (left < right && nums[right] >= target){
                right--;
            }
            while (left < right && nums[left] <= target){
                left ++;
            }
            if(left < right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }

        //将基准数放到中间
        nums[start] = nums[left];
        nums[left] = target;
        //递归左边
        sort(nums,start,left - 1);
        //递归右边
        sort(nums,left + 1,end);
    }
}
