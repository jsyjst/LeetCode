package medium._240;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/18
 *     desc   :编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 *              该矩阵具有以下特性：每行的元素从左到右升序排列。
 *              每列的元素从上到下升序排列。
 * </pre>
 */
public class Solution {
    /**
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0||matrix[0].length == 0||target < matrix[0][0]) return false;
        int m = matrix.length -1;
        int n = matrix[0].length-1;
        for (int i = 0; i <= Math.min(m,n); i++) {
            int left = i;
            int right = n;
            int mid;
            //行二分
            while (left<=right){
                mid = left +(right-left)/2;
                if(target == matrix[i][mid]){
                    return true;
                }else if(target < matrix[i][mid]){
                    right = mid-1;
                }else {
                    left = mid +1;
                }
            }
            left = i;
            right = m;
            //列二分
            while (left<=right){
                mid = left +(right-left)/2;
                if(target == matrix[mid][i]){
                    return true;
                }else if(target < matrix[mid][i]){
                    right = mid-1;
                }else {
                    left = mid +1;
                }
            }
        }
        return false;
    }

    /**
     * 优化时间复杂度
     */
    public boolean searchMatrixBetter(int[][] matrix, int target) {
        if(matrix.length == 0||matrix[0].length == 0||target < matrix[0][0]) return false;
        int m = 0;
        int n = matrix[0].length-1;
        while (n>=0&&m<matrix.length){
            if(target == matrix[m][n]){ //右上角开始访问
                return true;
            }else if(target<matrix[m][n]){ //目标小于右上角，就向左移动
                n--;
            }else { //目标大于右上角，向下移动
                m++;
            }
        }
        return false;
    }

}
