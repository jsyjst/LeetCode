package easy._058;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/05
 *     desc   : 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *              如果不存在最后一个单词，请返回 0 。
 *              说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * </pre>
 */
public class Solution {
    /**
     * 示例:
     * 输入: "Hello World"
     * 输出: 5
     */
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int result = 0;
        int temp = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)!=' '){
                temp++;
                if(i!=s.length()-1&&s.charAt(i+1)==' ')result = temp;
            }else {
                temp = 0;
            }
        }
        return (s.charAt(s.length()-1)==' ')?result:temp;
    }

    /**
     * 优化时间复杂度
     * 直接从后面查找
     * @param s
     * @return
     */
    public int lengthOfLastWordBetter(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int result = 0;
        for (int i = s.length()-1; i >=0; i++) {
            if(s.charAt(i)==' ') return s.length()-i-1;
        }
        return s.length();
    }

}
