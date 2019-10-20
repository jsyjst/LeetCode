package medium._438;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/20
 *     desc   : 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *     注：字母异位词指字母相同，但排列不同的字符串。不考虑答案输出的顺序。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * s: "cbaebabacd" p: "abc"
     * 输出:
     * [0, 6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *
     * 输入:
     * s: "abab" p: "ab"
     * 输出:
     * [0, 1, 2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词
     */

    //滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if(sLen<pLen) return res;
        int[] a = new int[26];
        int[] b = new int[26];
        for(char c:p.toCharArray()){
            b[c-'a']++;
        }
        for (int i = 0; i < pLen-1; i++) {
            a[s.charAt(i)-'a']++;
        }
        for (int i = pLen-1; i < sLen; i++) {
            a[s.charAt(i)-'a']++;
            if(isSame(a,b)) res.add(i-pLen+1);
            a[s.charAt(i-pLen+1)-'a']--;
        }
        return res;

    }
    private boolean isSame(int[] a,int[] b){
        for (int i = 0; i < 26; i++) {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
