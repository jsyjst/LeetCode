package 动态规划.medium._005;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/04/26
 *     desc   : 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }


    //自己的解法
    private static String longestPalindromeMine(String s) {
        if (s.length() == 0) {
            return s;
        }
        //start记录回文串的第一个字符，end为回文串的最后一个字符位置
        int start, end, len;
        int left, right;//分别遍历中心点的左边和右边
        int i;//以i为回文串中心点
        len = 0;
        start = 0;
        end = 0;
        for (i = 0; i < s.length() - 1; i++) {
            /**
             * 奇回文串，aba
             */
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (len < right - left + 1) {
                len = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
            /**
             * 偶回文串 abba
             */
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (len < right - left + 1) {
                len = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
        }
        return s.substring(start, end + 1);
    }


    /**
     * 题解：优化自己解法的代码
     *
     * @param s 字符串
     * @return 最长回文串
     */
    private static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        //start记录回文串的第一个字符，end为回文串的最后一个字符位置
        int start, end;
        start = 0;
        end = 0;
        //以i为回文串中心点
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = getPalindromeLen(s, i, i);//奇回文串长度 aba
            int len2 = getPalindromeLen(s, i, i + 1);//偶回文串长度 abba
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 得到回文串的长度
     *
     * @param s     字符串
     * @param left  中心点左边
     * @param right 中心点右边
     * @return 回文串长度
     */
    private static int getPalindromeLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
