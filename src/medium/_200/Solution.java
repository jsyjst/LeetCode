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

    public static void main(String[] args){
        char[][] grid ={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    /**
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * <p>
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     */

    //BFS
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int res = 0;
        int row = grid.length;
        int rank = grid[0].length;
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rank; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = 0;
                    queue.offer(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node node = queue.remove();
                        int i1 = node.row;
                        int j1 = node.rank;
                        if (j1+1 < rank && grid[i1][j1 + 1] == '1') {
                            queue.offer(new Node(i1, j1 + 1));
                            grid[i1][j1+1] = '0';
                        }
                        if (i1-1 >= 0 && grid[i1 - 1][j1] == '1') {
                            queue.offer(new Node(i1 - 1, j1));
                            grid[i1-1][j1] = '0';
                        }
                        if (i1+1 <row && grid[i1 + 1][j1] == '1') {
                            queue.offer(new Node(i1 + 1, j1));
                            grid[i1+1][j1] = '0';
                        }
                        if (j1-1 >= 0 && grid[i1][j1 - 1] == '1') {
                            queue.offer(new Node(i1, j1 - 1));
                            grid[i1][j1-1] = '0';
                        }
                    }
                }
            }
        }
        return res;

    }

   static class Node {
        int row;
        int rank;

        Node(int row, int rank) {
            this.row = row;
            this.rank = rank;
        }
    }

    // dfs解法
    public int numIslandsByDfs(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 将相邻的陆地都变成海水
    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
    }
}
