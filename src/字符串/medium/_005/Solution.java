package 字符串.medium._005;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/10
 *     desc   : 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * </pre>
 */
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0||s.length() == 1) return s;
        char[] c = s.toCharArray();
        //用来遍历
        int left,right;
        //用来记录最后的下标
        int start=0,end=0;
        //用来记录回文子串的大小
        int len = 0;
        //以i为中心点
        for(int i = 0;i < s.length() ;i++){
            //奇数情况
            left = i;
            right = i;
            while(left >= 0 && right <= s.length() - 1 && c[left] == c[right]){
                left--;
                right++;
            }
            if(right-left>len){
                len = right - left;
                start = left+1;
                end = right-1;
            }

            //偶数情况
            left = i;
            right = i + 1;
            while(left >= 0 && right <= s.length() - 1 && c[left] == c[right]){
                left--;
                right++;
            }
            if(right-left>len){
                len = right - left;
                start = left+1;
                end = right-1;
            }
        }
        return s.substring(start,end+1);
    }
}
