package medium._392;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/27
 *     desc   :  给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * </pre>
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        if(s.length()== 0) return true;
        int j =0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(j)) j++;
            if(j == s.length()) break;
        }
        return j==s.length();
    }

}
