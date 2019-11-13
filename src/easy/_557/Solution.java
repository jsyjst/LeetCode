package easy._557;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/13
 *     desc   : 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * </pre>
 */
public class Solution {
    /**
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */
    private StringBuilder resBuilder = new StringBuilder();
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(i != 0) resBuilder.append(" ");
            reverse(words[i]);
        }
        return resBuilder.toString();
    }

    private void reverse(String s){
        for (int i = s.length()-1; i >=0; i--) {
            resBuilder.append(s.charAt(i));
        }
    }
}
