package medium._073;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/17
 *     desc   : 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *     进阶:
 *     一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 *     一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 *     你能想出一个常数空间的解决方案吗？
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     *
     * 输入:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     */
    //空间复杂度O(m+n)
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] isZero = new boolean[m+n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    isZero[i] = true;  //记录行
                    isZero[m+j] = true; // 记录列
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isZero[i]||isZero[m+j]) matrix[i][j] = 0;
            }
        }
    }

}
