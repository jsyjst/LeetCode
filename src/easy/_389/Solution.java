package easy._389;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/22
 *     desc   : 给定两个字符串 s 和 t，它们只包含小写字母。
 *     字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *     请找出在 t 中被添加的字母。
 * </pre>
 */
public class Solution {
    /**
     * 输入：
     * s = "abcd"
     * t = "abcde"
     * 输出：
     * e
     * 解释：
     * 'e' 是那个被添加的字母。
     */
    //异或
    public char findTheDifference(String s, String t) {
        int res = 0;
        for(char c:s.toCharArray()) res^=c;
        for(char c:t.toCharArray()) res^=c;
        return (char)res;
    }
    //加法
    public char findTheDifferenceBySum(String s, String t) {
        int res = 0;
        for(char c:t.toCharArray()) res+=c;
        for(char c:s.toCharArray()) res-=c;
        return (char)res;
    }
}
