package medium._318;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/09
 *     desc   : 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 *     你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        System.out.println();
    }
    /**
     * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
     * 输出: 16
     * 解释: 这两个单词为 "abcw", "xtfn"。
     * <p>
     * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出: 4
     * 解释: 这两个单词为 "ab", "cd"。
     * <p>
     * 输入: ["a","aa","aaa","aaaa"]
     * 输出: 0
     * 解释: 不存在这样的两个单词。
     */
    public int maxProduct(String[] words) {
        int res = 0;
        for(String s:words) System.out.println(s);
        for (int i = 0; i < words.length-1; i++) {
            char[] c1 = words[i].toCharArray();
            for (int j = 1; j < words.length; j++) {
                char[] c2 = words[j].toCharArray();
                if(isDiff(c1,c2)) res = Math.max(res,c1.length*c2.length);
            }
        }
        return res;
    }

    private boolean isDiff(char[] s1,char[] s2){
        HashSet<Character> set= new HashSet<>();
        for (char aS1 : s1) {
            if(set.contains(aS1)) continue;
            set.add(aS1);
            for (char aS2 : s2) {
                if (aS1 == aS2) return false;
            }
        }
        return true;
    }

    //位运算：用二进制的一位表示某一个字母是否出现过，0表示没出现，1表示出现。
    // "abcd"二进制表示00000000 00000000 00000000 00001111、"bc"二进制表示00000000 00000000 00000000 00000110。
    // 当两个字符串没有相同的字母时，二进制数与的结果为0。
    public int maxProductBybit(String[] words) {
        int res = 0;
        int len = words.length;
        int[] wordBits = new int[len]; //将单词转化成26位的二进制
        for (int i = 0; i < len; i++) {
            for(char c:words[i].toCharArray()){
                wordBits[i]|= 1<<(c-'a');
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if((wordBits[i]&wordBits[j]) == 0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
