package easy._231;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/24
 *     desc   : 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 1
     * 输出: true
     * 解释: 2^0 = 1
     *
     * 输入: 16
     * 输出: true
     * 解释: 2^4 = 16
     *
     * 输入: 218
     * 输出: false
     */

    //常规解法，计算1的个数
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n&1;
            if(bit == 1) count++;
            if(count>1) return false;
            n>>=1;
        }
        return true;
    }

    //最优解法
    public boolean isPowerOfTwoBest(int n) {
        if(n<=0) return false;
        return (n&(n-1))==0;
    }
}
