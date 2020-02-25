package 排序算法.归并;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/25
 *     desc   :
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[] nums= new int[]{5,1,4,6,10,2,3,8,5,4};
        mergeSort(nums,0,nums.length - 1);
        for(int num : nums) System.out.println(num);
    }


    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            //对左半部分递归
            mergeSort(nums, start, mid);
            //对右半部分递归
            mergeSort(nums, mid + 1, end);
            //合并
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        //辅助数组
        int temp[] = new int[nums.length];
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        //复制数组
        for (int l = start; l <= end; l++) {
            nums[l] = temp[l];
        }
    }
}
