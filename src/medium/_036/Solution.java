package medium._036;

import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/27
 *     desc   : 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *                  1.数字 1-9 在每一行只能出现一次。
 *                  2.数字 1-9 在每一列只能出现一次。
 *                  3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
    }
    /**
     * 说明:
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     */
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> lowSet=new HashSet<>();
        HashSet<Character> rankSet=new HashSet<>();
        HashSet<Character> nineSet1 = new HashSet<>();
        HashSet<Character> nineSet2 = new HashSet<>();
        HashSet<Character> nineSet3 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //行
                if(lowSet.contains(board[i][j])&&board[i][j]!='.'){
                    System.out.println("行");
                    return false;
                }else {
                    lowSet.add(board[i][j]);
                }
                //列
                if(rankSet.contains(board[j][i])&&board[j][i]!='.'){
                    System.out.println("列");
                    return false;
                }else {
                    rankSet.add(board[j][i]);
                }
                //九宫格
                if(j<=2){
                    if(nineSet1.contains(board[i][j])&&board[i][j]!='.'){
                        return false;
                    }else {
                        nineSet1.add(board[i][j]);
                    }
                }else if(j<6){
                    if(nineSet2.contains(board[i][j])&&board[i][j]!='.'){
                        return false;
                    }else {
                        nineSet2.add(board[i][j]);
                    }
                }else {
                    if(nineSet3.contains(board[i][j])&&board[i][j]!='.'){
                        return false;
                    }else {
                        nineSet3.add(board[i][j]);
                    }
                }
            }
            if((i+1)%3==0){
                nineSet1.clear();
                nineSet2.clear();
                nineSet3.clear();
            }
            lowSet.clear();
            rankSet.clear();
        }
        return true;
    }

    /**
     * 评论时间复杂度更优解法
     */
    public static boolean isValidSudokuComment(char[][] board) {
        //记录某行的数字是否被放置
        boolean [][] row = new boolean[9][9];
        //记录某列
        boolean [][] rank = new boolean[9][9];
        //记录某各小九宫格
        boolean [][] nine = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j] -'1';
                    int nineNum = i/3*3+j/3;
                    if(row[i][num]||rank[j][num]||nine[nineNum][num]){
                        return false;
                    }else {
                        row[i][num] =true;
                        rank[j][num] = true;
                        nine[nineNum][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
