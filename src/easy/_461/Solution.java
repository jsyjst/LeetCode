package easy._461;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/09
 *     desc   : 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。给出两个整数 x 和 y，计算它们之间的汉明距离。
 * </pre>
 */
public class Solution {
    /**
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *       ↑  ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     * 0 ≤ x, y < 2^31.
     */
    public int hammingDistance(int x, int y) {
        int n = x^y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if((n&1)==1) res++;
            n>>=1;
            if(n == 0) break;
        }
        return res;
    }
}
