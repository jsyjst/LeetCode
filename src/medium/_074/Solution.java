package medium._074;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/18
 *     desc   : 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *              每行中的整数从左到右按升序排列。
 *              每行的第一个整数大于前一行的最后一个整数
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * <p>
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if(target<matrix[0][0]) return false;
        int m = matrix[0].length -1;
        int row = 0;
        while (row<matrix.length){
            if(matrix[row][0]>target){
                break;
            }else if(matrix[row][0] == target){
                return true;
            }
            row++;
        }
        row--;
        if(target>matrix[row][m]) return false;
        int left = 0;
        int right = m;
        int mid;
        while (left<=right){
            mid = left+(right-left)/2;
            if(target == matrix[row][mid]){
                return true;
            }else if(target <matrix[row][mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}
