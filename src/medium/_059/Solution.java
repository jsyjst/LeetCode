package medium._059;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/08
 *     desc   : 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 * </pre>
 */
public class Solution {

    public static void main(String [] args){
        System.out.println(generateMatrix(3));
    }
    /**
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     */
    public static int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int k = 1;
        int low = 0,rank = 0;
        int lowLen = n-1,rankLen = n-1;
        while (k<=n*n){
            //向右
            for (int i = rank; i <= rankLen; i++) res[low][i] = k++;
            if(k == n*n+1) break;
            //向下
            for (int i = low+1; i <= lowLen ; i++) res[i][rankLen] = k++;
            if(k == n*n+1) break;
            //向左
            for (int i = rankLen-1; i >= rank ; i--) res[lowLen][i] = k++;
            if(k == n*n+1) break;
            //向上
            for (int i = lowLen-1; i > low; i--) res[i][rank] = k++;
            if(k == n*n+1) break;
            low++;
            rank++;
            rankLen--;
            lowLen--;
        }
        return res;
    }
}
