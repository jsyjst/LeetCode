package medium._567;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/20
 *     desc   : 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *     换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * </pre>
 */
public class Solution {
    /**
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2<len1) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for(char c:s1.toCharArray()){
            a[c-'a']++;
        }
        for (int i = 0; i <len1-1 ; i++) {
            b[s2.charAt(i)-'a']++;
        }
        for (int i = len1-1; i <len2 ; i++) {
            b[s2.charAt(i)-'a']++;
            if(isSame(a,b)) return true;
            b[s2.charAt(i+1-len1)-'a']--;
        }
        return false;
    }

    private boolean isSame(int[] a,int[] b){
        for (int i = 0; i < 26; i++) {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
