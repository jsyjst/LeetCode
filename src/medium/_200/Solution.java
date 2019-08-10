package medium._200;

import java.util.LinkedList;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/10
 *     desc   : 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 *     一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 *     你可以假设网格的四个边均被水包围。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     *
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     */
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        if(grid[0].length == 0) return 0;
        int row = grid.length;
        int rank = grid[0].length;
        boolean[][] visited = new boolean[row][rank];
        LinkedList<Character> queue = new LinkedList<>();
        queue.offer(grid[0][0]);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                if(visited[i][j]) continue;
                if(grid[i][j] == '1'){
                    
                }
            }
        }

    }
}
