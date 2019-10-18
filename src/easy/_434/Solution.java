package easy._434;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/18
 *     desc   : 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *     请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * </pre>
 */
public class Solution {
    /**
     * 输入: "Hello, my name is John"
     * 输出: 5
     */
    public int countSegments(String s) {
        if(s.length()== 0) return 0;
        int count = 0;
        String[] words = s.trim().split(" ");
        for(String word:words){
            if(!" ".equals(word)) count++;
        }
        return count;
    }
}
