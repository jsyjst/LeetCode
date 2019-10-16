package medium._419;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/16
 *     desc   : 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 *     给你一个有效的甲板，仅由战舰或者空位组成。
 *     战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 *     两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * </pre>
 */
public class Solution {
    /**
     * X..X
     * ...X
     * ...X
     * 在上面的甲板中有2艘战舰。
     *
     * ...X
     * XXXX
     * ...X
     * 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
     */
    public int countBattleships(char[][] board) {
        if(board.length == 0) return 0;
        if(board[0].length == 0) return 0;
        int row = board.length;
        int rank = board[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                if(board[i][j]=='X'&&(i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.')){
                    res++;
                }
            }
        }
        return res;
    }

}
