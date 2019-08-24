package easy._326;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/24
 *     desc   : 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 27
     * 输出: true
     *
     * 输入: 0
     * 输出: false
     *
     * 输入: 9
     * 输出: true
     */
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(n == 1) return true;
        while (n!=1){
            if(n%3!=0) return false;
            n/=3;
        }
        return true;
    }
}
