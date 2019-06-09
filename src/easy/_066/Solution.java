package easy._066;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/09
 *     desc   : 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *              最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * <p>
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                carry =digits[i] + 1 >= 10 ? 1 : 0;
                result[i+1] = (digits[i] + 1)%10;
            }else {
                result[i+1] = (digits[i] + carry)%10;
                carry = digits[i] + carry>= 10 ? 1 : 0;
            }
        }
        if(carry == 0){
            for (int j = 0; j < digits.length; j++) {
                digits[j] = result[j+1];
            }
            return digits;
        }else {
            result[0] = carry;
        }
        return result;
    }

    /**
     * 更优
     */
    public int[] plusOneBest(int[] digits){
        for (int i = digits.length -1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i] !=0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
