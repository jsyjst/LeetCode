package easy._541;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/12
 *     desc   : 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。
 *     如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * </pre>
 */
public class Solution {
    /**
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     * 要求:
     * 该字符串只包含小写的英文字母。
     * 给定字符串的长度和 k 在[1, 10000]范围内。
     */
    private StringBuilder resBuilder = new StringBuilder();
    public String reverseStr(String s, int k) {
        int len = s.length();
        if(k<=1) return s;
        int i=0;
        while (i+k<=len){
            reverse(s.substring(i,i+k));//翻转
            resBuilder.append(s, i+k, Math.min(len,i+2*k));
            i+=2*k;
        }
        if(i<len) reverse(s.substring(i));
        return resBuilder.toString();
    }

    private void reverse(String temp){
        for (int i = temp.length()-1; i >=0 ; i--) {
            resBuilder.append(temp.charAt(i));
        }
    }
}
