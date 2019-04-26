package hard._004;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/04/25
 *     desc   : 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *              请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *              你可以假设 nums1 和 nums2 不会同时为空。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * <p>
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArraysByKey(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        System.arraycopy(nums1, 0, nums, 0, m);
        System.arraycopy(nums2, 0, nums, m, n);
        Arrays.sort(nums);
        if (nums.length % 2 != 0) {
            return nums[nums.length / 2] * 1.0;
        } else {
            return (nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2.0;
        }
    }

    /**
     * 题解
     * left_part              |        right_part
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * 利用中位数的定义得：
     * 1. len(left_part)=len(right_part)
     * 2. max(left_part)≤min(right_part)
     * 进而推出满足：
     * 1. i+j=m-i+j-n;即j=(m+n+1)/2-i ,其中n>m,i=0~m;
     * 2. B[j−1]≤A[i] 以及 A[i−1]≤B[j]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysByKey(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //确保n>m，即确保j不为负
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tp = m;
            m = n;
            n = tp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i>iMin && nums1[i - 1] > nums2[j]) {
                //i的值太大
                iMax = i-1;
            }else if (i < iMax  && nums2[j-1] > nums1[i]){
                //i的值太小
                iMin = i+1;
            } else{
                int maxLeft;
                if(i==0) maxLeft=nums2[j-1];
                else if(j==0) maxLeft = nums1[i-1];
                else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2 == 1) return maxLeft;
                int minRight;
                if(i == m) minRight = nums2[j];
                else if(j == n) minRight = nums1[i];
                else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (minRight+maxLeft)/2.0;
            }
        }
        return 0.0;
    }
}
