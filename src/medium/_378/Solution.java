package medium._378;

import java.util.PriorityQueue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/23
 *     desc   : 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * </pre>
 */
public class Solution {
    /**
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     * 返回 13。
     * 说明:你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
     */

    //优先队列解决
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int[] row:matrix){
            for(int num:row){
                queue.add(num);
            }
        }
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.poll();

    }

    //二分查找
    public int kthSmallestBest(int[][] matrix, int k) {
        int row = matrix.length;
        int rank = matrix[0].length;
        int left = matrix[0][0]; //最小值
        int right = matrix[row-1][rank-1]; //最大值
        while (left<right){
            int mid = left+(right-left)/2;//二分
            int count = findCount(matrix,row,rank,mid);
            if(count == k) return mid;
            if(count < k){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    //查找比
    private int findCount(int[][] matrix,int row,int rank,int mid){
        int i = row-1;
        int j = 0;
        int count = 0;
        while (i>=0&&j<rank){
            if(matrix[i][j]>mid){
                i--;
            }else {
                count += i+1;
                j++;
            }
        }
        return count;
    }
}
