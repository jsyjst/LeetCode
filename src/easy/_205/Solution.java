package easy._205;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/15
 *     desc   : 给定两个字符串 s 和 t，判断它们是否是同构的。
 *     如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *     所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 *     两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        String s="qwertyuiop[]asdfghjkl;'\\zxcvbnm,./";
        String t="\"',.pyfgcrl/=aoeuidhtns-\\\\;qjkxbmwvz\"";
        System.out.println(isIsomorphic(s,t));
    }
    /**
     * 输入: s = "egg", t = "add"
     * 输出: true
     *
     * 输入: s = "foo", t = "bar"
     * 输出: false
     *
     * 输入: s = "paper", t = "title"
     * 输出: true
     *
     * 说明:你可以假设 s 和 t 具有相同的长度。
     */
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()<2) return true;
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }else {
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}
