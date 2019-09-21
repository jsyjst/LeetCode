package easy._384;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/21
 *     desc   : 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 *     如果可以构成，返回 true ；否则返回 false。
 *     (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * </pre>
 */
public class Solution {
    /**
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.equals("")) return true;
        if(magazine.contains(ransomNote)) return true;
        int[] count = new int[26];
        for(char c:magazine.toCharArray()){
            count[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            count[c-'a']--;
            if(count[c-'a']<0) return false;
        }
        return true;
    }
}
