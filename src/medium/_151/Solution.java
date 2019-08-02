package medium._151;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/02
 *     desc   : 给定一个字符串，逐个翻转字符串中的每个单词。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        String s = " ";
        System.out.println(reverseWords(s));
    }
    /**
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 说明：
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */
    public static String reverseWords(String s) {
        s.trim();
        if(s.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length-1; i >=0 ; i--) {
            if(words[i].equals("")) continue;
            if(res.length() == 0){
                res.append(words[i]);
            }else {
                res.append(" ").append(words[i]);
            }
        }
        return res.toString();

    }
}
