package medium._201;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/13
 *     desc   : 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        System.out.println(5>>1);
    }
    /**
     * 输入: [5,7]
     * 输出: 4
     *
     * 输入: [0,1]
     * 输出: 0
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n){
            m>>=1;
            n>>=1;
            count++;
        }
        n<<= count;
        return n;
    }
}
