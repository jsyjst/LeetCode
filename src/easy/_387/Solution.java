package easy._387;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/25
 *     desc   : 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * </pre>
 */
public class Solution {
    /**
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     */
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map.put(c[i],map.getOrDefault(c[i],0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(c[i])==1) return i;
        }
        return -1;
    }
}
