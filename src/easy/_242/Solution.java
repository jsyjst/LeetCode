package easy._242;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/27
 *     desc   : 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * </pre>
 */
public class Solution {
    /**
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    //哈希表
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, (map.get(c)) + 1);
            }else {
                map.put(c,1);
            }
        }
        for(char tC:t.toCharArray()){
            if(!map.containsKey(tC)) return false;
            if(map.get(tC)<0) return false;
            map.put(tC,map.get(tC)-1);
        }
        for(int count:map.values()){
            if(count!=0) return false;
        }
        return true;
    }
    //数组
    public boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int count:counter){
            if(count!=0) return false;
        }
        return true;
    }

    //排序
    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
