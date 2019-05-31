package medium._048;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/31
 *     desc   :给定一个 n × n 的二维矩阵表示一个图像。
 *     将图像顺时针旋转 90 度。
 *     说明：
 *     你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(nums.length);
        rotate(nums);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(nums[i][j] );
            }
            System.out.println();
        }

    }
    /**
     * 示例 1:
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 示例 2:
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map.put(i * len + j, matrix[i][j]);//key为数组的位置
            }
        }
        int k = 0;
        for (int i = len-1; i >=0; i--) {
            for (int j = 0; j <len; j++) {
                matrix[j][i]= map.get(k++);
            }
        }
    }

    /**
     * 更优解决方法，找规律
     * 任意一个(i,j) , (j, n-i-1), (n-i-1, n-j-1), (n -j-1, i)就是这四个索引号上的数交换.
     * @param matrix
     */
    public void rotateBest(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++ ) {
            for (int j = i; j < n - i - 1; j ++ ){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
