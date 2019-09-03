package easy._290;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/03
 *     desc   : 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *     这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * </pre>
 */
public class Solution {
    /**
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     *
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     *
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     *
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] s = str.split(" ");
        char[] p = pattern.toCharArray();
        if(s.length!=p.length) return false;
        for (int i = 0; i < p.length; i++) {
            if(!map.containsKey(p[i])){
                if(map.containsValue(s[i])) return false;
                map.put(p[i],s[i]);
            }else {
                if(!map.get(p[i]).equals(s[i])) return false;
            }
        }
        return true;
    }
}
