package 回溯.medium._022;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/16
 *     desc   : 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        //System.out.println(generateParenthesis(3));
    }
    /**
     *  例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */
    List<String> res = new LinkedList<>();
    StringBuilder track = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    public void backtrack(int left, int right, int n) {
        if (left == n && right == n) {
            res.add(track.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left > n || right > n) {
            return;
        }
        track.append("(");
        backtrack(left+1, right, n);
        track.deleteCharAt(track.length()-1);

        track.append(")");
        backtrack(left, right+1, n);
        track.deleteCharAt(track.length()-1);
    }
}
