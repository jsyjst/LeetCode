package medium._130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/26
 *     desc   : 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *     找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * </pre>
 */
public class Solution {
    /**
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 解释:被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     */

    //BFS
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rowLen = board.length;
        int rankLen = board[0].length;
        Queue<Integer> queue = new LinkedList<>();//队列少不了
        for (int i = 0; i < rowLen ; i++) {
            for (int j = 0; j < rankLen ; j++) {
                //从边缘的’O'开始找起
                if ((i==0||i== rowLen-1||j==0||j== rankLen-1) && board[i][j] == 'O'){
                    queue.offer(i * rankLen + j);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int position = queue.poll();
                            int row = position / rankLen;
                            int rank = position % rankLen;
                            if (board[row][rank] =='#') continue;
                            board[row][rank] = '#';

                            //左
                            if (rank-1>=0&&board[row][rank - 1] == 'O') {
                                queue.offer(position - 1);
                            }
                            //右
                            if (rank+1<rankLen&&board[row][rank + 1] == 'O'){
                                queue.offer(position + 1);
                            }
                            //上
                            if (row-1>=0&&board[row - 1][rank] == 'O') {
                                queue.offer(position - rankLen);
                            }
                            //下
                            if (row+1<rowLen&&board[row + 1][rank] == 'O') {
                                queue.offer(position + rankLen);
                            }
                        }
                    }

                }
            }
        }
        //更改值
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < rankLen; j++) {
                if(board[i][j] == 'O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j] = 'O';
            }
        }
    }
}
