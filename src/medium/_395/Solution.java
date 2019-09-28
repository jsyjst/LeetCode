package medium._395;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/28
 *     desc   : 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * s = "aaabb", k = 3
     * 输出:
     * 3
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     *
     * 输入:
     * s = "ababbc", k = 2
     * 输出:
     * 5
     * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     */
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if(k<=1) return len;
        if(len == 0||k>len)  return 0;
        return count(s.toCharArray(),k,0,len-1);
    }

    private int count(char[] chars,int k,int start,int end){
        if(end - start + 1<k) return 0;
        int[] count = new int[26];//桶，对26个字母计数
        for(int i=start;i<=end;i++){
            count[chars[i]-'a']++;
        }
        //start的位置的次数小于k,则该字符不应该出现在结果字符串中
        while (end - start + 1>=k&&count[chars[start]-'a']<k) start++;
        while (end-start+1>=k&&count[chars[end]-'a']<k) end--;
        if(end-start+1<k) return 0;
        for (int i = start; i <= end ; i++) {
            if(count[chars[i]-'a']<k)
            return Math.max(count(chars,k,start,i-1),count(chars,k,i+1,end));
        }
        return end-start+1;
    }
}
