package easy._441;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/21
 *     desc   : 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *     给定一个数字 n，找出可形成完整阶梯行的总行数。
 *     n 是一个非负整数，并且在32位有符号整型的范围内。
 * </pre>
 */
public class Solution {
    /**
     * n = 5
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤
     * 因为第三行不完整，所以返回2.
     */
    //数学公式
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1+8*(long)n)-1)/2);
    }
}
