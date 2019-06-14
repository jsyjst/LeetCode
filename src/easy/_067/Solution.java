package easy._067;

import java.time.chrono.MinguoChronology;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/14
 *     desc   : 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *     输入为非空字符串且只包含数字 1 和 0。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * <p>
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for (; i >= 0; i--, j--) {
            int aInt = a.charAt(i) - '0';
            int bInt = 0;
            if (j >= 0) {
                bInt = b.charAt(j) - '0';
            }
            res.append((aInt + bInt + carry) % 2);
            carry = (aInt + bInt + carry) / 2;
        }
        if(carry>0) res.append(carry);
        return res.reverse().toString();
    }
}
