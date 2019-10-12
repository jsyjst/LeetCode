package easy._409;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/12
 *     desc   : 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *     在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public int longestPalindrome(String s) {
        if(s.length() <= 1) return s.length();
        //用来统计各字符的个数
        HashMap<Character,Integer> map = new HashMap();
        int res = 0;
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:map.keySet()){
            int count = map.get(c);
            if(count>1){
                res+=count/2*2;
            }
        }
        return res==s.length()?res:res+1;
    }
}
