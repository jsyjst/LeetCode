package easy._007;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/02
 *     desc   : 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *              注意:
 *              假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * 输入: 120
     * 输出: 21
     */
    public static void main(String[] args) {
        System.out.println(reverse(120));
    }

    public static int reverseMine(int x) {
        if (x == 0) return 0;
        String numString = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numString);
        if (numString.substring(0, 1).equals("-")) {
            stringBuilder.replace(0, 1, "");
            stringBuilder.append("-");
        } else if (numString.substring(numString.length() - 1).equals("0")) {
            stringBuilder.replace(numString.length() - 1, numString.length(), "");
        }
        stringBuilder.reverse();
        int num;
        try {
            num = Integer.valueOf(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
        return num;
    }

    /**
     * 题解
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
