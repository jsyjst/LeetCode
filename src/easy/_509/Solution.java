package easy._509;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/15
 *     desc   : 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 * </pre>
 */
public class Solution {
    /**
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     */
    public int fib(int N) {
        if(N<= 1) return N;
        if(N == 2) return 1;
        int last,cur;
        last = cur=1;
        for (int i = 3; i <= N ; i++) {
            int res = cur + last;
            last = cur;
            cur = res;
        }
        return cur;
    }
}
