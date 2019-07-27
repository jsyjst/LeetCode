package medium._131;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/27
 *     desc   : 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *     返回 s 所有可能的分割方案。
 * </pre>
 */
public class Solution {
    /**
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */
    public List<List<String>> partition(String s) {
        List<List<String>> resList = new ArrayList<>();
        backtrack(resList,new ArrayList<>(),s);
        return resList;

    }

    private void backtrack(List<List<String>> resList,List<String> res,String s){
        if(s==null || s.length() == 0) resList.add(new ArrayList<>(res));
        for (int i = 1; i <= s.length(); i++) {
            if(isPalindrome(s.substring(0,i))){
                res.add(s.substring(0,i));
                backtrack(resList,res,s.substring(i));
                res.remove(res.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
