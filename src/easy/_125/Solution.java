package easy._125;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/23
 *     desc   : 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *              说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        System.out.println();
    }
    /**
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * <p>
     * 输入: "race a car"
     * 输出: false
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValid(s.charAt(right))) {
                right--;
                continue;
            }
            if (isNumber(s.charAt(left))){
                if(s.charAt(left) != s.charAt(right)) return false;
            } else {
                int diff = Math.abs(s.charAt(left)-s.charAt(right));
                if(diff!=0&&diff !=32) return false;
            }
            left++;
            right--;

        }
        return true;
    }

    private boolean isValid(char c) {
        return c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
