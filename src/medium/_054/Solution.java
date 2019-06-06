package medium._054;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/06
 *     desc   : 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     *
     * 示例 2:
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int low = 0, rank = 0;
        int i=0;
        boolean isBreak = false;  //控制是否跳出循环
        while (i<=matrix.length/2&&i<=matrix[0].length/2) {
            //向右移动
            while (rank < matrix[0].length-i) {
                res.add(matrix[low][rank++]);
                isBreak = false;
            }
            if(isBreak) break;
            isBreak =true;
            rank--;
            low++;
            //向下移动
            while (low < matrix.length-i) {
                res.add(matrix[low++][rank]);
                isBreak =false;
            }
            if(isBreak) break;
            isBreak =true;
            low--;
            rank--;
            //向左移动
            while (rank >= i) {
                res.add(matrix[low][rank--]);
                isBreak =false;
            }
            if(isBreak) break;
            isBreak =true;
            rank++;
            low--;
            //向上移动
            while (low > i){
                res.add(matrix[low--][rank]);
                isBreak =false;
            }
            if(isBreak) break;
            isBreak =true;
            low++;
            rank++;
            i++;
        }
        return res;
    }

    /**
     * 优化代码量，不过空间复杂度增加
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrderBetter(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int low = 0, rank = 0;
        int lowLen = matrix.length -1;  //行
        int rankLen = matrix[0].length-1; //列
        while (low<=lowLen&&rank<=rankLen){
            //向右移动
            for (int i = rank; i <= rankLen; i++) res.add(matrix[low][i]);
            //向下移动
            for (int i = low+1; i <= lowLen; i++) res.add(matrix[i][rankLen]);
            if(low<lowLen&&rank<rankLen){
                //向左移动
                for (int i = rankLen-1; i>= rank ; i--) res.add(matrix[lowLen][i]);
                //向上移动
                for(int i= lowLen-1;i>low;i--) res.add(matrix[i][rank]);
            }
            lowLen--;
            rankLen--;
            low++;
            rank++;
        }
       return res;
    }
}
