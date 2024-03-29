package 字符串.medium._003;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/04/24
 *     desc   : 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * @param args
     */
    public static void main(String[] args){
        String s="abcabcbb";
        System.out.println(Solution.lengthOfLongestSubstringByCommon(s));
    }
    /**
     * 滑动窗口
     * 时间复杂度：O(2n) = O(n)O(2n)=O(n)
     * 使用 HashSet 将字符存储在当前窗口 [i, j)（最初j=i）中。
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
     * 直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。
     * 如果我们对所有的 i这样做，就可以得到答案。
     * @param s 给定字符串
     * @return  不含有重复字符的最长子串的长度。
     */
    static int lengthOfLongestSubstringByHashSet(String s) {
        int len=0;
        HashSet<Character> hashSet = new HashSet<>();
        int i=0,j=0;
        while (i< s.length()&&j<s.length()){
            if(hashSet.contains(s.charAt(j))){
                hashSet.remove(s.charAt(i++));
            }else {
                hashSet.add(s.charAt(j++));
                len = Math.max(len,j-i);
            }
        }
        return len;
    }

    /**
     * 优化的滑动窗口
     * 如果 s[j]在 [i, j)范围内有与 j'重复的字符，我们不需要逐渐增加 i。
     * 我们可以直接跳过 [i，j']范围内的所有元素，并将 i变为 j' + 1
     * @param s 给定字符串
     * @return  不含有重复字符的最长子串的长度。
     */
    public static int lengthOfLongestSubstringByHashMap(String s) {
        int size = s.length();
        if(size <= 1) return size;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int res = 0;
        while(start < size && end < size){
            if(map.containsKey(chars[end]) && map.get(chars[end]) >= start){
                res = Math.max(res,end - start);
                start = map.get(chars[end]) + 1;
            }
            map.put(chars[end],end);
            end++;
        }
        res = Math.max(res,end - start);
        return res;
    }

    // 复杂度n*n，双循环确定每个字母最长不重复的个数，然后取最大值
    static int lengthOfLongestSubstringByCommon(String s) {
        int res = 0;
        HashSet<Character> hashSet;
        for (int i = 0; i < s.length(); i++) {
            int l = 1;
            hashSet = new HashSet<>();
            hashSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (hashSet.contains(s.charAt(j))) {
                    break;
                }
                hashSet.add(s.charAt(j));
                l ++;
            }
            res = Math.max(res, l);
        }
        return res;
    }
}
