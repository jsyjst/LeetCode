package 回溯.medium._017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/14
 *     desc   :给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *            给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }

    /**
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     */

    /**
     * 该题的核心就是反复的使用上一次的组合
     * 1.假设字符串为23，则组合数为3*3=9；用ArrayList记录组合数
     * 2.这时候字符串为234，则组合数为9*3=27；用上次的ArrayList来增加以及修改组合数
     * 3.然后遍历字符串即可得到所以的组合数。
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {//遍历字符串
            int len = result.size();
            String digit = "";
            switch (digits.charAt(i)) {
                case '2':
                    digit = "abc";
                    break;
                case '3':
                    digit = "def";
                    break;
                case '4':
                    digit = "ghi";
                    break;
                case '5':
                    digit = "jkl";
                    break;
                case '6':
                    digit = "mno";
                    break;
                case '7':
                    digit = "pqrs";
                    break;
                case '8':
                    digit = "tuv";
                    break;
                case '9':
                    digit = "wxyz";
                    break;
            }
            if (len == 0) {//第一个字符的情况
                for (int k = 0; k < digit.length(); k++) {
                    result.add("" + digit.charAt(k));
                }
            } else {
                for (int j = 0; j < len; j++) {//在原来的List基础上增加
                    for (int k = 1; k < digit.length(); k++) {//然后遍历号码对应的字母
                        result.add(result.get(j) + digit.charAt(k));//增加k-1个字符，k=0比较特殊
                    }
                    result.set(j, result.get(j) + digit.charAt(0));//修改第j个元素，k=0的情况
                }
            }
        }
        return result;
    }

    HashMap<Character, String> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    StringBuilder track = new StringBuilder();
    public List<String> letterCombinationsByDfs(String digits) {
        if (digits.length() == 0) return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0);
        return res;
    }

    public void backtrack(String digits, int index) {
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for(int i = 0; i < s.length(); i++) {
            track.append(s.charAt(i));
            backtrack(digits, index + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
