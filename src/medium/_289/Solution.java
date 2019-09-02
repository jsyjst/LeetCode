package medium._289;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/02
 *     desc   : 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 *     给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
 *     每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *     如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 *     如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 *     如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 *     如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *     根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
 *     下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [
     *   [0,1,0],
     *   [0,0,1],
     *   [1,1,1],
     *   [0,0,0]
     * ]
     * 输出:
     * [
     *   [0,0,0],
     *   [1,0,1],
     *   [0,1,1],
     *   [0,1,0]
     * ]
     *进阶:
     * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
     * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题
     */
    public void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        int row = board.length;
        int rank = board[0].length;
        //上下左右各添加一排，这样就不用考虑边界问题
        int[][] old = new int[row+2][rank+2];
        //复制数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                old[i+1][j+1] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                int x = i+1;
                int y = j+1;
                int sum = old[x-1][y-1] + old[x-1][y] + old[x-1][y+1]
                        +old[x][y-1]+old[x][y+1]+old[x+1][y-1]+old[x+1][y]+old[x+1][y+1];
                if(sum < 2||sum>3) {
                    board[i][j] = 0;
                }else if(sum == 3){
                    board[i][j] = 1;
                }
            }
        }
    }


    /**
     * 原地算法
     * 第一个循环标记，第二个循环赋值
     *  1 :保持1
     *  0 :保持0
     *  -1：1转0
     *  -2：0转1
     */
    public void gameOfLifeBetter(int[][] board) {
        if(board.length == 0) return;
        int row = board.length;
        int rank = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                board[i][j]=check(board,i,j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }

    }
    private int check(int[][] board,int i,int j){
        int left = Math.max(0,j-1);
        int right = Math.min(board[0].length-1,j+1);
        int top = Math.max(0,i-1);
        int bottom = Math.min(board.length-1,i+1);
        int count = 0;
        for (int k = top; k <= bottom ; k++) {
            for (int l = left; l <= right; l++) {
                if(k == i&&l==j) continue;
                count = (board[k][l] == 1||board[k][l]==-1)?count+1:count;
            }
        }
        if((count<2||count>3) &&board[i][j]==1 ){
            return -1;
        }else if(count == 3&& board[i][j] == 0) {
            return -2;
        }else {
            return board[i][j];
        }
    }

}
