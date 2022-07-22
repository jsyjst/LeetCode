package 字符串.medium._005;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/10
 *     desc   : 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * </pre>
 */
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String oddRes = palindrome(s, i, i);
            String evenRes = palindrome(s, i, i+1);
            res = oddRes.length() > res.length() ? oddRes : res;
            res = evenRes.length() > res.length() ? evenRes : res;
        }
        return res;
    }

    public String palindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
