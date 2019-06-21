package medium._079;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/21
 *     desc   :给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
 *     同一个单元格内的字母不允许被重复使用。
 * </pre>
 */
public class Solution {
    /**
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true.
     * 给定 word = "SEE", 返回 true.
     * 给定 word = "ABCB", 返回 false.
     */
    public boolean exist(char[][] board, String word) {
        if (word.equals("")) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[] visit = new boolean[board.length * board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)&&backtrack(board,word,0,visit,i,j)) return true;
            }
        }
        return false;

    }

    private boolean backtrack(char[][] board, String word, int index, boolean[] visit,int i,int j) {
        if(i>= board.length||j>= board[0].length||i<0||j<0||board[i][j]!=word.charAt(index)||visit[i*board[0].length+j]) return false;
        if (index == word.length() - 1) return true;
        visit[i*board[0].length+j] = true;
        if(backtrack(board,word,index+1,visit,i,j+1)||backtrack(board,word,index+1,visit,i+1,j)
                ||backtrack(board,word,index+1,visit,i-1,j)||backtrack(board,word,index+1,visit,i,j-1)){
            return true;
        }
        visit[i*board[0].length+j] = false;
        return false;
    }

}
