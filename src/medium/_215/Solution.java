package medium._215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/26
 *     desc   : 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */

    //小顶堆
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i]>heap.peek()){
                heap.remove();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}
