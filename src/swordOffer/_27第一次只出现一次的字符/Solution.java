package swordOffer._27第一次只出现一次的字符;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/11
 *     desc   : 在一个字符串(0<=字符串长度<=10000，
 *     全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * </pre>
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        if(len == 0) return -1;
        int[] count = new int[52];
        for(char c:chars){
            if(c < 'a') count[c - 'A']++;
            else count[c - 'a' + 26]++;
        }
        for(int i = 0; i < len; i++){
            if(chars[i] < 'a') {
                if(count[chars[i] - 'A'] == 1) return i;
            }else{
                if(count[chars[i] - 'a' + 26] == 1) return i;
            }
        }
        return -1;
    }
}
